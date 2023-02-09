package restaurantManagementSystem;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;

import modifiedComponents.RoundButton;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class LogIn extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUsername;
	private JPasswordField textFieldPassword;
	private JLabel lblmessageuser;
	private JLabel lblmessagepass;
	private JLabel lblnotExistingAccount;
	private static String name = "";
	private static String Image = "";
	private static Boolean status = null;
	
	public LogIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 859, 558);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 102, 153));
		panel.setBounds(0, 0, 843, 519);
		panel.setBorder(null);
		contentPane.add(panel);
		panel.setLayout(null);
		
		RoundedPanel pnl_Login = new RoundedPanel(30);
		pnl_Login.setOpaque(false);
		pnl_Login.setBackground(Color.WHITE);
		pnl_Login.setBounds(44, 23, 420, 472);
		panel.add(pnl_Login);
		pnl_Login.setLayout(null);
		
		textFieldPassword = new JPasswordField();
		textFieldPassword.setBounds(56, 261, 323, 42);
		pnl_Login.add(textFieldPassword);
		textFieldPassword.setColumns(10);
		textFieldPassword.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		textFieldPassword.setBackground(Color.WHITE);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(55, 236, 324, 14);
		pnl_Login.add(lblPassword);
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setForeground(SystemColor.controlDkShadow);
		lblPassword.setFont(new Font("SansSerif", Font.BOLD, 15));
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(57, 140, 322, 14);
		pnl_Login.add(lblUsername);
		lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername.setForeground(SystemColor.controlDkShadow);
		lblUsername.setFont(new Font("SansSerif", Font.BOLD, 15));
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(56, 165, 323, 42);
		pnl_Login.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		textFieldUsername.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		textFieldUsername.setBackground(Color.WHITE);
		
		JLabel lblLogin = new JLabel("Login Account");
		lblLogin.setBounds(0, 45, 420, 28);
		pnl_Login.add(lblLogin);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setForeground(new Color(11, 31, 55));
		lblLogin.setFont(new Font("Arial", Font.BOLD, 26));
		
		RoundButton btnLogin = new RoundButton("Login", 40);
		btnLogin.addActionListener(new btnLogin());
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnLogin.setFocusable(false);
		btnLogin.setBackground(new Color(11, 31, 55));
		btnLogin.setBounds(56, 357, 323, 49);
		pnl_Login.add(btnLogin);
		
		lblmessageuser = new JLabel("");
		lblmessageuser.setForeground(new Color(220, 20, 60));
		lblmessageuser.setFont(new Font("Arial", Font.PLAIN, 10));
		lblmessageuser.setBounds(56, 206, 238, 14);
		pnl_Login.add(lblmessageuser);
		
		lblmessagepass = new JLabel("");
		lblmessagepass.setForeground(new Color(220, 20, 60));
		lblmessagepass.setFont(new Font("Arial", Font.PLAIN, 10));
		lblmessagepass.setBounds(56, 303, 238, 14);
		pnl_Login.add(lblmessagepass);
		
		lblnotExistingAccount = new JLabel("");
		lblnotExistingAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblnotExistingAccount.setForeground(new Color(220, 20, 60));
		lblnotExistingAccount.setFont(new Font("Arial", Font.PLAIN, 11));
		lblnotExistingAccount.setBounds(100, 314, 238, 14);
		pnl_Login.add(lblnotExistingAccount);
		
		JLabel lblback = new JLabel();
		Image background = new ImageIcon(this.getClass().getResource("/img/background.jfif")).getImage();
		lblback.setIcon(new ImageIcon(background));
		lblback.setBounds(0, 0, 843, 519);
		panel.add(lblback);
		
		
	}
	class btnLogin implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			lblmessageuser.setText(null);
			lblmessagepass.setText(null);
			lblnotExistingAccount.setText(null);
			
				if(textFieldUsername.getText().isBlank() || textFieldPassword.getText().isBlank()) {
					InvalidInputs BlankInput = new InvalidInputs();
					BlankInput.InputRequiredMessage(textFieldUsername, lblmessageuser);
					BlankInput.InputRequiredMessage(textFieldPassword, lblmessagepass);
				}else {
					textFieldUsername.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
					textFieldPassword.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
					lblmessageuser.setText(null);
					lblmessagepass.setText(null);
					lblnotExistingAccount.setText(null);
					try {
						Connection con = DriverManager.getConnection( "jdbc:ucanaccess://D:/DatabaseRMS.accdb");
						Statement statement = con.createStatement();
						ResultSet resultAdmin = statement.executeQuery("select * from Admin_Account");
						ResultSet resultAdmindet = statement.executeQuery("select * from Admin_Account");
						ResultSet resultCashier = statement.executeQuery("select * from Cashier_Account");
					
						ArrayList adminAcc = new ArrayList();
						ArrayList adminUsername = new ArrayList();
						ArrayList adminName = new ArrayList();
						ArrayList adminPassword = new ArrayList();
						ArrayList adminimage = new ArrayList();
						ArrayList <Boolean> adminStatus = new ArrayList<>();
						
						ArrayList cashierAcc = new ArrayList();
						ArrayList cashierName = new ArrayList();
						ArrayList cashierUsername = new ArrayList();
						ArrayList cashierPassword = new ArrayList();
						ArrayList cashierimage = new ArrayList();
						ArrayList <Boolean> cashierStatus = new ArrayList<>();
						
						setup frame = new setup();
		
						String loginInput = textFieldUsername.getText() + "-" + textFieldPassword.getText();
					
						while(resultAdmin.next()) {
							adminAcc.add(resultAdmin.getString("Username") + "-" + resultAdmin.getString("Password"));
							adminUsername.add(resultAdmin.getString("Username"));
							adminPassword.add(resultAdmin.getString("Password"));
							adminName.add(resultAdmin.getString("Admin_Name"));
							adminimage.add(resultAdmin.getNString("Image"));
							adminStatus.add(resultAdmin.getBoolean("Status"));
						}	
						
						while(resultCashier.next()) {
							cashierAcc.add(resultCashier.getString("Username") + "-" + resultCashier.getString("Password"));
							cashierUsername.add(resultCashier.getString("Username"));
							adminPassword.add(resultCashier.getString("Password"));
							cashierName.add(resultCashier.getString("Name"));
							cashierimage.add(resultCashier.getString("Image"));
							cashierStatus.add(resultCashier.getBoolean("Status"));
						}
					
						if(adminAcc.contains(loginInput)) {
							
							for (int i = 0; i < adminName.size(); i++) {
						
								if(adminUsername.get(i).equals(textFieldUsername.getText())) {
									status = adminStatus.get(i);
									name = adminName.get(i).toString();
									Image = adminimage.get(i).toString();
								}
							}
							
							if(status == true) {
								frame.setVisible(false);
								dispose();
								MainFrame mainframe = new MainFrame();
								
								mainframe.setData(new Model_CurrentUser(Image, "ADMIN", name));
								mainframe.setLocationRelativeTo(null);
								mainframe.setVisible(true);
							}else {
								lblnotExistingAccount.setText("Admin Account is not Active");
							}
							
							
						}else if(cashierAcc.contains(loginInput)) {
							frame.setVisible(false);
							dispose();
							
							CashierFrame cashierFrame = new CashierFrame();
							
							for (int i = 0; i < cashierName.size(); i++) {
								
								if(cashierUsername.get(i).equals(textFieldUsername.getText())) {
									name = cashierName.get(i).toString();
									Image = cashierimage.get(i).toString();
								}
							}
							cashierFrame.setData(new Model_CurrentUser(Image, "CASHIER", name));
							cashierFrame.setLocationRelativeTo(null);
							cashierFrame.setVisible(true);
						}else {
							if(adminUsername.contains(textFieldUsername.getText()) || cashierUsername.contains(textFieldUsername.getText())){
								textFieldPassword.setBorder(new LineBorder(Color.RED, 1, true));
								lblmessagepass.setText("Wrong password");
							}else {
								textFieldUsername.setBorder(new LineBorder(Color.RED, 1, true));
								textFieldPassword.setBorder(new LineBorder(Color.RED, 1, true));
								lblnotExistingAccount.setText("Wrong Username or Password");
							}
							
						}
				
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
		}
	}
	
}

