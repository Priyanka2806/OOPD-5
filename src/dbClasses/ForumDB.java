package dbClasses;
import java.sql.Timestamp;

import classes.DBDemo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ForumDB {

	public int addForumDetails(int forumID, String forumTopic, String forumURL, String forumDescription, 
			          Timestamp forumCreationTime, Timestamp forumCloseTime, String modCreatedUsername, String modClosedUsername)
	{
		int res_addForum=0;
		PreparedStatement addForumStmt;
		try {
			addForumStmt = DBDemo.getCon().prepareStatement("INSERT INTO forum(ForumID, Topic, URL, Summary, WhenCreated, CreatedByModerator_Username)"+ " VALUES(?, ?, ?, ?, ?, ?)");
			addForumStmt.setInt(1, forumID);
			addForumStmt.setString(2, forumTopic);
			addForumStmt.setString(3, forumURL);
			addForumStmt.setString(4, forumDescription);
			addForumStmt.setTimestamp(5, forumCreationTime);
			addForumStmt.setString(6, modCreatedUsername);
			res_addForum = addForumStmt.executeUpdate();
		} 
		catch (SQLException e) {
	
			e.printStackTrace();
		}
		return res_addForum;
	}
	
	public ResultSet displayActiveForumsFromDB()
	{
		PreparedStatement dispActiveStmt;
		ResultSet resultSet=null;
		try 
		{
			dispActiveStmt = DBDemo.getCon().prepareStatement("SELECT ForumID, Topic from forum WHERE WhenClosed is null");
			resultSet=dispActiveStmt.executeQuery();
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return resultSet;
	}
	public ResultSet displayClosedForumsFromDB()
	{
		PreparedStatement dispActiveStmt;
		ResultSet resultSet=null;
		try 
		{
			dispActiveStmt = DBDemo.getCon().prepareStatement("SELECT ForumID, Topic from forum WHERE WhenClosed is not null");
			resultSet=dispActiveStmt.executeQuery();
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public void searchForumDB(int id)
	{
		PreparedStatement searchForumStmt;
		ResultSet resultSet;
		try {
			searchForumStmt = DBDemo.getCon().prepareStatement("SELECT * from forum WHERE ForumID=?");
			searchForumStmt.setInt(1, id);
			resultSet = searchForumStmt.executeQuery();
	
			if(resultSet.next()){
				System.out.println("Welcome to the selected forum :D");
			}
			else
			{
				System.out.println("This forum does not exist!");
			}
			
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
	}
	
	public int closeForumDetails(String modName, int forumCloseID, Timestamp forumCloseTime)
	{	
		int res_closeForum=0;
		PreparedStatement closeForumStmt;
		try {
			closeForumStmt = DBDemo.getCon().prepareStatement("UPDATE forum SET WhenClosed = ?, DeletedByModerator_Username=? WHERE ForumID= ? ");
			closeForumStmt.setTimestamp(1, forumCloseTime);
			closeForumStmt.setString(2, modName);
			closeForumStmt.setInt(3, forumCloseID);
			res_closeForum = closeForumStmt.executeUpdate();
		} 
		catch (SQLException e) {
	
			e.printStackTrace();
		}
		return res_closeForum;
	}
	
	public int getCount()
	{
		ResultSet rSet;
		int rowCount=0;
		PreparedStatement getCountStmt;
		try {
			getCountStmt = DBDemo.getCon().prepareStatement("SELECT COUNT(*) FROM forum; ");
			rSet=getCountStmt.executeQuery();
			if(rSet.next())
			{
				rowCount=rSet.getInt(1);
			}
			
			
		} 
		catch (SQLException e) {
	
			e.printStackTrace();
		}
		
		return rowCount;
	}
	
}
