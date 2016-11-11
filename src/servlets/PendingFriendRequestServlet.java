package servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.Friendship;


public class PendingFriendRequestServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws  ServletException, IOException {
		ArrayList<String> pfrname_list = new ArrayList<>();
		
		
		String message=null;
		HttpSession session = request.getSession();
		String uname=(String)session.getAttribute("u_name");
		Friendship frnddb = new Friendship();
		ResultSet rs = frnddb.displayFriendRequests(uname);
		if(rs == null){
			message = "No pending friend requests!!";
			session.setAttribute("pfrMsg", message);
		}
		else{
			//int val=0;
			
			try {
				while(rs.next()){
					//PendingRequests pr = new PendingRequests(rs.getString(1), rs.getTimestamp(2));
					pfrname_list.add(rs.getString(1));
					
				}
				
				request.setAttribute("pendingFriends", pfrname_list);
				
				//request.setAttribute("pendingFriendsTime", time_list);
		
			} catch (SQLException e) {
				e.printStackTrace();
			}
	  
			request.getRequestDispatcher("/PendingFriendRequests.jsp").forward(request, response);
		}
		}

}
