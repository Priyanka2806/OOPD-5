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

public class SendRequestServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws  ServletException, IOException {
		int result =0;
		String message=null;
		String button = request.getParameter("sendPage");
		HttpSession session = request.getSession();
		String uname=(String)session.getAttribute("u_name");
		String recieverName = request.getParameter("frnd_id");
		
		if(button.equals("Back")){
			request.getRequestDispatcher("/UserProfilePage.jsp").forward(request, response);
		}
		else if(button.equals("Send Request")){
			Calendar c = Calendar.getInstance();
			Date d = c.getTime();
			Timestamp t = new Timestamp(d.getTime());
			Friendship friendship = new Friendship(uname, recieverName, t);
		}
		if(result == 1){
			message = "Done!";
		}
		else{
			message = "Cannot complete the request!";
		}
	  
		
		String abc = request.getParameter("sendPage");
		if(abc.equals("Back")){
			request.getRequestDispatcher("/UserProfilePage.jsp").forward(request, response);
		}
		else if(abc.equals("Send Request")){
			session.setAttribute("swMsg", message);
			request.getRequestDispatcher("/ViewActiveUsers.jsp").forward(request, response);
		}
		}


}
