package classes;
import java.sql.Connection;
import java.sql.DriverManager;



public class DBDemo {
	
	private final static String userName = "root";
	private final static String password = "root";
	static Connection con = null;
	public static Connection getCon(){
		if(con == null){
			try{
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smarthealthdb",userName,password);
			}
			catch(Exception ex){
				System.out.println("No connection");
			//throw new Exception(ex.getMessage());
			}
		}
		return con;
	}
	
	public static void close(Connection con) {
		try {
			con.close();
		} catch (Exception ex) {
		}
	}
	
}
