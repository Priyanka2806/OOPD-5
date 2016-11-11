package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.User;



public class UpdateProfileServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws  ServletException, IOException {
		String option = request.getParameter("UpdateOption");
		if(option.equals("Update")){
			String updateMsg = null;
			String select = request.getParameter("updateSelection");
			int sel = Integer.parseInt(select);
			String newValue = request.getParameter("new_value");
			HttpSession sObj = request.getSession();
			String username = (String) sObj.getAttribute("u_name");
			User ob1 = (User) sObj.getAttribute("loginObj");
			int temp = ob1.updateDetails(username, sel, newValue);
			String field = "";
			switch(sel){
			case 1: field = "NAME";
				break;
			case 2: field = "PASSWORD";
				break;
			case 3: field = "PRIMARY ID";
				break;
			case 4: field = "SECONDARY ID";
				break;
			case 5: field = "FIRST NAME";
				break;
			case 6: field = "LAST NAME";
				break;
			case 7: field = "ABOUT ME";
				break;
			case 9: field = "POSTAL AREA";
				break;
			}
			if(temp == 1){
				sObj.setAttribute(field, newValue);
				updateMsg = "Update Successful!! You can make more updates or go back to Profile.";
			}
			else{
				updateMsg = "Updation Failed. Try again!!";
			}
			request.setAttribute("updateMsg", updateMsg);
			request.getRequestDispatcher("/UpdateProfile.jsp").forward(request, response);
		}
		else if(option.equals("Back")){
			request.getRequestDispatcher("/UserProfilePage.jsp").forward(request, response);
		}
	}
	

}
