package com.example.pottypoll;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener, GoogleMap.OnMapLongClickListener {

    private GoogleMap mMap;

    private ArrayList<BathroomStruct> selectedLocationList;

    private Marker currentAddMarker = null;
    private FloatingActionButton addBathroomButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map2);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        addBathroomButton = (FloatingActionButton) findViewById(R.id.addBathroomButton);
        addBathroomButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MapActivity.this, add_review_page.class);
                intent.putExtra("LOCATION", currentAddMarker.getPosition());
                startActivityForResult(intent, 10);
            }
        });

        addBathroomButton.hide();
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        //mMap.setMinZoomPreference(12);
        LatLng cathy = new LatLng(40.4441197, -79.9533654);
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(ny));
        //LatLng cathy = new LatLng(40.7143528, -74.0059731);

        mMap = googleMap;
        mMap.setMinZoomPreference(10);
        mMap.setIndoorEnabled(true);
        UiSettings uiSettings = mMap.getUiSettings();
        uiSettings.setIndoorLevelPickerEnabled(true);
        uiSettings.setMyLocationButtonEnabled(true);
        uiSettings.setMapToolbarEnabled(true);
        uiSettings.setCompassEnabled(true);
        uiSettings.setZoomControlsEnabled(true);

        mMap.setOnCameraIdleListener(new GoogleMap.OnCameraIdleListener() {
            @Override
            public void onCameraIdle() {
                //Toast.makeText(MapActivity.this, mMap.getUiSettings().toString(),Toast.LENGTH_SHORT);

                updateMarkers();
                addBathroomButton.hide();

            }
        });

        mMap.setOnMarkerClickListener(this);
        mMap.setOnMapLongClickListener(this);

        //LatLng ny = new LatLng(40.7143528, -74.0059731);

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(cathy);
        mMap.addMarker(markerOptions);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(cathy));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(16));
    }

    private void updateMarkers(){
        BathroomAdaptor bathroomAdaptor = new BathroomAdaptor(MapActivity.this);
        ArrayList<BathroomStruct> bathrooms = (ArrayList<BathroomStruct>) bathroomAdaptor.getBathroomArray();

        HashMap<LatLng, ArrayList<BathroomStruct>> brMap = new HashMap<LatLng, ArrayList<BathroomStruct>>();

        mMap.clear();
        for(BathroomStruct bathroom : bathrooms) {
            LatLng coord = new LatLng(bathroom.YCORD, bathroom.XCORD);
            ArrayList<BathroomStruct> locList = brMap.get(coord);
            if(locList == null) {
                locList = new ArrayList<BathroomStruct>();
                brMap.put(coord, locList);
            }
            locList.add(bathroom);

        }

        Set<Entry<LatLng, ArrayList<BathroomStruct>>> locations = brMap.entrySet();
        for(Entry<LatLng, ArrayList<BathroomStruct>> location : locations){
            LatLng coord = location.getKey();
            MarkerOptions opts = new MarkerOptions();
            opts.position(coord);

            Marker mk = mMap.addMarker(opts);
            mk.setTag(location.getValue());
        }
    }

    public boolean onMarkerClick(final Marker marker){
        ArrayList<BathroomStruct> bathrooms = (ArrayList<BathroomStruct>) marker.getTag();

        if(bathrooms != null){
            //view bathroom activity
            /*Toast.makeText(this, "view bathrooms:" + bathrooms.size(), Toast.LENGTH_SHORT).show();
            if(bathrooms.size() > 1){
                ArrayList<Integer> floors = new ArrayList<Integer>();
                for(BathroomStruct br : bathrooms)
                    floors.add(br.FLOOR);

                selectedLocationList = bathrooms;
                Intent intent = new Intent(this, BathroomSelect.class);
                intent.putIntegerArrayListExtra("VALUES", floors);

                startActivityForResult(intent, 0);
            }
            else {
                Intent intent = new Intent();
                intent.putExtra("BATHROOM", bathrooms.get(0));

                //start activity
            }*/

            Intent intent = new Intent(this, bathroomList.class);
            intent.putExtra("LIST", (Serializable)bathrooms);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "Empty marker", Toast.LENGTH_SHORT).show();
        }

        return true;
    }

    @Override
    public void onMapLongClick(LatLng point) {
        if(currentAddMarker != null)
            currentAddMarker.remove();
        MarkerOptions newMarker = new MarkerOptions();
        newMarker.position(point);
        newMarker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        currentAddMarker = mMap.addMarker(newMarker);
        addBathroomButton.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0 && resultCode == 1){
            BathroomStruct br = null;
            int floor = data.getIntExtra("VALUE", -1);
            for(BathroomStruct bathroom : selectedLocationList){
                if(bathroom.FLOOR == floor){
                    br = bathroom;
                    break;
                }
            }

            if(br != null){Intent intent = new Intent(/*this, view class*/);
                Intent intent2 = new Intent(/*this, view class*/);
                intent2.putExtra("BATHROOM", br);

                //start activity
            }
        }
        else if(requestCode == 10){
            updateMarkers();
        }
    }
}
