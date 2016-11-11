package classes;

import java.sql.Timestamp;

public class ModeratorQualifications {

	private int qualificationId;
	private String username;
	private Timestamp whenAdded;
	
	public ModeratorQualifications(int qualificationId, String username, Timestamp whenAdded) {
		super();
		this.qualificationId = qualificationId;
		this.username = username;
		this.whenAdded = whenAdded;
	}

	public int getQualificationId() {
		return qualificationId;
	}

	public void setQualificationId(int qualificationId) {
		this.qualificationId = qualificationId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Timestamp getWhenAdded() {
		return whenAdded;
	}

	public void setWhenAdded(Timestamp whenAdded) {
		this.whenAdded = whenAdded;
	}
	
	
	
	
}
