package classes;

import java.sql.Timestamp;

public class Rating {

	private String postUsername;
	private Timestamp postTime;
	private String raterUsername;
	private float stars;
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
	public String getRaterUsername() {
		return raterUsername;
	}
	public void setRaterUsername(String raterUsername) {
		this.raterUsername = raterUsername;
	}
	public float getStars() {
		return stars;
	}
	public void setStars(float stars) {
		this.stars = stars;
	}
	public Rating(String postUsername, Timestamp postTime, String raterUsername, float stars) {
		super();
		this.postUsername = postUsername;
		this.postTime = postTime;
		this.raterUsername = raterUsername;
		this.stars = stars;
	}
	
	

}
