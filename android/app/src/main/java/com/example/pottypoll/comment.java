package com.example.pottypoll;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;
import java.io.*; 
import java.util.*;


import java.io.*;
import java.util.*;

public class comment
{
	private static final int MAX_FLAGS = 5;

	/*
        private String comment;
        private int rating;
        private int numRatings = 0;
        private int ratingTotal = 0;
        private int flags = 0;
        private int id;
        private int userID;
        private int bathroomID;
        private int helpful = 0;
        private int unhelpful = 0;
    */
	private int flags;
	private CommentStruct current;
	private int currentID;
	private CommentAdaptor database;
	private ArrayList<CommentStruct> comments = new ArrayList<CommentStruct>();

	public comment(Context context)
	{
		database = new CommentAdaptor(context);
		current = new CommentStruct(0, 0, 0, 0, 0, 0, "");

	}

	public comment(Context context, String comment, int rating, int userID, int bathroomID, int date, int helpful, int unhelpful)

	{
		database = new CommentAdaptor(context);
		current = new CommentStruct(bathroomID, userID, rating, date, helpful, unhelpful, comment);

	}

	public comment(int alPos)
	{

		current = comments.get(alPos);

	}

	public void setComment(String shitpost)
	{

		current.TEXT = shitpost;

	}

	public void setRating(int rating)
	{

		current.RATING = rating;

	}

	public void setUserID(int userID)
	{

		current.AUTHOR = userID;
	}

	public void setBathroomID(int bathroomID)
	{

		current.PARENT = bathroomID;

	}

	public String getComment()
	{

		String c = current.TEXT;
		return c;

	}

	public int getRating()
	{

		int r = current.RATING;
		return r;

	}

	public int getUserID()
	{

		int i = current.AUTHOR;
		return i;

	}

	public int getBathroomID()
	{

		int i = current.PARENT;
		return i;

	}

	public int getID()
	{

		int i = currentID;
		return i;
	}

	public void setHelpful()
	{
		current.HELPFUL++;
		database.MarkHelpful(currentID);

	}

	public void setUnhelpful()
	{

		current.UNHELPFUL++;
		database.MarkUnhelpful(currentID);
		checkFlags();

	}

	public int getHelpful()
	{

		int h = current.HELPFUL;
		return h;

	}

	public int getUnhelpful()
	{

		int uh = current.UNHELPFUL;
		return uh;

	}

	public ArrayList getCommentsForBathroom()
	{
		comments = database.getCommentArray(current.PARENT);
		return comments;

	}

	public ArrayList getCommentsForBathroom(int bathroomID)
	{

		comments = database.getCommentArray(bathroomID);
		return comments;
	}

	public boolean addComment()
	{
		if(!checkForNulls(current.PARENT, current.AUTHOR, current.RATING, current.TEXT))
		{

			return false;

		}

		currentID = (int)database.insertData(current.PARENT, current.AUTHOR, current.RATING, current.TEXT);

		if(currentID < 0)
		{

			return false;

		}

		return true;

	}

	public boolean addComment(int bID, int uID, int r, String cmt)
	{
		if (r<0 || r>5)
			return false;

		if(!checkForNulls(bID, uID, r, cmt))
		{

			return false;

		}

		currentID = (int)database.insertData(bID, uID, r, cmt);

		if(currentID < 0)
		{
			return false;
		}

		current.PARENT = bID;
		current.AUTHOR = uID;
		current.RATING = r;
		current.TEXT = cmt;

		return true;

	}
  
	public boolean deleteComment(int userID)
  	{
	  if(userID <0 || userID != current.AUTHOR)
	  {
		  return false;
	  }
		database.deleteComment(currentID);
		current = new CommentStruct(0, 0, 0, 0, 0, 0, "");
		return true;
  	}


	public boolean editComment(int userID, String edits)
	{

		if(userID <0 || userID != current.AUTHOR || edits ==null)
		{
			return false;
		}

		database.deleteComment(currentID);
		currentID = (int)database.insertData(current.PARENT, userID, current.RATING, edits);
		current.TEXT = edits;

		if(currentID < 0)
		{

			return false;

		}

		return true;		

	}
	

   public void addFlag()
   {
       flags++;
       checkFlags();
   }

   private void checkFlags() {

	   if (database.getUnhelpful(currentID) >= MAX_FLAGS) {

		   database.deleteComment(currentID);
	   }
   }

	private boolean checkForNulls(int bID, int uID, int r, String cmt)
	{


		if(bID < 0 || uID < 0 || cmt == null || cmt.length() == 0)
		{

			return false;

		}

		if(r < 0 || r > 5)
		{
			return false;
		}

		return true;

	}

}