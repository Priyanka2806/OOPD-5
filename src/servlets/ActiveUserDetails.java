package servlets;

public class ActiveUserDetails {

	public String active_username;
	public int withdraw_request = 0;
	public int isFriend = 0;
	
	public ActiveUserDetails(){
		super();
	}
	
	public ActiveUserDetails(String active_username, int withdraw_request, int isFriend) {
		super();
		this.active_username = active_username;
		this.withdraw_request = withdraw_request;
		this.isFriend = isFriend;	
	};
}
