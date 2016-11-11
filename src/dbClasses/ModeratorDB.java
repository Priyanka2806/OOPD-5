package dbClasses;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classes.DBDemo;

public class ModeratorDB {

	public int addModerator(String username, String cont, String[] qualify, long regTime){
		int value = 0, value1 = 0, value2 = 0;
		PreparedStatement st, s1;
		try {
			st = DBDemo.getCon().prepareStatement("INSERT INTO moderator(Username, Phone)"
					+ " VALUES(?, ?)");
			st.setString(1, username);
			st.setString(2, cont);
			
			value1 = st.executeUpdate();
			
			s1 = DBDemo.getCon().prepareStatement("INSERT INTO moderatorqualification(QualificationID, Username, WhenAdded)"
					+ " VALUES(?, ?, ?)");
			for(int i=0; i<qualify.length; i++){
				
				s1.setInt(1, Integer.parseInt(qualify[i]));
				s1.setString(2, username);
				Date d = new Date(regTime);
				s1.setDate(3, d);
			
				value2 = s1.executeUpdate();
				
				
			} 
		}catch (SQLException e) {
	
			e.printStackTrace();
		}
		if(value1 == 1 && value2 == 1){
			value = 1;
		}
		return value;
	}
	
	
	public ResultSet displayDetails(String username)
	{
		PreparedStatement st1;
		ResultSet rs = null;
		//ResultSet rs1 = null;
		try {
			st1 = DBDemo.getCon().prepareStatement("SELECT u.Username, Password, Email1, Email2, FirstName, LastName, AboutMe, PhotoURL1, PostalArea, Phone from user u, moderator m where u.Username = m.Username and u.Username = ?");
			//ps1 = DBDemo.getCon().prepareStatement("SELECT q.Description from user u, moderatorqualification mq, qualification q where u.Username = mq.Username and mq.QualificationID = q.QualificationID and u.Username = ?");		
			st1.setString(1, username);
			//ps1.setString(1, username);
			
			rs = st1.executeQuery();
			//rs1 = ps1.executeQuery();
			
		} 
		catch (SQLException e) {
	
				e.printStackTrace();
		}
		
		return rs;
	}
	
	public ResultSet displayQualDetails(String username)
	{
		PreparedStatement ps1;
		ResultSet rs = null;
		//ResultSet rs1 = null;
		try {
			//st1 = DBDemo.getCon().prepareStatement("SELECT u.Username, Password, Email1, Email2, FirstName, LastName, AboutMe, PhotoURL1 PostalArea, Phone, q.Description from user u, moderator m, moderatorqualification mq, qualification q where u.Username = m.Username and m.Username = mq.Username and mq.QualificationID = q.QualificationID and u.Username = ?");
			ps1 = DBDemo.getCon().prepareStatement("SELECT q.Description from user u, moderatorqualification mq, qualification q where u.Username = mq.Username and mq.QualificationID = q.QualificationID and u.Username = ?");		
			ps1.setString(1, username);
			//ps1.setString(1, username);
			
			rs = ps1.executeQuery();
			
		} 
		catch (SQLException e) {
	
				e.printStackTrace();
		}
		
		return rs;
	}
	public int updateDetails(int selection, String username, String value){
		String statement = "";
		int abc = 0;
		switch(selection){
				case 1: statement = "UPDATE user u, moderator m SET u.Username = ? WHERE u.Username=m.Username and u.Username = ?";
						break;
				
				case 2: statement = "UPDATE user u, moderator m SET Password = ? WHERE u.Username=m.Username and u.Username = ?";
						break;
						
				case 3: statement = "UPDATE user u, moderator m SET Email1 = ? WHERE u.Username=m.Username and u.Username = ?";
						break;
						
				case 4: statement = "UPDATE user u, moderator m SET Email2 = ? WHERE u.Username=m.Username and u.Username = ?";
						break;
				
				case 5: statement = "UPDATE user u, moderator m SET FirstName = ? WHERE u.Username=m.Username and u.Username = ?";
						break;
						
				case 6: statement = "UPDATE user u, moderator m SET LastName = ? WHERE u.Username=m.Username and u.Username = ?";
						break;
				
				case 7: statement = "UPDATE user u, moderator m SET AboutMe = ? WHERE u.Username=m.Username and u.Username = ?";
						break;
				
				case 8: statement = "UPDATE user u, moderator m SET PhotoURL1 = ? WHERE u.Username=m.Username and u.Username = ?";
						break;
						
				case 9: statement = "UPDATE user u, moderator m SET PostalArea = ? WHERE u.Username=m.Username and u.Username = ?";
						break;
						
				case 10: statement = "UPDATE user u, moderator m SET Phone = ? WHERE u.Username=m.Username and u.Username = ?";
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
