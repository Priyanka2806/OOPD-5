package dbClasses;
import java.sql.Timestamp;

import classes.DBDemo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HealthDataDB {
	
	
	public int addHealthDataDB(int datumID, String uname, int propertyId, int propertyVal, Timestamp whenSavedDB)
	{
		int res_HDForum=0;
		PreparedStatement addHDStmt;
		try {
			addHDStmt = DBDemo.getCon().prepareStatement("INSERT INTO datum(DatumID, Username, PropertyID, Value, WhenSaved)"+ " VALUES(?, ?, ?, ?, ?)");
			addHDStmt.setInt(1, datumID);
			addHDStmt.setString(2, uname);
			addHDStmt.setInt(3, propertyId);
			addHDStmt.setInt(4, propertyVal);
			addHDStmt.setTimestamp(5, whenSavedDB);
			res_HDForum = addHDStmt.executeUpdate();
		} 
		catch (SQLException e) {
	
			e.printStackTrace();
		}
		return res_HDForum;
	}

	public int getRowCount() {
		ResultSet rSet;
		int rowCount=0;
		PreparedStatement getCountStmt;
		try {
			getCountStmt = DBDemo.getCon().prepareStatement("SELECT COUNT(*) FROM datum; ");
			rSet=getCountStmt.executeQuery();
			if(rSet.next())
			{
				rowCount=rSet.getInt(1);
			}
			
			
		} 
		catch (SQLException e) {
	
			e.printStackTrace();
		}
		
		return rowCount;
		
	}

	public ResultSet displayHealthDataFromDB(String u_name) {
		PreparedStatement dispHDStmt;
		ResultSet resultSet=null;
		try 
		{
			dispHDStmt = DBDemo.getCon().prepareStatement("SELECT PropertyID, Value, WhenSaved from datum WHERE Username = ?");
			dispHDStmt.setString(1, u_name);
			resultSet=dispHDStmt.executeQuery();
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return resultSet;
	}

	public ResultSet displayProperties() {
		PreparedStatement dispPropertyStmt;
		ResultSet resultSet=null;
		try 
		{
			dispPropertyStmt = DBDemo.getCon().prepareStatement("SELECT * from property");
			resultSet=dispPropertyStmt.executeQuery();
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return resultSet;
	}
}
