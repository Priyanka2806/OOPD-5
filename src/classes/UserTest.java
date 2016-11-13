package classes;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class UserTest {
	
	User user_tst = new User();

	
	public void displayDetails_test1() {
		ResultSet display_result=null;
		int displayResult_size=0;
		try {
			//Test case 1
			display_result=user_tst.displayDetails("neh");
			display_result.last();
			displayResult_size=display_result.getRow();
			System.out.println(displayResult_size);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(displayResult_size,1);
		//pass("Not yet implemented");
	}
	
	
	public void displayDetails_test2() {
		ResultSet display_result=null;
		int displayResult_size=0;
		try {
			//Test case 2
			display_result=user_tst.displayDetails("poo");
			display_result.last();
			displayResult_size=display_result.getRow();
			System.out.println(displayResult_size);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(displayResult_size,1);
		//pass("Not yet implemented");
	}
	
	
	public void updateDetails_test1() {
		int updateResult=0;
		//Test case 1
		updateResult=user_tst.updateDetails("neh",5,"hellooooooooo");
		
		System.out.println(updateResult);
		
		assertEquals(updateResult,1);
		//pass("Not yet implemented");
	}
	
	@Test
	public void deleteUser_test1() {
		int deleteResult=0;
		//Test case 1
		deleteResult=user_tst.deleteUser("neh");
		
		System.out.println(deleteResult);
		
		assertEquals(deleteResult,1);
		//pass("Not yet implemented");
	}


}
