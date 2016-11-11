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


public class SendWithdrawRequestServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws  ServletException, IOException {
		int result =0;
		String message=null;
		String button = request.getParameter("sendWithdraw");
		HttpSession session = request.getSession();
		String uname=(String)session.getAttribute("u_name");
		String recieverName = request.getParameter("fid");
		Friendship f = new Friendship();
		Calendar c = Calendar.getInstance();
		Date d = c.getTime();
		Timestamp t = new Timestamp(d.getTime());
		if(button.equals("Back")){
			request.getRequestDispatcher("/UserProfilePage.jsp").forward(request, response);
		}
		//else if(button.equals("Send Friend Request")){
		
			//result = f.addFriendship(uname, recieverName, t);
		//}
		else if(button.equals("Withdraw")){
			result = f.withdrawFriendRequest(uname, recieverName, t);
		}
		if(result == 1){
			message = "Done!";
		}
		else{
			message = "Cannot complete the request!";
		}
	  
		String def = request.getParameter("sendWithdraw");
		if(def.equals("Withdraw")){
			session.setAttribute("swMsg", message);
			request.getRequestDispatcher("/ViewWithdrawList.jsp").forward(request, response);
		}
		else if(def.equals("Back")){
			request.getRequestDispatcher("/UserProfilePage.jsp").forward(request, response);
		}
		}

}
