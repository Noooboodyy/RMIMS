package restaurantManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import modifiedComponents.RoundButton;

import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;

public class setup extends JFrame {

	private JPanel contentPane;
	private JLabel lblTitle;
	private JTextField textFieldRestaurantName;
	private JLabel lblRestaurantName;
	private JTextField textField_RestaurantAddress;
	private JLabel lblRestaurantAddress;
	private JTextField textField_RestaurantContactNum;
	private JLabel lblRestaurantContactNumber;
	private JTextField textField_RsetaurantEmailAddress;
	private JLabel lblRestaurantEmailAddress;
	private JTextField textField_AdminName;
	private JLabel lblAdministratorName;
	private JLabel lblAdministratorContactNumber;
	private JTextField textField_AdminContactNum;
	private JLabel lblUsername;
	private JTextField textField_Username;
	private JLabel lblPassword;
	private JTextField textField_Password;
	private RoundButton btnSetup;
	private JLabel lblfieldrequired1;
	private JLabel lblfieldrequired2;
	private JLabel lblfieldrequired3;
	private JLabel lblfieldrequired4;
	private JLabel lblfieldrequired5;
	private JLabel lblfieldrequired6;
	private JLabel lblfieldrequired7;
	private JLabel lblfieldrequired8;
	private JLabel lblfieldrequired9;
	private JLabel lblbackg;
	private String idfinal;
	ArrayList idRestaurant = new ArrayList();
	ArrayList idAdminAcc = new ArrayList();
	private JTextField textField_AdminEmailAddres;
	private JLabel lblAddress;
	private JTextField textField_Address;
	private JLabel lblfieldrequired10;

