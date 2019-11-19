package com.example.pottypoll;

class comment
{
	private static final int MAX_FLAGS = 5;

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
	private CommentAdaptor database = new CommentAdaptor();
	private ArrayList<CommentStruct> comments = new ArrayList<CommentStruct>();

	public static void comment()
	{

		comment = 0;
		rating = 0;
		id = 0;
		bathroomID = 0;

	}

	public static void comment(String cmnt, int r, int uID, int bID)
	{

		comment = cmnt;
		rating = r;
		userID = uID;
		bathroomID = bID;

	}

	public static void comment(int alPos)
	{

		comment = comments.get(alPos).TEXT;
		rating = comments.get(alPos).RATING;
		userID = comments.get(alPos).AUTHOR;
		bathroomID = comments.get(alPos).PARENT;
		helpful = comments.get(alPos).HELPFUL;
		unhelpful = comments.get(alPos).UNHELPFUL;

	}

	public static void setComment(String shitpost)
	{

		comment = shitpost;

	}

	public static void setRating(int r)
	{

		rating = r;

	}

	public static void setUserID(int uID)
	{

		userID = uID;
	
	}

	public static void setBathroomID(int bID)
	{

		bathroomID = bID;

	}

	public static String getComment()
	{

		String c = comment;
		return c;

	}

	public static double getRating()
	{

		double r = rating;
		return r;

	}

	public static int getUserID()
	{

		int i = userID;
		return i;

	}

	public static int getBathroomID()
	{

		int i = bathroomID;
		return i;

	}

	public static int getID()
	{

		int i = id;
		return i;
	}

	public static void setHelpful()
	{

		helpful++;
		database.MarkHelpful(id);

	}

	public static void setUnhelpful()
	{

		unhelpful++;
		database.MarkUnhelpful(id);

	}

	public static int getHelpful()
	{

		int h = helpful;
		return helpful;

	}

	public static int getUnhelpful()
	{

		int uh = unhelpful;
		return uh;

	}

	public static ArrayList getCommentsForBathroom()
	{

		comments = database.getCommentArray(bathroomID);
		return comments;

	}

	public static boolean addComment()
	{

		id = (int)database.insertData(bathroomID, userID, rating, comment);

		if(id < 0)
		{

			return false;

		}

		return true;

	}

	public static boolean addComment(int bID, int uID, int r, String cmt)
	{

		comment = cmt;
		rating = r;
		userID = uID;
		bathroomID = bID;

		id = (int)database.insertData(bID, uID, r, cmt);

		if(id < 0)
		{

			return false;

		}

		return true;

	}

	public static void addFlag()
	{

		flags++;
		checkFlags();

	}

	private static void checkFlags()
	{

		if(flags >= MAX_FLAGS)
		{

			database.deleteComment(id);
			
		}

	}

}