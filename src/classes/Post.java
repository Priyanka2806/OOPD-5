package classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;

import dbClasses.CommentRateDB;
import dbClasses.ForumDB;
import dbClasses.PostDB;
import servlets.ActiveUserDetails;

public class Post {

	private String username;
	private Timestamp timeCreated;
	private int forumId;
	private String textEntry;
	private ArrayList<Comment> commentList = new ArrayList<Comment>();
	private ArrayList<Rating> ratingList = new ArrayList<Rating>();
	private String photoLocation;
	private String linkLocation;
	private String videoLocation;
	
	public Post()
	{
		super();
	}
	public String getPhotoLocation() {
		return photoLocation;
	}
	public void setPhotoLocation(String photoLocation) {
		this.photoLocation = photoLocation;
	}
	public String getLinkLocation() {
		return linkLocation;
	}
	public void setLinkLocation(String linkLocation) {
		this.linkLocation = linkLocation;
	}
	public String getVideoLocation() {
		return videoLocation;
	}
	public void setVideoLocation(String videoLocation) {
		this.videoLocation = videoLocation;
	}
	
	public String getUsername() {
		return username;
	}
	public ArrayList<Comment> getCommentList() {
		return commentList;
	}
	public void setCommentList(ArrayList<Comment> commentList) {
		this.commentList = commentList;
	}
	public ArrayList<Rating> getRatingList() {
		return ratingList;
	}
	public void setRatingList(ArrayList<Rating> ratingList) {
		this.ratingList = ratingList;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Timestamp getTimeCreated() {
		return timeCreated;
	}
	public void setTimeCreated(Timestamp timeCreated) {
		this.timeCreated = timeCreated;
	}
	public int getForumId() {
		return forumId;
	}
	public void setForumId(int forumId) {
		this.forumId = forumId;
	}
	public String getTextEntry() {
		return textEntry;
	}
	public void setTextEntry(String textEntry) {
		this.textEntry = textEntry;
	}
	
	public Post(String username, Timestamp timeCreated, int forumId, String textEntry ) {
		super();
		int addPostResult;
		this.username = username;
		this.timeCreated = timeCreated;
		this.forumId = forumId;
		this.textEntry = textEntry;
		PostDB pdb = new PostDB();
		addPostResult=pdb.addPost(username,timeCreated,forumId,textEntry,photoLocation,linkLocation,videoLocation);
//		if(addPostResult==1)
//		{
//			System.out.println("Post added!");
//		}
		
	}
	
	public ResultSet viewPosts(int forum_id)
	{
		ResultSet res_set_view=null;
		PostDB pdb_view = new PostDB();
		res_set_view=pdb_view.viewPost(forum_id);
		return res_set_view;
	}
	
	//To search for a post and display the comments on it
	public int formCommentList(String post_username) throws SQLException
	{
		int res=0;
		ResultSet rs=null;
		CommentRateDB comm_db = new CommentRateDB();
		rs=comm_db.retrieveComments(post_username);
		while(rs.next())
		{
			Comment comm_obj = new Comment();
			try {
				comm_obj.setPostUsername(post_username);
				comm_obj.setPostTime(rs.getTimestamp(1));
				comm_obj.setCommentUsername(rs.getString(2));
				comm_obj.setCommentTime(rs.getTimestamp(3));
				comm_obj.setCommentText(rs.getString(4));
				comm_obj.setPhotoLocation(rs.getString(5));
				comm_obj.setLinkLocation(rs.getString(6));
				comm_obj.setVideoLocation(rs.getString(7));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			commentList.add(comm_obj);
		}
		return res;
	}
	
	//To search for a post and display the average rating on it
		public float formRatingsListAndComputeRating(String post_username) throws SQLException
		{
			float avg_rating=0;
			float sum=0;
			int total_ratings=0;
			ResultSet rs=null;
			CommentRateDB rate_db = new CommentRateDB();
			rs=rate_db.retrieveRatings(post_username);
			while(rs.next())
			{
				Rating rate_obj = new Rating();
				try {
					rate_obj.setPostUsername(post_username);
					rate_obj.setPostTime(rs.getTimestamp(2));
					rate_obj.setRaterUsername(rs.getString(3));
					rate_obj.setStars(rs.getFloat(4));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ratingList.add(rate_obj);
			}
			total_ratings=ratingList.size();
			
			Iterator<Rating> ratingIterator = ratingList.iterator();
			while(ratingIterator.hasNext())
			{
				Rating rate_obj = ratingIterator.next();
				sum=sum+rate_obj.getStars();
			}
			
			avg_rating=sum/total_ratings;
			return avg_rating;
		}
		

	
	
	
}
