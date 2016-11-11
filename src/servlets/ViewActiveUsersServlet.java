package servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbClasses.FriendshipDB;
import dbClasses.UserDB;

public class ViewActiveUsersServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws  ServletException, IOException {
		ArrayList<String> usrname_list = new ArrayList<>();
		ArrayList<String> friend_list = new ArrayList<>();
		ArrayList<ActiveUserDetails> activeUser_list = new ArrayList<>();
		ArrayList<String> usrname_withdraw_list = new ArrayList<>();
		ArrayList<String> usrname_sendReq_list = new ArrayList<>();
		
		HttpSession session = request.getSession();
		String uname=(String)session.getAttribute("u_name");
		String message=null;
		
		UserDB udb = new UserDB();
		FriendshipDB frendb = new FriendshipDB();
		ResultSet withdrawRS = FriendshipDB.friendshipWithdrawStatus(uname);  
		ResultSet rs = udb.displayActiveUsers();
		//Adding active users to a list
		if(rs == null){
			message = "No active users other than you!";
			session.setAttribute("userMsg", message);
		}
		else{
			ActiveUserDetails aud;
			try {
				while(rs.next()){
					usrname_list.add(rs.getString(1));
					aud = new ActiveUserDetails();
					aud.active_username = rs.getString(1);
					activeUser_list.add(aud);
				}
				request.setAttribute("activeUsers", usrname_list);
		
			} catch (SQLException e) {
				e.printStackTrace();
			}
	  
			//request.getRequestDispatcher("/ViewActiveUsers.jsp").forward(request, response);
		}
		
		
		//Adding users to withdrawList
		if(withdrawRS == null){
			
		}
		else{
			
			try {
				while(withdrawRS.next()){
					usrname_withdraw_list.add(withdrawRS.getString(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	  
			
		}
		
		
		//Adding users to friends list
		ResultSet rs_active_frnd = frendb.displayActiveFriends(uname);
		if(rs_active_frnd == null){

		}
		else{
			//int val=0;
			
			try {
				while(rs_active_frnd.next()){
					//val = 1;
					if(rs_active_frnd.getString(1).equals(uname)){
						ResultSet r1 = frendb.returnStatus(rs_active_frnd.getString(2));
						if(r1.next()){
							if(r1.getInt(1) == 1){
								//System.out.println(rs.getString(2));
								friend_list.add(rs_active_frnd.getString(2));
							}
						}
					}
					else if(rs_active_frnd.getString(2).equals(uname)){
						ResultSet r2 = frendb.returnStatus(rs_active_frnd.getString(1));
						if(r2.next()){
							if(r2.getInt(1) == 1){
								//System.out.println(rs.getString(1));
								friend_list.add(rs_active_frnd.getString(1));
							}
						}
					}
					request.setAttribute("activeFriends", friend_list);
		
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
			///Setting flags for withdraw requests and isFriend
			Iterator<ActiveUserDetails> activeUserIterator = activeUser_list.iterator();
			while(activeUserIterator.hasNext())
			{
				ActiveUserDetails aud_obj = activeUserIterator.next();
				
				Iterator<String> withdrawIterator = usrname_withdraw_list.iterator();
				while (withdrawIterator.hasNext()) {
					String obj_withdraw_string = withdrawIterator.next();
					if(aud_obj.active_username.equals(obj_withdraw_string))
					{
						aud_obj.withdraw_request = 1;
					}
				}
				
				Iterator<String> activeFriendIterator = friend_list.iterator();
				while (activeFriendIterator.hasNext()) {
					String obj_friend_string = activeFriendIterator.next();
					if(aud_obj.active_username.equals(obj_friend_string))
					{
						aud_obj.isFriend = 1;
					}
				}
				if(aud_obj.withdraw_request == 0 && aud_obj.isFriend == 0)
				{
					usrname_sendReq_list.add(aud_obj.active_username);
				}
			}
		}
		
		request.setAttribute("activeUserDetails", activeUser_list);
		
		
		String userOption = request.getParameter("UserOptions");
		if(userOption.equals("Withdraw Friend Requests")){
			request.setAttribute("withdrawList", usrname_withdraw_list);
			request.getRequestDispatcher("/ViewWithdrawList.jsp").forward(request, response);
		}
		else if(userOption.equals("Send Friend Request")){
			request.setAttribute("sendRequestList", usrname_sendReq_list);
			request.getRequestDispatcher("/ViewActiveUsers.jsp").forward(request, response);
		}
	}
}
