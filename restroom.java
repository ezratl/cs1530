package com.example.pottypoll;
import java.io.*; 
import java.util.*;

class restroom
{

	private static final int MAX_FLAGS = 5;
/*
	private long longitude;
	private long latitude;
*/	
	//private int rating;
	//private int numRatings = 0;
	//private int ratingTotal = 0;
/*	
	private int id;
	private int userID;
	private String gender;
	private String address;
	private String name;
	private int floor;
	private String hours;
	private int shower;
	private int sink;
	private int paperTowels;	
*/
	private int flags = 0;
	private BathroomStruct current;	
	private int currentID;
	private BathroomAdaptor database = new BathroomAdaptor();
	private ArrayList<BathroomStruct> restrooms = new ArrayList<BathroomStruct>();

	public  void restroom()
	{

		current = new BathroomStruct(0, 0, "", 0, 0, 0, 0, "", 0, 0, "", 0, 0, 0, 0, 0);

	}

	public  void restroom(int id, int author, String gender, int shower, int sink, int papertowels, int active, String location, double x, double y, String building, int floor, String hours, int rating, int raters, int date)
	{

		current = new BathroomStruct(id, author, gender, shower, sink, papertowels, active, location, x, y, building, floor, hours, rating, raters, date);
		currentID = id;
		current.AUTHOR = author;
		current.GENDER = gender;
		current.BUILDNAME = building;
		current.XCORD = x;
		current.YCORD = y;
		current.LOCATION = location;
		current.FLOOR = floor;
		current.HOURS = hours;
		current.SHOWER = shower;
		current.SINK = sink;
		current.PAPERTOWELS = papertowels;

	}

	public  void restroom(int alPos)
	{

		current = restrooms.get(alPos);

	}


	public  void setX(long l)
	{

		current.XCORD = l;

	}

	public  void setY(long l)
	{

		current.YCORD = l;

	}

	public  void setRating(int r)
	{

		database = new UserAdaptor(ApplicationProvider.getApplicationContext());
		current.RATERS++;
		current.RATING += r;
		database.addRating(currentID, r);
		database.addRater(currentID);

	}

	public void setUserID(int uID)
	{

		current.AUTHOR = uID;

	}

	public void setGender(String g)
	{

		current.GENDER = g;

	}

	public void setAddress(String a)
	{

		current.BUILDNAME = a;

	}

	public void setName(String n)
	{

		current.LOCATION = n;

	}

	public void setFloor(int f)
	{

		current.FLOOR = f;

	}

	public void setHours(String h)
	{

		current.HOURS = h;

	}

	public void setShower(int s)
	{

		current.SHOWER = s;

	}

	public void setSink(int s)
	{

		current.SINK = s;

	}

	public void setPT(int pt)
	{

		current.PAPERTOWELS = pt;

	}

	public long getX()
	{

		long l = current.XCORD;
		return l;

	}

	public long getY()
	{

		long l = current.YCORD;
		return l;

	}

	public int getRating()
	{

		database = new UserAdaptor(ApplicationProvider.getApplicationContext());
		int r = database.getRating(currentID)/database.getRaters(currentID);
		return r;

	}

	public int getUserID()
	{

		int uid = current.AUTHOR;
		return uid;

	}

	public String getGender()
	{

		String g = current.GENDER;
		return g;

	}

	public String getAddress()
	{

		String a = current.BUILDNAME;
		return a;

	}

	public String getName()
	{

		String n = current.LOCATION;
		return n;

	}

	public int getFloor()
	{

		int f = current.FLOOR;
		return f;

	}

	public String getHours()
	{

		String h = current.HOURS;
		return h;

	}

	public int getShower()
	{

		int s = current.SHOWER;
		return s;

	}

	public int getSink()
	{

		int s = current.SINK;
		return s;

	}

	public int getPT()
	{

		int pt = current.PAPERTOWELS;
		return pt;

	}

	public boolean addRestroom()
	{

		database = new UserAdaptor(ApplicationProvider.getApplicationContext());

		if(!checkForNulls(current.AUTHOR, current.GENDER, current.BUILDNAME, current.XCORD, current.YCORD, current.LOCATION, current.FLOOR, current.HOURS, current.SHOWER, current.SINK, current.PAPERTOWELS))
		{

			return false;

		}

		currentID = (int)database.insertData(current.AUTHOR, current.GENDER, current.BUILDNAME, current.XCORD, current.YCORD, current.LOCATION, current.FLOOR, current.HOURS, current.SHOWER, current.SINK, current.PAPERTOWELS);

		if(currentID < 0)
		{

			return false;

		}

		return true;

	}

	public boolean addRestroom(int userID, String gender, String address, long xcoord, long ycoord, String name, int floor, String hours, int shower, int sink, int papertowels)
	{

		database = new UserAdaptor(ApplicationProvider.getApplicationContext());

		if(!checkForNulls(userID, gender, address, xcoord, ycoord, name, floor, hours, shower, sink, papertowels))
		{

			return false;

		}

		currentID = (int)database.insertData(userID, gender, address, xcoord, ycoord, name, floor, hours, shower, sink, papertowels);
		current.AUTHOR = userID;
		current.GENDER = gender;
		current.BUILDNAME = address;
		current.XCORD = xcoord;
		current.YCORD = ycoord;
		current.LOCATION = name;
		current.FLOOR = floor;
		current.HOURS = hours;
		current.SHOWER = shower;
		current.SINK = sink;
		current.PAPERTOWELS = papertowels;

		if(currentID < 0)
		{

			return false;

		}

		return true;

	}

	public ArrayList getRestrooms(long lng, long lat)
	{

		database = new UserAdaptor(ApplicationProvider.getApplicationContext());
		restrooms = database.getBathroomArray();

		for(int i = 0; i < restrooms.size; i++)
		{

			if(!(restrooms.get(i).XCORD == lat && restrooms.get(i).YCORD == lng))
			{

				restrooms.remove(i);

			}

		}

		return restrooms;

	}

	public void addFlag()
	{

		database = new UserAdaptor(ApplicationProvider.getApplicationContext());
		flags++;
		database.addFlag(currentID);
		checkFlags();

	}

	private void checkFlags()
	{

		database = new UserAdaptor(ApplicationProvider.getApplicationContext());

		if(database.getFlags(currentID) >= MAX_FLAGS)
		{

			database.deleteBathroom(currentID);

		}

	}

	private boolean checkForNulls(int userID, String gender, String address, long xcoord, long ycoord, String name, int floor, String hours, int shower, int sink, int papertowels)
	{

		if(userID < 0 || gender == null || address == null || xcoord < 0 || ycoord < 0 || name == null || floor < 0 || hours == null || shower < 0 || sink < 0 || papertowels < 0)
		{

			return false;

		}

		return true;

	}

}