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

	public void comment()
	{

		comment = 0;
		rating = 0;
		id = 0;
		bathroomID = 0;

	}

	public void comment(String comment, int rating, int userID, int bathroomID)
	{

		this.comment = comment;
		this.rating = rating;
		this.userID = userID;
		this.bathroomID = bathroomID;

	}

	public void setComment(String shitpost)
	{

		comment = shitpost;

	}

	public void setRating(int rating)
	{

		numRatings++;
		ratingTotal += rating;
		this.rating = ratingTotal/numRatings;

	}

	public void setUserID(int userID)
	{

		this.userID = userID;
	}

	public void setBathroomID(int bathroomID)
	{

		this.bathroomID = bathroomID;
	}

	public String getComment()
	{

		String c = comment;
		return c;

	}

	public double getRating()
	{

		double r = rating;
		return r;

	}

	public int getUserID()
	{

		int i = userID;
		return i;

	}

	public int getBathroomID()
	{

		int i = bathroomID;
		return i;

	}

	public int getID()
	{

		int i = id;
		return i;
	}

	public void addComment(CommentAdaptor database)
	{

		id = (int)database.insertData(bathroomID, userID, rating, comment);

		if(id < 0)
		{

			System.out.println("Failed to add comment to database.");

		}

		return database;

	}

	public void addComment(int bID, int uID, int r, String cmt, CommentAdaptor database)
	{

		comment = cmt;
		rating = r;
		userID = uID;
		bathroomID = bID;

		id = (int)database.insertData(bID, uID, r, cmt);

		if(id < 0)
		{

			System.out.println("Failed to add comment to database.");

		}

		return database;

	}

	public void addFlag(CommentAdaptor database)
	{

		flags++;
		checkFlags(database);

	}

	private void checkFlags(CommentAdaptor database)
	{

		if(flags >= MAX_FLAGS)
		{

			database.deleteComment(id);
			
		}

	}

}