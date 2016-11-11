package servlets;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SelectedUserTypeServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws  ServletException, IOException {

		//String message;
		//PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		int userType=0;
		String buttonClicked = request.getParameter("submit1");
		if(buttonClicked.equals("proceed")){
			String userTypeValue=request.getParameter("userType");
			HttpSession obj1 = request.getSession();
			userType = Integer.parseInt(userTypeValue);
			obj1.setAttribute("uTypeString", userTypeValue);
			obj1.setAttribute("uType", userType);
			request.getRequestDispatcher("/FillDetails.jsp").forward(request, response);
		}
	}

	
}

