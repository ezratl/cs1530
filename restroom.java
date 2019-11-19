package com.example.pottypoll;

class restroom
{

	private static final int MAX_FLAGS = 5;

	private long longitude;
	private long latitude;
	private int rating;
	private int numRatings = 0;
	private int ratingTotal = 0;
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
	private int flags = 0;
	private BathroomAdaptor database = new BathroomAdaptor();
	private ArrayList<BathroomStruct> restrooms = new ArrayList<BathroomStruct>();

	public static void restroom()
	{

		userID = 0;
		gender = "";
		address = "";
		name = "";
		floor = 0;
		hours = "";
		shower = 0;
		sink = 0;
		paperTowels = 0;

	}

	public static void restroom(int uID, String g, String a, String n, int f, String h, int sh, int snk, int pt)
	{

		userID = uID;
		gender = g;
		address = a;
		name = n;
		floor = f;
		hours = h;
		shower = sh;
		sink = snk;
		paperTowels = pt;

	}

	public static void restroom(int alPos)
	{

		id = restrooms.get(alPos).ID;
		gender = restrooms.get(alPos).GENDER;
		shower = restrooms.get(alPos).SHOWER;
		sink = restrooms.get(alPos).SINK;
		paperTowels = restrooms.get(alPos).PAPERTOWELS;
		floor = restrooms.get(alPos).FLOOR;
		hours = restrooms.get(alPos).HOURS;
		rating = restrooms.get(alPos).RATING;		//ask christian how the rating works in bathroom database, or figure it out /shrug
		ratingTotal = restrooms.get(alPos).RATERS;
		address = restrooms.get(alPos).LOCATION;
		latitude = restrooms.get(alPos).XCORD; 
		longitude = restrooms.get(alPos).YCORD;

	}


	public static void setLongitude(long l)
	{

		longitude = l;

	}

	public static void setLatitude(long l)
	{

		latitude = l;

	}

	public static void setRating(int r)
	{

		numRatings++;
		ratingTotal += r;
		rating = ratingTotal/numRatings;
		database.addRating(id);
		database.addRater(id);

	}

	public static void setUserID(int uID)
	{

		userID = uID;

	}

	public static void setGender(String g)
	{

		gender =  g;

	}

	public static void setAddress(String a)
	{

		address = a;

	}

	public static void setName(String n)
	{

		name = n;

	}

	public static void setFloor(int f)
	{

		floor = f;

	}

	public static void setHours(String h)
	{

		hours = h;

	}

	public static void setShower(int s)
	{

		shower = s;

	}

	public static void setSink(int s)
	{

		sink = s;

	}

	public static void setPT(int pt)
	{

		paperTowels = pt;

	}

	public static long getLongitude()
	{

		long l = longitude;
		return l;

	}

	public static long getLatitude()
	{

		long l = latitude;
		return l;

	}

	public static int getRating()
	{

		int r = rating;
		return r;

	}

	public static int getUserID()
	{

		int uid = userID;
		return uid;

	}

	public static String getGender()
	{

		String g = gender;
		return g;

	}

	public static String getAddress()
	{

		String a = address;
		return a;

	}

	public static String getName()
	{

		String n = name;
		return n;

	}

	public static int getFloor()
	{

		int f = floor;
		return f;

	}

	public static String getHours()
	{

		String h = hours;
		return h;

	}

	public static int getShower()
	{

		int s = shower;
		return s;

	}

	public static int getSink()
	{

		int s = sink;
		return s;

	}

	public static int getPT()
	{

		int pt = paperTowels;
		return pt;

	}

	public static boolean addRestroom(BathroomAdaptor database)
	{

		id = (int)database.insertData(userID, gender, address, name, floor, hours, shower, sink, paperTowels);

		if(id < 0)
		{

			return false;

		}

		return true;

	}

	public static boolean addRestroom(int uID, String g, String a, String n, int f, String h, int sh, int snk, int pt)
	{

		userID = uID;
		gender = g;
		address = a;
		name = n;
		floor = f;
		hours = h;
		shower = sh;
		sink = snk;
		paperTowels = pt;

		id = (int)database.insertData(userID, gender, address, name, floor, hours, shower, sink, paperTowels);

		if(id < 0)
		{

			return false;

		}

		return true;

	}

	public static ArrayList getRestrooms(long lng, long lat)
	{

		restrooms = database.getBathroomArray();

		for(int i = 0; i < restrooms.size; i++)
		{

			if(restrooms.get(i).XCORD == lat || restrooms.get(i).YCORD == lng)
			{

				restrooms.remove(i);

			}

		}

		return restrooms;

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

			database.deleteBathroom(id);

		}

	}

}