package com.example.pottypoll;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;


public class CommentAdaptor
{
    CommentHelper helper;
    public CommentAdaptor(Context context)
    {
        helper = new CommentAdaptor.CommentHelper(context);
    }

    public long insertData(int bathroomID, int userID, int rating, String comment) //returns ID if successful, is - on failure
    {
        SQLiteDatabase db =helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        //data to store
        contentValues.put(CommentHelper.COLUMN_PARENT, bathroomID);
        contentValues.put(CommentHelper.COLUMN_AUTHOR, userID);
        contentValues.put(CommentHelper.COLUMN_RATING, rating);
        contentValues.put(CommentHelper.COLUMN_TEXT, comment); //Must be 250 Chars max
        contentValues.put(CommentHelper.COLUMN_DATE, 0);
        contentValues.put(CommentHelper.COLUMN_HELPFUL, 0);
        contentValues.put(CommentHelper.COLUMN_UNHELPFUL, 0);

        return db.insert(CommentAdaptor.CommentHelper.TABLE_NAME, null, contentValues);
    }

    public void deleteComment(int ID) //deletes the comment with the given ID
    {
        SQLiteDatabase db= helper.getWritableDatabase();
        db.delete(CommentHelper.TABLE_NAME, CommentHelper.COLUMN_ID+" = '"+ID+"'", null);
    }

    public void MarkHelpful(int ID)
    {
        SQLiteDatabase db= helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CommentHelper.COLUMN_HELPFUL, getHelpful(ID) + 1);

        db.update(CommentHelper.TABLE_NAME, contentValues, CommentHelper.COLUMN_ID+" = '"+ID+"'", null );
    }
    public void MarkUnhelpful(int ID)
    {
        SQLiteDatabase db= helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CommentHelper.COLUMN_UNHELPFUL, getUnhelpful(ID) + 1);

        db.update(CommentHelper.TABLE_NAME, contentValues, CommentHelper.COLUMN_ID+" = '"+ID+"'", null );
    }

    //getters
    public int getHelpful(int uid) //returns -1 on error
    {
        SQLiteDatabase db= helper.getWritableDatabase();
        String[] columns={CommentHelper.COLUMN_HELPFUL};
        Cursor cursor = db.query(CommentHelper.TABLE_NAME, columns, CommentHelper.COLUMN_ID+" = '"+uid+"'", null, null, null, null);
        int value = -1;
        while(cursor.moveToNext()) //this shouldn't ever loop
        {
            int cname = cursor.getColumnIndex(CommentHelper.COLUMN_HELPFUL);
            value = cursor.getInt(cname);
        }
        return value;
    }
    public int getUnhelpful(int uid) //returns -1 on error
    {
        SQLiteDatabase db= helper.getWritableDatabase();
        String[] columns={CommentHelper.COLUMN_UNHELPFUL};
        Cursor cursor = db.query(CommentHelper.TABLE_NAME, columns, CommentHelper.COLUMN_ID+" = '"+uid+"'", null, null, null, null);
        int value = -1;
        while(cursor.moveToNext()) //this shouldn't ever loop
        {
            int cname = cursor.getColumnIndex(CommentHelper.COLUMN_UNHELPFUL);
            value = cursor.getInt(cname);
        }
        return value;
    }

    public String getComments(int bathroomID) //Returns author ID and Comment Text for a given bathroom
    {
        SQLiteDatabase db= helper.getWritableDatabase();
        String[] columns={CommentHelper.COLUMN_AUTHOR, CommentHelper.COLUMN_TEXT};
        Cursor cursor = db.query(CommentHelper.TABLE_NAME, columns, CommentHelper.COLUMN_PARENT+" = '"+bathroomID+"'", null, null, null, null);
        StringBuffer output = new StringBuffer();
        while(cursor.moveToNext())
        {
            int cparent = cursor.getColumnIndex(CommentHelper.COLUMN_AUTHOR);
            int uparent = cursor.getInt(cparent);

            int ctext = cursor.getColumnIndex(CommentHelper.COLUMN_TEXT);
            String utext = cursor.getString(ctext);

            output.append(uparent+" "+utext+"\n");
        }
        return output.toString();

    }
    static class CommentHelper extends SQLiteOpenHelper
    {
        private static final int DATABASE_VERSION = 1;
        private static final String DATABASE_NAME = "PP_commentDB";
        private static final String TABLE_NAME = "PP_Comment";
        private static final String COLUMN_ID = "_id";
        private static final String COLUMN_PARENT = "BathroomID";
        private static final String COLUMN_AUTHOR = "UserID";
        private static final String COLUMN_RATING = "Rating";
        private static final String COLUMN_DATE = "DateCreated";
        private static final String COLUMN_HELPFUL = "Helpful";
        private static final String COLUMN_UNHELPFUL = "Unhelpful";
        private static final String COLUMN_TEXT = "Comment";
        private Context context;

        private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_PARENT + " INTEGER, " + COLUMN_AUTHOR + " INTEGER, " + COLUMN_DATE + " INTEGER, " + COLUMN_TEXT + " VARCHAR(250), " +COLUMN_RATING + " INTEGER, "+COLUMN_UNHELPFUL + " INTEGER, "+ COLUMN_HELPFUL + " INTEGER);";
        private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

        //SQLiteDatabase database;

        public CommentHelper(Context context)
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
