package servlets;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.Friendship;


public class AcceptRejectRequestServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws  ServletException, IOException {
		int result =0;
		String message="";
		String button = request.getParameter("AcceptRejectRequest");
		HttpSession session = request.getSession();
		String uname=(String)session.getAttribute("u_name");
		String requesterName = request.getParameter("uid");
		Friendship fdb = new Friendship();
		Calendar calendar = Calendar.getInstance();
		Date d = calendar.getTime();
		Timestamp t = new Timestamp(d.getTime());
		
		if(button.equals("Back")){
			request.getRequestDispatcher("/UserProfilePage.jsp").forward(request, response);
		}
		if(button.equals("Accept Friend Request")){
			result = fdb.acceptFriendRequest(uname, requesterName, t);
		}
		else if(button.equals("Reject Friend Request")){
			result = fdb.rejectFriendRequest(uname, requesterName, t);
		}
		if(result == 1){
			message = "Done!";
		}
		else{
			message = "Cannot complete the request!";
		}
	  
		session.setAttribute("arMsg", message);
		request.getRequestDispatcher("/PendingFriendRequests.jsp").forward(request, response);
		}

}
