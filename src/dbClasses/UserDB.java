package dbClasses;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classes.DBDemo;

public class UserDB {

	public int addUser(String username, int karma, long regTime){
		int value = 0;
		PreparedStatement  st2;
		Date d = new Date(regTime);
		try {
			
			st2 = DBDemo.getCon().prepareStatement("INSERT INTO enduser(Username, Karma, DateCreated)"
					+ " VALUES(?, ?, ?)");
			st2.setString(1, username);
			st2.setInt(2, karma);
			
			
			st2.setDate(3,d);
			
			value = st2.executeUpdate();
			
	        
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		return value;
	}
	
	public ResultSet displayDetails(String username)
	{
		PreparedStatement st, s1;
        ResultSet rs = null;
		try {
			s1 = DBDemo.getCon().prepareStatement("UPDATE user SET Status = 1");
			int b = s1.executeUpdate();
			st = DBDemo.getCon().prepareStatement("SELECT u.Username, Password, Email1, Email2, FirstName, LastName, AboutMe, PhotoURL1, PostalArea from user u, enduser e where u.Username = e.Username and u.Username = ?");
			st.setString(1, username);
			rs = st.executeQuery();

			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return rs;  
	}
	
	public int updateDetails(int selection, String username, String value){
		String statement = "";
		int temp = 0;
		switch(selection){
				case 1 : statement = "UPDATE user u, enduser e SET u.Username = ? WHERE u.Username=e.Username and u.Username = ?";
						break;
				
				case 2: statement = "UPDATE user u, enduser e SET Password = ? WHERE u.Username=e.Username and u.Username = ?";
						break;
						
				case 3: statement = "UPDATE user u, enduser e SET Email1 = ? WHERE u.Username=e.Username and u.Username = ?";
						break;
						
				case 4: statement = "UPDATE user u, enduser e SET Email2 = ? WHERE u.Username=e.Username and u.Username = ?";
						break;
				
				case 5: statement = "UPDATE user u, enduser e SET FirstName = ? WHERE u.Username=e.Username and u.Username = ?";
						break;
						
				case 6: statement = "UPDATE user u, enduser e SET LastName = ? WHERE u.Username=e.Username and u.Username = ?";
						break;
				
				case 7: statement = "UPDATE user u, enduser e SET AboutMe = ? WHERE u.Username=e.Username and u.Username = ?";
						break;
						
				case 8: statement = "UPDATE user u, enduser e SET PhotoURL1 = ? WHERE u.Username=e.Username and u.Username = ?";
						break;
						
				case 9: statement = "UPDATE user u, enduser e SET PostalArea = ? WHERE u.Username=e.Username and u.Username = ?";
						break;
		}
		
		PreparedStatement st;
		try {
			st = DBDemo.getCon().prepareStatement(statement);
			st.setString(1, value);
			st.setString(2, username);
			
			temp = st.executeUpdate();
	     
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		return temp;
	}
	
	public ResultSet displayActiveUsers() {
		//int val1 = 0;
		PreparedStatement st3; 
		ResultSet rs = null;
		try{
			st3 = DBDemo.getCon().prepareStatement("SELECT Username from user WHERE Status = ? and UserTypeId = ?");
			st3.setInt(1, 1);
			st3.setInt(2, 1);
			rs = st3.executeQuery();
		}
		
		catch (SQLException e) {

			e.printStackTrace();
	}
		return rs;
	}
}
