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


public class UnfriendedServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws  ServletException, IOException {
		String choice = request.getParameter("Unfriend");
		if(choice.equals("Unfriend")){
			String message=null;
			HttpSession session = request.getSession();
			String uname=(String)session.getAttribute("u_name");
			String requestedUsername = request.getParameter("userid");
			Friendship fdb = new Friendship();
			Calendar c = Calendar.getInstance();
			Date d = c.getTime();
			Timestamp t = new Timestamp(d.getTime());
			int result = fdb.unFriend(uname, requestedUsername, t);
			if(result == 1){
				message = "Unfriended Successfully!";
				session.setAttribute("unfrndMsg", message);
			}
			else{
				message = "Cannot Unfriend!";
				session.setAttribute("unfrndMsg", message);
			}
	  
			request.getRequestDispatcher("/ViewFriends.jsp").forward(request, response);
		}
		else if(choice.equals("Back")){
			request.getRequestDispatcher("/UserProfilePage.jsp").forward(request, response);
		}
	}
	

}
