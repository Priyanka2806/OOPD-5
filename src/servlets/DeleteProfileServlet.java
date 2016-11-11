package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbClasses.SmartHealthDB;

public class DeleteProfileServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws  ServletException, IOException {
		
		String mString = null;
		String buttonSelected = request.getParameter("deleteButton");
		if(buttonSelected.equals("Confirm")){
		
			mString= "Profile De-activated successfully!! To activate it, Login";
			HttpSession sObj = request.getSession();
			String username = (String) sObj.getAttribute("u_name");
			SmartHealthDB obj = new SmartHealthDB();
			obj.deactivateUser(username);
			request.setAttribute("deleteMsg", mString);
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
		else if(buttonSelected.equals("Cancel")){
			request.getRequestDispatcher("/UserProfilePage.jsp").forward(request, response);
		}
		
	}


}
