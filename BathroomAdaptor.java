package com.example.pottypoll;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;


public class BathroomAdaptor
{
    BathroomHelper helper;
    public BathroomAdaptor(Context context)
    {
        helper = new BathroomAdaptor.BathroomHelper(context);
    }

    static class BathroomHelper extends SQLiteOpenHelper
    {
        private static final int DATABASE_VERSION = 1;
        private static final String DATABASE_NAME = "PP_BathroomDB";
        private static final String TABLE_NAME = "PP_Bathroom";
        private static final String COLUMN_ID = "_id";
        private static final String COLUMN_AUTHOR = "UserID";
        private static final String COLUMN_GENDER = "Gender";
        private static final String COLUMN_SHOWER = "Shower";
        private static final String COLUMN_SINK = "Sink";
        private static final String COLUMN_PAPERTOWELS = "PaperTowels";
        private static final String COLUMN_ACTIVE = "Active";
        private static final String COLUMN_LOCATION = "Address";
        private static final String COLUMN_BUILDNAME = "Name";
        private static final String COLUMN_FLOOR = "Floor";
        private static final String COLUMN_HOURS = "Hours";
        private static final String COLUMN_RATING = "Rating";
        private static final String COLUMN_RATERS = "Raters"; //number of ratings already, so we can just add the new one without recalculating
        private static final String COLUMN_DATE = "DateCreated";
        private Context context;

        private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+COLUMN_LOCATION + " VARCHAR(250), "+COLUMN_BUILDNAME + " VARCHAR(250), "+COLUMN_FLOOR + " INTEGER, "+COLUMN_HOURS + " VARCHAR(250), " + COLUMN_AUTHOR + " INTEGER, " + COLUMN_DATE + " DATETIME, " + COLUMN_GENDER + " VARCHAR(25), " +COLUMN_RATING + " INTEGER, "+COLUMN_SHOWER + " INTEGER, "+COLUMN_SINK + " INTEGER, "+COLUMN_PAPERTOWELS + " INTEGER, "+COLUMN_SHOWER + " INTEGER, "+COLUMN_ACTIVE + " INTEGER, "+ COLUMN_RATERS + " INTEGER);";
        private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

        //SQLiteDatabase database;

        public BathroomHelper(Context context)
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

