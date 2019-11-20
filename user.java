package com.example.pottypoll;
import androidx.test.core.app.ApplicationProvider;
import java.io.*;
import java.util.*;

public class user
{

	private long longitude;
	private long latitude;
	private String username;
	private String email;
	private int mod;
	private int id;
	private boolean loggedIn;
	private UserAdaptor database;

	public user()
	{

		username = "";
		email = "";
		longitude = -1;
		latitude = -1;
		mod = 0;
		loggedIn = false;
		database = new UserAdaptor(ApplicationProvider.getApplicationContext());
	}

	public user(String un, String e, int m)
	{

		username = un;
		email = e;
		mod = m;
		loggedIn = false;
		database = new UserAdaptor(ApplicationProvider.getApplicationContext());
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

			return true;

		}

		return false;

	}

	public boolean addUserToDatabase(String password)
	{
		//database = new UserAdaptor(ApplicationProvider.getApplicationContext());
		if(database.getPassword(username).length() > 0)
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

		//database = new UserAdaptor(ApplicationProvider.getApplicationContext());
		System.out.println("len = " + database.getPassword(username).length());
		if(user==null || emailAddress==null || pass==null ||
				!validEmail(emailAddress) || database.getPassword(username).length() > 0)
		{
			return false;

		}

		id = (int)database.insertData(user, pass, emailAddress, m);

		if(id < 0)
		{

			return false;

		}
		username = user;
		email = emailAddress;
		mod = m;

		return true;

	}

	public boolean logIn(String user, String pass)
	{
		//database = new UserAdaptor(ApplicationProvider.getApplicationContext());
		if(user==null || pass==null)
		{
			return false;
		}
		int idCheck = database.getID(user, pass);

		if(idCheck < 0)
		{
			//System.out.println("id = " + idCheck);
			return false;

		}
		else
		{

			username = user;
			id = idCheck;
			loggedIn = true;
			return true;

		}

		//return false;

	}

	public void logout ()
	{
		loggedIn = false;
		username = "";
		email = "";
		mod = 0;
		loggedIn = false;
	}

	private boolean validEmail(String given)
	{

		int size = given.length();
		int atSign = given.indexOf('@');
		int dotSign = given.indexOf('.');

		if(atSign < dotSign && dotSign == (size - 4))
		{

			return true;

		}

		return false;

	}

}
