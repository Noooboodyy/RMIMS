package restaurantManagementSystem;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

import graph.*;
import modifiedComponents.ComboBox;
import restaurantManagementSystem.Order.selectCategory;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
public class incomeMonitoringPanel extends JPanel {

	private Calendar calendar;
	private static int currweekNumber;
	private static int WeekNumber;
	private static int year;
	private static int currYear;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	private Chart dailyChart, monthlyChart, yearlyChart;
	private Chart3 weeklyChart;
	private double revenueMon = 0;
	private double revenueTue = 0;
	private double revenueWed = 0;
	private double revenueTHU = 0;
	private double revenueFRI = 0;
	private double revenueSAT = 0;
	private double revenueSUN = 0;
	
	private double expenseMon = 0;
	private double expenseTue = 0;
	private double expenseWed = 0;
	private double expenseThu = 0;
	private double expenseFri = 0;
	private double expenseSat = 0;
	private double expenseSun = 0;

	ArrayList <Double> weekRev = new ArrayList<>();
	ArrayList <Double> weekExp = new ArrayList<>();
	ArrayList <String> date = new ArrayList<>();
	ArrayList <String> years = new ArrayList<>();
	ArrayList <Double> yearRev = new ArrayList<>();
	ArrayList <Double> yearExp = new ArrayList<>();
	private Double yearlyRev;
	private Double yearlyExp;
	private String Date;
	private Double WeeklyRev;
	private Double WeeklyExp;
	static int yearw;
	static int yearY;
	static int weekNumber;
	DateTimeFormatter formatter;
	LocalDate date1 = LocalDate.now();
	int currentYear = date1.getYear();
	int currentWeekNumber = date1.get(java.time.temporal.WeekFields.ISO.weekOfWeekBasedYear());
	JScrollPane weeklyscrollPane;


	private Date Mon;
	private Date Tue;
	private Date Wed;
	private Date Thu;
	private Date Fri;
	private Date Sat;
	private Date Sun;
	private Date origSunday;

	private String weekDates;
	private double weekRevenue;
	int year3;

	private ComboBox comboBox_Period;
	private ComboBox comboBox_ChartorTable;
	private RoundedPanel panel_IncomeChart;
	private JLabel btn_next;
	private JLabel btn_prev;
	private JLabel lblNewLabel_1;

	private static String choice;

	private double expensesJanuary = 0, expensesFebruary = 0, expensesMarch = 0, expensesApril = 0, expensesMay = 0, expensesJune = 0, 
			expensesJuly = 0, expensesAugust = 0, expensesSeptember = 0, expensesOctober= 0, expensesNovember = 0, expensesDecember = 0;
	
	private double revenueJanuary = 0, revenueFebruary = 0, revenueMarch = 0, revenueApril = 0, revenueMay = 0, revenueJune = 0, 
			revenueJuly = 0, revenueAugust = 0, revenueSeptember = 0, revenueOctober= 0, revenueNovember = 0, revenueDecember = 0;
	
	private JLabel lblYear;
	private Chart2 value;
	
	private legend legend;
	private ComboBox comboBox_Period2;
	private Double RevthisDay;
	private Double ExpthisDay;
	private Double RevthisWeek;
	private Double ExpthisWeek;
	private Double RevthisMonth;
	private Double ExpthisMonth;
	private Double RevthisYear;
	private Double ExpthisYear;
	
	private Card Card_Expenses;
	private Card Card_Revenue;
	private Card Card_TotalIncome;

