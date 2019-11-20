package com.example.pottypoll;

class user
{
	
	private long longitude;
	private long latitude;
	private String username;
	private String email;
	private String password;
	private int mod;
	private int id;
	private boolean loggedIn = false;
	private UserAdaptor database = new UserAdaptor();

	public static void user()
	{

		username = "";
		email = "";
		password = "";
		location[0] = -1;
		location[1] = -1;
		mod = 0;

	}

	public static void user(String un, String e, String p, int m)
	{

		username = un;
		email = e;
		password = p;
		mod = m;

	}

	public static void setLongitude(long l)
	{

		longitude = l;

	}

	public static void setLatitude(long l)
	{

		latitude = l;

	}

	public static void setUsername(String username)
	{

		this.username = username;

	}

	public static void setPassword(String password)
	{

		this.password = password;

	}

	public static void setEmail(String email)
	{

		this.email = email;
	}

	public static void setMod(int mod)
	{

		this.mod = mod;

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

	public static String getUsername()
	{

		String u = username;
		return u;

	}

	public static String getPassword()
	{

		int p = password;
		return p;

	}

	public static String getEmail()
	{

		String e = email;
		return e;

	}

	public static int getMod()
	{

		int m = mod;
		return mod;

	}

	public static int getID()
	{

		int i = id;
		return i;
	}

	public static boolean getLoginStatus()
	{

		boolean l = loggedIn;
		return l;
	}

	public static boolean checkSignUp(String user, String emailAddress, String pass)
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

	public static boolean addUserToDatabase()
	{

		if(database.getPassword(username).length() > 0 ||database.getPassword(username) != null)
		{

			return false;

		}

		id = (int)database.insertData(username, password, email, mod);
		
		if(id < 0)
		{

			return false;

		}

		return true;

	}

	public static boolean addUserToDatabase(String user, String emailAddress, String pass, int m)
	{

		if(database.getPassword(user).length() > 0 ||database.getPassword(user) != null)
		{

			return false;

		}

		username = user;
		email = emailAddress;
		password = pass;
		mod = m;

		id = (int)database.insertData(user, pass, emailAddress, m);
		
		if(id < 0)
		{

			return false;

		}

		return true;

	}

	public static boolean logIn(String user, String pass)
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
			loggedIn = true;
			return true;

		}

		return false;

	}

	private static boolean validEmail(String given)
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

}