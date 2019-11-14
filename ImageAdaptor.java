package com.example.pottypoll;

import android.content.Context;
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

        private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_PARENT + " INTEGER, " + COLUMN_AUTHOR + " INTEGER, " + COLUMN_DATE + " DATETIME, " + COLUMN_LOCATION + " VARCHAR(250), " +COLUMN_UNHELPFUL + " INTEGER, "+ COLUMN_HELPFUL + " INTEGER);";
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
