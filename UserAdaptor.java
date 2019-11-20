package com.example.pottypoll;

//import SQLiteOpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class UserAdaptor
{
    UserHelper helper;
    public UserAdaptor(Context context)
    {
        helper = new UserHelper(context);
    }

    public long insertData(String name, String password, String email, int mod) //returns ID if successful, is - on failure
    {
        SQLiteDatabase db =helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserHelper.COLUMN_NAME, name);
        contentValues.put(UserHelper.COLUMN_PW, password);
        contentValues.put(UserHelper.COLUMN_EMAIL, email);
        contentValues.put(UserHelper.COLUMN_MOD, mod);
        contentValues.put(UserHelper.COLUMN_REP, 1);
        contentValues.put(UserHelper.COLUMN_CREATED, 0);

        return db.insert(UserHelper.TABLE_NAME, null, contentValues);
    }
    public String getPassword(String name) //returns a string with the user's password.
    {
        SQLiteDatabase db= helper.getWritableDatabase();
        String[] columns={UserHelper.COLUMN_PW};
        String[] selectionArgs={name};
        Cursor cursor = db.query(UserHelper.TABLE_NAME, columns, UserHelper.COLUMN_NAME+" =?", selectionArgs, null, null, null);
        StringBuffer output = new StringBuffer();
        while(cursor.moveToNext())
        {
            int cpw = cursor.getColumnIndex(UserHelper.COLUMN_PW);
            String upw = cursor.getString(cpw);
            output.append(upw);
        }
        return output.toString();
    }

    public String getName(int uid)
    {
        SQLiteDatabase db= helper.getWritableDatabase();
        String[] columns={UserHelper.COLUMN_NAME};
        Cursor cursor = db.query(UserHelper.TABLE_NAME, columns, UserHelper.COLUMN_ID+" = '"+uid+"'", null, null, null, null);
        StringBuffer output = new StringBuffer();
        while(cursor.moveToNext()) //this shouldn't ever loop
        {
            int cname = cursor.getColumnIndex(UserHelper.COLUMN_PW);
            String uname = cursor.getString(cname);
            output.append(uname);
        }
        return output.toString();
    }

    public int getID(String name, String pw) //returns the ID of a user if given the name and pw. -1 if failure
    {
        SQLiteDatabase db= helper.getWritableDatabase();
        String[] columns={UserHelper.COLUMN_ID};
        String[] selectionArgs={name, pw};
        Cursor cursor = db.query(UserHelper.TABLE_NAME, columns, UserHelper.COLUMN_NAME+ " =? AND "+UserHelper.COLUMN_PW+" =?", selectionArgs, null, null, null);
        //StringBuffer output = new StringBuffer();
        int uid = -1;
        while(cursor.moveToNext()) //this shouldn't need to loop, since you shouldn't be able to have multiple users with same username
        {
            int cid = cursor.getColumnIndex(UserHelper.COLUMN_ID);
            uid = cursor.getInt(cid);
        }
        //return output.toString();
        return uid;
    }

    public void updatePW(int ID, String newPW) //updates password for a user with a given ID.
    {
        SQLiteDatabase db= helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserHelper.COLUMN_PW, newPW);

        db.update(UserHelper.TABLE_NAME, contentValues, UserHelper.COLUMN_ID+" = '"+ID+"'", null );
    }

    public void deleteUser(int ID)
    {
        SQLiteDatabase db= helper.getWritableDatabase();
        db.delete(UserHelper.TABLE_NAME, UserHelper.COLUMN_ID+" = '"+ID+"'", null);
    }

    public String getAllData()
    {
        SQLiteDatabase db= helper.getWritableDatabase();
        String[] columns={UserHelper.COLUMN_ID, UserHelper.COLUMN_NAME, UserHelper.COLUMN_PW, UserHelper.COLUMN_REP, UserHelper.COLUMN_CREATED, UserHelper.COLUMN_EMAIL, UserHelper.COLUMN_MOD};
        Cursor cursor = db.query(UserHelper.TABLE_NAME, columns, null, null, null, null, null);
        StringBuffer output = new StringBuffer();
        while(cursor.moveToNext())
        {
            int cid = cursor.getColumnIndex(UserHelper.COLUMN_ID);
            int uid = cursor.getInt(cid);

            int cname = cursor.getColumnIndex(UserHelper.COLUMN_NAME);
            String uname = cursor.getString(cname);

            int crep = cursor.getColumnIndex(UserHelper.COLUMN_REP);
            int urep = cursor.getInt(crep);

            int ccreated = cursor.getColumnIndex(UserHelper.COLUMN_CREATED);
            int ucreated = cursor.getInt(ccreated);

            int cemail = cursor.getColumnIndex(UserHelper.COLUMN_EMAIL);
            String uemail = cursor.getString(cemail);

            int cpw = cursor.getColumnIndex(UserHelper.COLUMN_PW);
            String upw = cursor.getString(cpw);

            int cmod = cursor.getColumnIndex(UserHelper.COLUMN_MOD);
            int umod = cursor.getInt(cmod);
            output.append(uid+" "+uname+" "+urep+" "+ucreated+" "+uemail+" "+upw+" "+umod+"\n");
        }
        return output.toString();
    }
    public String getSomeData(String selection, String[] selectionArgs, String groupBy, String having, String orderBy)
    {
        SQLiteDatabase db= helper.getWritableDatabase();
        String[] columns={UserHelper.COLUMN_ID, UserHelper.COLUMN_NAME, UserHelper.COLUMN_PW, UserHelper.COLUMN_REP, UserHelper.COLUMN_CREATED, UserHelper.COLUMN_EMAIL, UserHelper.COLUMN_MOD};
        Cursor cursor = db.query(UserHelper.TABLE_NAME, columns, selection, selectionArgs, groupBy, having, orderBy);
        StringBuffer output = new StringBuffer();
        while(cursor.moveToNext())
        {
            int cid = cursor.getColumnIndex(UserHelper.COLUMN_ID);
            int uid = cursor.getInt(cid);

            int cname = cursor.getColumnIndex(UserHelper.COLUMN_NAME);
            String uname = cursor.getString(cname);

            int crep = cursor.getColumnIndex(UserHelper.COLUMN_REP);
            int urep = cursor.getInt(crep);

            int ccreated = cursor.getColumnIndex(UserHelper.COLUMN_CREATED);
            int ucreated = cursor.getInt(ccreated);

            int cemail = cursor.getColumnIndex(UserHelper.COLUMN_EMAIL);
            String uemail = cursor.getString(cemail);

            int cpw = cursor.getColumnIndex(UserHelper.COLUMN_PW);
            String upw = cursor.getString(cpw);

            int cmod = cursor.getColumnIndex(UserHelper.COLUMN_MOD);
            int umod = cursor.getInt(cmod);

            output.append(uid+" "+uname+" "+urep+" "+ucreated+" "+uemail+" "+upw+" "+umod+"\n");
        }
        return output.toString();
    }


    static class UserHelper extends SQLiteOpenHelper
    {
        private static final int DATABASE_VERSION = 1;
        private static final String DATABASE_NAME = "PP_userDB";
        private static final String TABLE_NAME = "PP_User";
        private static final String COLUMN_ID = "_id";
        private static final String COLUMN_NAME = "Username";
        private static final String COLUMN_REP = "UserRep";
        private static final String COLUMN_CREATED = "UserCreated";
        private static final String COLUMN_EMAIL = "UserEmail";
        private static final String COLUMN_MOD = "Moderator";
        private static final String COLUMN_PW = "UserPW";
        private Context context;

        private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME + " VARCHAR(50), " + COLUMN_REP + " INTEGER, " + COLUMN_CREATED + " INTEGER, " + COLUMN_EMAIL + " VARCHAR(50), " +COLUMN_MOD + " INTEGER, "+ COLUMN_PW + " VARCHAR(50));";
        private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

        //SQLiteDatabase database;

        public UserHelper(Context context)
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

