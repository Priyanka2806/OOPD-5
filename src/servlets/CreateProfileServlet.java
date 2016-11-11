package servlets;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.Moderator;
import classes.User;

public class CreateProfileServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	//This Servlet add the new users to the database.
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws  ServletException, IOException {

		//System.out.println("Check1");
		response.setContentType("text/html");
		String[] photo = new String[3];
		HttpSession sUserType = request.getSession();
		String userTyp = (String)sUserType.getAttribute("uTypeString");
		int userType = Integer.parseInt(userTyp);
		String buttonClicked = request.getParameter("done");
		System.out.println(buttonClicked);
		if(buttonClicked.equals("Create Profile")){
			//System.out.println("Check2");
			String user=request.getParameter("username");
			String password=request.getParameter("pwd");
			String pEmail=request.getParameter("email1");
			String sEmail=request.getParameter("email2");
			String f_name=request.getParameter("firstName");
			String l_name=request.getParameter("lastName");
			photo[0]=request.getParameter("photo1");
			photo[1]=request.getParameter("photo2");
		
			String aboutme=request.getParameter("aboutMe");
			String address=request.getParameter("address");
			
			long time = System.currentTimeMillis();
			if(userType==1){
				//System.out.println("Check3");
				int karma = 0;
				User u= new User(user, pEmail, sEmail, password, f_name, l_name, address, aboutme, time, photo, userType, karma);
			}
			if(userType==4){
				//System.out.println("Check4");
				String phoneValue=request.getParameter("phone");
				char[] phone = phoneValue.toCharArray();
				String qualify=request.getParameter("qualify");
				Moderator mod = new Moderator(user, pEmail, sEmail,password, f_name, l_name, address, aboutme, time, photo, userType, qualify, phone );
			}
			
			request.getRequestDispatcher("/ProfileCreatedFile.jsp").forward(request, response);
		}
	}

	
}
