package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import restaurantManagementSystem.LogIn;
import restaurantManagementSystem.setup;

public class RMSMain{
	public RMSMain() {
		int count = 0;
		Connection checkAdminAcc;
		try {
			checkAdminAcc = DriverManager.getConnection("jdbc:ucanaccess://D:/DatabaseRMS.accdb");
			Statement statement = checkAdminAcc.createStatement();
			ResultSet result = statement.executeQuery("select * from Admin_Account");
			while(result.next()) {
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		if(count == 0) {
			System.out.print("amaw");
			new setup().setVisible(true);
		}else {
			new LogIn().setVisible(true);
		}
	}
	public static void main(String[] args) {
		new RMSMain();
		
	}
}
