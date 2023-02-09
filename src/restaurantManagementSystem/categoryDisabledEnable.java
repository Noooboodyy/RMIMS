package restaurantManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class categoryDisabledEnable {

	public categoryDisabledEnable(boolean Status) {
		ArrayList disabledCategories = new ArrayList();
		ArrayList product2disableID = new ArrayList();
		Connection con;
		try {
			con = DriverManager.getConnection( "jdbc:ucanaccess://D:/DatabaseRMS.accdb");
			Statement statement = con.createStatement();
			ResultSet resultcat = statement.executeQuery("select * from Categories_Record");
			ResultSet resultpro = statement.executeQuery("select * from Products_Record");
			
			while(resultcat.next()) {
				boolean status = resultcat.getBoolean("Status");
				String categoryName = resultcat.getString("Category_Name");
				
				if(status == Status) {
					disabledCategories.add(categoryName);
				}
			}
			while(resultpro.next()) {
				String productID = resultpro.getString("ID");
				String productCategory = resultpro.getString("Category");
				
				if(disabledCategories.contains(productCategory)) {
					product2disableID.add(productID);
				}
				
			}
			System.out.println(product2disableID);
			PreparedStatement pst = con.prepareStatement("UPDATE Products_Record set Status = ? where ID = ?");
			
			for (int i = 0; i < product2disableID.size(); i++) {
				pst.setBoolean(1, Status);
				pst.setString(2, product2disableID.get(i).toString());
				pst.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
