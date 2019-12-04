package com.example.pottypoll;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;


public class ImageAdaptor
{
    ImageHelper helper;
    public ImageAdaptor(Context context)
    {
        helper = new ImageAdaptor.ImageHelper(context);
    }

    public long insertData(int bathroomID, int userID, String IMG_Address ) //returns ID if successful, is - on failure
    {
        SQLiteDatabase db =helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        //data to store
        contentValues.put(ImageHelper.COLUMN_PARENT, bathroomID);
        contentValues.put(ImageHelper.COLUMN_AUTHOR, userID);
        contentValues.put(ImageHelper.COLUMN_LOCATION, IMG_Address);
        contentValues.put(ImageHelper.COLUMN_DATE, 0);
        contentValues.put(ImageHelper.COLUMN_HELPFUL, 0);
        contentValues.put(ImageHelper.COLUMN_UNHELPFUL, 0);

        return db.insert(ImageAdaptor.ImageHelper.TABLE_NAME, null, contentValues);
    }

    public void deleteImage(int ID) //delete bathroom with given id
    {
        SQLiteDatabase db= helper.getWritableDatabase();
        db.delete(ImageHelper.TABLE_NAME, ImageHelper.COLUMN_ID+" = '"+ID+"'", null);
    }

        public void MarkHelpful(int ID)
    {
        SQLiteDatabase db= helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ImageHelper.COLUMN_HELPFUL, getHelpful(ID) + 1);

        db.update(ImageHelper.TABLE_NAME, contentValues, ImageHelper.COLUMN_ID+" = '"+ID+"'", null );
    }
    public void MarkUnhelpful(int ID)
    {
        SQLiteDatabase db= helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ImageHelper.COLUMN_UNHELPFUL, getUnhelpful(ID) + 1);

        db.update(ImageHelper.TABLE_NAME, contentValues, ImageHelper.COLUMN_ID+" = '"+ID+"'", null );
    }

    //getters
    public int getHelpful(int uid) //returns -1 on error
    {
        SQLiteDatabase db= helper.getWritableDatabase();
        String[] columns={ImageHelper.COLUMN_HELPFUL};
        Cursor cursor = db.query(ImageHelper.TABLE_NAME, columns, ImageHelper.COLUMN_ID+" = '"+uid+"'", null, null, null, null);
        int value = -1;
        while(cursor.moveToNext()) //this shouldn't ever loop
        {
            int cname = cursor.getColumnIndex(ImageHelper.COLUMN_HELPFUL);
            value = cursor.getInt(cname);
        }
        return value;
    }
    public int getUnhelpful(int uid) //returns -1 on error
    {
        SQLiteDatabase db= helper.getWritableDatabase();
        String[] columns={ImageHelper.COLUMN_UNHELPFUL};
        Cursor cursor = db.query(ImageHelper.TABLE_NAME, columns, ImageHelper.COLUMN_ID+" = '"+uid+"'", null, null, null, null);
        int value = -1;
        while(cursor.moveToNext()) //this shouldn't ever loop
        {
            int cname = cursor.getColumnIndex(ImageHelper.COLUMN_UNHELPFUL);
            value = cursor.getInt(cname);
        }
        return value;
    }





    public String getImage(int bathroomID) //Returns author ID and Image Location Text for a given bathroom
    {
        SQLiteDatabase db = helper.getWritableDatabase();
        String[] columns = {ImageHelper.COLUMN_AUTHOR, ImageHelper.COLUMN_LOCATION};
        Cursor cursor = db.query(ImageHelper.TABLE_NAME, columns, ImageHelper.COLUMN_PARENT + " = '" + bathroomID + "'", null, null, null, null);
        StringBuffer output = new StringBuffer();
        while (cursor.moveToNext())
        {
            int cparent = cursor.getColumnIndex(ImageHelper.COLUMN_AUTHOR);
            int uparent = cursor.getInt(cparent);

            int ctext = cursor.getColumnIndex(ImageHelper.COLUMN_LOCATION);
            String utext = cursor.getString(ctext);

            output.append(uparent + " " + utext + "\n");
        }
        return output.toString(); //UID LOCATION then next line then UID LOCATION
    }

    static class ImageHelper extends SQLiteOpenHelper
    {
        private static final int DATABASE_VERSION = 1;
        private static final String DATABASE_NAME = "PP_ImageDB";
        private static final String TABLE_NAME = "PP_Image";
        private static final String COLUMN_ID = "_id";
        private static final String COLUMN_PARENT = "BathroomID";
        private static final String COLUMN_AUTHOR = "UserID";
        private static final String COLUMN_LOCATION = "Address";
        private static final String COLUMN_DATE = "DateCreated";
        private static final String COLUMN_HELPFUL = "Helpful";
        private static final String COLUMN_UNHELPFUL = "Unhelpful";
        private Context context;

        private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_PARENT + " INTEGER, " + COLUMN_AUTHOR + " INTEGER, " + COLUMN_DATE + " INTEGER, " + COLUMN_LOCATION + " VARCHAR(250), " +COLUMN_UNHELPFUL + " INTEGER, "+ COLUMN_HELPFUL + " INTEGER);";
        private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

        //SQLiteDatabase database;

        public ImageHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try
            {
                db.execSQL(CREATE_TABLE);
            }
            catch (SQLiteException e)
            {
                //throw a user friendly error
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1)
        {
            try
            {
                db.execSQL(DROP_TABLE); //delete it
                onCreate(db);           //make it again
            }
            catch (SQLiteException e)
            {
                //throw a user friendly error
            }
        }

    }


}
