package com.example.pottypoll;
import java.io.*; 
import java.util.*;

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

	public void user()
	{

		username = "";
		email = "";
		password = "";
		longitude = -1;
		latitude = -1;
		mod = 0;

	}

	public void user(String un, String e, String p, int m)
	{

		username = un;
		email = e;
		password = p;
		mod = m;

	}

	public void setLongitude(long l)
	{

		longitude = l;

	}

	public void setLatitude(long l)
	{

		latitude = l;

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

	public long getLongitude()
	{

		long l = longitude;
		return l;
		
	}

	public long getLatitude()
	{

		long l = latitude;
		return l;

	}

	public String getUsername()
	{

		String u = username;
		return u;

	}

	public String getPassword()
	{

		String p = password;
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

	public boolean getLoginStatus()
	{

		boolean l = loggedIn;
		return l;
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

	public boolean addUserToDatabase()
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

	public boolean addUserToDatabase(String user, String emailAddress, String pass, int m)
	{

		if(database.getPassword(user).length() <= 0 || database.getPassword(user) == null)
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

	public boolean logIn(String user, String pass)
	{

		int idCheck = database.getID(user, pass);

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

}