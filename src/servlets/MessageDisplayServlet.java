package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MessageDisplayServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws  ServletException, IOException {

		String message=null;
		//PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		
		String buttonSelected = request.getParameter("button");
		if(buttonSelected.equals("Login")){
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
		else if(buttonSelected.equals("Later")){
			message = "Thank You!!";
			request.setAttribute("msg", message);
			request.getRequestDispatcher("/ProfileCreatedFile.jsp").forward(request, response);
			request.getRequestDispatcher("/Login.jsp").forward(request, response);	
		}
	}
}
