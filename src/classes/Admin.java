package classes;

import java.sql.ResultSet;

import dbClasses.SmartHealthDB;
import dbClasses.AdminDB;

public class Admin extends Person{

	protected char contactNo[];
	
	public Admin(String username, String primaryEmail, String secondaryEmail,
			String password, String firstName, String lastName, String address,
			String aboutMe,  long regTime, String[] photoURL, int userType,
			char contactNo[]) {
		
		super(username, primaryEmail, secondaryEmail, password, firstName, lastName, address, aboutMe, photoURL, regTime,
				userType);
		
		this.contactNo = contactNo;
		
		
		
		//To be shifted to either jsp or Servlet -----
		String cont ="";
		for(int k=0; k<=9; k++){
			cont = cont + contactNo[k];
		}
		//--------------
		
		
		
		AdminDB adb = new AdminDB();
		int abc = adb.addAdmin(username, cont);
		
		//print statement not required here
		if(abc == 1){
			System.out.println("Admin Added Successfully!!");
		}  
		//--------------
	}
	
	@Override
	public ResultSet displayDetails(String username) {

		//System.out.println("Display of admin");
        ResultSet rs = null;
        AdminDB adb = new AdminDB();
		rs = adb.displayDetails(username);
		
		return rs;
	}

	@Override
	public int updateDetails(String username, int selection, String value) {
		AdminDB adb = new AdminDB();
		int var = adb.updateDetails(selection, username, value);
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
