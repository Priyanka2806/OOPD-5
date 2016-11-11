package servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.User;




public class UserProfilePageServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws  ServletException, IOException {
		
		String Selection = request.getParameter("UserOptions");
		HttpSession s = request.getSession();
		if(Selection.equals("Logout")){
			
			s.invalidate();
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
		else if(Selection.equals("Delete Profile")){
			
			request.getRequestDispatcher("/DeleteProfile.jsp").forward(request, response);
		}
		else if(Selection.equals("Update Profile")){
			User udb = (User)s.getAttribute("loginObj");
			String username = request.getParameter("u_name");
			ResultSet rSet = udb.displayDetails(username);
			
			try {
				if(rSet.next()){
					request.setAttribute("NAME",rSet.getString(1));
					request.setAttribute("PASSWORD", rSet.getString(2));
					request.setAttribute("PRIMARY ID", rSet.getString(3));
					request.setAttribute("SECONDARY ID",rSet.getString(4));
					request.setAttribute("FIRST NAME",rSet.getString(5));
					request.setAttribute("LAST NAME", rSet.getString(6));
					request.setAttribute("ABOUT ME", rSet.getString(7));
					request.setAttribute("PHOTO URL", rSet.getString(8));
					request.setAttribute("POSTAL AREA", rSet.getString(9));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("/UpdateProfile.jsp").forward(request, response);
		}
		else if(Selection.equals("View Active Users")){
			System.out.println("Active Users View");
		}
		else if(Selection.equals("View Friends")){
			System.out.println("View Friends");
		}
		else if(Selection.equals("View Pending Friend Requests")){
			System.out.println("Pending Friend Requests");
			
		}
		
		
	}
}