	public setup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 859, 644);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.scrollbar);
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		RoundedPanel panelSetupAcc = new RoundedPanel(30);
		panelSetupAcc.setForeground(new Color(255, 255, 255));
		panelSetupAcc.setBackground(Color.WHITE);
		panelSetupAcc.setOpaque(false);
		panelSetupAcc.setBounds(65, 11, 715, 583);
		contentPane.add(panelSetupAcc);
		panelSetupAcc.setLayout(null);
		
		lblTitle = new JLabel("Setup Admin Account");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(0, 0, 51));
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 24));
		lblTitle.setBounds(-63, 11, 843, 35);
		panelSetupAcc.add(lblTitle);
		
		textFieldRestaurantName = new JTextField();
		textFieldRestaurantName.setForeground(new Color(106, 106, 106));
		textFieldRestaurantName.setFont(new Font("SansSerif", Font.PLAIN, 11));
		textFieldRestaurantName.setColumns(10);
		textFieldRestaurantName.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		textFieldRestaurantName.setBackground(Color.WHITE);
		textFieldRestaurantName.setBounds(34, 108, 303, 35);
		panelSetupAcc.add(textFieldRestaurantName);
		
		lblRestaurantName = new JLabel("Restaurant Name");
		lblRestaurantName.setForeground(SystemColor.controlDkShadow);
		lblRestaurantName.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblRestaurantName.setBounds(34, 83, 130, 14);
		panelSetupAcc.add(lblRestaurantName);
		
		textField_RestaurantAddress = new JTextField();
		textField_RestaurantAddress.setForeground(new Color(106, 106, 106));
		textField_RestaurantAddress.setFont(new Font("SansSerif", Font.PLAIN, 11));
		textField_RestaurantAddress.setColumns(10);
		textField_RestaurantAddress.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		textField_RestaurantAddress.setBackground(Color.WHITE);
		textField_RestaurantAddress.setBounds(382, 108, 303, 35);
		panelSetupAcc.add(textField_RestaurantAddress);
		
		lblRestaurantAddress = new JLabel("Restaurant Address");
		lblRestaurantAddress.setForeground(SystemColor.controlDkShadow);
		lblRestaurantAddress.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblRestaurantAddress.setBounds(382, 83, 130, 14);
		panelSetupAcc.add(lblRestaurantAddress);
		
		textField_RestaurantContactNum = new JTextField();
		textField_RestaurantContactNum.setForeground(new Color(106, 106, 106));
		textField_RestaurantContactNum.setFont(new Font("SansSerif", Font.PLAIN, 11));
		textField_RestaurantContactNum.setColumns(10);
		textField_RestaurantContactNum.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		textField_RestaurantContactNum.setBackground(Color.WHITE);
		textField_RestaurantContactNum.setBounds(34, 191, 303, 35);
		panelSetupAcc.add(textField_RestaurantContactNum);
		
		lblRestaurantContactNumber = new JLabel("Restaurant Contact Number");
		lblRestaurantContactNumber.setForeground(SystemColor.controlDkShadow);
		lblRestaurantContactNumber.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblRestaurantContactNumber.setBounds(34, 166, 184, 14);
		panelSetupAcc.add(lblRestaurantContactNumber);
		
		textField_RsetaurantEmailAddress = new JTextField();
		textField_RsetaurantEmailAddress.setForeground(new Color(106, 106, 106));
		textField_RsetaurantEmailAddress.setFont(new Font("SansSerif", Font.PLAIN, 11));
		textField_RsetaurantEmailAddress.setColumns(10);
		textField_RsetaurantEmailAddress.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		textField_RsetaurantEmailAddress.setBackground(Color.WHITE);
		textField_RsetaurantEmailAddress.setBounds(382, 191, 303, 35);
		panelSetupAcc.add(textField_RsetaurantEmailAddress);
		
		lblRestaurantEmailAddress = new JLabel("Restaurant Email Address");
		lblRestaurantEmailAddress.setForeground(SystemColor.controlDkShadow);
		lblRestaurantEmailAddress.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblRestaurantEmailAddress.setBounds(382, 166, 184, 14);
		panelSetupAcc.add(lblRestaurantEmailAddress);
		
		textField_AdminName = new JTextField();
		textField_AdminName.setForeground(new Color(106, 106, 106));
		textField_AdminName.setFont(new Font("SansSerif", Font.PLAIN, 11));
		textField_AdminName.setColumns(10);
		textField_AdminName.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		textField_AdminName.setBackground(Color.WHITE);
		textField_AdminName.setBounds(34, 275, 303, 35);
		panelSetupAcc.add(textField_AdminName);
		
		lblAdministratorName = new JLabel("Admin Name");
		lblAdministratorName.setForeground(SystemColor.controlDkShadow);
		lblAdministratorName.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblAdministratorName.setBounds(34, 250, 184, 14);
		panelSetupAcc.add(lblAdministratorName);
		
		lblAdministratorContactNumber = new JLabel("Admin Contact Number");
		lblAdministratorContactNumber.setForeground(SystemColor.controlDkShadow);
		lblAdministratorContactNumber.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblAdministratorContactNumber.setBounds(382, 250, 184, 14);
		panelSetupAcc.add(lblAdministratorContactNumber);
		
		textField_AdminContactNum = new JTextField();
		textField_AdminContactNum.setForeground(new Color(106, 106, 106));
		textField_AdminContactNum.setFont(new Font("SansSerif", Font.PLAIN, 11));
		textField_AdminContactNum.setColumns(10);
		textField_AdminContactNum.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		textField_AdminContactNum.setBackground(Color.WHITE);
		textField_AdminContactNum.setBounds(382, 275, 303, 35);
		panelSetupAcc.add(textField_AdminContactNum);
		
		lblUsername = new JLabel("Username");
		lblUsername.setForeground(SystemColor.controlDkShadow);
		lblUsername.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblUsername.setBounds(34, 421, 184, 14);
		panelSetupAcc.add(lblUsername);
		
		textField_Username = new JTextField();
		textField_Username.setForeground(new Color(106, 106, 106));
		textField_Username.setFont(new Font("SansSerif", Font.PLAIN, 11));
		textField_Username.setColumns(10);
		textField_Username.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		textField_Username.setBackground(Color.WHITE);
		textField_Username.setBounds(34, 446, 303, 35);
		panelSetupAcc.add(textField_Username);
		
		lblPassword = new JLabel("Password");
		lblPassword.setForeground(SystemColor.controlDkShadow);
		lblPassword.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblPassword.setBounds(382, 421, 184, 14);
		panelSetupAcc.add(lblPassword);
		
		textField_Password = new JTextField();
		textField_Password.setForeground(new Color(106, 106, 106));
		textField_Password.setFont(new Font("SansSerif", Font.PLAIN, 11));
		textField_Password.setColumns(10);
		textField_Password.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		textField_Password.setBackground(Color.WHITE);
		textField_Password.setBounds(382, 446, 303, 35);
		panelSetupAcc.add(textField_Password);
		
		btnSetup = new RoundButton("Setup", 40);
		btnSetup.setFocusable(false);
		btnSetup.addActionListener(new btnSetup());
		btnSetup.setForeground(Color.WHITE);
		btnSetup.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnSetup.setBackground(new Color(0, 0, 51));
		btnSetup.setBounds(34, 517, 651, 42);
		panelSetupAcc.add(btnSetup);
		
		lblfieldrequired1 = new JLabel("");
		lblfieldrequired1.setForeground(new Color(220, 20, 60));
		lblfieldrequired1.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblfieldrequired1.setBounds(33, 141, 238, 14);
		panelSetupAcc.add(lblfieldrequired1);
		
		lblfieldrequired2 = new JLabel("");
		lblfieldrequired2.setForeground(new Color(220, 20, 60));
		lblfieldrequired2.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblfieldrequired2.setBounds(382, 141, 238, 14);
		panelSetupAcc.add(lblfieldrequired2);
		
		lblfieldrequired3 = new JLabel("");
		lblfieldrequired3.setForeground(new Color(220, 20, 60));
		lblfieldrequired3.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblfieldrequired3.setBounds(33, 225, 238, 14);
		panelSetupAcc.add(lblfieldrequired3);
		
		lblfieldrequired4 = new JLabel("");
		lblfieldrequired4.setForeground(new Color(220, 20, 60));
		lblfieldrequired4.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblfieldrequired4.setBounds(382, 225, 238, 14);
		panelSetupAcc.add(lblfieldrequired4);
		
		lblfieldrequired5 = new JLabel("");
		lblfieldrequired5.setForeground(new Color(220, 20, 60));
		lblfieldrequired5.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblfieldrequired5.setBounds(34, 310, 238, 14);
		panelSetupAcc.add(lblfieldrequired5);
		
		lblfieldrequired6 = new JLabel("");
		lblfieldrequired6.setForeground(new Color(220, 20, 60));
		lblfieldrequired6.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblfieldrequired6.setBounds(382, 310, 238, 14);
		panelSetupAcc.add(lblfieldrequired6);
		
		lblfieldrequired7 = new JLabel("");
		lblfieldrequired7.setForeground(new Color(220, 20, 60));
		lblfieldrequired7.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblfieldrequired7.setBounds(33, 481, 238, 14);
		panelSetupAcc.add(lblfieldrequired7);
		
		lblfieldrequired8 = new JLabel("");
		lblfieldrequired8.setForeground(new Color(220, 20, 60));
		lblfieldrequired8.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblfieldrequired8.setBounds(382, 481, 238, 14);
		panelSetupAcc.add(lblfieldrequired8);
		
		lblfieldrequired9 = new JLabel("");
		lblfieldrequired9.setForeground(new Color(220, 20, 60));
		lblfieldrequired9.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblfieldrequired9.setBounds(33, 396, 238, 14);
		panelSetupAcc.add(lblfieldrequired9);
		
		textField_AdminEmailAddres = new JTextField();
		textField_AdminEmailAddres.setForeground(new Color(106, 106, 106));
		textField_AdminEmailAddres.setFont(new Font("SansSerif", Font.PLAIN, 11));
		textField_AdminEmailAddres.setColumns(10);
		textField_AdminEmailAddres.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		textField_AdminEmailAddres.setBackground(Color.WHITE);
		textField_AdminEmailAddres.setBounds(34, 361, 303, 35);
		panelSetupAcc.add(textField_AdminEmailAddres);
		
		JLabel lblAdminEmailAddress = new JLabel("Admin Email Address");
		lblAdminEmailAddress.setForeground(SystemColor.controlDkShadow);
		lblAdminEmailAddress.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblAdminEmailAddress.setBounds(34, 336, 184, 14);
		panelSetupAcc.add(lblAdminEmailAddress);
		
		lblAddress = new JLabel("Address");
		lblAddress.setForeground(SystemColor.controlDkShadow);
		lblAddress.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblAddress.setBounds(383, 335, 184, 14);
		panelSetupAcc.add(lblAddress);
		
		textField_Address = new JTextField();
		textField_Address.setForeground(new Color(106, 106, 106));
		textField_Address.setFont(new Font("SansSerif", Font.PLAIN, 11));
		textField_Address.setColumns(10);
		textField_Address.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		textField_Address.setBackground(Color.WHITE);
		textField_Address.setBounds(383, 360, 303, 35);
		panelSetupAcc.add(textField_Address);
		
		lblfieldrequired10 = new JLabel("");
		lblfieldrequired10.setForeground(new Color(220, 20, 60));
		lblfieldrequired10.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblfieldrequired10.setBounds(382, 395, 238, 14);
		panelSetupAcc.add(lblfieldrequired10);
		
		lblbackg = new JLabel("");
		Image background = new ImageIcon(this.getClass().getResource("/img/background.jfif")).getImage();
		lblbackg.setIcon(new ImageIcon(background));
		lblbackg.setBounds(0, 0, 843, 605);
		contentPane.add(lblbackg);
	}
	class btnSetup implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			InvalidInputs message = new InvalidInputs();
			Admin admin = new Admin();
			admin.setResName(textFieldRestaurantName.getText());
			admin.setResAddress(textField_RestaurantAddress.getText());
			admin.setResConNum(textField_RestaurantContactNum.getText());
			admin.setResEmAdd(textField_RsetaurantEmailAddress.getText());
			admin.setAdminName(textField_AdminName.getText());
			admin.setAdminConNum(textField_AdminContactNum.getText());
			admin.setUsername(textField_Username.getText());
			admin.setPassword(textField_Password.getText());
			admin.setAdminEmAdd(textField_AdminEmailAddres.getText());
			admin.setAdminAdd(textField_Address.getText());
			getExistingIDRes();
			
			if(admin.getResName().isBlank() || admin.getResAddress().isBlank() || admin.getResConNum().isBlank() || admin.getResEmAdd().isBlank()
				||	admin.getAdminName().isBlank() || admin.getAdminConNum().isBlank() || admin.getUsername().isBlank() || admin.getPassword().isBlank() || admin.getAdminEmAdd().isBlank() || admin.getAdminAdd().isBlank()) {
				
				message.InputRequiredMessage(textFieldRestaurantName, lblfieldrequired1);
				message.InputRequiredMessage(textField_RestaurantAddress, lblfieldrequired2);
				message.InputRequiredMessage(textField_RestaurantContactNum, lblfieldrequired3);
				message.InputRequiredMessage(textField_RsetaurantEmailAddress, lblfieldrequired4);
				message.InputRequiredMessage(textField_AdminName, lblfieldrequired5);
				message.InputRequiredMessage(textField_AdminContactNum, lblfieldrequired6);
				message.InputRequiredMessage(textField_Username, lblfieldrequired7);
				message.InputRequiredMessage(textField_Password, lblfieldrequired8);
				message.InputRequiredMessage(textField_AdminEmailAddres, lblfieldrequired9);
				message.InputRequiredMessage(textField_Address, lblfieldrequired10);
				
				
			}else {
				setup frame = new setup();
				checkID(idRestaurant);
				saveResData(idfinal, textFieldRestaurantName, textField_RestaurantAddress,textField_RestaurantContactNum, textField_RsetaurantEmailAddress);
				checkID(idAdminAcc);
				saveAdminAcc(idfinal, textField_AdminName, textField_AdminContactNum, textField_Username, textField_Password, textField_AdminEmailAddres, textField_Address);
				new LogIn().setVisible(true);
				frame.setVisible(false);
				dispose();
			}
			

		}
		
	}
	public void saveResData(String id, JTextField resName, JTextField resAddress,JTextField conNum, JTextField resEmailAdd) {
		try {
			Connection setupAcc = DriverManager.getConnection( "jdbc:ucanaccess://D:/DatabaseRMS.accdb");
			PreparedStatement pst = setupAcc.prepareStatement("insert into Restaurant_Details(ID ,Restaurant_Name, Restaurant_Address, Restaurant_Contact_Number, Restaurant_Email_Address)values(?, ?, ?, ?, ?)");
			pst.setString(1, id);
			pst.setString(2, resName.getText());
			pst.setString(3, resAddress.getText());
			pst.setString(4, conNum.getText());
			pst.setString(5, resEmailAdd.getText());
			pst.executeUpdate();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	public void saveAdminAcc(String id, JTextField Name,JTextField conNum, JTextField username, JTextField password, JTextField EmAdd, JTextField Address) {
		try {
			Connection setupAcc = DriverManager.getConnection( "jdbc:ucanaccess://D:/DatabaseRMS.accdb");
			PreparedStatement pst = setupAcc.prepareStatement("insert into Admin_Account(ID ,Admin_Name, Admin_Contact_Number, Username, Password, Image, Status, Admin_Email_Address, Address)values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
			pst.setString(1, id);
			pst.setString(2, Name.getText());
			pst.setString(3, conNum.getText());
			pst.setString(4, username.getText());
			pst.setString(5, password.getText());
			pst.setString(6, "no image");
			pst.setBoolean(7, true);
			pst.setString(8, EmAdd.getText());
			pst.setString(9, Address.getText());
			pst.executeUpdate();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	public String generateId() {
		Random random = new Random();
		int first = random.nextInt(999);
		int second = random.nextInt(999);
		int third = random.nextInt(999);
		return first + "-" + second + "-" + third;
	 }
	
	public void checkID(ArrayList ID) {
		while(true) {
			String id = generateId();
			if(!ID.contains(id)) {
				idfinal = id;
				break;
			}else {
				continue;
			}
			
		}
	}
	public void getExistingIDRes() {
		Connection con;
		try {
			con = DriverManager.getConnection( "jdbc:ucanaccess://D:/DatabaseRMS.accdb");
			Statement statement = con.createStatement();
			ResultSet resulResData = statement.executeQuery("select * from Restaurant_Details");
			
			
			while(resulResData.next()) {
				String id = resulResData.getString("ID");
				idRestaurant.add(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void getExistingIDAdmin() {
		Connection con;
		try {
			con = DriverManager.getConnection( "jdbc:ucanaccess://D:/DatabaseRMS.accdb");
			Statement statement = con.createStatement();
			ResultSet resulAdminAcc = statement.executeQuery("select * from Admin_Account");
			
			
			while(resulAdminAcc.next()) {
				String id = resulAdminAcc.getString("ID");
				idAdminAcc.add(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
