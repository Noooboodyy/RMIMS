package restaurantManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;


import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JProgressBar;
import javax.swing.JMenuBar;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import fileChooser.JnaFileChooser;
import modifiedComponents.GradientColorPanel;
import modifiedComponents.RoundButton;
import restaurantManagementSystem.ProductManagement.ActionsBtnCellRenderer;
import restaurantManagementSystem.ProductManagement.StatusBtnCellRenderer;
import restaurantManagementSystem.ProductManagement.tableCellRenderer;

import java.awt.SystemColor;
import javax.swing.border.LineBorder;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JPanel panel_2;
	private Table table_TableM;
	private Dashboard dashboard;
	private ProductManagement productManagement;
	private ExpensesManagement expensesManagement;
	private Order order;
	RoundedPanel btn_Report;
	private IncomeMonitoring report;
	JPanel panel_Windows;
	private CategoryManagement categoryManagement;
	private JLabel Position;
	private JLabel userName;
	private String currentUser;
	private ImageAvatar avatar;
	private SystemUsers systemUsers;
	private JTextField textField_Name;
	private JTextField textField_Address;
	private JTextField textField_EmailAddress;
	private JTextField textField_ContactNumber;
	private JTextField textField_Username;
	private JTextField textField_Password;
	private JLabel lblmessage_Name;
	private JLabel lblName; 
	private JLabel lblmessage_Address; 
	private JLabel lblPosition; 
	private JLabel lblmessage_EmailAddress; 
	private JLabel lblEmailAddress;
	private JLabel lblmessage_ContactNumber;
	JLabel lblName_ContactNumber; 
	JLabel lblLoginInformation; 
	JLabel lblUsername; JLabel lblmessage_Username; 
	JLabel lblName_ContactNumber_1; 
	JLabel lblmessage_Password;
	JLabel productImage;
	private String image;
	private JPanel EditAcc;
	private String currentImage;
	private RoundedPanel btn_dashboard;
	private RoundedPanel btn_Categories;
	private RoundedPanel btn_Expenses;
	private RoundedPanel btn_FoodProducts;
	private RoundedPanel btn_SystemUsers;
	private RoundedPanel btn_incomemonitoring;
	private RoundedPanel btn_Order;
	private RoundedPanel btn_EditAcc;
	private JLabel lblPersonalInformation;
	private JLabel lblRestaurantInformation;
	private JTextField textField_RestaurantName;
	private JLabel lblRestaurantName;
	private JLabel lblmessage_RestaurantName;
	private JLabel lblmessage_restaurantAddress;
	private JTextField textField_RetaurantAddress;
	private JLabel lblRestaurantAddress;
	private JLabel lblContactDetails_1;
	private JTextField textField_RestaurantEmail;
	private JLabel lblmessage_restaurantEmail;
	private JLabel lblRestaurantEmail;
	private JTextField textField_restaurantContactNum;
	private JLabel lblmessage_restaurantContactNum;
	private JLabel lblRestaurantContavtNum;
	private String RestaurantID;
	private JLabel lblResName;
	private RoundedPanel ComboBox;
	private JLabel message_DialogBox;
	private JLabel iconStore;
	private JLabel iconeditAcc;
	private JLabel iconSignOut;
	
	public void change_btnColors() {
		
	}
	public MainFrame() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 1206, 723);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(241, 143, 244));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel panelBar_1 = new JPanel();
		panelBar_1.setBounds(0, 0, 57, 724);
		panelBar_1.setBackground(new Color(255, 183, 3, 220));
		
		GradientColorPanel panelBar = new GradientColorPanel();
		panelBar.setColor1(new Color(232, 168, 0));
		panelBar.setColor2(new Color(255, 183, 3, 210));
		panelBar.setBounds(260, 0, 946, 44);
		panelBar.setBackground(new Color(249, 162, 0));
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBounds(56, 0, 206, 724);
		panelMenu.setBackground(new Color(11, 31, 55));	
		
		btn_dashboard = new RoundedPanel(10);
		btn_dashboard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dashboard();
			}
		});
		
		btn_dashboard.setBounds(10, 104, 186, 45);
		btn_dashboard.setForeground(new Color(11, 31, 55));
		btn_dashboard.setBorder(null);
		btn_dashboard.setOpaque(false);
		btn_dashboard.setBackground(new Color(66, 50, 95));
		btn_dashboard.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dashboard");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 7, 83, 34);
		btn_dashboard.add(lblNewLabel);
		
		btn_Categories = new RoundedPanel(10);
		btn_Categories.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				removeReport();
				disableEditAcc();
				closeComboBox();
				changeColor(btn_Categories, btn_dashboard, btn_Expenses, btn_FoodProducts, btn_SystemUsers, btn_incomemonitoring, btn_Order, btn_EditAcc);
				disableOtherPanels(categoryManagement, dashboard, expensesManagement, productManagement, order, report, systemUsers);
			}
		});
		Image noImage = new ImageIcon(this.getClass().getResource("/img/noImage.png")).getImage().getScaledInstance(194, 194, Image.SCALE_SMOOTH);
		
		EditAcc = new JPanel();
		EditAcc.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(129, 129, 129)));
		EditAcc.setBackground(new Color(255, 255, 255));
		EditAcc.setBounds(262, 43, 944, 681);
		EditAcc.setVisible(false);
		
		ComboBox = new RoundedPanel(20);
		ComboBox.setForeground(new Color(120, 120, 120));
		ComboBox.setBackground(new Color(255, 255, 255));
		ComboBox.setBounds(420, 230, 410, 191);
		ComboBox.setOpaque(false);
		ComboBox.setVisible(false);
		contentPane.add(ComboBox);
		ComboBox.setLayout(null);
		
		Image Alerticon = new ImageIcon(this.getClass().getResource("/img/checks.png")).getImage();
		JLabel AlertIcon = new JLabel("");
		AlertIcon.setIcon(new ImageIcon(Alerticon));
		AlertIcon.setHorizontalAlignment(SwingConstants.CENTER);
		AlertIcon.setBounds(10, 22, 390, 64);
		ComboBox.add(AlertIcon);
		
		message_DialogBox = new JLabel();
		message_DialogBox.setText("message");
		message_DialogBox.setHorizontalAlignment(SwingConstants.CENTER);
		message_DialogBox.setFont(new Font("SansSerif", Font.PLAIN, 12));
		message_DialogBox.setBounds(10, 97, 390, 29);
		ComboBox.add(message_DialogBox);
		
		RoundButton rndbtnOk = new RoundButton("Finish", 40);
		rndbtnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dashboard();
			}
		});
		rndbtnOk.setText("Ok");
		rndbtnOk.setForeground(Color.WHITE);
		rndbtnOk.setFont(new Font("SansSerif", Font.PLAIN, 12));
		rndbtnOk.setFocusable(false);
		rndbtnOk.setBackground(new Color(11, 31, 55));
		rndbtnOk.setBounds(87, 137, 236, 32);
		ComboBox.add(rndbtnOk);
		contentPane.add(EditAcc);
		EditAcc.setLayout(null);
		
		productImage = new JLabel("");
		productImage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jButton1ActionPerformed(e);
			}
		});
		productImage.setIcon(new ImageIcon(noImage));
		productImage.setHorizontalAlignment(SwingConstants.CENTER);
		productImage.setBounds(10, 48, 149, 149);
		EditAcc.add(productImage);
		
		textField_Name = new JTextField();
		textField_Name.setFont(new Font("SansSerif", Font.PLAIN, 12));
		textField_Name.setColumns(10);
		textField_Name.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		textField_Name.setBackground(new Color(245, 245, 245));
		textField_Name.setBounds(177, 66, 287, 42);
		EditAcc.add(textField_Name);
		
		lblmessage_Name = new JLabel("");
		lblmessage_Name.setHorizontalAlignment(SwingConstants.LEFT);
		lblmessage_Name.setForeground(new Color(220, 20, 60));
		lblmessage_Name.setFont(new Font("Arial", Font.PLAIN, 10));
		lblmessage_Name.setBounds(177, 109, 194, 14);
		EditAcc.add(lblmessage_Name);
		
		lblName = new JLabel("Name");                               
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setForeground(SystemColor.controlDkShadow);
		lblName.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblName.setBounds(177, 48, 227, 14);
		EditAcc.add(lblName);
		
		lblmessage_Address = new JLabel("");
		lblmessage_Address.setHorizontalAlignment(SwingConstants.LEFT);
		lblmessage_Address.setForeground(new Color(220, 20, 60));
		lblmessage_Address.setFont(new Font("Arial", Font.PLAIN, 10));
		lblmessage_Address.setBounds(177, 189, 155, 14);
		EditAcc.add(lblmessage_Address);
		
		lblPosition = new JLabel("Address");
		lblPosition.setHorizontalAlignment(SwingConstants.LEFT);
		lblPosition.setForeground(SystemColor.controlDkShadow);
		lblPosition.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblPosition.setBounds(177, 127, 119, 23);
		EditAcc.add(lblPosition);
		
		textField_Address = new JTextField();
		textField_Address.setFont(new Font("SansSerif", Font.PLAIN, 12));
		textField_Address.setColumns(10);
		textField_Address.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		textField_Address.setBackground(new Color(245, 245, 245));
		textField_Address.setBounds(177, 148, 287, 42);
		EditAcc.add(textField_Address);
		
		JLabel lblContactDetails = new JLabel("Contact Details");
		lblContactDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblContactDetails.setForeground(SystemColor.controlDkShadow);
		lblContactDetails.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblContactDetails.setBounds(10, 214, 481, 23);
		EditAcc.add(lblContactDetails);
		
		lblmessage_EmailAddress = new JLabel("");
		lblmessage_EmailAddress.setHorizontalAlignment(SwingConstants.LEFT);
		lblmessage_EmailAddress.setForeground(new Color(220, 20, 60));
		lblmessage_EmailAddress.setFont(new Font("Arial", Font.PLAIN, 10));
		lblmessage_EmailAddress.setBounds(21, 298, 194, 14);
		EditAcc.add(lblmessage_EmailAddress);
		
		textField_EmailAddress = new JTextField();
		textField_EmailAddress.setFont(new Font("SansSerif", Font.PLAIN, 12));
		textField_EmailAddress.setColumns(10);
		textField_EmailAddress.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		textField_EmailAddress.setBackground(new Color(245, 245, 245));
		textField_EmailAddress.setBounds(21, 255, 455, 42);
		EditAcc.add(textField_EmailAddress);
		
		lblEmailAddress = new JLabel("Email Address");
		lblEmailAddress.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmailAddress.setForeground(SystemColor.controlDkShadow);
		lblEmailAddress.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblEmailAddress.setBounds(21, 237, 227, 14);
		EditAcc.add(lblEmailAddress);
		
		lblmessage_ContactNumber = new JLabel("");
		lblmessage_ContactNumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblmessage_ContactNumber.setForeground(new Color(220, 20, 60));
		lblmessage_ContactNumber.setFont(new Font("Arial", Font.PLAIN, 10));
		lblmessage_ContactNumber.setBounds(21, 377, 194, 14);
		EditAcc.add(lblmessage_ContactNumber);
		
		textField_ContactNumber = new JTextField();
		textField_ContactNumber.setFont(new Font("SansSerif", Font.PLAIN, 12));
		textField_ContactNumber.setColumns(10);
		textField_ContactNumber.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		textField_ContactNumber.setBackground(new Color(245, 245, 245));
		textField_ContactNumber.setBounds(21, 334, 455, 42);
		EditAcc.add(textField_ContactNumber);
		
		lblName_ContactNumber = new JLabel("Contact Number");                                      
		lblName_ContactNumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblName_ContactNumber.setForeground(SystemColor.controlDkShadow);
		lblName_ContactNumber.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblName_ContactNumber.setBounds(21, 316, 227, 14);
		EditAcc.add(lblName_ContactNumber);
		
		lblLoginInformation = new JLabel("Login Information");
		lblLoginInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginInformation.setForeground(SystemColor.controlDkShadow);
		lblLoginInformation.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblLoginInformation.setBounds(10, 406, 481, 23);
		EditAcc.add(lblLoginInformation);
		
		lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername.setForeground(SystemColor.controlDkShadow);
		lblUsername.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblUsername.setBounds(21, 429, 227, 14);
		EditAcc.add(lblUsername);
		
		textField_Username = new JTextField();
		textField_Username.setFont(new Font("SansSerif", Font.PLAIN, 12));
		textField_Username.setColumns(10);
		textField_Username.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		textField_Username.setBackground(new Color(245, 245, 245));
		textField_Username.setBounds(21, 447, 455, 42);
		EditAcc.add(textField_Username);
		
		lblmessage_Username = new JLabel("");
		lblmessage_Username.setHorizontalAlignment(SwingConstants.LEFT);
		lblmessage_Username.setForeground(new Color(220, 20, 60));
		lblmessage_Username.setFont(new Font("Arial", Font.PLAIN, 10));
		lblmessage_Username.setBounds(21, 490, 194, 14);
		EditAcc.add(lblmessage_Username);
		
		lblName_ContactNumber_1 = new JLabel("Password");
		lblName_ContactNumber_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblName_ContactNumber_1.setForeground(SystemColor.controlDkShadow);
		lblName_ContactNumber_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblName_ContactNumber_1.setBounds(21, 508, 227, 14);
		EditAcc.add(lblName_ContactNumber_1);
		
		textField_Password = new JTextField();
		textField_Password.setFont(new Font("SansSerif", Font.PLAIN, 12));
		textField_Password.setColumns(10);
		textField_Password.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		textField_Password.setBackground(new Color(245, 245, 245));
		textField_Password.setBounds(21, 526, 455, 42);
		EditAcc.add(textField_Password);
		
		lblmessage_Password = new JLabel("");
		lblmessage_Password.setHorizontalAlignment(SwingConstants.LEFT); 
		lblmessage_Password.setForeground(new Color(220, 20, 60));
		lblmessage_Password.setFont(new Font("Arial", Font.PLAIN, 10));
		lblmessage_Password.setBounds(21, 569, 194, 14);
		EditAcc.add(lblmessage_Password);
		
		RoundButton btnFinish = new RoundButton("Finish", 40);
		btnFinish.addActionListener(new btnFinished());
		btnFinish.setForeground(Color.WHITE);
		btnFinish.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnFinish.setFocusable(false);
		btnFinish.setBackground(new Color(11, 31, 55));
		btnFinish.setBounds(253, 594, 470, 42);
		EditAcc.add(btnFinish);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new btnBack());
		btnBack.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnBack.setFocusable(false);
		btnBack.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(263, 647, 458, 23);
		EditAcc.add(btnBack);
		
		lblPersonalInformation = new JLabel("Personal Information");
		lblPersonalInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonalInformation.setForeground(SystemColor.controlDkShadow);
		lblPersonalInformation.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblPersonalInformation.setBounds(10, 11, 481, 23);
		EditAcc.add(lblPersonalInformation);
		
		lblRestaurantInformation = new JLabel("Restaurant Information");
		lblRestaurantInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblRestaurantInformation.setForeground(SystemColor.controlDkShadow);
		lblRestaurantInformation.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblRestaurantInformation.setBounds(502, 11, 432, 23);
		EditAcc.add(lblRestaurantInformation);
		
		textField_RestaurantName = new JTextField();
		textField_RestaurantName.setFont(new Font("SansSerif", Font.PLAIN, 12));
		textField_RestaurantName.setColumns(10);
		textField_RestaurantName.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		textField_RestaurantName.setBackground(new Color(245, 245, 245));
		textField_RestaurantName.setBounds(571, 66, 363, 42);
		EditAcc.add(textField_RestaurantName);
		
		lblRestaurantName = new JLabel("Name");
		lblRestaurantName.setHorizontalAlignment(SwingConstants.LEFT);
		lblRestaurantName.setForeground(SystemColor.controlDkShadow);
		lblRestaurantName.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblRestaurantName.setBounds(571, 48, 227, 14);
		EditAcc.add(lblRestaurantName);
		
		lblmessage_RestaurantName = new JLabel("");
		lblmessage_RestaurantName.setHorizontalAlignment(SwingConstants.LEFT);
		lblmessage_RestaurantName.setForeground(new Color(220, 20, 60));
		lblmessage_RestaurantName.setFont(new Font("Arial", Font.PLAIN, 10));
		lblmessage_RestaurantName.setBounds(571, 109, 194, 14);
		EditAcc.add(lblmessage_RestaurantName);
		
		lblmessage_restaurantAddress = new JLabel("");
		lblmessage_restaurantAddress.setHorizontalAlignment(SwingConstants.LEFT);
		lblmessage_restaurantAddress.setForeground(new Color(220, 20, 60));
		lblmessage_restaurantAddress.setFont(new Font("Arial", Font.PLAIN, 10));
		lblmessage_restaurantAddress.setBounds(571, 188, 194, 14);
		EditAcc.add(lblmessage_restaurantAddress);
		
		textField_RetaurantAddress = new JTextField();
		textField_RetaurantAddress.setFont(new Font("SansSerif", Font.PLAIN, 12));
		textField_RetaurantAddress.setColumns(10);
		textField_RetaurantAddress.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		textField_RetaurantAddress.setBackground(new Color(245, 245, 245));
		textField_RetaurantAddress.setBounds(571, 145, 363, 42);
		EditAcc.add(textField_RetaurantAddress);
		
		lblRestaurantAddress = new JLabel("Address");
		lblRestaurantAddress.setHorizontalAlignment(SwingConstants.LEFT);
		lblRestaurantAddress.setForeground(SystemColor.controlDkShadow);
		lblRestaurantAddress.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblRestaurantAddress.setBounds(571, 127, 227, 14);
		EditAcc.add(lblRestaurantAddress);
		
		lblContactDetails_1 = new JLabel("Contact Details");
		lblContactDetails_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblContactDetails_1.setForeground(SystemColor.controlDkShadow);
		lblContactDetails_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblContactDetails_1.setBounds(571, 214, 363, 23);
		EditAcc.add(lblContactDetails_1);
		
		textField_RestaurantEmail = new JTextField();
		textField_RestaurantEmail.setFont(new Font("SansSerif", Font.PLAIN, 12));
		textField_RestaurantEmail.setColumns(10);
		textField_RestaurantEmail.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		textField_RestaurantEmail.setBackground(new Color(245, 245, 245));
		textField_RestaurantEmail.setBounds(571, 255, 363, 42);
		EditAcc.add(textField_RestaurantEmail);
		
		lblmessage_restaurantEmail = new JLabel("");
		lblmessage_restaurantEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblmessage_restaurantEmail.setForeground(new Color(220, 20, 60));
		lblmessage_restaurantEmail.setFont(new Font("Arial", Font.PLAIN, 10));
		lblmessage_restaurantEmail.setBounds(571, 298, 194, 14);
		EditAcc.add(lblmessage_restaurantEmail);
		
		lblRestaurantEmail = new JLabel("Email Address");
		lblRestaurantEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblRestaurantEmail.setForeground(SystemColor.controlDkShadow);
		lblRestaurantEmail.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblRestaurantEmail.setBounds(571, 237, 227, 14);
		EditAcc.add(lblRestaurantEmail);
		
		textField_restaurantContactNum = new JTextField();
		textField_restaurantContactNum.setFont(new Font("SansSerif", Font.PLAIN, 12));
		textField_restaurantContactNum.setColumns(10);
		textField_restaurantContactNum.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		textField_restaurantContactNum.setBackground(new Color(245, 245, 245));
		textField_restaurantContactNum.setBounds(571, 334, 363, 42);
		EditAcc.add(textField_restaurantContactNum);
		
		lblmessage_restaurantContactNum = new JLabel("");
		lblmessage_restaurantContactNum.setHorizontalAlignment(SwingConstants.LEFT);
		lblmessage_restaurantContactNum.setForeground(new Color(220, 20, 60));
		lblmessage_restaurantContactNum.setFont(new Font("Arial", Font.PLAIN, 10));
		lblmessage_restaurantContactNum.setBounds(571, 377, 194, 14);
		EditAcc.add(lblmessage_restaurantContactNum);
		
		lblRestaurantContavtNum = new JLabel("Contact Number");
		lblRestaurantContavtNum.setHorizontalAlignment(SwingConstants.LEFT);
		lblRestaurantContavtNum.setForeground(SystemColor.controlDkShadow);
		lblRestaurantContavtNum.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblRestaurantContavtNum.setBounds(571, 316, 227, 14);
		EditAcc.add(lblRestaurantContavtNum);
		btn_Categories.setBounds(10, 148, 186, 45);
		btn_Categories.setLayout(null);
		btn_Categories.setOpaque(false);
		btn_Categories.setForeground(new Color(11, 31, 55));
		btn_Categories.setBorder(null);
		btn_Categories.setBackground(new Color(11, 31, 55));
		
		JLabel lbl_Categories = new JLabel("Categories");
		lbl_Categories.setForeground(Color.WHITE);
		lbl_Categories.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lbl_Categories.setBounds(10, 7, 124, 34);
		btn_Categories.add(lbl_Categories);
		
		JPanel panel = new JPanel();
		panel.setBounds(15, 91, 180, 1);
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panelMenu);
		
		panelMenu.setLayout(null);
		panelMenu.add(panel);
		panelMenu.add(btn_dashboard);
		panelMenu.add(btn_Categories);
		
		btn_Expenses = new RoundedPanel(10);
		btn_Expenses.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				disableEditAcc();
				closeComboBox();
				removeReport();
				changeColor(btn_Expenses, btn_dashboard, btn_Categories, btn_FoodProducts, btn_SystemUsers, btn_incomemonitoring, btn_Order, btn_EditAcc);
				disableOtherPanels(expensesManagement, dashboard,  productManagement, order, report, categoryManagement, systemUsers);
			}
		});
		btn_Expenses.setLayout(null);
		btn_Expenses.setOpaque(false);
		btn_Expenses.setForeground(new Color(11, 31, 55));
		btn_Expenses.setBorder(null);
		btn_Expenses.setBackground(new Color(11, 31, 55));
		btn_Expenses.setBounds(10, 193, 186, 45);
		panelMenu.add(btn_Expenses);
		
		JLabel lbl_Categories_1 = new JLabel("Expenses");
		lbl_Categories_1.setForeground(Color.WHITE);
		lbl_Categories_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lbl_Categories_1.setBounds(10, 7, 86, 34);
		btn_Expenses.add(lbl_Categories_1);
		
		btn_FoodProducts = new RoundedPanel(10);
		btn_FoodProducts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				disableEditAcc();
				closeComboBox();
				productManagement.displayDataProduct();
				productManagement.getCategories();
				removeReport();
				changeColor(btn_FoodProducts, btn_dashboard, btn_Categories, btn_Expenses, btn_SystemUsers, btn_incomemonitoring, btn_Order, btn_EditAcc);
				disableOtherPanels(productManagement, dashboard, expensesManagement, order, report, categoryManagement, systemUsers);
			}
		});
		btn_FoodProducts.setLayout(null);
		btn_FoodProducts.setOpaque(false);
		btn_FoodProducts.setForeground(new Color(11, 31, 55));
		btn_FoodProducts.setBorder(null);
		btn_FoodProducts.setBackground(new Color(11, 31, 55));
		btn_FoodProducts.setBounds(10, 236, 186, 45);
		panelMenu.add(btn_FoodProducts);
		
		JLabel lbl_Categories_2 = new JLabel("Products");
		lbl_Categories_2.setForeground(Color.WHITE);
		lbl_Categories_2.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lbl_Categories_2.setBounds(10, 7, 124, 34);
		btn_FoodProducts.add(lbl_Categories_2);
		
		btn_SystemUsers = new RoundedPanel(10);
		btn_SystemUsers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				disableEditAcc();
				closeComboBox();
				removeReport();
				systemUsers.displayDataUsers();
				systemUsers.removeCurrent(userName.getText());
				changeColor(btn_SystemUsers, btn_dashboard, btn_Categories, btn_Expenses, btn_FoodProducts, btn_incomemonitoring, btn_Order, btn_EditAcc);
				disableOtherPanels(systemUsers, productManagement, dashboard, expensesManagement, order, report, categoryManagement);
			}
		});
		btn_SystemUsers.setLayout(null);
		btn_SystemUsers.setOpaque(false);
		btn_SystemUsers.setForeground(new Color(11, 31, 55));
		btn_SystemUsers.setBorder(null);
		btn_SystemUsers.setBackground(new Color(11, 31, 55));
		btn_SystemUsers.setBounds(10, 279, 186, 45);
		panelMenu.add(btn_SystemUsers);
		
		JLabel lbl_Categories_2_1 = new JLabel("System Users");
		lbl_Categories_2_1.setForeground(Color.WHITE);
		lbl_Categories_2_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lbl_Categories_2_1.setBounds(10, 7, 124, 34);
		btn_SystemUsers.add(lbl_Categories_2_1);
		
		btn_incomemonitoring = new RoundedPanel(10);
		btn_incomemonitoring.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				disableEditAcc();
				closeComboBox();
				panel_Windows.add(report);
				changeColor(btn_incomemonitoring, btn_dashboard, btn_Categories, btn_Expenses, btn_FoodProducts, btn_SystemUsers, btn_Order, btn_EditAcc);
				disableOtherPanels(report, order, productManagement, dashboard, expensesManagement, categoryManagement, systemUsers);
			}
		});
		btn_incomemonitoring.setLayout(null);
		btn_incomemonitoring.setOpaque(false);
		btn_incomemonitoring.setForeground(new Color(11, 31, 55));
		btn_incomemonitoring.setBorder(null);
		btn_incomemonitoring.setBackground(new Color(11, 31, 55));
		btn_incomemonitoring.setBounds(10, 323, 186, 45);
		panelMenu.add(btn_incomemonitoring);
		
		JLabel lbl_Categories_2_2 = new JLabel("Income monitoring");
		lbl_Categories_2_2.setForeground(Color.WHITE);
		lbl_Categories_2_2.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lbl_Categories_2_2.setBounds(10, 7, 124, 34);
		btn_incomemonitoring.add(lbl_Categories_2_2);
		
		btn_Order = new RoundedPanel(10);
		btn_Order.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				disableEditAcc();
				order.getCategories();
				order.displayProducts();
				closeComboBox();
				removeReport();
				changeColor(btn_Order, btn_dashboard, btn_Categories, btn_Expenses, btn_FoodProducts, btn_SystemUsers, btn_incomemonitoring, btn_EditAcc);
				disableOtherPanels(order, productManagement, dashboard, expensesManagement, report, categoryManagement, systemUsers);
			}
		});
		btn_Order.setLayout(null);
		btn_Order.setOpaque(false);
		btn_Order.setForeground(new Color(11, 31, 55));
		btn_Order.setBorder(null);
		btn_Order.setBackground(new Color(11, 31, 55));
		btn_Order.setBounds(10, 367, 186, 45);
		panelMenu.add(btn_Order);
		
		JLabel lbl_Categories_2_3 = new JLabel("Order");
		lbl_Categories_2_3.setForeground(Color.WHITE);
		lbl_Categories_2_3.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lbl_Categories_2_3.setBounds(10, 7, 124, 34);
		btn_Order.add(lbl_Categories_2_3);
		
		RoundedPanel btn_signOut = new RoundedPanel(10);
		btn_signOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				dispose();
				new LogIn().setVisible(true);
			}
		});
		btn_signOut.setLayout(null);
		btn_signOut.setOpaque(false);
		btn_signOut.setForeground(new Color(11, 31, 55));
		btn_signOut.setBorder(null);
		btn_signOut.setBackground(new Color(11, 31, 55));
		btn_signOut.setBounds(9, 456, 186, 45);
		panelMenu.add(btn_signOut);
		
		JLabel lbl_Signout = new JLabel("Sign out");
		lbl_Signout.setForeground(Color.WHITE);
		lbl_Signout.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lbl_Signout.setBounds(10, 7, 124, 34);
		btn_signOut.add(lbl_Signout);
		
		avatar = new ImageAvatar();
		avatar.setBorderSize(1);
		avatar.setGradientColor1(Color.WHITE);
		avatar.setGradientColor2(Color.WHITE);
		avatar.setBounds(15, 11, 52, 52);
		panelMenu.add(avatar);
		
		userName = new JLabel("Name");
		userName.setFont(new Font("SansSerif", Font.PLAIN, 13));
		userName.setForeground(new Color(255, 255, 255));
		userName.setBounds(17, 67, 178, 19);
		panelMenu.add(userName);
		
		Position = new JLabel("Position");
		Position.setForeground(Color.WHITE);
		Position.setFont(new Font("SansSerif", Font.BOLD, 23));
		Position.setBounds(73, 28, 124, 19);
		panelMenu.add(Position);
		
		btn_EditAcc = new RoundedPanel(10);
		btn_EditAcc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeColor(btn_EditAcc, btn_Order, btn_dashboard, btn_Categories, btn_Expenses, btn_FoodProducts, btn_SystemUsers, btn_incomemonitoring);
				EditAcc.setVisible(true);
				setEnableRec(panel_Windows, false);
				getDataTOEdit();
				
			}
		});
		
		btn_EditAcc.setLayout(null);
		btn_EditAcc.setOpaque(false);
		btn_EditAcc.setForeground(new Color(11, 31, 55));
		btn_EditAcc.setBorder(null);
		btn_EditAcc.setBackground(new Color(11, 31, 55));
		btn_EditAcc.setBounds(9, 412, 186, 45);
		panelMenu.add(btn_EditAcc);
		
		JLabel lbl_EditAcc = new JLabel("Edit Account");
		lbl_EditAcc.setForeground(Color.WHITE);
		lbl_EditAcc.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lbl_EditAcc.setBounds(10, 7, 97, 34);
		btn_EditAcc.add(lbl_EditAcc);
		
		panel_Windows = new JPanel();
		panel_Windows.setBounds(262, 43, 944, 681);
		panel_Windows.setLayout(null);
		
		dashboard= new Dashboard();
		dashboard.setSize(946, 681);
		dashboard.setLocation(0, 0);
		panel_Windows.add(dashboard);
		productManagement = new ProductManagement();
		panel_Windows.add(productManagement);
		expensesManagement = new ExpensesManagement();
		panel_Windows.add(expensesManagement);
		order = new Order();
		panel_Windows.add(order);
		report = new IncomeMonitoring();
		
		systemUsers = new SystemUsers();
		panel_Windows.add(systemUsers);
		
		
		categoryManagement = new CategoryManagement();
		panel_Windows.add(categoryManagement);
		
		disableOtherPanels(dashboard, expensesManagement, productManagement, order, report, categoryManagement, systemUsers);
		contentPane.add(panel_Windows);
		
		Image background = new ImageIcon(this.getClass().getResource("/img/large-background.jpg")).getImage();
		contentPane.setLayout(null);
		contentPane.add(panelBar_1);
		panelBar_1.setLayout(null);
		
		JLabel iconDashboard = new JLabel();
		iconDashboard.setHorizontalAlignment(SwingConstants.RIGHT);
		Image imag = new ImageIcon(this.getClass().getResource("/img/Dashboard.png")).getImage().getScaledInstance(31, 31, Image.SCALE_SMOOTH);
		iconDashboard.setIcon(new ImageIcon(imag));
		iconDashboard.setBounds(12, 103, 32, 45);
		panelBar_1.add(iconDashboard);
		
		JLabel iconCategories = new JLabel();
		iconCategories.setHorizontalAlignment(SwingConstants.RIGHT);
		Image imag1 = new ImageIcon(this.getClass().getResource("/img/categories.png")).getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH);
		iconCategories.setIcon(new ImageIcon(imag1));
		iconCategories.setBounds(5, 149, 37, 45);
		panelBar_1.add(iconCategories);
		
		JLabel iconExpenses = new JLabel();
		iconExpenses.setHorizontalAlignment(SwingConstants.RIGHT);
		Image imag2 = new ImageIcon(this.getClass().getResource("/img/Expenses.png")).getImage().getScaledInstance(27, 27, Image.SCALE_SMOOTH);
		iconExpenses.setIcon(new ImageIcon(imag2));
		iconExpenses.setBounds(11, 198, 32, 38);
		panelBar_1.add(iconExpenses);
		
		JLabel iconProducts = new JLabel();
		iconProducts.setHorizontalAlignment(SwingConstants.RIGHT);
		Image imag3 = new ImageIcon(this.getClass().getResource("/img/foodProduct.png")).getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH);
		iconProducts.setIcon(new ImageIcon(imag3));
		iconProducts.setBounds(11, 239, 31, 45);
		panelBar_1.add(iconProducts);
		
		JLabel iconSystemUsers = new JLabel();
		iconSystemUsers.setHorizontalAlignment(SwingConstants.RIGHT);
		Image imag4 = new ImageIcon(this.getClass().getResource("/img/users.png")).getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
		iconSystemUsers.setIcon(new ImageIcon(imag4));
		iconSystemUsers.setBounds(11, 282, 31, 45);
		panelBar_1.add(iconSystemUsers);
		
		JLabel iconReport = new JLabel();
		iconReport.setHorizontalAlignment(SwingConstants.RIGHT);
		Image imag5 = new ImageIcon(this.getClass().getResource("/img/report.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		iconReport.setIcon(new ImageIcon(imag5));
		iconReport.setBounds(12, 328, 31, 45);
		panelBar_1.add(iconReport);
		
		JLabel iconOrder = new JLabel();
		iconOrder.setHorizontalAlignment(SwingConstants.RIGHT);
		Image imag6 = new ImageIcon(this.getClass().getResource("/img/order.png")).getImage().getScaledInstance(27, 27, Image.SCALE_SMOOTH);
		iconOrder.setIcon(new ImageIcon(imag6));
		iconOrder.setBounds(12, 372, 31, 45);
		panelBar_1.add(iconOrder);
		
		iconeditAcc = new JLabel();
		Image imag7 = new ImageIcon(this.getClass().getResource("/img/EditAcc.png")).getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH);
		iconeditAcc.setHorizontalAlignment(SwingConstants.RIGHT);
		iconeditAcc.setIcon(new ImageIcon(imag7));
		iconeditAcc.setBounds(12, 415, 31, 45);
		panelBar_1.add(iconeditAcc);
		
		iconSignOut = new JLabel();
		Image imag8 = new ImageIcon(this.getClass().getResource("/img/logout.png")).getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
		iconSignOut.setHorizontalAlignment(SwingConstants.RIGHT);
		iconSignOut.setIcon(new ImageIcon(imag8));
		iconSignOut.setBounds(12, 461, 31, 45);
		panelBar_1.add(iconSignOut);
		contentPane.add(panelBar);
		panelBar.setLayout(null);
		
		
		lblResName = new JLabel("Restaurant Name");
		lblResName.setBounds(59, 0, 540, 44);
		getDataTOEdit();
		panelBar.add(lblResName);
		
		lblResName.setBackground(new Color(255, 204, 51));
		lblResName.setHorizontalAlignment(SwingConstants.LEFT);
		lblResName.setForeground(new Color(255, 255, 255));
		lblResName.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		Image image = new ImageIcon(this.getClass().getResource("/img/store.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		iconStore = new JLabel("");
		iconStore.setHorizontalAlignment(SwingConstants.CENTER);
		iconStore.setIcon(new ImageIcon(image));
		iconStore.setBounds(10, 0, 49, 44);
		panelBar.add(iconStore);
		
		
		JLabel lblbackground = new JLabel("");
		lblbackground.setBounds(0, 0, 1206, 724);
		lblbackground.setIcon(new ImageIcon(background));
		contentPane.add(lblbackground);
		
		
			
	}
	private void closeComboBox() {
		ComboBox.setVisible(false);
		setEnableRec(panel_Windows,true);
	}
	private void jButton1ActionPerformed(MouseEvent evt) {
		JnaFileChooser jnaCh = new JnaFileChooser();
		jnaCh.addFilter("Pictures", "jpg", "jpeg", "gif", "png", "bmp");
		boolean save = jnaCh.showOpenDialog(this);
		if (save) {
			
			image = jnaCh.getSelectedFile().getAbsolutePath();
			Image background = new ImageIcon(jnaCh.getSelectedFile().getAbsolutePath()).getImage().getScaledInstance(194, 194, Image.SCALE_SMOOTH);
			productImage.setIcon(new ImageIcon(background));

		}
	}
	private void dashboard() {
		dashboard.cardsData();
		removeReport();
		disableEditAcc();
		closeComboBox();
		changeColor(btn_dashboard, btn_Categories, btn_Expenses, btn_FoodProducts, btn_SystemUsers, btn_incomemonitoring, btn_Order, btn_EditAcc);
		disableOtherPanels(dashboard, expensesManagement, productManagement, order, report, categoryManagement, systemUsers);
	}
	public void getArrayData(ArrayList list) {
		try {
			Connection con = DriverManager.getConnection( "jdbc:ucanaccess://D:/DatabaseRMS.accdb");
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery("select * from Admin_Account");

			while(result.next()) {
				String name = result.getString("Admin_Name");
				list.add(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String getcurrentID() {
		String ID = "";
		
		try {
			Connection con = DriverManager.getConnection( "jdbc:ucanaccess://D:/DatabaseRMS.accdb");
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery("select * from Admin_Account");
			
			while(result.next()) {
				String name = result.getString("Admin_Name");
				
				if(getCurrentuser(userName.getText()).equals(name)) {
					ID = result.getString("ID");
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ID;
	}
	
	public String getCurrentuser(String user) {
		return user;
	}
	private class btnBack implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			dashboard.cardsData();
			removeReport();
			disableEditAcc();
			changeColor(btn_dashboard, btn_Categories, btn_Expenses, btn_FoodProducts, btn_SystemUsers, btn_incomemonitoring, btn_Order, btn_EditAcc);
			disableOtherPanels(dashboard, expensesManagement, productManagement, order, report, categoryManagement, systemUsers);
		}
		
	}
	private class btnFinished implements ActionListener{
		InvalidInputs message = new InvalidInputs();
		ArrayList <String> IDvalues = new ArrayList<>();
		ArrayList <String> Namevalues = new ArrayList<>();

		@Override
		public void actionPerformed(ActionEvent e) {
			getArrayData(Namevalues);
			Namevalues.remove(getCurrentuser(userName.getText()));
			
			
			if(image == null) {
				image = currentImage;;
			}
				
			if(textField_Name.getText().isBlank() || textField_EmailAddress.getText().isBlank() || textField_ContactNumber.getText().isBlank() || textField_Address.getText().isBlank()
				|| textField_Username.getText().isBlank() || textField_Password.getText().isBlank() || textField_RestaurantName.getText().isBlank() || textField_RetaurantAddress.getText().isBlank()
				|| textField_RestaurantEmail.getText().isBlank() || textField_restaurantContactNum.getText().isBlank()) {
				message.InputRequiredMessage(textField_Name, lblmessage_Name);
				message.InputRequiredMessage(textField_EmailAddress, lblmessage_EmailAddress);
				message.InputRequiredMessage(textField_ContactNumber, lblmessage_ContactNumber);
				message.InputRequiredMessage(textField_Address, lblmessage_Address);
				message.InputRequiredMessage(textField_Username, lblmessage_Username);
				message.InputRequiredMessage(textField_Password, lblmessage_Password);
				message.InputRequiredMessage(textField_RestaurantName, lblmessage_RestaurantName);
				message.InputRequiredMessage(textField_RetaurantAddress, lblmessage_restaurantAddress);
				message.InputRequiredMessage(textField_RestaurantEmail, lblmessage_restaurantEmail);
				message.InputRequiredMessage(textField_restaurantContactNum, lblmessage_restaurantContactNum);
					
			}else if(message.checkExistingData(Namevalues, textField_Name, lblmessage_Name)) {

				if(message.checkExistingData(Namevalues, textField_Name, lblmessage_Name)) {
					textField_Name.setBorder(new LineBorder(Color.RED, 1, true));
					lblmessage_Name.setText("Name Already Existing");
				}
				
				Namevalues.clear();
			}else {
				String Name = textField_Name.getText();
				String ContactNum = textField_ContactNumber.getText();
				String EmailAdd = textField_EmailAddress.getText();
				String Address = textField_Address.getText();
				String Username = textField_Username.getText();
				String Password = textField_Password.getText();
				
				String resName = textField_RestaurantName.getText();
				String resAddress = textField_RetaurantAddress.getText();
				String resEmail = textField_RestaurantEmail.getText();
				String resContactNum = textField_restaurantContactNum.getText();
							
				try {
					Connection con = DriverManager.getConnection( "jdbc:ucanaccess://D:/DatabaseRMS.accdb");
						
					PreparedStatement pst = con.prepareStatement("UPDATE Admin_Account set Admin_Name = ?, Admin_Contact_Number = ?, Admin_Email_Address = ?, Image = ?, Address = ?, Username = ?, Password = ? where ID = ?");
					pst.setString(1, Name);
					pst.setString(2, ContactNum);
					pst.setString(3, EmailAdd);
					pst.setString(4, image);
					pst.setString(5, Address);
					pst.setString(6, Username);
					pst.setString(7, Password);
					pst.setString(8, getcurrentID());
					pst.executeUpdate();
					
					PreparedStatement pstRes = con.prepareStatement("UPDATE Restaurant_Details set Restaurant_Name = ?, Restaurant_address = ?, Restaurant_Email_Address = ?, Restaurant_Contact_Number = ? where ID = ?");
					pstRes.setString(1, resName);
					pstRes.setString(2, resAddress);
					pstRes.setString(3, resEmail);
					pstRes.setString(4, resContactNum);
					pstRes.setString(5, RestaurantID);
					pstRes.executeUpdate();
					
					setData(new Model_CurrentUser(image, "ADMIN", Name));
					setDataProfile(Name,"ADMIN", image);
					getDataTOEdit();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
				dashboard();
				message_DialogBox.setText("Records updated successfully");
				ComboBox.setVisible(true);
				EditAcc.setVisible(false);
				setEnableRec(panel_Windows,false);
				Namevalues.clear();
			}


		}
	}
	private void getDataTOEdit() {
		try {
			Connection con = DriverManager.getConnection( "jdbc:ucanaccess://D:/DatabaseRMS.accdb");
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery("select * from Admin_Account");
			ResultSet resultRes = statement.executeQuery("select * from Restaurant_Details");
			
			Image imag = new ImageIcon(this.getClass().getResource("/img/noImage.png")).getImage().getScaledInstance(194, 194, Image.SCALE_SMOOTH);;
			
			while(result.next()) {
				String img = result.getString("Image");
				String name = result.getString("Admin_Name");
				String Address = result.getString("Address");
				String Email = result.getString("Admin_Email_Address");
				String ContactNum = result.getString("Admin_Contact_Number");
				String username = result.getString("Username");
				String password = result.getString("Password");
				if(getCurrentuser(userName.getText()).equals(name)) {
					
					File f = new File(img);
						if(img.equals("no image") || !f.exists()) {
							imag = new ImageIcon(this.getClass().getResource("/img/noImage.png")).getImage().getScaledInstance(194, 194, Image.SCALE_SMOOTH);
						}else {
							imag = new ImageIcon(img).getImage().getScaledInstance(194, 194, Image.SCALE_SMOOTH);
						}
				currentImage = img;
				productImage.setIcon(new ImageIcon(imag));
				textField_Name.setText(name);
				textField_Address.setText(Address);
				textField_EmailAddress.setText(Email);
				textField_ContactNumber.setText(ContactNum);
				textField_Username.setText(username);
				textField_Password.setText(password);
				}
				
			}
			while(resultRes.next()) {
				RestaurantID = resultRes.getString("ID");
				String name = resultRes.getString("Restaurant_Name");
				String address = resultRes.getString("Restaurant_address");
				String email = resultRes.getString("Restaurant_Email_Address");
				String contactNum = resultRes.getString("Restaurant_Contact_Number");
				
				lblResName.setText(name);
				
				textField_RestaurantName.setText(name);
				textField_RetaurantAddress.setText(address);
				textField_RestaurantEmail.setText(email);
				textField_restaurantContactNum.setText(contactNum);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void setDataProfile(String name, String position, String image) {
		userName.setText(name);
    	Position.setText(position);
    	Image imag;
    	File f = new File(image);
		if(image.equals("no image") || !f.exists()) {
			imag = new ImageIcon(this.getClass().getResource("/img/noImage.png")).getImage().getScaledInstance(52, 62, Image.SCALE_SMOOTH);
		}else {
			imag = new ImageIcon(image).getImage().getScaledInstance(52, 52, Image.SCALE_SMOOTH);
		}
		avatar.setImage(new ImageIcon(imag));
	}
	
	public void setData(Model_CurrentUser user) {
    	userName.setText(user.getName());
    	Position.setText(user.getPosition());
    	Image imag;
    	File f = new File(user.getImageAvatar());
		if(user.getImageAvatar().equals("no image") || !f.exists()) {
			imag = new ImageIcon(this.getClass().getResource("/img/noImage.png")).getImage().getScaledInstance(52, 62, Image.SCALE_SMOOTH);
		}else {
			imag = new ImageIcon(user.getImageAvatar()).getImage().getScaledInstance(52, 52, Image.SCALE_SMOOTH);
		}
		avatar.setImage(new ImageIcon(imag));
		
		
		SystemUsers user1 = new SystemUsers();
		user1.setData(new Model_CurrentUser(user.getPosition(), user.getName()));
		systemUsers.removeCurrent(userName.getText());
		getCurrentuser(userName.getText());
		
    }
	
	private void disableOtherPanels(JPanel enable, JPanel disable1, JPanel disable2, JPanel disable3, JPanel disable4, JPanel disable5, JPanel disable6) {
		enable.setVisible(true);
		disable1.setVisible(false);
		disable2.setVisible(false);
		disable3.setVisible(false);
		disable4.setVisible(false);
		disable5.setVisible(false);
		disable6.setVisible(false);
	}
	private void changeColor(JPanel enable, JPanel disable1, JPanel disable2, JPanel disable3, JPanel disable4, JPanel disable5, JPanel disable6, JPanel disable7) {
		enable.setBackground(new Color(66, 50, 95));;
		disable1.setBackground(new Color(11, 31, 55));
		disable2.setBackground(new Color(11, 31, 55));
		disable3.setBackground(new Color(11, 31, 55));
		disable4.setBackground(new Color(11, 31, 55));
		disable5.setBackground(new Color(11, 31, 55));
		disable6.setBackground(new Color(11, 31, 55));
		disable7.setBackground(new Color(11, 31, 55));
	}
	private void disableEditAcc() {
		EditAcc.setVisible(false);
		setEnableRec(panel_Windows, true);
	}
	private void removeReport() {
		panel_Windows.remove(report);
		panel_Windows.revalidate();
		panel_Windows.repaint();
	}
	private void setEnableRec(Component container, boolean enable){
		container.setEnabled(enable);

		try {
			Component[] components= ((Container) container).getComponents();
			for (int i = 0; i < components.length; i++) {
				setEnableRec(components[i], enable);
			}
		} catch (ClassCastException e) {

		}
	}
}
