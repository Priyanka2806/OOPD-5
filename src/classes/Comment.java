package classes;

import java.sql.Timestamp;

public class Comment {
 private String postUsername;
 private Timestamp postTime;
 private String commentUsername;
 private Timestamp commentTime;
 private String commentText;
 private String photoLocation;
 private String videoLocation;
 private String linkLocation;
public String getPostUsername() {
	return postUsername;
}
public void setPostUsername(String postUsername) {
	this.postUsername = postUsername;
}
public Timestamp getPostTime() {
	return postTime;
}
public void setPostTime(Timestamp postTime) {
	this.postTime = postTime;
}
public String getCommentUsername() {
	return commentUsername;
}
public void setCommentUsername(String commentUsername) {
	this.commentUsername = commentUsername;
}
public Timestamp getCommentTime() {
	return commentTime;
}
public void setCommentTime(Timestamp commentTime) {
	this.commentTime = commentTime;
}
public String getCommentText() {
	return commentText;
}
public void setCommentText(String commentText) {
	this.commentText = commentText;
}
public String getPhotoLocation() {
	return photoLocation;
}
public void setPhotoLocation(String photoLocation) {
	this.photoLocation = photoLocation;
}
public String getVideoLocation() {
	return videoLocation;
}
public void setVideoLocation(String videoLocation) {
	this.videoLocation = videoLocation;
}
public String getLinkLocation() {
	return linkLocation;
}
public void setLinkLocation(String linkLocation) {
	this.linkLocation = linkLocation;
}
public Comment(String postUsername, Timestamp postTime, String commentUsername, Timestamp commentTime,
		String commentText, String photoLocation, String videoLocation, String linkLocation) {
	super();
	this.postUsername = postUsername;
	this.postTime = postTime;
	this.commentUsername = commentUsername;
	this.commentTime = commentTime;
	this.commentText = commentText;
	this.photoLocation = photoLocation;
	this.videoLocation = videoLocation;
	this.linkLocation = linkLocation;
}

}
