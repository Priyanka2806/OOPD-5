package dbClasses;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classes.DBDemo;

public class SmartHealthDB {
	
	public int addPerson(String username, String primaryEmail, String secondaryEmail,
			String password, String firstName, String lastName, String address,
			String aboutMe,  long regTime, String[] photoURL,  int userType){
		int value = 0;
		PreparedStatement st1;
		try {
			st1 = DBDemo.getCon().prepareStatement("INSERT INTO user(Username, Password, Email1, Email2, FirstName, LastName, AboutMe, PhotoURL1, PhotoURL2, PhotoURL3, PostalArea, UserTypeID, Status)"
					+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 1)");
			st1.setString(1, username);
			st1.setString(2, password);
			st1.setString(3, primaryEmail);
			st1.setString(4, secondaryEmail);
			st1.setString(5, firstName);
			st1.setString(6, lastName);
			st1.setString(7, aboutMe);
			st1.setString(8, photoURL[0]);
			st1.setString(9, photoURL[1]);
			st1.setString(10, photoURL[2]);
			st1.setString(11, address);
			st1.setInt(12, userType);
			//st1.setInt(13, userType);
			value = st1.executeUpdate();

			
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		return value;
	}
	
	public ResultSet checkLogin(String loginId, String password){
		PreparedStatement st1;
		ResultSet rs = null;
		try {
			st1 = DBDemo.getCon().prepareStatement("SELECT Username, UserTypeID from user where Email1 = ? and Password = ?");
					
			st1.setString(1, loginId);
			st1.setString(2, password);
			
			rs = st1.executeQuery();

		

		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		return rs;
	}
	
	public int deactivateUser(String username){
		int value = 10;
		PreparedStatement st;
		int newStatus = 0;
		try {
			st = DBDemo.getCon().prepareStatement("UPDATE user SET Status = ? WHERE Username = ?");
			st.setInt(1, newStatus);
			st.setString(2, username);
			value = st.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return value;
   
	}
	
	public ResultSet validateUser(){
		
		PreparedStatement ps;
		ResultSet rset = null;
			try {
				ps = DBDemo.getCon().prepareStatement("SELECT Username FROM user");
				rset = ps.executeQuery();
				
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return rset;	
	}	

}
