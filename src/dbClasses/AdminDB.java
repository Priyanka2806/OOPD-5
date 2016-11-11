package dbClasses;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classes.DBDemo;

public class AdminDB {
	
	public int addAdmin(String username, String cont){
		int value = 0;
		PreparedStatement st;
		try {
			st = DBDemo.getCon().prepareStatement("INSERT INTO administrator(Username, Phone)"
					+ " VALUES(?, ?)");
			st.setString(1, username);
			st.setString(2, cont);
			
			value = st.executeUpdate();
	
	        
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		return value;
	}
	
	
	public ResultSet displayDetails(String username){
		ResultSet r = null;
		PreparedStatement st;
		try {
		st =DBDemo.getCon().prepareStatement("SELECT u.Username, Password, Email1, Email2, FirstName, LastName, AboutMe, PhotoURL1, PostalArea, Phone from user u, administrator a "
				+ "WHERE u.Username = a.Username and u.Username = ?");
		
		st.setString(1, username);
		r = st.executeQuery();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}
	
	public int updateDetails(int selection, String username, String value){
		String statement = "";
		int abc = 0;
		switch(selection){
				case 1 : statement = "UPDATE user u, administrator a SET u.Username = ? WHERE u.Username=a.Username and u.Username = ?";
						break;
				
				case 2: statement = "UPDATE user u, administrator a SET Password = ? WHERE u.Username=a.Username and u.Username = ?";
						break;
						
				case 3: statement = "UPDATE user u, administrator a SET Email1 = ? WHERE u.Username=a.Username and u.Username = ?";
						break;
						
				case 4: statement = "UPDATE user u, administrator a SET Email2 = ? WHERE u.Username=a.Username and u.Username = ?";
						break;
				
				case 5: statement = "UPDATE user u, administrator a SET FirstName = ? WHERE u.Username=a.Username and u.Username = ?";
						break;
						
				case 6: statement = "UPDATE user u, administrator a SET LastName = ? WHERE u.Username=a.Username and u.Username = ?";
						break;
				
				case 7: statement = "UPDATE user u, administrator a SET AboutMe = ? WHERE u.Username=a.Username and u.Username = ?";
						break;
						
				case 8: statement = "UPDATE user u, administrator a SET PhotoURL1 = ? WHERE u.Username=a.Username and u.Username = ?";
						break;
						
				case 9: statement = "UPDATE user u, administrator a SET PostalArea = ? WHERE u.Username=a.Username and u.Username = ?";
						break;
						
				case 10: statement = "UPDATE user u, administrator a SET Phone = ? WHERE u.Username=a.Username and u.Username = ?";
						break;
		}
		
		PreparedStatement st;
		try {
			st = DBDemo.getCon().prepareStatement(statement);
			st.setString(1, value);
			st.setString(2, username);
			
			abc = st.executeUpdate();
	        
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		return abc;
	}
	
}
