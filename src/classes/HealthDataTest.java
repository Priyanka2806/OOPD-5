package classes;

import static org.junit.Assert.*;

import org.junit.Test;

public class HealthDataTest {

	HealthData hd_test = new HealthData();
	public void addHD_test() {
		int addHD_result=0;
		//Test case 1
		addHD_result=hd_test.addHealthData("neh",2,2,25);
		
		System.out.println(addHD_result);
		
		assertEquals(addHD_result,1);
		//pass("Not yet implemented");
	}
	
	
	public void displayYourHealthData_test() {
		int displayYourHD_result=0;
		//Test case 1
		displayYourHD_result=hd_test.displayYourHealthData("rahul");
		
		System.out.println(displayYourHD_result);
		
		assertEquals(displayYourHD_result,1);
		//pass("Not yet implemented");
	}
	
	@Test
	public void displayFriendsHealthData_test() {
		int displayFriendsHD_result=0;
		//Test case 1
		displayFriendsHD_result=hd_test.displayYourFriendsHealthData("neh");
		
		System.out.println(displayFriendsHD_result);
		
		assertEquals(displayFriendsHD_result,1);
		//pass("Not yet implemented");
	}

}