	public incomeMonitoringPanel() {
		
		setBackground(UIManager.getColor("CheckBox.background"));
		setPreferredSize(new Dimension(944, 750));
		setLayout(null);
		
		
		calendar = Calendar.getInstance();
		currweekNumber = calendar.get(Calendar.WEEK_OF_YEAR);
		currYear = calendar.get(Calendar.YEAR);


		yearw = currentYear;
		yearY = currYear;
		
		
		choice = "Daily";

		panel_IncomeChart = new RoundedPanel(25);
		panel_IncomeChart.setLayout(null);
		panel_IncomeChart.setOpaque(false);
		panel_IncomeChart.setForeground(Color.WHITE);
		panel_IncomeChart.setBackground(Color.WHITE);
		panel_IncomeChart.setBounds(10, 257, 926, 484);
		add(panel_IncomeChart);
		
		legend = new legend();
		legend.setOpaque(false);
		legend.setBounds(255, 412, 404, 42);
		

		lblYear = new JLabel("");
		lblYear.setToolTipText("");
		lblYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblYear.setForeground(new Color(163, 163, 163));
		lblYear.setFont(new Font("SansSerif", Font.BOLD, 17));
		lblYear.setBackground(new Color(149, 149, 149));
		lblYear.setBounds(179, 21, 506, 32);
		

		Image imgnxt = new ImageIcon(this.getClass().getResource("/img/Next.png")).getImage();
		Image imgprev = new ImageIcon(this.getClass().getResource("/img/Prev.png")).getImage();
		btn_next = new JLabel("");
		btn_next.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(choice.equals("Daily")) {
					if(String.valueOf(currweekNumber).equals(54)) {
						currYear += 1;

					}else {
						currweekNumber += 1;
						dailyGraph();
					}
				}if(choice.equals("Monthly")) {
					currYear += 1;
					monthlyGraph();

				}if(choice.equals("Weekly")) {
					yearw += 1;
					weekNumber = 1;
					WeeklyGraph();
				}if(choice.equals("Yearly")) {
					yearY += 1;
					YearlyGraph();
				}

			}
		});
		btn_next.setBounds(883, 209, 39, 72);
		panel_IncomeChart.add(btn_next);
		btn_next.setIcon(new ImageIcon(imgnxt));
		btn_prev = new JLabel("");
		btn_prev.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(choice.equals("Daily")) {
					if(String.valueOf(currweekNumber).equals(1)) {
						currweekNumber = 54;
						currYear -= 1;
		
					}else {
						currweekNumber -= 1;
						dailyGraph();
					}
				}if(choice.equals("Monthly")) {
					currYear -= 1;
					monthlyGraph();
				}if(choice.equals("Weekly")) {
					yearw -= 1;
					weekNumber = 1;
					WeeklyGraph();
				}if(choice.equals("Yearly")) {
					yearY -= 11;
					YearlyGraph();
				}
		
		
			}
		});
		btn_prev.setBounds(5, 209, 39, 72);
		panel_IncomeChart.add(btn_prev);
		btn_prev.setIcon(new ImageIcon(imgprev));

		comboBox_Period = new ComboBox();
		comboBox_Period.setForeground(new Color(112, 112, 112));
		comboBox_Period.setOpaque(true);
		comboBox_Period.setMaximumRowCount(100);
		comboBox_Period.setFont(new Font("SansSerif", Font.PLAIN, 12));
		comboBox_Period.setFocusable(false);
		comboBox_Period.setEditable(false);
		comboBox_Period.setBorder(new LineBorder(new Color(227, 227, 227)));
		comboBox_Period.setBackground(Color.WHITE);
		comboBox_Period.setBounds(695, 20, 182, 32);
		panel_IncomeChart.add(comboBox_Period);
		addItemsPeriods();

		comboBox_Period.addActionListener(new selectCategory());

		lblNewLabel_1 = new JLabel("Income Chart");
		lblNewLabel_1.setBackground(new Color(149, 149, 149));
		lblNewLabel_1.setToolTipText("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setForeground(new Color(148, 148, 148));
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblNewLabel_1.setBounds(43, 13, 134, 42);
		panel_IncomeChart.add(lblNewLabel_1);

		RoundedPanel panel_1_1 = new RoundedPanel(25);
		panel_1_1.setLayout(null);
		panel_1_1.setOpaque(false);
		panel_1_1.setForeground(Color.WHITE);
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(10, 11, 926, 230);
		add(panel_1_1);
		
		Card_Expenses = new Card();
		Card_Expenses.setColor2(new Color(5, 61, 105));
		Card_Expenses.setColor1(new Color(0, 133, 213));
		Card_Expenses.setBounds(10, 64, 290, 144);
		panel_1_1.add(Card_Expenses);
		
		Card_Revenue = new Card();
		Card_Revenue.setColor2(new Color(50, 45, 87));
		Card_Revenue.setColor1(new Color(68, 60, 119));
		Card_Revenue.setBounds(310, 64, 290, 144);
		panel_1_1.add(Card_Revenue);
		
		Card_TotalIncome = new Card();
		Card_TotalIncome.setColor2(new Color(81, 27, 101));
		Card_TotalIncome.setColor1(new Color(153, 102, 255));
		Card_TotalIncome.setBounds(610, 64, 290, 144);
		panel_1_1.add(Card_TotalIncome);
		
		comboBox_Period2 = new ComboBox();
		comboBox_Period2.addActionListener(new selectPeriod2());
		comboBox_Period2.addItem("This Day");
		comboBox_Period2.addItem("This Week");
		comboBox_Period2.addItem("This Month");
		comboBox_Period2.addItem("This Year");
		comboBox_Period2.setOpaque(true);
		comboBox_Period2.setMaximumRowCount(100);
		comboBox_Period2.setForeground(new Color(112, 112, 112));
		comboBox_Period2.setFont(new Font("SansSerif", Font.PLAIN, 12));
		comboBox_Period2.setFocusable(false);
		comboBox_Period2.setEditable(false);
		comboBox_Period2.setBorder(new LineBorder(new Color(227, 227, 227)));
		comboBox_Period2.setBackground(Color.WHITE);
		comboBox_Period2.setBounds(22, 21, 248, 32);
		panel_1_1.add(comboBox_Period2);
		
		
		
		Daily();
		

	}
	class selectCategory implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			if(comboBox_Period.getSelectedItem() == "Daily") {
				choice = "Daily";
				resetDate();
				Daily();
				lblYear.setText(String.valueOf(""));
				legend.setVisible(false);
				resetWeekly();
				
			}else if(comboBox_Period.getSelectedItem() == "Weekly"){
				choice = "Weekly";
				resetDate();
				WeeklyGraph();
				panel_IncomeChart.add(lblYear);
				lblYear.setText(String.valueOf(yearw));
				legend.setVisible(true);
				
			}else if(comboBox_Period.getSelectedItem() == "Monthly") {
				choice = "Monthly";
				resetDate();
				monthlyGraph();
				panel_IncomeChart.add(lblYear);
				legend.setVisible(false);
				resetWeekly();
				
			}else if(comboBox_Period.getSelectedItem() == "Yearly") {
				choice = "Yearly" ;
				resetDate();
				YearlyGraph();
				panel_IncomeChart.add(lblYear);
			}
		}
	}
	
	
	public void ref(PropertyChangeEvent evt) {
		comboBox_Period.setSelectedItem("Daily");
		Daily();
		lblYear.setText(String.valueOf(""));
		dailyChart.setVisible(true);
		monthlyChart.setVisible(false);
		weeklyscrollPane.setVisible(false);
	}
	public void addItemsPeriods() {
		comboBox_Period.addItem("Daily");
		comboBox_Period.addItem("Weekly");
		comboBox_Period.addItem("Monthly");
		comboBox_Period.addItem("Yearly");
	}
	public double income(Double income) {
		if(income <= 0) {
			income = 0.0;
		}
		return income;
	}

	public void dailyGraph() {
		lblYear.setText(String.valueOf(""));
		getDailyRev();
		getDailyExp();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
		panel_IncomeChart.removeAll();
		dailyChart = new Chart();
		dailyChart.setBounds(34, 64, 854, 385);
		panel_IncomeChart.add(dailyChart);
		dailyChart.removeAll();
		dailyChart.addLegend("Revenue", new Color(245, 189, 135));
		dailyChart.addLegend("Expense", new Color(135, 189, 245));
		dailyChart.addLegend("Income", new Color(60, 176, 67));
		dailyChart.addData(new ModelChart("MON " + dateFormat.format(Mon), new double[]{revenueMon , expenseMon, income(revenueMon - expenseMon)}));
		dailyChart.addData(new ModelChart("TUE " + dateFormat.format(Tue), new double[]{revenueTue, expenseTue, income(revenueTue - expenseTue)}));
		dailyChart.addData(new ModelChart("WED " + dateFormat.format(Wed), new double[]{revenueWed, expenseWed, income(revenueWed - expenseWed)}));
		dailyChart.addData(new ModelChart("THU " + dateFormat.format(Thu), new double[]{revenueTHU, expenseThu, income(revenueTHU - expenseThu)}));
		dailyChart.addData(new ModelChart("FRI " + dateFormat.format(Fri), new double[]{revenueFRI, expenseFri, income(revenueFRI - expenseFri)}));
		dailyChart.addData(new ModelChart("SAT " + dateFormat.format(Sat), new double[]{revenueSAT, expenseSat, income(revenueSAT - expenseSat)}));
		dailyChart.addData(new ModelChart("SUN " + dateFormat.format(Sun) , new double[]{revenueSUN, revenueSUN, income(revenueSUN - revenueSUN)}));
		
		dailyChart.revalidate();
		dailyChart.repaint();
		refresh();
		legend.setVisible(false);
		
	}

	public void getDailyRev() {
		revenueSUN = 0; revenueMon = 0; revenueTue = 0; revenueWed = 0; revenueTHU = 0; revenueFRI = 0; revenueSAT = 0;

		getDatesDaily();
		Connection con;
		
		try {
			con = DriverManager.getConnection("jdbc:ucanaccess://D:/DatabaseRMS.accdb");
			Statement statement = con.createStatement();
			ResultSet revResult = statement.executeQuery("select * from Revenue_Record");

			while(revResult.next()) {
				Date date = revResult.getDate("Date");
				double revenue = revResult.getDouble("Income");	
				
				if(dateFormat.format(date).equals(dateFormat.format(Mon))) {
					revenueMon = revenue;
				}
				if(dateFormat.format(date).equals(dateFormat.format(Tue))) {
					revenueTue = revenue;
				}
				if(dateFormat.format(date).equals(dateFormat.format(Wed))) {
					revenueWed = revenue;
				}
				if(dateFormat.format(date).equals(dateFormat.format(Thu))) {
					revenueTHU = revenue;
				}
				if(dateFormat.format(date).equals(dateFormat.format(Fri))) {
					revenueFRI = revenue;
				}
				if(dateFormat.format(date).equals(dateFormat.format(Sat))) {
					revenueSAT = revenue;
				}
				if(dateFormat.format(date).equals(dateFormat.format(Sun))) {
					revenueSUN = revenue;
				}
				
			}

			

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public void getDailyExp() {
		expenseSun = 0; expenseMon = 0; expenseTue = 0; expenseWed = 0; expenseThu = 0; expenseFri = 0; expenseSat = 0;

		getDatesDaily();
		Connection con;
		
		try {
			con = DriverManager.getConnection( "jdbc:ucanaccess://D:/DatabaseRMS.accdb");
			Statement statement = con.createStatement();
			ResultSet expResult = statement.executeQuery("select * from Expenses_Record");

			while(expResult.next()) {
				Date date = expResult.getDate("Date");
				double amount = expResult.getDouble("Amount");	
				String period = expResult.getString("Expense_period");
				if(period.equals("Day")) {
					if(dateFormat.format(date).equals(dateFormat.format(Mon))) {
						expenseMon += amount;
					}
					if(dateFormat.format(date).equals(dateFormat.format(Tue))) {
						expenseTue += amount;
					}
					if(dateFormat.format(date).equals(dateFormat.format(Wed))) {
						expenseWed += amount;
					}
					if(dateFormat.format(date).equals(dateFormat.format(Thu))) {
						expenseThu += amount;
					}
					if(dateFormat.format(date).equals(dateFormat.format(Fri))) {
						expenseFri += amount;
					}
					if(dateFormat.format(date).equals(dateFormat.format(Sat))) {
						expenseSat += amount;
					}
					if(dateFormat.format(date).equals(dateFormat.format(Sun))) {
						expenseSun += amount;
					}
				}
			}

			

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void getDatesDaily() {

		calendar.clear();
		calendar.set(Calendar.YEAR, currYear);
		calendar.set(Calendar.WEEK_OF_YEAR, currweekNumber);

		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		Mon = calendar.getTime();
		calendar.add(Calendar.DATE, 1);
		Tue = calendar.getTime();
		calendar.add(Calendar.DATE, 1);
		Wed = calendar.getTime();
		calendar.add(Calendar.DATE, 1);
		Thu = calendar.getTime();
		calendar.add(Calendar.DATE, 1);
		Fri = calendar.getTime();
		calendar.add(Calendar.DATE, 1);
		Sat = calendar.getTime();
		calendar.add(Calendar.DATE, 1);
		Sun = calendar.getTime();

	}
	public void getWeekly() {
		revenueSUN = 0; revenueMon = 0; revenueTue = 0; revenueWed = 0; revenueTHU = 0; revenueFRI = 0; revenueSAT = 0;
		WeeklyRev = 0.0;

		lblYear.setText(String.valueOf(yearw));
		Connection con;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			
			LocalDate monday = LocalDate.of(yearw, 1, 1).with(java.time.temporal.WeekFields.ISO.weekOfYear(), weekNumber).with(java.time.DayOfWeek.MONDAY);
			LocalDate tuesday = monday.plusDays(1);
			LocalDate wednesday = monday.plusDays(2);
			LocalDate thursday = monday.plusDays(3);
			LocalDate friday = monday.plusDays(4);
			LocalDate saturday = monday.plusDays(5);
			LocalDate sunday = monday.plusDays(6);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yy");

			con = DriverManager.getConnection( "jdbc:ucanaccess://D:/DatabaseRMS.accdb");
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery("select * from Revenue_Record");

			while(result.next()) {
				Date date = result.getDate("Date");
				double income = result.getDouble("Income");	
				

				if(dateFormat.format(date).equals(formatter.format(monday))) {
					revenueMon = income;
				}
				if(dateFormat.format(date).equals(formatter.format(tuesday))) {
					revenueTue = income;
				}
				if(dateFormat.format(date).equals(formatter.format(wednesday))) {
					revenueWed = income;
				}
				if(dateFormat.format(date).equals(formatter.format(thursday))) {
					revenueTHU = income;
				}
				if(dateFormat.format(date).equals(formatter.format(friday))) {
					revenueFRI = income;
				}
				if(dateFormat.format(date).equals(formatter.format(saturday))) {
					revenueSAT = income;
				}
				if(dateFormat.format(date).equals(formatter.format(sunday))) {
					revenueSUN = income;
				}
			}
			
			WeeklyRev = (revenueMon + revenueTue + revenueWed + revenueTHU + revenueFRI + revenueSAT + revenueSUN);
			Date = (formatter1.format(monday) +" - "+ formatter1.format(sunday));

		} catch (SQLException e) {
			e.printStackTrace();
		}catch(Exception i) {
		}
  
	}
	
	
	public void getWeeklyExp() {
		expenseSun = 0; expenseMon = 0; expenseTue = 0; expenseWed = 0; expenseThu = 0; expenseFri = 0; expenseSat = 0;
		WeeklyExp = 0.0;

		lblYear.setText(String.valueOf(yearw));
		Connection con;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			
			LocalDate monday = LocalDate.of(yearw, 1, 1).with(java.time.temporal.WeekFields.ISO.weekOfYear(), weekNumber).with(java.time.DayOfWeek.MONDAY);
			LocalDate tuesday = monday.plusDays(1);
			LocalDate wednesday = monday.plusDays(2);
			LocalDate thursday = monday.plusDays(3);
			LocalDate friday = monday.plusDays(4);
			LocalDate saturday = monday.plusDays(5);
			LocalDate sunday = monday.plusDays(6);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yy");

			con = DriverManager.getConnection("jdbc:ucanaccess://D:/DatabaseRMS.accdb");
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery("select * from Expenses_Record");

			while(result.next()) {
				
				Date date = result.getDate("Date");
				double amount = result.getDouble("Amount");	
				String period = result.getString("Expense_period");
				
				if(period.equals("Week") || !period.equals("Week")) {
					if(dateFormat.format(date).equals(formatter.format(monday))) {
						expenseMon += amount;
					}
					if(dateFormat.format(date).equals(formatter.format(tuesday))) {
						expenseTue += amount;
					}
					if(dateFormat.format(date).equals(formatter.format(wednesday))) {
						expenseWed += amount;
					}
					if(dateFormat.format(date).equals(formatter.format(thursday))) {
						expenseThu += amount;
					}
					if(dateFormat.format(date).equals(formatter.format(friday))) {
						expenseFri += amount;
					}
					if(dateFormat.format(date).equals(formatter.format(saturday))) {
						expenseSat += amount;
					}
					if(dateFormat.format(date).equals(formatter.format(sunday))) {
						expenseSun += amount;
					}
				}
			}
			
			WeeklyExp = (expenseMon + expenseTue + expenseWed + expenseThu + expenseFri + expenseSat + expenseSun);

		} catch (SQLException e) {
			e.printStackTrace();
		}catch(Exception i) {
		}
  
	}
	public void WeeklyGraph() {
		
		weeklyscrollPane = new JScrollPane();
		panel_IncomeChart.removeAll();
		showWeek();
		value = new Chart2();
		value.setLocation(34, 345);
		value.setPreferredSize(new Dimension(75, 350));
		
		weeklyChart = new Chart3();
		weeklyChart.setLocation(34, 64);
		weeklyChart.setPreferredSize(new Dimension(8000, 345));
		weeklyChart.removeAll();
		value.removeAll();
		value.addLegend("Revenue", new Color(245, 189, 135));
		value.addLegend("Expense", new Color(135, 189, 245));
		value.addLegend("Income", new Color(60, 176, 67));
		weeklyChart.addLegend("Revenue", new Color(245, 189, 135));
		weeklyChart.addLegend("Expense", new Color(135, 189, 245));
		weeklyChart.addLegend("Income", new Color(60, 176, 67));
		for(int i = 0; i < date.size(); i++) {
			value.addData(new ModelChart(date.get(i), new double[]{weekRev.get(i), weekExp.get(i), income(weekRev.get(i) - weekExp.get(i))}));
		}
		for(int i = 0; i < date.size(); i++) {
			weeklyChart.addData(new ModelChart(date.get(i), new double[]{weekRev.get(i), weekExp.get(i), income(weekRev.get(i) - weekExp.get(i))}));
		}
		
		weeklyChart.revalidate();
		weeklyChart.repaint();
		value.revalidate();
		value.repaint();
		weeklyscrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		weeklyscrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		weeklyscrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		weeklyscrollPane.setHorizontalScrollBar(new ScrollBar());
		weeklyscrollPane.getVerticalScrollBar().setBackground(Color.WHITE);
		weeklyscrollPane.getViewport().setBackground(Color.WHITE);
	    JPanel p = new JPanel();
	    p.setBackground(Color.WHITE);
	    weeklyscrollPane.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
	    weeklyscrollPane.setViewportView(weeklyChart);
	    weeklyscrollPane.setRowHeaderView(value);
	    weeklyscrollPane.setBounds(34, 64, 854, 345);
		panel_IncomeChart.add(weeklyscrollPane);
		refresh();
	}
	private void resetDate() {
		calendar.clear();
		calendar = Calendar.getInstance();
		currweekNumber = calendar.get(Calendar.WEEK_OF_YEAR);
		currYear = calendar.get(Calendar.YEAR);
		weekNumber = 1;
		yearY = currentYear;
		yearw = currentYear;
	}
	private void refresh() {
		
		panel_IncomeChart.add(lblNewLabel_1);
		panel_IncomeChart.add(comboBox_Period);
		panel_IncomeChart.add(legend);
		panel_IncomeChart.add(btn_prev);
		panel_IncomeChart.add(btn_next);
		panel_IncomeChart.add(lblYear);
		panel_IncomeChart.revalidate();
		panel_IncomeChart.repaint();
	}
	public void showWeek() {
		Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, yearw);
        cal.set(Calendar.MONTH, Calendar.DECEMBER);
        cal.set(Calendar.DAY_OF_MONTH, 28);
		int maxWeekNumber = (cal.get(Calendar.WEEK_OF_YEAR));

		date.clear();
		weekRev.clear();
		weekExp.clear();
		
		getWeekly();
		getWeeklyExp();
		weekRev.add(WeeklyRev);
		weekExp.add(WeeklyExp);
		date.add(Date);
		
		for (int i = 0; i < 51; i++) {
			weekNumber += 1;
			getWeekly();
			getWeeklyExp();
			weekRev.add(WeeklyRev);
			weekExp.add(WeeklyExp);
			date.add(Date);
		}
	}
	
	public void getMonthly() {
		revenueJanuary = 0; revenueFebruary = 0; revenueMarch = 0; revenueApril = 0; revenueMay = 0; revenueJune = 0; 
		revenueJuly = 0; revenueAugust = 0; revenueSeptember = 0; revenueOctober= 0; revenueNovember = 0; revenueDecember = 0;

		Connection con;
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-yyyy");
		try {
			con = DriverManager.getConnection( "jdbc:ucanaccess://D:/DatabaseRMS.accdb");
			Statement statement = con.createStatement();
			ResultSet revresult = statement.executeQuery("select * from Revenue_Record");

			while(revresult.next()) {
				Date date = revresult.getDate("Date");
				double income = revresult.getDouble("Income");	
			
				if(dateFormat.format(date).equals("01-" + currYear)) {
					revenueJanuary += income;
				}
				if(dateFormat.format(date).equals("02-" + currYear)) {
					revenueFebruary += income;
				}
				if(dateFormat.format(date).equals("03-" + currYear)) {
					revenueMarch += income;
				}
				if(dateFormat.format(date).equals("04-" + currYear)) {
					revenueApril += income;
				}
				if(dateFormat.format(date).equals("05-" + currYear)) {
					revenueMay += income;
				}
				if(dateFormat.format(date).equals("06-" + currYear)) {
					revenueJune += income;
				}
				if(dateFormat.format(date).equals("07-" + currYear)) {
					revenueJuly += income;
				}
				if(dateFormat.format(date).equals("08-" + currYear)) {
					revenueAugust += income;
				}
				if(dateFormat.format(date).equals("09-" + currYear)) {
					revenueSeptember += income;
				}
				if(dateFormat.format(date).equals("10-" + currYear)) {
					revenueOctober += income;
				}
				if(dateFormat.format(date).equals("11-" + currYear)) {
					revenueNovember += income;
				}
				if(dateFormat.format(date).equals("12-" + currYear)) {
					revenueDecember += income;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void getMonthlyExp() {
		expensesJanuary = 0; expensesFebruary = 0; expensesMarch = 0; expensesApril = 0; expensesMay = 0; expensesJune = 0; 
		expensesJuly = 0; expensesAugust = 0; expensesSeptember = 0; expensesOctober= 0; expensesNovember = 0; expensesDecember = 0;

		Connection con;
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-yyyy");
		try {
			con = DriverManager.getConnection( "jdbc:ucanaccess://D:/DatabaseRMS.accdb");
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery("select * from Expenses_Record");

			while(result.next()) {
				Date date = result.getDate("Date");
				String period = result.getString("Expense_period");
				double Expense = result.getDouble("Amount");	
				if(period.equals("Month") || !period.equals("Month")) {
					if(dateFormat.format(date).equals("01-" + currYear)) {
						expensesJanuary += Expense;
					}
					if(dateFormat.format(date).equals("02-" + currYear)) {
						expensesFebruary += Expense;
					}
					if(dateFormat.format(date).equals("03-" + currYear)) {
						expensesMarch += Expense;
					}
					if(dateFormat.format(date).equals("04-" + currYear)) {
						expensesApril += Expense;
					}
					if(dateFormat.format(date).equals("05-" + currYear)) {
						expensesMay += Expense;
					}
					if(dateFormat.format(date).equals("06-" + currYear)) {
						expensesJune += Expense;
					}
					if(dateFormat.format(date).equals("07-" + currYear)) {
						expensesJuly += Expense;
					}
					if(dateFormat.format(date).equals("08-" + currYear)) {
						expensesAugust += Expense;
					}
					if(dateFormat.format(date).equals("09-" + currYear)) {
						expensesSeptember += Expense;
					}
					if(dateFormat.format(date).equals("10-" + currYear)) {
						expensesOctober += Expense;
					}
					if(dateFormat.format(date).equals("11-" + currYear)) {
						expensesNovember += Expense;
					}
					if(dateFormat.format(date).equals("12-" + currYear)) {
						expensesDecember += Expense;
					}
				}
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	private void monthlyGraph() {
		getMonthly();
		getMonthlyExp();
		panel_IncomeChart.removeAll();
		lblYear.setText(String.valueOf(currYear));
		monthlyChart = new Chart();
		monthlyChart.setBounds(34, 64, 832, 385);
		monthlyChart.addLegend("Revenue", new Color(245, 189, 135));
		monthlyChart.addLegend("Expense", new Color(135, 189, 245));
		monthlyChart.addLegend("Income", new Color(60, 176, 67));
		panel_IncomeChart.add(monthlyChart);

		monthlyChart.removeAll();
		monthlyChart.addData(new ModelChart("JAN " , new double[]{revenueJanuary, expensesJanuary, income(revenueJanuary - expensesJanuary)}));
		monthlyChart.addData(new ModelChart("FEB " , new double[]{revenueFebruary, expensesFebruary, income(revenueFebruary - expensesFebruary)}));
		monthlyChart.addData(new ModelChart("MAR " , new double[]{revenueMarch, expensesMarch, income(revenueMarch - expensesMarch)}));
		monthlyChart.addData(new ModelChart("APR " , new double[]{revenueApril, expensesApril, income(revenueApril - expensesApril)}));
		monthlyChart.addData(new ModelChart("MAY " , new double[]{revenueMay, expensesMay, income(revenueMay - expensesMay)}));
		monthlyChart.addData(new ModelChart("JUN " , new double[]{revenueJune, expensesJune, income(revenueJune - expensesJune)}));
		monthlyChart.addData(new ModelChart("JUL " , new double[]{revenueJuly, expensesJuly, income(revenueJuly - expensesJuly)}));
		monthlyChart.addData(new ModelChart("AUG " , new double[]{revenueAugust, expensesAugust, income(revenueAugust - expensesAugust)}));
		monthlyChart.addData(new ModelChart("SEP " , new double[]{revenueSeptember, expensesSeptember, income(revenueSeptember - expensesSeptember)}));
		monthlyChart.addData(new ModelChart("OCT" , new double[]{revenueOctober, expensesOctober, income(revenueOctober - expensesOctober)}));
		monthlyChart.addData(new ModelChart("NOV " , new double[]{revenueNovember, expensesNovember, income(revenueNovember - expensesNovember)}));
		monthlyChart.addData(new ModelChart("DEC " , new double[]{revenueDecember, expensesDecember, income(revenueDecember - expensesDecember)}));
		monthlyChart.revalidate();
		monthlyChart.repaint();
		refresh();
	}
	private void getYearlyRev() {
		yearlyRev = 0.0;
		double year = 0;
		Connection con;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
		try {
			con = DriverManager.getConnection( "jdbc:ucanaccess://D:/DatabaseRMS.accdb");
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery("select * from Revenue_Record");

			while(result.next()) {
				Date date = result.getDate("Date");
				double rev = result.getDouble("Income");
				
					if(dateFormat.format(date).equals(String.valueOf(yearY))) {
						
						 year += rev;
					}
				
			}
			yearlyRev = year;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private void getYearlyExp() {
		yearlyExp = 0.0;
		double year = 0;
		Connection con;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
		try {
			con = DriverManager.getConnection( "jdbc:ucanaccess://D:/DatabaseRMS.accdb");
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery("select * from Expenses_Record");

			while(result.next()) {
				Date date = result.getDate("Date");
				String period = result.getString("Expense_period");
				double Expense = result.getDouble("Amount");	
				if(period.equals("Year") || !period.equals("Year")) {
				
					if(dateFormat.format(date).equals(String.valueOf(yearY))) {
						
						 year += Expense;
					}
				}
			}
			
			yearlyExp = year;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void YearlyGraph() {
		showYear();
		panel_IncomeChart.removeAll();
		yearlyChart = new Chart();
		yearlyChart.setBounds(34, 64, 832, 385);
		yearlyChart.addLegend("Revenue", new Color(245, 189, 135));
		yearlyChart.addLegend("Expense", new Color(135, 189, 245));
		yearlyChart.addLegend("Income", new Color(60, 176, 67));
		panel_IncomeChart.add(yearlyChart);

		yearlyChart.removeAll();
		for (int i = 0; i < years.size(); i++) {
			yearlyChart.addData(new ModelChart(years.get(i) , new double[]{yearRev.get(i), yearExp.get(i), (yearRev.get(i) - yearExp.get(i))}));
		}
		
		
		yearlyChart.revalidate();
		yearlyChart.repaint();
		refresh();
	}
	
	private void showYear() {

		yearExp.clear();
		yearRev.clear();
		years.clear();
		
		
		getYearlyRev();
		getYearlyExp();
		yearExp.add(yearlyExp);
		yearRev.add(yearlyRev);
		years.add(String.valueOf(yearY));
		
		for (int i = 0; i < 5; i++) {
			yearY += 1;
			getYearlyRev();
			getYearlyExp();
			yearExp.add(yearlyExp);
			years.add(String.valueOf(yearY));
			yearRev.add(yearlyRev);
		}
	}
	private void resetWeekly() {
		weekRev.clear();
		weekExp.clear();
		date.clear();
		
	}
	private void Daily() {
		getDatesDaily();
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(Calendar.YEAR, currYear);
		cal.set(Calendar.WEEK_OF_YEAR, currweekNumber);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		if(dateFormat.format(cal.getTime()).equals(dateFormat.format(Sun))) {
			currweekNumber -= 1;
		}
		dailyGraph();
		
	}
	class selectPeriod2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			if(comboBox_Period2.getSelectedItem() == "This Day") {
				getRevExpthisDay();
				setCardsData(RevthisDay, ExpthisDay);
				
			}else if(comboBox_Period2.getSelectedItem() == "This Week"){
				getRevExpthisWeek();
				setCardsData(RevthisWeek, ExpthisWeek);
				
			}else if(comboBox_Period2.getSelectedItem() == "This Month") {
				getRevExpthisMonth();
				setCardsData(RevthisMonth, ExpthisMonth);
				
			}else if(comboBox_Period2.getSelectedItem() == "This Year") {
				getRevExpthisYear();
				setCardsData(RevthisYear, ExpthisYear);
				
			}
		}
	}
	private void setCardsData(Double rev, Double exp) {
		Card_Expenses.setData(new Model_Card(new ImageIcon(getClass().getResource("/img/expensesW.png")), "Total Expenses", "₱ " + String.valueOf(rev)));
		Card_Revenue.setData(new Model_Card(new ImageIcon(getClass().getResource("/img/revenueW.png")), "Total Revenue", "₱ " + String.valueOf(exp)));
		Card_TotalIncome.setData(new Model_Card(new ImageIcon(getClass().getResource("/img/incomeW.png")), "Total Income", "₱ " + String.valueOf(rev - exp)));
	}
	private void getRevExpthisDay() {
		LocalDate currDate = LocalDate.now();
		java.sql.Date current = java.sql.Date.valueOf(currDate);
		Double rev = 0.0;
		Double exp = 0.0;
		Connection con;
		//ExpthisDay
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			con = DriverManager.getConnection( "jdbc:ucanaccess://D:/DatabaseRMS.accdb");
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery("select * from Revenue_Record");
			ResultSet resultex = statement.executeQuery("select * from expenses_Record");

			while(result.next()) {
				Double revenue = result.getDouble("Income");
				Date date = result.getDate("Date");
				if(dateFormat.format(date).equals(dateFormat.format(current))) {
					rev += revenue;
				}
			}
			
			
			while(resultex.next()) {
				Double expe = resultex.getDouble("Amount");
				Date date = resultex.getDate("Date");
				String period = resultex.getString("Expense_period");
				if(period.equals("Day")) {
					if(dateFormat.format(date).equals(dateFormat.format(current))) {
						exp += expe;
					}
				}
				
			}
			RevthisDay = rev;
			ExpthisDay = exp;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private void getRevExpthisWeek() {
		Date today = new Date(); 
        Calendar cal = Calendar.getInstance(); 
        cal.setTime(today); 
  
        int currentWeekNumber = cal.get(Calendar.WEEK_OF_YEAR); 
		Double rev = 0.0;
		Double exp = 0.0;
		Connection con;
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			con = DriverManager.getConnection( "jdbc:ucanaccess://D:/DatabaseRMS.accdb");
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery("select * from Revenue_Record");
			ResultSet resultex = statement.executeQuery("select * from expenses_Record");

			while(result.next()) {
				Double revenue = result.getDouble("Income");
				Date date = result.getDate("Date");
				cal.setTime(date); 
		        int inputWeekNumber = cal.get(Calendar.WEEK_OF_YEAR); 
		
		        if (currentWeekNumber == inputWeekNumber) {
		        	rev += revenue;
		        }
		        
			}
			
			while(resultex.next()) {
				Double expe = resultex.getDouble("Amount");
				Date date = resultex.getDate("Date");
				String period = resultex.getString("Expense_period");
				if(period.equals("Week") || !period.equals("Week")) {
					cal.setTime(date); 
				     int inputWeekNumber = cal.get(Calendar.WEEK_OF_YEAR); 
				
				     if (currentWeekNumber == inputWeekNumber) {
				        exp += expe;
				     }
				}
				
				
				
			}
			RevthisWeek = rev;
			ExpthisWeek = exp;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private void getRevExpthisMonth() {
		LocalDate currDate = LocalDate.now();
		java.sql.Date current = java.sql.Date.valueOf(currDate);
		Double rev = 0.0;
		Double exp = 0.0;
		Connection con;
		//ExpthisDay
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yyyy");
		try {
			con = DriverManager.getConnection( "jdbc:ucanaccess://D:/DatabaseRMS.accdb");
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery("select * from Revenue_Record");
			ResultSet resultex = statement.executeQuery("select * from expenses_Record");

			while(result.next()) {
				Double revenue = result.getDouble("Income");
				Date date = result.getDate("Date");
				if(dateFormat.format(date).equals(dateFormat.format(current))) {
					rev += revenue;
				}
			}
			
			
			while(resultex.next()) {
				Double expe = resultex.getDouble("Amount");
				Date date = resultex.getDate("Date");
				String period = resultex.getString("Expense_period");
				if(period.equals("Month") || !period.equals("Month")) {
					if(dateFormat.format(date).equals(dateFormat.format(current))) {
						exp += expe;
					}
				}
				
			}
			RevthisMonth = rev;
			ExpthisMonth = exp;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private void getRevExpthisYear() {
		LocalDate currDate = LocalDate.now();
		java.sql.Date current = java.sql.Date.valueOf(currDate);
		Double rev = 0.0;
		Double exp = 0.0;
		Connection con;
		//ExpthisDay
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
		try {
			con = DriverManager.getConnection( "jdbc:ucanaccess://D:/DatabaseRMS.accdb");
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery("select * from Revenue_Record");
			ResultSet resultex = statement.executeQuery("select * from expenses_Record");

			while(result.next()) {
				Double revenue = result.getDouble("Income");
				Date date = result.getDate("Date");
				if(dateFormat.format(date).equals(dateFormat.format(current))) {
					rev += revenue;
				}
			}
			
			
			while(resultex.next()) {
				Double expe = resultex.getDouble("Amount");
				Date date = resultex.getDate("Date");
				String period = resultex.getString("Expense_period");
				if(period.equals("Year") || !period.equals("Year")) {
					if(dateFormat.format(date).equals(dateFormat.format(current))) {
						exp += expe;
					}
				}
				
			}
			RevthisYear = rev;
			ExpthisYear = exp;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
