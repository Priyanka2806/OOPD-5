package classes;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import dbClasses.SmartHealthDB;
import dbClasses.UserDB;


public class User extends Person {
	protected int karma;

	public User()
	{
		super();
	}

	public User(String username, String primaryEmail, String secondaryEmail,
			String password, String firstName, String lastName, String address,
			String aboutMe,  long regTime, String[] photoURL, int userType,
			int karma) {
		
		super(username, primaryEmail, secondaryEmail, password, firstName, lastName, address, aboutMe, photoURL, regTime,
				userType);
		UserDB udb = new UserDB();
		int var = udb.addUser(username, karma, regTime);
		if(var == 1){	
	        System.out.println("User Added Successfully!!");
		}
	}
 
	
	@Override
	public ResultSet displayDetails(String username)
	{
        ResultSet rs;
        UserDB udb = new UserDB();
		rs = udb.displayDetails(username);

		return rs;
  
	}
	


	@Override
	public int updateDetails(String username, int selection, String value) {
		UserDB udb = new UserDB();
		int var = udb.updateDetails(selection, username, value);
		return var;
		
	}


	@Override
	public int deleteUser(String username) {
		SmartHealthDB shdb = new SmartHealthDB();
		int var = shdb.deactivateUser(username);
		if(var == 1){
			System.out.println("User deactivated successfully!!");
		}
		return var;
		
	}
	

}
