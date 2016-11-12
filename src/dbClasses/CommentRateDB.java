package dbClasses;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import classes.DBDemo;

public class CommentRateDB {
//add new comment method
	public int addComment(String postUsername,Timestamp postTime,String commentUsername,Timestamp commentTime,String commentText,String photoLocation,String linkLocation,String videoLocation)
	{
		int res_addComment=0;
		PreparedStatement addCommStmt;
		try {
			addCommStmt = DBDemo.getCon().prepareStatement("INSERT INTO post(Post_Username, Post_TimeCreated, Comment_Username, CommentTime, CommentText, PhotoLocation, LinkLocation, VideoLocation)"+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
			addCommStmt.setString(1, postUsername);
			addCommStmt.setTimestamp(2, postTime);
			addCommStmt.setString(3, commentUsername);
			addCommStmt.setTimestamp(4, commentTime);
			addCommStmt.setString(5, commentText);
			addCommStmt.setString(5, photoLocation);
			addCommStmt.setString(5, linkLocation);
			addCommStmt.setString(5, videoLocation);
			res_addComment = addCommStmt.executeUpdate();
		} 
		catch (SQLException e) {
	
			e.printStackTrace();
		}
		return res_addComment;
	}
	
	//retrieve comments method
	public ResultSet retrieveComments(String post_u_name)
	{
		
		PreparedStatement viewCommentsStmt;
		ResultSet resultSet=null;
		try 
		{
			viewCommentsStmt = DBDemo.getCon().prepareStatement("SELECT Post_TimeCreated, Comment_Username, CommentTime, CommentText, PhotoLocation, LinkLocation, VideoLocation from post WHERE Post_Username = ?");
			viewCommentsStmt.setString(1, post_u_name);
			resultSet=viewCommentsStmt.executeQuery();
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return resultSet;
	}
	
	//add new rating
		public int addRating(String postUsername,Timestamp postTime,String raterUsername,float stars)
		{
			int res_addRating=0;
			PreparedStatement addRatingStmt;
			try {
				addRatingStmt = DBDemo.getCon().prepareStatement("INSERT INTO rating(Post_Username, Post_TimeCreated, Rater_Username, Stars)"+ " VALUES(?, ?, ?, ?)");
				addRatingStmt.setString(1, postUsername);
				addRatingStmt.setTimestamp(2, postTime);
				addRatingStmt.setString(3, raterUsername);
				addRatingStmt.setFloat(4, stars);
				res_addRating = addRatingStmt.executeUpdate();
			} 
			catch (SQLException e) {
		
				e.printStackTrace();
			}
			return res_addRating;
		}
	
	//retrieve rating
		public ResultSet retrieveRatings(String post_u_name)
		{
			
			PreparedStatement viewCommentsStmt;
			ResultSet resultSet=null;
			try 
			{
				viewCommentsStmt = DBDemo.getCon().prepareStatement("SELECT Post_TimeCreated, Comment_Username, CommentTime, CommentText, PhotoLocation, LinkLocation, VideoLocation from post WHERE Post_Username = ?");
				viewCommentsStmt.setString(1, post_u_name);
				resultSet=viewCommentsStmt.executeQuery();
				
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			return resultSet;
		}
}
