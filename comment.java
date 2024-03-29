package com.example.pottypoll;
import java.io.*; 
import java.util.*;

class comment
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
	private CommentStruct current; 
	private int currentID;
	private CommentAdaptor database = new CommentAdaptor();
	private ArrayList<CommentStruct> comments = new ArrayList<CommentStruct>();

	public void comment()
	{

		current = new CommentStruct(0, 0, 0, 0, 0, 0, "");

	}

	public void comment(String comment, int rating, int userID, int bathroomID, int date, int helpful, int unhelpful)
	{

		current = new CommentStruct(bathroomID, userID, rating, date, helpful, unhelpful, comment);

	}

	public void comment(int alPos)
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

		database = new UserAdaptor(ApplicationProvider.getApplicationContext());
		current.HELPFUL++;
		database.MarkHelpful(currentID);

	}

	public void setUnhelpful()
	{

		database = new UserAdaptor(ApplicationProvider.getApplicationContext());
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

		database = new UserAdaptor(ApplicationProvider.getApplicationContext());
		comments = database.getCommentArray(current.PARENT);
		return comments;

	}

	public ArrayList getCommentsForBathroom(int bathroomID)
	{

		database = new UserAdaptor(ApplicationProvider.getApplicationContext());
		comments = database.getCommentArray(bathroomID);

	}

	public boolean addComment()
	{

		database = new UserAdaptor(ApplicationProvider.getApplicationContext());

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

		database = new UserAdaptor(ApplicationProvider.getApplicationContext());

		if(!checkForNulls(bID, uID, r, cmt))
		{

			return false;

		}

		currentID = (int)database.insertData(bID, uID, r, cmt);
		current.PARENT = bID;
		current.AUTHOR = uID;
		current.RATING = r;
		current.TEXT = cmt;

		if(currentID < 0)
		{

			return false;

		}

		return true;

	}

	public boolean editComment(int bathroomID, int userID, int rating, String edits, int commentID)
	{

		database = new UserAdaptor(ApplicationProvider.getApplicationContext());

		if(!checkForNulls(bathroomID, userID, rating, edits))
		{

			return false;

		}

		database.deleteComment(commentID);
		currentID = (int)database.insertData(bathroomID, userID, rating, edits);
		current.PARENT = bathroomID;
		current.AUTHOR = userID;
		current.RATING = rating;
		current.TEXT = edits;

		if(currentID < 0)
		{

			return false;

		}

		return true;		

	}
/*
	public void addFlag()
	{

		flags++;
		checkFlags();

	}
*/
	private void checkFlags()
	{

		database = new UserAdaptor(ApplicationProvider.getApplicationContext());
		if(database.getUnhelpful(currentID) >= MAX_FLAGS)
		{

			database.deleteComment(currentID);
			
		}

	}

	private boolean checkForNulls(int bID, int uID, int r, String cmt)
	{


		if(bID < 0 || uID < 0 || cmt == null)
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