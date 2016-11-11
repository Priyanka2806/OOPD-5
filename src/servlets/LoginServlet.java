package servlets;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.crypto.provider.RSACipher;

import dbClasses.SmartHealthDB;
import dbClasses.UserDB;


public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws  ServletException, IOException {

		String message=null;
		//PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		
		String buttonSelected = request.getParameter("button");
		if(buttonSelected.equals("Login")){
		String email=request.getParameter("emailId");
		String password=request.getParameter("password");
		HttpSession sessionObj = request.getSession();
		SmartHealthDB ob = new SmartHealthDB();
		ResultSet value = ob.checkLogin(email, password);
		if(value == null){
			message = "Invalid Login ID, or Password!!";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
		else{
			try {
				sessionObj.setAttribute("loginObj", value);
				sessionObj.setAttribute("u_name", value.getString(1));
			//request.setAttribute("u_name", value);
			
			//request.setAttribute("uName", value);
				UserDB udb = new UserDB();
				String username;
				username = value.getString(1);
				message = "Welcome " + username + "!!" ;
				sessionObj.setAttribute("message", message);
				ResultSet rSet = udb.displayDetails(username);
				if(rSet.next()){
					sessionObj.setAttribute("NAME",rSet.getString(1));
					sessionObj.setAttribute("PASSWORD", rSet.getString(2));
					sessionObj.setAttribute("PRIMARY ID", rSet.getString(3));
					sessionObj.setAttribute("SECONDARY ID",rSet.getString(4));
					sessionObj.setAttribute("FIRST NAME",rSet.getString(5));
					sessionObj.setAttribute("LAST NAME", rSet.getString(6));
					sessionObj.setAttribute("ABOUT ME", rSet.getString(7));
					sessionObj.setAttribute("PHOTO URL", rSet.getString(8));
					sessionObj.setAttribute("POSTAL AREA", rSet.getString(9));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	  
			request.getRequestDispatcher("/UserProfilePage.jsp").forward(request, response);
		}
		
		
		}
		else if(buttonSelected.equals("Sign Up")){
			RequestDispatcher obj = request.getRequestDispatcher("/SignUp.jsp");
			obj.forward(request, response);
		}
	}

}
