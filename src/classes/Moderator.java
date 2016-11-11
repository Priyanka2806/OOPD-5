package classes;


import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Scanner;


import dbClasses.ModeratorDB;
import dbClasses.SmartHealthDB;

public class Moderator extends Person{
	
	protected String qualification;
	protected char contactNo[];


	public Moderator(String username, String primaryEmail,
			String secondaryEmail, String password, String firstName,
			String lastName, String address, String aboutMe, long regTime, String[] photoURL,
			 int userType, String qualification,
			char contactNo[]) {
		
		super(username, primaryEmail, secondaryEmail, password, firstName, lastName, address, aboutMe, photoURL, regTime,
				userType);
		this.qualification = qualification;
		this.contactNo = contactNo;

		
		String [] qualify = qualification.split(",");
		String cont ="";
		for(int k=0; k<=9; k++){
			cont = cont + contactNo[k];
		}
		 ModeratorDB mdb = new ModeratorDB();
		 int var = mdb.addModerator(username, cont, qualify, regTime);
		 
		 if(var == 1){
	        System.out.println("Moderator Added Successfully!!");
		 }   
	}

	@Override
	public ResultSet displayDetails(String username)
	{
		ResultSet rs, rs1;
		ModeratorDB mdb = new ModeratorDB();
		rs = mdb.displayDetails(username);
		//rs1 = mdb.displayQualDetails(username);
		String q="";
			return rs;
	}
	
	@Override
	public int updateDetails(String username, int selection, String value)
	{
		
		ModeratorDB mdb = new ModeratorDB();
		int var = mdb.updateDetails(selection, username, value);
		return var;

	}
	
	@Override
	public void deleteUser(String username) {
		SmartHealthDB shdb = new SmartHealthDB();
		int var = shdb.deactivateUser(username);
		if(var == 1){
			System.out.println("User deactivated successfully!!");
		}
		
	}
}
