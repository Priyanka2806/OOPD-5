package classes;


import java.sql.ResultSet;

import java.sql.Timestamp;

import dbClasses.FriendshipDB;

public class Friendship {

	protected String requesterUsername;
	protected String requestedUsername;
	protected Timestamp whenRequested;
	protected Timestamp whenWithdrawn;
	protected Timestamp whenRejected;
	protected Timestamp whenConfirmed;
	protected Timestamp whenUnfriended;

	public Friendship() {
		super();
	}

	public Friendship(String requesterUsername, String requestedUsername, Timestamp whenRequested) {
		
		this.requesterUsername = requesterUsername;
		this.requestedUsername = requestedUsername;
		this.whenRequested = whenRequested;
		
		
		FriendshipDB fdb = new FriendshipDB();
		int abc = fdb.addFriendship(requesterUsername, requestedUsername, whenRequested);
		if(abc == 1){
			System.out.println("Friend Request Sent!!");
		}
	}
	
	//To display pending friend requests
	public ResultSet displayFriendRequests(String username){
		//int flag = 0;
		ResultSet rs;
		FriendshipDB fdb = new FriendshipDB();
		rs = fdb.displayFriendRequests(username);
		
		return rs;
	}
	
	public ResultSet searchFriend(String username){
		//int tem = 0;
		FriendshipDB fdb = new FriendshipDB();
		ResultSet rs = fdb.searchFriend(username);
		
		return rs;
	}
	
	//To accept a friend request
	public int acceptFriendRequest(String username, String requesterUsername, Timestamp whenConfirmed){
		FriendshipDB fdb = new FriendshipDB();
		this.whenConfirmed = whenConfirmed;
		int abc = fdb.acceptFriendRequest(username, requesterUsername, whenConfirmed);
		return abc;
	
	}
	
	//To reject a friend request
	public int rejectFriendRequest(String username, String requesterUsername, Timestamp whenRejected){
		this.whenRejected = whenRejected;
		FriendshipDB fdb = new FriendshipDB();
		int abc = fdb.rejectFriendRequest(username, requesterUsername, whenRejected);
		return abc;
	}
		
	//To withdraw a friend request
	public int withdrawFriendRequest(String username, String requestedUsername, Timestamp whenWithdrawn){
			
		this.whenWithdrawn = whenWithdrawn;
		FriendshipDB fdb = new FriendshipDB();
		int abc = fdb.withdrawFriendRequest(username, requestedUsername, whenWithdrawn);
		return abc;
	}
	
	public int unFriend(String username, String requestedUsername, Timestamp whenUnfriended){
		
		this.whenUnfriended = whenUnfriended;
		FriendshipDB fdb = new FriendshipDB();
		int abc = fdb.unFriend(username, requestedUsername, whenUnfriended);
		return abc;
	}

	public ResultSet displayActiveFriends(String username) {
		//int val = 0;
		ResultSet rs = null;
		FriendshipDB fdb = new FriendshipDB();
		rs = fdb.displayActiveFriends(username);
		
		return rs;
	}

}
