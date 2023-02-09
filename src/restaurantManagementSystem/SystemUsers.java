package restaurantManagementSystem;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EventListener;
import java.util.Random;

import javax.swing.table.DefaultTableCellRenderer.*;

import fileChooser.*;
import modifiedComponents.RoundButton;
import tableButtons.Actions;
import tableButtons.ActionsBtnTableActionCellEditor;
import tableButtons.ActiveUserStatus;
import tableButtons.AddressContactBtnTableActionCellEditor;
import tableButtons.Availability;
import tableButtons.StatusBtnTableActionCellEditor;
import tableButtons.actionEvent;
import tableButtons.statusEvent;
import tableButtons.AddressContactDetails;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.ScrollPaneConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SystemUsers extends JPanel {
	MainFrame frame;
	private RoundedPanel panel_Add_UpdateUser;
	private RoundedPanel panel;
	private JTextField textField_Name;
	private Table table;
	private JLabel lblmessage_Name;
	private JLabel lblmessage_Address;
	private JLabel lblmessage_EmailAddress;
	private JLabel lblmessage_ContactNumber;
	private JScrollPane scrollPaneTableM;
	private JLabel productImage;
	static String addORupdate;
	static String exemptedID;
	static String exemptedTableName;
	static String image;
	private Image imag;
	private String idfinal;
	private JLabel lblimg;
	statusEvent eventStatus;
	actionEvent eventActions;
	private statusEvent AddCon;
	int row;
	Object value;
	Object valueName;
	int count = 1;
	ArrayList av = new ArrayList();
	private JTextField textField_EmailAddress;
	private JTextField textField_ContactNumber;
	private JLabel lblLoginInformation;
	private JLabel lblUsername;
	private JTextField textField_Username;
	private JLabel lblmessage_Username;
	private JLabel lblName_ContactNumber_1;
	private JTextField textField_Password;
	private JLabel lblmessage_Password;
	private JTextField textField_Address;
	private String Position;
	private RoundedPanel AddressContactDetails;
	ArrayList Details = new ArrayList();
	private JLabel iconUser;
	private JLabel iconPosition;
	private JLabel lblUserName;
	private JLabel lblPos;
	private JLabel iconAddress;
	private JLabel lblAddress;
	private JLabel iconEmail;
	private JLabel lblemail;
	private JLabel iconContactNumber;
	private JLabel lblContactNum;
	private int backNum;
	private static String currentUser = "";
	private JLabel message_DialogBox;
	private RoundedPanel messageDialogBox;
	private String postoDelete;
	private RoundButton rndbtnOkay;
	private RoundButton rndbtnCancel;
	private String currentPos;
	
	public SystemUsers() {
		setBackground(UIManager.getColor("CheckBox.background"));
		setBounds(0, 0, 944, 681);
		setLayout(null);

		lblimg = new JLabel("");
		lblimg.setBounds(0, 0, 64, 64);
		
		panel_Add_UpdateUser = new RoundedPanel(30);
		panel_Add_UpdateUser.setOpaque(false);
		panel_Add_UpdateUser.setBackground(new Color(255, 255, 255));
		panel_Add_UpdateUser.setBounds(387, 11, 501, 628);
		panel_Add_UpdateUser.setBorder(null);

		panel_Add_UpdateUser.setLayout(null);

		textField_Name = new JTextField();
		textField_Name.setFont(new Font("SansSerif", Font.PLAIN, 12));
		textField_Name.setColumns(10);
		textField_Name.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		textField_Name.setBackground(Color.WHITE);
		textField_Name.setBounds(189, 39, 287, 42);
		panel_Add_UpdateUser.add(textField_Name);

		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setForeground(SystemColor.controlDkShadow);
		lblName.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblName.setBounds(189, 21, 227, 14);
		panel_Add_UpdateUser.add(lblName);

		RoundButton btnFinish = new RoundButton("Finish", 40);
		btnFinish.addActionListener(new btnFinished());
		
		messageDialogBox = new RoundedPanel(20);
		messageDialogBox.setBackground(new Color(255, 255, 255));
		messageDialogBox.setOpaque(false);
		messageDialogBox.setBounds(256, 189, 410, 191);
		messageDialogBox.setVisible(false);
		add(messageDialogBox);
		messageDialogBox.setLayout(null);
		
		rndbtnOkay = new RoundButton("Finish", 40);
		rndbtnOkay.addActionListener(new btnOkay());
		rndbtnOkay.setText("Okay");
		rndbtnOkay.setForeground(Color.WHITE);
		rndbtnOkay.setFont(new Font("SansSerif", Font.PLAIN, 12));
		rndbtnOkay.setFocusable(false);
		rndbtnOkay.setBackground(new Color(11, 31, 55));
		rndbtnOkay.setBounds(211, 137, 137, 32);
		messageDialogBox.add(rndbtnOkay);
		
		rndbtnCancel = new RoundButton("Finish", 40);
		rndbtnCancel.addActionListener(new btnBack());
		rndbtnCancel.setText("Cancel");
		rndbtnCancel.setForeground(Color.WHITE);
		rndbtnCancel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		rndbtnCancel.setFocusable(false);
		rndbtnCancel.setBackground(new Color(192, 192, 192));
		rndbtnCancel.setBounds(47, 137, 141, 32);
		messageDialogBox.add(rndbtnCancel);
		
		Image alert = new ImageIcon(this.getClass().getResource("/img/alert.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		JLabel AlertIcon = new JLabel("");
		AlertIcon.setIcon(new ImageIcon(alert));
		AlertIcon.setHorizontalAlignment(SwingConstants.CENTER);
		AlertIcon.setBounds(10, 11, 390, 64);
		messageDialogBox.add(AlertIcon);
		
		message_DialogBox = new JLabel();
		message_DialogBox.setText("select a product");
		message_DialogBox.setHorizontalAlignment(SwingConstants.CENTER);
		message_DialogBox.setFont(new Font("SansSerif", Font.PLAIN, 12));
		message_DialogBox.setBounds(10, 86, 390, 29);
		messageDialogBox.add(message_DialogBox);
		
		AddressContactDetails = new RoundedPanel(20);
		AddressContactDetails.setBackground(new Color(255, 255, 255));
		AddressContactDetails.setBounds(262, 64, 383, 360);
		AddressContactDetails.setOpaque(false);
		add(AddressContactDetails);
		AddressContactDetails.setLayout(null);
		
		RoundButton rndbtnBack = new RoundButton("Finish", 40);
		rndbtnBack.addActionListener(new btnBack());
		rndbtnBack.setText("Back");
		rndbtnBack.setForeground(Color.WHITE);
		rndbtnBack.setFont(new Font("SansSerif", Font.PLAIN, 12));
		rndbtnBack.setFocusable(false);
		rndbtnBack.setBackground(new Color(11, 31, 55));
		rndbtnBack.setBounds(37, 301, 310, 32);
		AddressContactDetails.add(rndbtnBack);
		
		Image User = new ImageIcon(this.getClass().getResource("/img/profile-user.png")).getImage();
		iconUser = new JLabel("");
		iconUser.setIcon(new ImageIcon(User));
		iconUser.setBounds(37, 28, 32, 32);
		AddressContactDetails.add(iconUser);
		
		Image Pos = new ImageIcon(this.getClass().getResource("/img/office-chair.png")).getImage();
		iconPosition = new JLabel("");
		iconPosition.setIcon(new ImageIcon(Pos));
		iconPosition.setBounds(37, 79, 32, 32);
		AddressContactDetails.add(iconPosition);
		
		lblUserName = new JLabel("Name");
		lblUserName.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblUserName.setBounds(89, 37, 241, 14);
		AddressContactDetails.add(lblUserName);
		
		lblPos = new JLabel("Position");
		lblPos.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblPos.setBounds(89, 87, 241, 14);
		AddressContactDetails.add(lblPos);
		
		Image Loc = new ImageIcon(this.getClass().getResource("/img/location.png")).getImage();
		iconAddress = new JLabel("");
		iconAddress.setIcon(new ImageIcon(Loc));
		iconAddress.setBounds(37, 132, 32, 32);
		AddressContactDetails.add(iconAddress);
		
		lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblAddress.setBounds(89, 141, 241, 14);
		AddressContactDetails.add(lblAddress);
		
		Image email = new ImageIcon(this.getClass().getResource("/img/mail.png")).getImage();
		iconEmail = new JLabel("");
		iconEmail.setIcon(new ImageIcon(email));
		iconEmail.setBounds(37, 183, 32, 32);
		AddressContactDetails.add(iconEmail);
		
		lblemail = new JLabel("Email");
		lblemail.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblemail.setBounds(89, 192, 241, 14);
		AddressContactDetails.add(lblemail);
		
		
		Image ContactNum = new ImageIcon(this.getClass().getResource("/img/phone.png")).getImage();
		iconContactNumber = new JLabel("");
		iconContactNumber.setIcon(new ImageIcon(ContactNum));
		iconContactNumber.setBounds(37, 233, 32, 32);
		AddressContactDetails.add(iconContactNumber);
		
		lblContactNum = new JLabel("Contact Number");
		lblContactNum.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblContactNum.setBounds(89, 242, 241, 14);
		AddressContactDetails.add(lblContactNum);
		AddressContactDetails.setVisible(false);
		
		btnFinish.setForeground(Color.WHITE);
		btnFinish.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnFinish.setFocusable(false);
		btnFinish.setBackground(new Color(11, 31, 55));
		btnFinish.setBounds(22, 541, 454, 42);
		panel_Add_UpdateUser.add(btnFinish);
		add(panel_Add_UpdateUser);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new btnBack());
		btnBack.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnBack.setFocusable(false);
		btnBack.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(22, 594, 458, 23);
		panel_Add_UpdateUser.add(btnBack);

		lblmessage_Name = new JLabel("");
		lblmessage_Name.setHorizontalAlignment(SwingConstants.LEFT);
		lblmessage_Name.setForeground(new Color(220, 20, 60));
		lblmessage_Name.setFont(new Font("Arial", Font.PLAIN, 10));
		lblmessage_Name.setBounds(189, 82, 194, 14);
		panel_Add_UpdateUser.add(lblmessage_Name);

		JLabel lblPosition = new JLabel("Address");
		lblPosition.setHorizontalAlignment(SwingConstants.LEFT);
		lblPosition.setForeground(SystemColor.controlDkShadow);
		lblPosition.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblPosition.setBounds(189, 100, 119, 23);
		panel_Add_UpdateUser.add(lblPosition);

		lblmessage_Address = new JLabel("");
		lblmessage_Address.setHorizontalAlignment(SwingConstants.LEFT);
		lblmessage_Address.setForeground(new Color(220, 20, 60));
		lblmessage_Address.setFont(new Font("Arial", Font.PLAIN, 10));
		lblmessage_Address.setBounds(189, 162, 155, 14);
		panel_Add_UpdateUser.add(lblmessage_Address);

		productImage = new JLabel("");
		Image background = new ImageIcon(this.getClass().getResource("/img/noImage.png")).getImage().getScaledInstance(194, 194, Image.SCALE_SMOOTH);
		productImage.setIcon(new ImageIcon(background));
		productImage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jButton1ActionPerformed(e);
			}
		});
		productImage.setHorizontalAlignment(SwingConstants.CENTER);
		productImage.setBounds(22, 21, 149, 149);
		panel_Add_UpdateUser.add(productImage);
		
		JLabel lblContactDetails = new JLabel("Contact Details");
		lblContactDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblContactDetails.setForeground(SystemColor.controlDkShadow);
		lblContactDetails.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblContactDetails.setBounds(10, 176, 481, 23);
		panel_Add_UpdateUser.add(lblContactDetails);
		
		lblmessage_EmailAddress = new JLabel("");
		lblmessage_EmailAddress.setHorizontalAlignment(SwingConstants.LEFT);
		lblmessage_EmailAddress.setForeground(new Color(220, 20, 60));
		lblmessage_EmailAddress.setFont(new Font("Arial", Font.PLAIN, 10));
		lblmessage_EmailAddress.setBounds(21, 260, 194, 14);
		panel_Add_UpdateUser.add(lblmessage_EmailAddress);
		
		textField_EmailAddress = new JTextField();
		textField_EmailAddress.setFont(new Font("SansSerif", Font.PLAIN, 12));
		textField_EmailAddress.setColumns(10);
		textField_EmailAddress.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		textField_EmailAddress.setBackground(Color.WHITE);
		textField_EmailAddress.setBounds(21, 217, 455, 42);
		panel_Add_UpdateUser.add(textField_EmailAddress);
		
		JLabel lblEmailAddress = new JLabel("Email Address");
		lblEmailAddress.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmailAddress.setForeground(SystemColor.controlDkShadow);
		lblEmailAddress.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblEmailAddress.setBounds(21, 199, 227, 14);
		panel_Add_UpdateUser.add(lblEmailAddress);
		
		lblmessage_ContactNumber = new JLabel("");
		lblmessage_ContactNumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblmessage_ContactNumber.setForeground(new Color(220, 20, 60));
		lblmessage_ContactNumber.setFont(new Font("Arial", Font.PLAIN, 10));
		lblmessage_ContactNumber.setBounds(21, 339, 194, 14);
		panel_Add_UpdateUser.add(lblmessage_ContactNumber);
		
		textField_ContactNumber = new JTextField();
		textField_ContactNumber.setFont(new Font("SansSerif", Font.PLAIN, 12));
		textField_ContactNumber.setColumns(10);
		textField_ContactNumber.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		textField_ContactNumber.setBackground(Color.WHITE);
		textField_ContactNumber.setBounds(21, 296, 455, 42);
		panel_Add_UpdateUser.add(textField_ContactNumber);
		
		JLabel lblName_ContactNumber = new JLabel("Contact Number");
		lblName_ContactNumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblName_ContactNumber.setForeground(SystemColor.controlDkShadow);
		lblName_ContactNumber.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblName_ContactNumber.setBounds(21, 278, 227, 14);
		panel_Add_UpdateUser.add(lblName_ContactNumber);
		
		lblLoginInformation = new JLabel("Login Information");
		lblLoginInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginInformation.setForeground(SystemColor.controlDkShadow);
		lblLoginInformation.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblLoginInformation.setBounds(10, 349, 481, 23);
		panel_Add_UpdateUser.add(lblLoginInformation);
		
		lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername.setForeground(SystemColor.controlDkShadow);
		lblUsername.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblUsername.setBounds(21, 372, 227, 14);
		panel_Add_UpdateUser.add(lblUsername);
		
		textField_Username = new JTextField();
		textField_Username.setFont(new Font("SansSerif", Font.PLAIN, 12));
		textField_Username.setColumns(10);
		textField_Username.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		textField_Username.setBackground(Color.WHITE);
		textField_Username.setBounds(21, 390, 455, 42);
		panel_Add_UpdateUser.add(textField_Username);
		
		lblmessage_Username = new JLabel("");
		lblmessage_Username.setHorizontalAlignment(SwingConstants.LEFT);
		lblmessage_Username.setForeground(new Color(220, 20, 60));
		lblmessage_Username.setFont(new Font("Arial", Font.PLAIN, 10));
		lblmessage_Username.setBounds(21, 433, 194, 14);
		panel_Add_UpdateUser.add(lblmessage_Username);
		
		lblName_ContactNumber_1 = new JLabel("Password");
		lblName_ContactNumber_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblName_ContactNumber_1.setForeground(SystemColor.controlDkShadow);
		lblName_ContactNumber_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblName_ContactNumber_1.setBounds(21, 451, 227, 14);
		panel_Add_UpdateUser.add(lblName_ContactNumber_1);
		
		textField_Password = new JTextField();
		textField_Password.setFont(new Font("SansSerif", Font.PLAIN, 12));
		textField_Password.setColumns(10);
		textField_Password.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		textField_Password.setBackground(Color.WHITE);
		textField_Password.setBounds(21, 469, 455, 42);
		panel_Add_UpdateUser.add(textField_Password);
		
		lblmessage_Password = new JLabel("");
		lblmessage_Password.setHorizontalAlignment(SwingConstants.LEFT);
		lblmessage_Password.setForeground(new Color(220, 20, 60));
		lblmessage_Password.setFont(new Font("Arial", Font.PLAIN, 10));
		lblmessage_Password.setBounds(21, 512, 194, 14);
		panel_Add_UpdateUser.add(lblmessage_Password);
		
		textField_Address = new JTextField();
		textField_Address.setFont(new Font("SansSerif", Font.PLAIN, 12));
		textField_Address.setColumns(10);
		textField_Address.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		textField_Address.setBackground(Color.WHITE);
		textField_Address.setBounds(189, 121, 287, 42);
		panel_Add_UpdateUser.add(textField_Address);
		panel_Add_UpdateUser.setVisible(false);

		JLabel lblNewLabel_1_1 = new JLabel("System Users");
		lblNewLabel_1_1.setToolTipText("");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setForeground(new Color(11, 31, 55));
		lblNewLabel_1_1.setFont(new Font("SansSerif", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(20, 11, 265, 42);
		add(lblNewLabel_1_1);

		panel = new RoundedPanel(25);
		panel.setForeground(new Color(255, 255, 255));
		panel.setOpaque(false);
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(20, 51, 910, 619);
		add(panel);
		panel.setLayout(null);

		RoundButton btn_AddAdmin = new RoundButton("New button", 30);
		btn_AddAdmin.setFocusable(false);
		btn_AddAdmin.addActionListener(new btnAddAdmin());
		btn_AddAdmin.setIcon(new ImageIcon(this.getClass().getResource("/img/add2.png")));
		btn_AddAdmin.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btn_AddAdmin.setBackground(new Color(0, 204, 102));
		btn_AddAdmin.setForeground(new Color(255, 255, 255));
		btn_AddAdmin.setText(" Add Admin");
		btn_AddAdmin.setBounds(20, 11, 129, 31);
		panel.add(btn_AddAdmin);

		scrollPaneTableM = new JScrollPane();
		scrollPaneTableM.setBounds(12, 53, 888, 555);
		panel.add(scrollPaneTableM);
		
		RoundButton btn_AddCashier = new RoundButton("New button", 30);
		btn_AddCashier.setText(" Add Cashier");
		btn_AddCashier.addActionListener(new btnAddCashier());
		btn_AddCashier.setIcon(new ImageIcon(this.getClass().getResource("/img/add2.png")));
		btn_AddCashier.setForeground(Color.WHITE);
		btn_AddCashier.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btn_AddCashier.setFocusable(false);
		btn_AddCashier.setBackground(new Color(15, 132, 9));
		btn_AddCashier.setBounds(159, 11, 129, 31);
		panel.add(btn_AddCashier);
		displayDataUsers();
		
	}
	
	public void setData(Model_CurrentUser user) {
		currentUser = user.getName();
		displayDataUsers();
		
    }
	
	private void jButton1ActionPerformed(MouseEvent evt) {
		JnaFileChooser jnaCh = new JnaFileChooser();
		jnaCh.addFilter("Pictures", "jpg", "jpeg", "gif", "png", "bmp");
		boolean save = jnaCh.showOpenDialog(this.frame);
		if (save) {
			
			image = jnaCh.getSelectedFile().getAbsolutePath();
			Image background = new ImageIcon(jnaCh.getSelectedFile().getAbsolutePath()).getImage().getScaledInstance(194, 194, Image.SCALE_SMOOTH);
			productImage.setIcon(new ImageIcon(background));

		}
	}

	class btnAddAdmin implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			backNum = 1;
			Position = "Admin";
			scrollPaneTableM.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
			panel_Add_UpdateUser.setVisible(true);
			setEnableRec(panel,false);
			addORupdate = "add";
			exemptedID = "";
			exemptedTableName = "";
		}
	}
	
	class btnOkay implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(postoDelete.equals("Own")) {
				deleteAdmin();
			}else if(postoDelete.equals("Admin")) {
				deleteAdmin();
				
			}else if(postoDelete.equals("Cashier")) {
				deleteCashier();
				setEnableRec(panel,true);
				messageDialogBox.setVisible(false);
			}else if(postoDelete.equals("Edit")) {
				setEnableRec(panel,true);
				message_DialogBox.setText(null);
				rndbtnOkay.setBounds(211, 137, 141, 32);
				messageDialogBox.setVisible(false);
			}
		}
	}
	
	class btnAddCashier implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			backNum = 1;
			Position = "Cashier";
			scrollPaneTableM.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
			panel_Add_UpdateUser.setVisible(true);
			setEnableRec(panel,false);
			addORupdate = "add";
			exemptedID = "";
			exemptedTableName = "";
		}
	}

	class btnBack implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			reset();
			if(backNum == 1) {
				scrollPaneTableM.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				panel_Add_UpdateUser.setVisible(false);
				setEnableRec(panel,true);
			}else if(backNum == 2) {
				scrollPaneTableM.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				AddressContactDetails.setVisible(false);
				setEnableRec(panel,true);
			}else if(backNum == 3) {
				setEnableRec(panel,true);
				message_DialogBox.setText(null);
				rndbtnOkay.setBounds(211, 137, 141, 32);
				messageDialogBox.setVisible(false);
			}
			
			
		}
	}
	class btnFinished implements ActionListener{
		InvalidInputs message = new InvalidInputs();
		ArrayList <String> IDvalues = new ArrayList<>();
		ArrayList <String> productNamevalues = new ArrayList<>();

		@Override
		public void actionPerformed(ActionEvent e) {
			getArrayData(productNamevalues, 2);
			productNamevalues.remove(exemptedTableName);
			
			
			if(image == null) {
				image = "no image";
			}
			if(textField_Name.getText().isBlank() || textField_EmailAddress.getText().isBlank() || textField_ContactNumber.getText().isBlank() || textField_Address.getText().isBlank()
				|| textField_Username.getText().isBlank() || textField_Password.getText().isBlank()) {
				message.InputRequiredMessage(textField_Name, lblmessage_Name);
				message.InputRequiredMessage(textField_EmailAddress, lblmessage_EmailAddress);
				message.InputRequiredMessage(textField_ContactNumber, lblmessage_ContactNumber);
				message.InputRequiredMessage(textField_Address, lblmessage_Address);
				message.InputRequiredMessage(textField_Username, lblmessage_Username);
				message.InputRequiredMessage(textField_Password, lblmessage_Password);
				
			}else if(message.checkExistingData(productNamevalues, textField_Name, lblmessage_Name)) {

				if(message.checkExistingData(productNamevalues, textField_Name, lblmessage_Name)) {
					textField_Name.setBorder(new LineBorder(Color.RED, 1, true));
					lblmessage_Name.setText("Name Already Existing");
				}
				lblmessage_Address.setText(null);
				
				productNamevalues.clear();
			}else {
				String Name = textField_Name.getText();
				String ContactNum = textField_ContactNumber.getText();
				String EmailAdd = textField_EmailAddress.getText();
				String Address = textField_Address.getText();
				String Username = textField_Username.getText();
				String Password = textField_Password.getText();
				
				if(addORupdate.equalsIgnoreCase("add")) {
					try {
						Connection con = DriverManager.getConnection( "jdbc:ucanaccess://D:/DatabaseRMS.accdb");
						if(Position.equals("Admin")) {
							getArrayData(IDvalues, 0);
							checkID(IDvalues);
							PreparedStatement pst = con.prepareStatement("insert into Admin_Account(ID, Admin_Name, Admin_Contact_Number, Admin_Email_Address, Status, Image, Address, Username, Password)values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
							pst.setString(1, idfinal);
							pst.setString(2, Name);
							pst.setString(3, ContactNum);
							pst.setString(4, EmailAdd);
							pst.setBoolean(5, true);
							pst.setString(6, image);
							pst.setString(7, Address);
							pst.setString(8, Username);
							pst.setString(9, Password);
							pst.executeUpdate();
							IDvalues.clear();
						}else if(Position.equals("Cashier")) {
							getArrayData(IDvalues, 0);
							checkID(IDvalues);
							PreparedStatement pst = con.prepareStatement("insert into Cashier_Account(ID, Name, Contact_number, Email_Address, Status, Image, Address, Username, Password)values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
							pst.setString(1, idfinal);
							pst.setString(2, Name);
							pst.setString(3, ContactNum);
							pst.setString(4, EmailAdd);
							pst.setBoolean(5, true);
							pst.setString(6, image);
							pst.setString(7, Address);
							pst.setString(8, Username);
							pst.setString(9, Password);
							pst.executeUpdate();
							IDvalues.clear();
						}
						
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
					panel_Add_UpdateUser.setVisible(false);
					setEnableRec(panel,true);
					displayDataUsers();
					reset();

				}else if(addORupdate.equalsIgnoreCase("update")) {
					row = table.getSelectedRow();
					value = table.getValueAt(row, 0);				
					try {
						Connection con = DriverManager.getConnection( "jdbc:ucanaccess://D:/DatabaseRMS.accdb");
							PreparedStatement pst = con.prepareStatement("UPDATE Cashier_Account set Name = ?, Contact_number = ?, Email_Address = ?, Image = ?, Address = ?, Username = ?, Password = ? where ID = ?");
							pst.setString(1, Name);
							pst.setString(2, ContactNum);
							pst.setString(3, EmailAdd);
							pst.setString(4, image);
							pst.setString(5, Address);
							pst.setString(6, Username);
							pst.setString(7, Password);
							pst.setString(8, value.toString());
							pst.executeUpdate();
							IDvalues.clear();
						

					} catch (SQLException ex) {
						ex.printStackTrace();
					}
					panel_Add_UpdateUser.setVisible(false);
					setEnableRec(panel,true);
					displayDataUsers();
					reset();
					

				}
				scrollPaneTableM.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				IDvalues.clear();
				productNamevalues.clear();
			}


		}
	}
	
	public void removeCurrent(String name) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (int i = 0; i < table.getRowCount(); i++) {
			
			if(table.getValueAt(i, 2).equals(name)) {
				model.removeRow(i);
			}
		}
	}
	
	public void setUserActiveStatus(boolean available) {
		row = table.getSelectedRow();
		value = table.getValueAt(row, 0);
		String pos = table.getValueAt(row, 3).toString();
		ArrayList disabledCategories = new ArrayList();

		try {
			Connection con = DriverManager.getConnection( "jdbc:ucanaccess://D:/DatabaseRMS.accdb");
			
			PreparedStatement pstadmin = con.prepareStatement("UPDATE Admin_Account set Status = ? where ID = ?");
			PreparedStatement pstcashier = con.prepareStatement("UPDATE Cashier_Account set Status = ? where ID = ?");
			if(pos.equals("Admin"))	{
				pstadmin.setBoolean(1, available);	
				pstadmin.setString(2, value.toString());
				pstadmin.executeUpdate();
			}else if(pos.equals("Cashier")) {
				pstcashier.setBoolean(1, available);	
				pstcashier.setString(2, value.toString());
				pstcashier.executeUpdate();
			}
			
			
			//displayDataProduct();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
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

	public void getArrayData(ArrayList list, int columnIndex) {
		for (int i = 0; i < table.getRowCount(); i++) {
			Object IDvalue = table.getValueAt(i, columnIndex);
			list.add(String.valueOf(IDvalue));
		}
	}

	class tableCellRenderer implements TableCellRenderer{

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,int row, int column) {
			String imageName = value.toString();
			ImageIcon imag = new ImageIcon(
					new ImageIcon(imageName).getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH));
			return new image(imageName);
		}

	}
	class StatusBtnCellRenderer implements TableCellRenderer{

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			String nm = value.toString();

			return new ActiveUserStatus(nm);
		}

	}
	
	class ActionsBtnCellRenderer implements TableCellRenderer{

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			return new Actions();
		}

	}
	class AddressContactBtnCellRenderer implements TableCellRenderer{

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			return new AddressContactDetails();
		}

	}
	public void displayDataUsers() {

		table = new Table();
		table.setShowVerticalLines(false);
		table.setFont(new Font("SansSerif", Font.PLAIN, 14));

		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"ID no.", "Image", "Name", "Position", "Status", "More Info", "Actions"
				}
				)
		{
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });

		table.fixTable(scrollPaneTableM);
		scrollPaneTableM.setViewportView(table);
		Connection con;
		Availability btn = new Availability("");
		try {
			con = DriverManager.getConnection( "jdbc:ucanaccess://D:/DatabaseRMS.accdb");
			Statement statement = con.createStatement();
			ResultSet resultadmin = statement.executeQuery("select * from Admin_Account");
			ResultSet resultcahier = statement.executeQuery("select * from Cashier_Account");
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			while(resultadmin.next()) {
				
				String ID = resultadmin.getString("ID");
				String adminName = resultadmin.getString("Admin_Name");
				String ContactNo = resultadmin.getString("Admin_Contact_Number");
				String EmailAdd = resultadmin.getString("Admin_Email_Address");
				Boolean Status = resultadmin.getBoolean("Status");
				String Img = resultadmin.getString("Image");
				String status;
				
				if(Status == true) {
					status = "Active";

				}else {
					status = "Not Active";
				}

				table.addRow(new Object[]{ID , Img, adminName, "Admin", status, null, null}) ;
				
			}
			
			while(resultcahier.next()) {
				String ID = resultcahier.getString("ID");
				String cahierName = resultcahier.getString("Name");
				String ContactNo = resultcahier.getString("Contact_Number");
				String EmailAdd = resultcahier.getString("Email_Address");
				Boolean Status = resultcahier.getBoolean("Status");
				String Img = resultcahier.getString("Image");
				String status;

				if(Status == true) {
					status = "Active";

				}else {
					status = "Not Active";
				}

				table.addRow(new Object[]{ID , Img, cahierName, "Cashier", status, null, null}) ;
				
				
				continue;
			}
			removeCurrent(currentUser);
			actions();
			userActiveStatus();
			AddressContactDetails();
			
			table.getColumn("Name").setPreferredWidth(140);
			
			table.getColumn("Status").setPreferredWidth(120);
			table.getColumn("Image").setCellRenderer(new tableCellRenderer());
			table.setSelectionBackground(Color.WHITE);
			table.getColumn("Status").setCellRenderer(new StatusBtnCellRenderer());
			table.getColumn("Status").setCellEditor(new StatusBtnTableActionCellEditor(eventStatus));
			table.setRowHeight(70);
			table.getColumn("Actions").setCellRenderer(new ActionsBtnCellRenderer());
			table.getColumn("Actions").setCellEditor(new ActionsBtnTableActionCellEditor(eventActions));
			table.getColumn("More Info").setCellRenderer(new AddressContactBtnCellRenderer());
			table.getColumn("More Info").setCellEditor(new AddressContactBtnTableActionCellEditor(AddCon));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void userActiveStatus() {

		eventStatus = new statusEvent() {
			@Override
			public void availability(int row) {

				value = table.getValueAt(row, 0).toString();
				String valueAv = table.getValueAt(row, 4).toString();

				if(valueAv.toString().equals("Active")) {
					setUserActiveStatus(false);
				}else if(valueAv.toString().equals("Not Active")) {
					setUserActiveStatus(true);
				}	
				displayDataUsers();
			}

		};

	}
	
	
	public void actions() {

		eventActions = new actionEvent() {

			@Override
			public void onEdit(int row) {
				if(table.getValueAt(row, 3).toString().equals("Admin")){
					setEnableRec(panel,false);
					postoDelete = "Edit";
					message_DialogBox.setText("Can't edit information of another Admin");
					rndbtnOkay.setBounds(45, 137, 315, 32);
					messageDialogBox.setVisible(true);
					
					
				}else if(table.getValueAt(row, 3).toString().equals("Cashier")) {
					backNum = 1;
					Position = "Cashier";
					getAdressAndContact(row);
					scrollPaneTableM.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
					Image imag = new ImageIcon(this.getClass().getResource("/img/noImage.png")).getImage().getScaledInstance(194, 194, Image.SCALE_SMOOTH);;
					panel_Add_UpdateUser.setVisible(true);
					setEnableRec(panel,false);
					value = table.getValueAt(row, 0).toString();
					
					valueName = table.getValueAt(row, 2);
					
					String imageEx = table.getValueAt(row, 1).toString();
					File f = new File(imageEx);
						if(imageEx.equals("no image") || !f.exists()) {
							imag = new ImageIcon(this.getClass().getResource("/img/noImage.png")).getImage().getScaledInstance(194, 194, Image.SCALE_SMOOTH);
						}else {
							imag = new ImageIcon(imageEx).getImage().getScaledInstance(194, 194, Image.SCALE_SMOOTH);
						}
						
					image = imageEx;
					productImage.setIcon(new ImageIcon(imag));
					textField_Name.setText(table.getValueAt(row, 2).toString());
					textField_Address.setText(Details.get(0).toString());
					textField_EmailAddress.setText(Details.get(1).toString());
					textField_ContactNumber.setText(Details.get(2).toString());
					textField_Username.setText(Details.get(3).toString());
					textField_Password.setText(Details.get(4).toString());
					
					addORupdate = "update";
					exemptedID = value.toString();
					exemptedTableName = valueName.toString();
					Details.clear();
				}
				

			}

			@Override
			public void onDelete(int row) {
				value = table.getValueAt(row, 0).toString();
				String pos = table.getValueAt(row, 3).toString();
				backNum = 3;
				if(table.getValueAt(row, 3).toString().equals(currentUser)) {
					setEnableRec(panel,false);
					postoDelete = "Own";
					message_DialogBox.setText("Do you want to delete your own Account?");
					messageDialogBox.setVisible(true);
				}else if(pos.equals("Admin")) {
					setEnableRec(panel,false);
					postoDelete = "Admin";
					message_DialogBox.setText("Do you want to delete the Admin account of " + table.getValueAt(row, 2).toString() + "?");
					messageDialogBox.setVisible(true);
				}else if(pos.equals("Cashier")) {
					setEnableRec(panel,false);
					postoDelete = "Cashier";
					message_DialogBox.setText("Do you want to delete the Cashier account of " + table.getValueAt(row, 2).toString() + "?");
					messageDialogBox.setVisible(true);
				}

			}

		};

	}
	private void deleteAdmin() {
		row = table.getSelectedRow();
		value = table.getValueAt(row, 0).toString();
		try {
			Connection con = DriverManager.getConnection("jdbc:ucanaccess://D:/DatabaseRMS.accdb");
			PreparedStatement pstadmin = con.prepareStatement("delete from Admin_Account where ID = ?");
			
			pstadmin.setString(1, value.toString());
			pstadmin.executeUpdate();
			
			displayDataUsers();
			setEnableRec(panel,true);
			messageDialogBox.setVisible(false);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}
	private void deleteCashier() {
		row = table.getSelectedRow();
		value = table.getValueAt(row, 0).toString();
		try {
			Connection con = DriverManager.getConnection("jdbc:ucanaccess://D:/DatabaseRMS.accdb");
			PreparedStatement pstadmin = con.prepareStatement("delete from Cashier_Account where ID = ?");
			
			pstadmin.setString(1, value.toString());
			pstadmin.executeUpdate();
			
			displayDataUsers();
			setEnableRec(panel,true);
			messageDialogBox.setVisible(false);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	public void AddressContactDetails() {

		AddCon = new statusEvent() {

			@Override
			public void availability(int row) {
				backNum = 2;
				getAdressAndContact(row);
				lblUserName.setText(table.getValueAt(row, 2).toString());
				lblPos.setText(table.getValueAt(row, 3).toString());
				lblAddress.setText(Details.get(0).toString());
				lblemail.setText(Details.get(1).toString());
				lblContactNum.setText(Details.get(2).toString());
				scrollPaneTableM.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
				AddressContactDetails.setVisible(true);
				setEnableRec(panel,false);
				Details.clear();	
			}

		};

	}
	public void getAdressAndContact(int row) {
		String id = table.getValueAt(row, 0).toString();
		String pos = table.getValueAt(row, 3).toString();
		
		if(pos.equals("Admin")) {
			try {
				Connection con = DriverManager.getConnection( "jdbc:ucanaccess://D:/DatabaseRMS.accdb");
				Statement statement = con.createStatement();
				ResultSet result = statement.executeQuery("select * from Admin_Account");

				while(result.next()) {
					String ID = result.getString("ID");
					String email = result.getString("Admin_Email_Address");
					String Address = result.getString("Address");
					String ContactNum = result.getString("Admin_Contact_Number");
					String Username = result.getString("Username");
					String Password = result.getString("Password");
					
					if(ID.equals(id)) {
						Collections.addAll(Details,Address ,email , ContactNum, Username, Password);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(pos.equals("Cashier")) {
			try {
				Connection con = DriverManager.getConnection( "jdbc:ucanaccess://D:/DatabaseRMS.accdb");
				Statement statement = con.createStatement();
				ResultSet result = statement.executeQuery("select * from Cashier_Account");

				while(result.next()) {
					String ID = result.getString("ID");
					String ContactNum = result.getString("Contact_number");
					String Address = result.getString("Address");
					String email = result.getString("Email_Address");
					String Username = result.getString("Username");
					String Password = result.getString("Password");
					
					if(ID.equals(id)) {
						Collections.addAll(Details,Address ,email , ContactNum, Username, Password);
					}
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
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
	public String generateId() {
		Random random = new Random();
		int first = random.nextInt(999);
		int second = random.nextInt(999);
		int third = random.nextInt(999);
		return first + "-" + second + "-" + third;
	 }
	public void reset() {
		Image background = new ImageIcon(this.getClass().getResource("/img/noImage.png")).getImage().getScaledInstance(194, 194, Image.SCALE_SMOOTH);
		productImage.setIcon(new ImageIcon(background));
		textField_Name.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		textField_Name.setText(null);
		lblmessage_Name.setText(null);
		lblmessage_Address.setText(null);
	}
}

