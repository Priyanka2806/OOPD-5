package dbClasses;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;


import classes.DBDemo;

public class FriendshipDB {
	
	public int addFriendship(String requesterUsername, String requestedUsername, Timestamp time){
		int value = 0;
		PreparedStatement st, st1;
		ResultSet resultSet;
		try {
			st = DBDemo.getCon().prepareStatement("SELECT * from friendship WHERE (Requester_Username = ? and Requested_Username = ?) or (Requester_Username = ? and Requested_Username = ?)");
			st.setString(1, requesterUsername);
			st.setString(2, requestedUsername);
			st.setString(3, requestedUsername);
			st.setString(4, requesterUsername);
			resultSet = st.executeQuery();
	
			if(resultSet.next()){
				System.out.println("Cannot send friend request multiple times!!");
			}
			else{
			st1 = DBDemo.getCon().prepareStatement("INSERT INTO friendship(Requester_Username, Requested_Username, WhenRequested)"
					+ " VALUES(?, ?, ?)");
			st1.setString(1, requesterUsername);
			st1.setString(2, requestedUsername);
			st1.setTimestamp(3, time);
			
			value = st1.executeUpdate();
		
			}
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		return value;
		
	}
	
	public ResultSet displayFriendRequests(String username){
		ResultSet r2 = null;
		PreparedStatement st2;
		try {
			st2 = DBDemo.getCon().prepareStatement("SELECT Requester_Username, WhenRequested FROM friendship where Requested_Username = ? and WhenRejected is NULL and WhenConfirmed is NULL and WhenWithdrawn is NULL");	
			st2.setString(1, username);
			r2 = st2.executeQuery();
	        
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		return r2;

		}
	
	public ResultSet searchFriend(String username){
		PreparedStatement sta;
		ResultSet r3 = null;
		try {
			sta = DBDemo.getCon().prepareStatement("SELECT Username, Email1, FirstName, LastName FROM user WHERE Username = ? and Status = 1");
			sta.setString(1, username);
			
			r3 = sta.executeQuery();
			
		}
			 catch (SQLException e) {
					
					e.printStackTrace();
				}
		return r3;
	}
	
public int acceptFriendRequest(String username, String requesterUsername, Timestamp time){
		int value = 0;
		PreparedStatement st3;
		try {
			st3 = DBDemo.getCon().prepareStatement("UPDATE friendship SET WhenConfirmed = ? WHERE Requested_Username = ? and Requester_Username = ?");
			st3.setTimestamp(1, time);
			st3.setString(2, username);
			st3.setString(3, requesterUsername);
			
			value = st3.executeUpdate();
	        
	
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		return value;
	}

public int rejectFriendRequest(String username, String requesterUsername, Timestamp time){
	int value = 0;
	PreparedStatement st3;
	try {
		st3 = DBDemo.getCon().prepareStatement("UPDATE friendship SET WhenRejected = ? WHERE Requested_Username = ? and Requester_Username = ?");
		
		st3.setTimestamp(1, time);
		st3.setString(2, username);
		st3.setString(3, requesterUsername);
		//st1.setDate(3, time);
		
		value = st3.executeUpdate();
      
	} catch (SQLException e) {

		e.printStackTrace();
	}
	return value;
}

public int unFriend(String username, String requestedUsername, Timestamp time){
	int value = 0;
	PreparedStatement st3;

	try {
		st3 = DBDemo.getCon().prepareStatement("UPDATE friendship SET WhenUnfriended = ? WHERE ((Requested_Username = ? and Requester_Username = ?) or (Requested_Username = ? and Requester_Username = ?))  and WhenConfirmed is NOT NULL");
		
		st3.setTimestamp(1, time);
		st3.setString(2, requestedUsername);
		st3.setString(3, username);
		st3.setString(4, username);
		st3.setString(5, requestedUsername);
		//st1.setDate(3, time);
		
		value = st3.executeUpdate();
       
	} catch (SQLException e) {

		e.printStackTrace();
	}
	return value;
}

public int withdrawFriendRequest(String username, String requestedUsername, Timestamp time){
	int value = 0;
	//ResultSet rs;
	PreparedStatement st3; 

	try {
		
		st3 = DBDemo.getCon().prepareStatement("UPDATE friendship SET WhenWithdrawn = ? WHERE Requester_Username = ? and Requested_Username = ? and WhenConfirmed is NULL and WhenRejected is NULL");
		
		st3.setTimestamp(1, time);
		st3.setString(2, username);
		st3.setString(3, requestedUsername);
		
		value = st3.executeUpdate();
		 
	
	} catch (SQLException e) {

		e.printStackTrace();
	
	
}
	return value;
}

	public ResultSet displayActiveFriends(String username) {
	//int val1 = 0;
	PreparedStatement st3; 
	ResultSet rs = null;
	try{
		st3 = DBDemo.getCon().prepareStatement("SELECT Requester_Username, Requested_Username from friendship WHERE (Requested_Username = ? or Requester_Username = ?) and WhenConfirmed is NOT NULL and WhenUnfriended is NULL");
		st3.setString(1, username);
		st3.setString(2, username);
		rs = st3.executeQuery();
	}
	
	catch (SQLException e) {

		e.printStackTrace();
}
	return rs;
}

public ResultSet returnStatus(String username){
	//int val1 = 0;
	PreparedStatement st3; 
	ResultSet rs = null;
	try{
		st3 = DBDemo.getCon().prepareStatement("SELECT Status from user WHERE Username = ?");
		st3.setString(1, username);
		//st3.setString(2, username);
		rs = st3.executeQuery();
	}
	
	catch (SQLException e) {

		e.printStackTrace();
}
	return rs;
}

public static ResultSet friendshipWithdrawStatus(String username)
{
	//int fStatus=0;
	PreparedStatement st4; 
	ResultSet rs = null;
	try{
		st4 = DBDemo.getCon().prepareStatement("Select Requested_Username from friendship WHERE Requester_Username = ? and WhenConfirmed is NULL and WhenRejected is NULL");
		st4.setString(1, username);
		rs = st4.executeQuery();
	}
	
	catch (SQLException e) {

		e.printStackTrace();
	}
	return rs;
}

}
