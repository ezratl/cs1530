class restroom
{

	private static final int MAX_FLAGS = 5;

	//private int location[] = {0, 0};	//longitude, latitude
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

	public void restroom()
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

	public void restroom(int userID, String gender, String address, String name, int floor, String hours, int shower, int sink, int pt)
	{

		this.userID = userID;
		this.gender = gender;
		this.address = address;
		this.name = name;
		this.floor = floor;
		this.hours = hours;
		this.shower = shower;
		this.sink = sink;
		paperTowels = pt;

	}

/*
	public void setLongitude(int longitude)
	{

		location[0] = longitude;

	}

	public void setLatitude(int latitude)
	{

		location[1] = latitude;

	}

	public void setLocation(int location[])
	{

		this.location = location;
	}
*/
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

	public void setGender(String gender)
	{

		this.gender =  gender;

	}

	public void setAddress(String address)
	{

		this.address = address;

	}

	public void setName(String name)
	{

		this.name = name;

	}

	public void setFloor(int floor)
	{

		this.floor = floor;

	}

	public void setHours(String hours)
	{

		this.hours = hours;

	}

	public void setShower(int shower)
	{

		this.shower = shower;

	}

	public void setSink(int sink)
	{

		this.sink = sink;

	}

	public void setPT(int paperTowels)
	{

		this.paperTowels = paperTowels;
	}

/*
	public int[] getLocation()
	{

		int l[] = location;
		return location;

	}
*/
	public double getRating()
	{

		double r = rating;
		return r;

	}

	public int getUserID()
	{

		int uid = userID;
		return uid;

	}

	public String getGender()
	{

		String g = gender;
		return g;

	}

	public String getAddress()
	{

		String a = address;
		return a;

	}

	public String getName()
	{

		String n = name;
		return n;

	}

	public int getFloor()
	{

		int f = floor;
		return f;

	}

	public String getHours()
	{

		String h = hours;
		return h;

	}

	public int getShower()
	{

		int s = shower;
		return s;

	}

	public int getSink()
	{

		int s = sink;
		return s;

	}

	public int getPT()
	{

		int pt = paperTowels;
		return pt;

	}

	public BathroomAdaptor addRestroom(BathroomAdaptor database)
	{

		id = (int)database.insertData(userID, gender, address, name, floor, hours, shower, sink, paperTowels);

		if(id < 0)
		{

			System.out.println("Failed to add restroom to database.");

		}

		return database;

	}

	public BathroomAdaptor addRestroom(int userID, String gender, String address, String name, int floor, String hours, int shower, int sink, int pt, BathroomAdaptor database)
	{

		this.userID = userID;
		this.gender = gender;
		this.address = address;
		this.name = name;
		this.floor = floor;
		this.hours = hours;
		this.shower = shower;
		this.sink = sink;
		paperTowels = pt;

		id = (int)database.insertData(userID, gender, address, name, floor, hours, shower, sink, paperTowels);

		if(id < 0)
		{

			System.out.println("Failed to add restroom to database.");

		}

		return database;

	}

	public void addFlag()
	{

		flags++;
		checkFlags();

	}

	private void checkFlags()
	{

		if(flags >= MAX_FLAGS)
		{

			//remove the restroom

		}

	}

}