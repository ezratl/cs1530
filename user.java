class user
{
	
	private int location[] = new int[2];	//longitude, latitude
	private String username;
	private String email;
	private String password;
	private int mod;
	private int id;

	public void user()
	{

		username = "";
		email = "";
		password = "";
		location[0] = -1;
		location[1] = -1;
		mod = 0;

	}

	public void user(String username, String email, String password, int mod)
	{

		this.username = username;
		this.email = email;
		this.password = password;
		this.mod = mod;

	}

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

	public void setUsername(String username)
	{

		this.username = username;

	}

	public void setPassword(String password)
	{

		this.password = password;

	}

	public void setEmail(String email)
	{

		this.email = email;
	}

	public void setMod(int mod)
	{

		this.mod = mod;

	}

	public int[] getLocation()
	{

		int l[] = location;
		return l;
		
	}

	public String getUsername()
	{

		String u = username;
		return u;

	}

	public String getPassword()
	{

		int p = password;
		return p;

	}

	public String getEmail()
	{

		String e = email;
		return e;

	}

	public int getMod()
	{

		int m = mod;
		return mod;

	}

	public int getID()
	{

		int i = id;
		return i;
	}

	public boolean checkSignUp(String user, String emailAddress, String pass)
	{

		//if email is a valid email address
		if(validEmail(emailAddress))
		{

			//save values
			username = user;
			email = emailAddress;
			password = pass;

			return true;

		}

		return false;

	}

	public UserAdaptor addUserToDatabase(UserAdaptor database)
	{

		id = (int)database.insertData(username, password, email, mod);
		
		if(id < 0)
		{

			System.out.println("Failed to add user to database.");

		}

		return database;

	}

	public UserAdaptor addUserToDatabase(String user, String emailAddress, String pass, int m, UserAdaptor database)
	{

		username = user;
		email = emailAddress;
		password = pass;
		mod = m;

		id = (int)database.insertData(user, pass, emailAddress, m);
		
		if(id < 0)
		{

			System.out.println("Failed to add user to database.");

		}

		return database;

	}

	public boolean logIn(String user, String pass, UserAdaptor database)
	{

		int id = database.getID(user, pass);

		if(idCheck < 0)
		{

			return false;

		}
		else
		{

			username = user;
			password = pass;
			id = idCheck;
			return true;

		}

		return false;

	}

	private boolean validEmail(String given)
	{

		int size = given.length();
		int atSign = given.indexOf('@');
		int dotSign = given.indexOf('.');

		if(atSign < dotSign && dotSign == (size - 3))
		{

			return true;

		}

		return false;

	}
/*
	public void addComment(String cmnt, CommentAdaptor database)
	{

		comment newComment = new comment(cmnt, 0);	//need to add it to appropriate restroom (shrug)
		//add comment to database

	}

	public void addRestroom()
	{

		//???

	}

	public void flagRestroom()
	{

		//get restroom
		restroom flagged = new restroom();
		flagged.addFlag();

	}

	public void flagComment()
	{

		//get comment
		comment flagged = new comment();
		flagged.addFlag();

	}

	public void rateRestroom(int rating)
	{

		//get restroom
		restroom rated = new restroom();
		rated.setRating(rating);

	}

	public void rateComment(int rating)
	{

		//get comment
		comment rated = new comment();
		rated.setRating(rating);

	}

	public int[] getNearestRestroom()
	{

		map finder = new map();
		int restroomLocation[] = finder.findNearestRestroom(location);
		return restroomLocation;

	}
*/
}