package classes;

public class UserType {

	private int userTypeId;
	private String description;
	
	
	public UserType(int userTypeId, String description) {
		super();
		this.userTypeId = userTypeId;
		this.description = description;
	}
	public int getUserTypeId() {
		return userTypeId;
	}
	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
