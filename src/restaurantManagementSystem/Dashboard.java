package restaurantManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import modifiedComponents.GradientColorPanel;

public class Dashboard extends JPanel {
	private Card Card_FoodProducts;
	private Card Card_Categories;
	private Card Card_SystemUsers;
	private Card Card_Expenses;
	private Card Card_Revenue;
	private Card Card_TotalIncome;
	private Card Card_ProductSold;
	
	public Dashboard() {
		setBounds(0, 0, 944, 681);
		setLayout(null);
		
		GradientColorPanel panel_dashboard = new GradientColorPanel();
		panel_dashboard.setColor1(new Color(240, 240, 240));
		panel_dashboard.setColor2(new Color(239, 241, 252));
		panel_dashboard.setBounds(0, 0, 944, 681);
		add(panel_dashboard);
		panel_dashboard.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Dashboard");
		lblNewLabel_1.setToolTipText("");
		lblNewLabel_1.setBounds(20, 11, 202, 42);
		panel_dashboard.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setForeground(new Color(11, 31, 55));
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 22));
		
		RoundedPanel panel = new RoundedPanel(30);
		panel.setForeground(new Color(255, 255, 255));
		panel.setOpaque(false);
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(20, 54, 914, 344);
		panel_dashboard.add(panel);
		panel.setLayout(null);
		
		Card_FoodProducts = new Card();
		Card_FoodProducts.setBounds(10, 24, 215, 144);
		panel.add(Card_FoodProducts);
		Card_FoodProducts.setColor2(new Color(18, 90, 36));
		Card_FoodProducts.setColor1(new Color(51, 204, 0));
		
		Card_ProductSold = new Card();
		Card_ProductSold.setBounds(685, 24, 215, 144);
		panel.add(Card_ProductSold);
		Card_ProductSold.setColor2(new Color(166, 73, 17));
		Card_ProductSold.setColor1(new Color(255, 204, 0));
		
		
		Card_SystemUsers = new Card();
		Card_SystemUsers.setBounds(460, 24, 215, 144);
		panel.add(Card_SystemUsers);
		Card_SystemUsers.setColor2(new Color(141, 74, 24));
		Card_SystemUsers.setColor1(new Color(180, 133, 99));
		
		
		Card_Categories = new Card();
		Card_Categories.setBounds(235, 24, 215, 144);
		panel.add(Card_Categories);
		Card_Categories.setColor2(new Color(115, 11, 41));
		Card_Categories.setColor1(new Color(204, 51, 102));
		
		Card_TotalIncome = new Card();
		Card_TotalIncome.setBounds(610, 179, 290, 144);
		panel.add(Card_TotalIncome);
		Card_TotalIncome.setColor2(new Color(81, 27, 101));
		Card_TotalIncome.setColor1(new Color(153, 102, 255));
		
		Card_Expenses = new Card();
		Card_Expenses.setColor2(new Color(5, 61, 105));
		Card_Expenses.setColor1(new Color(0, 133, 213));
		
		Card_Expenses.setBounds(10, 179, 290, 144);
		panel.add(Card_Expenses);
		
		Card_Revenue = new Card();
		Card_Revenue.setColor2(new Color(50, 45, 87));
		Card_Revenue.setColor1(new Color(68, 60, 119));
		
		Card_Revenue.setBounds(310, 179, 290, 144);
		panel.add(Card_Revenue);
		
		cardsData();
	}
	public void cardsData() {
		int foodProducts = 0;
		int AdminAcc = 0;
		int CashierAcc = 0;
		int categories = 0;
		Double totalExpenses = 0.0;
		Double totalRevenue = 0.0;
		int ProductSold = 0;
		
		LocalDate currDate = LocalDate.now();
		Date current = Date.valueOf(currDate);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Connection checkAdminAcc;
		try {
			checkAdminAcc = DriverManager.getConnection( "jdbc:ucanaccess://D:/DatabaseRMS.accdb");
			Statement statement = checkAdminAcc.createStatement();
			ResultSet resultFoodProducts = statement.executeQuery("select * from Products_Record");
			ResultSet resultcategories = statement.executeQuery("select * from Categories_Record");
			ResultSet resultAdminAccounts = statement.executeQuery("select * from Admin_Account");
			ResultSet resultCashierAccounts = statement.executeQuery("select * from Cashier_Account");
			ResultSet resultExpenses = statement.executeQuery("select * from Expenses_Record");
			ResultSet resultRevenue = statement.executeQuery("select * from Revenue_Record");
			ResultSet resultProductSold = statement.executeQuery("select * from ProductSales_Record");
			
			
			while(resultFoodProducts.next()) {
				foodProducts++;
			}
			while(resultcategories.next()) {
				categories++;
			}
			while(resultAdminAccounts.next()) {
				AdminAcc++;
			}
			while(resultCashierAccounts.next()) {
				CashierAcc++;
			}
			while(resultExpenses.next()) {
				Double expenses = resultExpenses.getDouble("Amount");
				Date date = resultExpenses.getDate("Date");
				String period = resultExpenses.getString("Expense_period");
				if(dateFormat.format(date).equals(dateFormat.format(current))) {
					if(period.equals("Day")) {
						totalExpenses += expenses;
					}
				}
			}
			while(resultRevenue.next()) {
				Double revenue = resultRevenue.getDouble("Income");
				Date date = resultRevenue.getDate("Date");
				if(dateFormat.format(date).equals(dateFormat.format(current))) {
					totalRevenue += revenue;
				}
				
			}
			while(resultProductSold.next()) {
				int sold = resultProductSold.getInt("Quantity");
				ProductSold += sold;
			}
			
			Card_FoodProducts.setData(new Model_Card(new ImageIcon(getClass().getResource("/img/menuW.png")), "Food Product", String.valueOf(foodProducts)));
			Card_Categories.setData(new Model_Card(new ImageIcon(getClass().getResource("/img/categoriesW.png")), "Categories", String.valueOf(categories)));
			Card_SystemUsers.setData(new Model_Card(new ImageIcon(getClass().getResource("/img/UsersW.png")), "System Users", String.valueOf(AdminAcc + CashierAcc)));
			Card_Expenses.setData(new Model_Card(new ImageIcon(getClass().getResource("/img/expensesW.png")), "Today's Expenses", "₱ " + String.valueOf(totalExpenses)));
			Card_Revenue.setData(new Model_Card(new ImageIcon(getClass().getResource("/img/revenueW.png")), "Today's Revenue", "₱ " + String.valueOf(totalRevenue)));
			Card_TotalIncome.setData(new Model_Card(new ImageIcon(getClass().getResource("/img/incomeW.png")), "Today's Income", "₱ " + String.valueOf(totalRevenue - totalExpenses)));
			Card_ProductSold.setData(new Model_Card(new ImageIcon(getClass().getResource("/img/productSoldW.png")), "Total Products Sold", String.valueOf(ProductSold)));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
