package classes;

import java.sql.ResultSet;

import dbClasses.SmartHealthDB;

public abstract class Person {

	private String username;
	private String primaryEmail;
	private String secondaryEmail;
	private String password;
	private String firstName;
	private String lastName;
	private String address;
	private String aboutMe;
	private String[] photoURL = new String[3];
	private long regTime;
	private int userType;
	
	public Person(String username, String primaryEmail, String secondaryEmail, String password, String firstName,
			String lastName, String address, String aboutMe, String[] photoURL, long regTime, int userType) {
		super();
		this.username = username;
		this.primaryEmail = primaryEmail;
		this.secondaryEmail = secondaryEmail;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.aboutMe = aboutMe;
		this.photoURL = photoURL;
		this.regTime = regTime;
		this.userType = userType;
		
		SmartHealthDB shdb = new SmartHealthDB();
		shdb.addPerson(username, primaryEmail, secondaryEmail, password, firstName, lastName, address, aboutMe, regTime, photoURL, userType);
	}

	
	public String getUsername() {
		return username;
	}
	public String getPrimaryEmail() {
		return primaryEmail;
	}
	public void setPrimaryEmail(String primaryEmail) {
		this.primaryEmail = primaryEmail;
	}
	public String getSecondaryEmail() {
		return secondaryEmail;
	}
	public void setSecondaryEmail(String secondaryEmail) {
		this.secondaryEmail = secondaryEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAboutMe() {
		return aboutMe;
	}
	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}
	public String[] getPhotoURL() {
		return photoURL;
	}
	public void setPhotoURL(String[] photoURL) {
		this.photoURL = photoURL;
	}
	public long getRegTime() {
		return regTime;
	}
	public void setRegTime(long regTime) {
		this.regTime = regTime;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	
	abstract public ResultSet displayDetails(String username);
	abstract public  int updateDetails(String username, int selection, String value);
	abstract public void deleteUser(String username);
	
}
