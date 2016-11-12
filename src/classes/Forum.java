package classes;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import dbClasses.ForumDB;


public class Forum 
{
	Scanner in = new Scanner(System.in);
	int forum_id_count=0;
	protected int forumID;
	protected String forumTopic;
	protected String forumURL;
	protected String forumDescription;
	protected Timestamp forumCreationTime;
	protected Timestamp forumCloseTime;
	protected String modCreatedUsername;
	protected String modClosedUsername;
	protected ArrayList<Post> postList = new ArrayList<Post>();
	
	public Forum() {
		super();
	}
	
//	public Forum(int forumID, String forumTopic, String forumURL, String forumDescription, Timestamp forumCreationTime,
//			Timestamp forumCloseTime, String modCreatedUsername, String modClosedUsername) {
//		super();
//		//forumID=;
//		this.forumID=++forum_id_count;
//		this.forumTopic = forumTopic;
//		forumURL = "http://smarthealth.com/" + forumID + forumTopic;
//		this.forumURL = forumURL;
//		this.forumDescription = forumDescription;
//		this.forumCreationTime = forumCreationTime;
//		this.forumCloseTime = forumCloseTime;
//		this.modCreatedUsername = modCreatedUsername;
//		this.modClosedUsername = modClosedUsername;
//		
//		ForumDB forumdb = new ForumDB();
//		int abc = forumdb.addForumDetails(forumID, forumTopic, forumURL, forumDescription, forumCreationTime, forumCloseTime, modCreatedUsername, modClosedUsername);
//		if(abc == 1){
//			System.out.println("Forum added successfully!!");
//		}
//	}
	public void addNewForum(String modUname)
	{
		int addForumResult=0;
		String url;
		//int x=++forum_id_count;
		
		ForumDB forumdb = new ForumDB();
		forum_id_count=forumdb.getCount();
		System.out.println("Rowcount in forum class is: " + forum_id_count);
		this.forumID=++forum_id_count;
		System.out.println("forum id is: " + this.forumID);
		
		System.out.println("Enter topic for the forum");
		String topic = in.nextLine();
		this.forumTopic = topic;
		
		url = "http://smarthealth.com/" + forumID + forumTopic;
		this.forumURL = url;
		
		System.out.println("Enter short description for the forum");
		String description = in.nextLine();
		this.forumDescription = description;
		
		Calendar calForumCreation = Calendar.getInstance();
		Date dateForumCreation = calForumCreation.getTime();
		Timestamp tsForumCreation = new Timestamp(dateForumCreation.getTime());
		this.forumCreationTime = tsForumCreation;
		
		this.forumCloseTime = null;
		
		this.modCreatedUsername = modUname;
		this.modClosedUsername = null;
		
		
		addForumResult = forumdb.addForumDetails(forumID, forumTopic, forumURL, forumDescription, forumCreationTime, forumCloseTime, modCreatedUsername, modClosedUsername);
		if(addForumResult == 1){
			System.out.println("Forum added successfully!!");
		}
	}
	
	public int displayActiveForums()
	{
		ResultSet rs_active;
		int flag=0;
		ForumDB forumdb = new ForumDB();
		rs_active=forumdb.displayActiveForumsFromDB();
		try {
			while(rs_active.next())
			{
				System.out.println("ID-" + rs_active.getInt(1) + "  " + "Topic-" + rs_active.getString(2));
				flag=1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	public int displayClosedForums()
	{
		ResultSet rs_closed;
		int flag=0;
		ForumDB forumdb = new ForumDB();
		rs_closed=forumdb.displayClosedForumsFromDB();
		try {
			while(rs_closed.next())
			{
				System.out.println("ID-" + rs_closed.getInt(1) + "  " + "Topic-" + rs_closed.getString(2));
				flag=1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
		
	}
	//To search for a forum and display its details
	public int searchForum(int fID) throws SQLException
	{
		int res=0;
		ResultSet rs=null;
		ForumDB forumdb = new ForumDB();
		forumdb.searchForumDB(fID);
		Post post_obj = new Post();
		rs=post_obj.viewPosts(fID);
		while(rs.next())
		{
			Post pst = new Post();
			try {
				pst.setUsername(rs.getString(1));
				pst.setTextEntry(rs.getString(2));
				pst.setPhotoLocation(rs.getString(3));
				pst.setLinkLocation(rs.getString(4));
				pst.setVideoLocation(rs.getString(5));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			postList.add(pst);
		}
		return res;
	}
	
	public void closeForum(String modName)
	{
		int deleteForumResult=0;
		System.out.println("List of active forums:\n ");
		int i = displayActiveForums();
		System.out.println("Enter the forum ID of the forum you want to close:\n ");
		int deleteID = in.nextInt();
		in.nextLine();
		
		Calendar calForumClose = Calendar.getInstance();
		Date dateForumClose = calForumClose.getTime();
		Timestamp tsForumClose = new Timestamp(dateForumClose.getTime());
		this.forumCloseTime = tsForumClose;
		
		ForumDB forumdb = new ForumDB();
		deleteForumResult = forumdb.closeForumDetails(modName,deleteID,tsForumClose);
		if(deleteForumResult!=0)
		{
			System.out.println("Forum deleted successfully!!");
		}
	}
	
	
}
