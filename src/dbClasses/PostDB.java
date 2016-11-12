package dbClasses;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import classes.DBDemo;

public class PostDB {
	public int addPost(String username,Timestamp timeCreated,int forumId,String textEntry,String photoLocation,String linkLocation,String videoLocation)
	{
		int res_addPost=0;
		PreparedStatement addHDStmt;
		try {
			addHDStmt = DBDemo.getCon().prepareStatement("INSERT INTO post(Username, TimeCreated, ForumID, TextEntry, PhotoLocation, LinkLocation, VideoLocation)"+ " VALUES(?, ?, ?, ?, ?, ?, ?)");
			addHDStmt.setString(1, username);
			addHDStmt.setTimestamp(2, timeCreated);
			addHDStmt.setInt(3, forumId);
			addHDStmt.setString(4, textEntry);
			addHDStmt.setString(5, photoLocation);
			addHDStmt.setString(5, linkLocation);
			res_addPost = addHDStmt.executeUpdate();
		} 
		catch (SQLException e) {
	
			e.printStackTrace();
		}
		return res_addPost;
	}
	
	public ResultSet viewPost(int f_id)
	{
		
		PreparedStatement viewPostsStmt;
		ResultSet resultSet=null;
		try 
		{
			viewPostsStmt = DBDemo.getCon().prepareStatement("SELECT Username, TextEntry, PhotoLocation, LinkLocation, VideoLocation from post WHERE ForumID = ?");
			viewPostsStmt.setInt(1, f_id);
			resultSet=viewPostsStmt.executeQuery();
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return resultSet;
	}

}
