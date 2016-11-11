package classes;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Post {

	private String username;
	private Timestamp timeCreated;
	private int forumId;
	private String textEntry;
	private ArrayList<Comment> commentList = new ArrayList<Comment>();
	private ArrayList<Rating> ratingList = new ArrayList<Rating>();
	
	
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
		this.username = username;
		this.timeCreated = timeCreated;
		this.forumId = forumId;
		this.textEntry = textEntry;
	}
	
	
	
}
