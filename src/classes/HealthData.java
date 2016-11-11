package classes;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;


import dbClasses.FriendshipDB;
import dbClasses.HealthDataDB;

//Equivalent to Datum Table in Database.
public class HealthData {
	int datum_id_count=0;
	protected int datumID;
	protected String hdUsername;
	protected int hdpropertyID;
	protected int hdValue;
	protected Timestamp hdWhenSaved;
	
	
	

	public void addHealthData(String username, int type, int propId, int propVal) {
		int addHDResult=0;
		HealthDataDB hdDB = new HealthDataDB();
		datum_id_count=hdDB.getRowCount();
		this.datumID=++datum_id_count;
		this.hdUsername=username;
		this.hdpropertyID=propId;
		this.hdValue=propVal;
		
		Calendar calHDCreation = Calendar.getInstance();
		Date dateHDCreation = calHDCreation.getTime();
		Timestamp tsHDCreation = new Timestamp(dateHDCreation.getTime());
		this.hdWhenSaved = tsHDCreation;
		
		
		
		
		addHDResult=hdDB.addHealthDataDB(datumID,hdUsername,hdpropertyID,hdValue,hdWhenSaved);
		
		if(addHDResult==1)
		{
			System.out.println("Health data added successfully!");
		}
		
	}
	
	public int displayYourHealthData(String uname)
	{
		ResultSet rs_viewHD;
		ResultSet rs_Properties;
		int flag=0;
		HealthDataDB hddb = new HealthDataDB();
		rs_viewHD=hddb.displayHealthDataFromDB(uname);
		rs_Properties=hddb.displayProperties();
		
		System.out.println("The properties and their IDs are:");
		
		try {
			while(rs_Properties.next())
			{
				System.out.println("ID-" + rs_Properties.getInt(1) + "  " + "Property-" + rs_Properties.getString(2) + "  " + "Description-" + rs_Properties.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			while(rs_viewHD.next())
			{
				System.out.println("Property ID-" + rs_viewHD.getInt(1) + "  " + "Value-" + rs_viewHD.getString(2) + "  " + "Time when recorded-" + rs_viewHD.getString(3));
				flag=1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	protected void displayYourFriendsHealthData(String username){
		ResultSet rs = null;
		
		FriendshipDB fdb = new FriendshipDB();
		rs = fdb.displayActiveFriends(username);
		HealthDataDB hddb = new HealthDataDB();
		ResultSet rs_Properties;
		rs_Properties=hddb.displayProperties();
		try {
			while(rs_Properties.next())
			{
				System.out.println("ID-" + rs_Properties.getInt(1) + "  " + "Property-" + rs_Properties.getString(2) + "  " + "Description-" + rs_Properties.getString(3));
			}
			while(rs.next()){
				String friendName = null;
				if(rs.getString(1).equals(username)){
					ResultSet r1 = fdb.returnStatus(rs.getString(2));
					if(r1.next()){
						if(r1.getInt(1) == 1){
							friendName = rs.getString(2);
						}
					}
				}
				else if(rs.getString(2).equals(username)){
					ResultSet r2 = fdb.returnStatus(rs.getString(1));
					if(r2.next()){
						if(r2.getInt(1) == 1){
							friendName = rs.getString(1);
						}
					}
				}
				
				ResultSet rs_viewHD;
				rs_viewHD=hddb.displayHealthDataFromDB(friendName);
				int temp = 0;
				System.out.println("For friend " + friendName + " health data details are-");
				while(rs_viewHD.next())
				{
					temp=1;
					System.out.println("Property ID-" + rs_viewHD.getInt(1) + "  " + "Value-" + rs_viewHD.getString(2) + "  " + "Time when recorded-" + rs_viewHD.getString(3));
				}
				if(temp==0){
					System.out.println("No health data stored for this user");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
