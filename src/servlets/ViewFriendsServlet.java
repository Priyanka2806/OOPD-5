package servlets;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbClasses.FriendshipDB;



public class ViewFriendsServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws  ServletException, IOException {
		ArrayList<String> uname_list = new ArrayList<>();
		String message=null;
		HttpSession session = request.getSession();
		String uname=(String)session.getAttribute("u_name");
		FriendshipDB fdb = new FriendshipDB();
		ResultSet rs = fdb.displayActiveFriends(uname);
		if(rs == null){
			message = "No active friends!";
			request.setAttribute("frndMsg", message);
		}
		else{
			//int val=0;
			
			try {
				while(rs.next()){
					//val = 1;
					if(rs.getString(1).equals(uname)){
						ResultSet r1 = fdb.returnStatus(rs.getString(2));
						if(r1.next()){
							if(r1.getInt(1) == 1){
								//System.out.println(rs.getString(2));
								uname_list.add(rs.getString(2));
							}
						}
					}
					else if(rs.getString(2).equals(uname)){
						ResultSet r2 = fdb.returnStatus(rs.getString(1));
						if(r2.next()){
							if(r2.getInt(1) == 1){
								//System.out.println(rs.getString(1));
								uname_list.add(rs.getString(1));
							}
						}
					}
					request.setAttribute("activeFriends", uname_list);
		
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	  
			request.setAttribute("frndMsg", message);
			request.getRequestDispatcher("/ViewFriends.jsp").forward(request, response);
		}
		}
		
	}


