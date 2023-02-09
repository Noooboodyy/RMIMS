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

import com.healthmarketscience.jackcess.Table;

import fileChooser.JnaFileChooser;
import modifiedComponents.GradientColorPanel;
import modifiedComponents.RoundButton;
import restaurantManagementSystem.ProductManagement.ActionsBtnCellRenderer;
import restaurantManagementSystem.ProductManagement.StatusBtnCellRenderer;
import restaurantManagementSystem.ProductManagement.tableCellRenderer;


import java.awt.SystemColor;
import javax.swing.border.LineBorder;

public class CashierFrame extends JFrame {

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
	private RoundedPanel btn_Order;
	private RoundedPanel btn_EditAcc;
	private JLabel lblPersonalInformation;
	private String RestaurantID;
	private JLabel lblResName;
	private RoundedPanel ComboBox;
	private JLabel message_DialogBox;
	private JLabel iconStore;
	private JLabel iconeditAcc;
	private JLabel iconSignOut;
	
	public void change_btnColors() {
		
	}
	public CashierFrame() {
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
		Image noImage = new ImageIcon(this.getClass().getResource("/img/noImage.png")).getImage().getScaledInstance(194, 194, Image.SCALE_SMOOTH);
		
		EditAcc = new JPanel();
		EditAcc.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(129, 129, 129)));
		EditAcc.setBackground(new Color(255, 255, 255));
		EditAcc.setBounds(262, 43, 504, 681);
		EditAcc.setVisible(false);
		
		ComboBox = new RoundedPanel(20);
		ComboBox.setBackground(new Color(255, 255, 255));
		ComboBox.setBounds(315, 200, 410, 191);
		ComboBox.setOpaque(false);
		ComboBox.setVisible(false);
		contentPane.add(ComboBox);
		ComboBox.setLayout(null);
		
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
		
		message_DialogBox = new JLabel();
		message_DialogBox.setText("select a product");
		message_DialogBox.setHorizontalAlignment(SwingConstants.CENTER);
		message_DialogBox.setFont(new Font("SansSerif", Font.PLAIN, 12));
		message_DialogBox.setBounds(10, 97, 390, 29);
		
		ComboBox.add(message_DialogBox);

		Image Alerticon = new ImageIcon(this.getClass().getResource("/img/checks.png")).getImage();
		JLabel AlertIcon = new JLabel("");
		AlertIcon.setIcon(new ImageIcon(Alerticon));
		AlertIcon.setHorizontalAlignment(SwingConstants.CENTER);
		AlertIcon.setBounds(10, 22, 390, 64);
		ComboBox.add(AlertIcon);
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
		btnFinish.setBounds(21, 594, 455, 42);
		EditAcc.add(btnFinish);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new btnBack());
		btnBack.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnBack.setFocusable(false);
		btnBack.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(21, 647, 458, 23);
		EditAcc.add(btnBack);
		
		lblPersonalInformation = new JLabel("Personal Information");
		lblPersonalInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonalInformation.setForeground(SystemColor.controlDkShadow);
		lblPersonalInformation.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblPersonalInformation.setBounds(10, 11, 481, 23);
		EditAcc.add(lblPersonalInformation);
		
		JPanel panel = new JPanel();
		panel.setBounds(15, 91, 180, 1);
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panelMenu);
		
		panelMenu.setLayout(null);
		panelMenu.add(panel);
		panelMenu.add(btn_dashboard);
		
		btn_Order = new RoundedPanel(10);
		btn_Order.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				disableEditAcc();
				order.getCategories();
				order.displayProducts();
				closeComboBox();
				changeColor(btn_Order, btn_dashboard, btn_EditAcc);
				disableOtherPanels(order, dashboard);
			}
		});
		btn_Order.setLayout(null);
		btn_Order.setOpaque(false);
		btn_Order.setForeground(new Color(11, 31, 55));
		btn_Order.setBorder(null);
		btn_Order.setBackground(new Color(11, 31, 55));
		btn_Order.setBounds(9, 149, 186, 45);
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
		btn_signOut.setBounds(8, 238, 186, 45);
		panelMenu.add(btn_signOut);
		
		JLabel lbl_Signout = new JLabel("Sign out");
		lbl_Signout.setForeground(Color.WHITE);
		lbl_Signout.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lbl_Signout.setBounds(10, 7, 83, 34);
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
				changeColor(btn_EditAcc, btn_Order, btn_dashboard);
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
		btn_EditAcc.setBounds(8, 194, 186, 45);
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
		
		order = new Order();
		panel_Windows.add(order);
		
		disableOtherPanels(dashboard, order);
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
		
		
		JLabel iconOrder = new JLabel();
		iconOrder.setHorizontalAlignment(SwingConstants.RIGHT);
		Image imag6 = new ImageIcon(this.getClass().getResource("/img/order.png")).getImage().getScaledInstance(27, 27, Image.SCALE_SMOOTH);
		iconOrder.setIcon(new ImageIcon(imag6));
		iconOrder.setBounds(13, 149, 31, 45);
		panelBar_1.add(iconOrder);
		
		iconeditAcc = new JLabel();
		Image imag7 = new ImageIcon(this.getClass().getResource("/img/EditAcc.png")).getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH);
		iconeditAcc.setHorizontalAlignment(SwingConstants.RIGHT);
		iconeditAcc.setIcon(new ImageIcon(imag7));
		iconeditAcc.setBounds(13, 197, 31, 45);
		panelBar_1.add(iconeditAcc);
		
		iconSignOut = new JLabel();
		Image imag8 = new ImageIcon(this.getClass().getResource("/img/logout.png")).getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
		iconSignOut.setHorizontalAlignment(SwingConstants.RIGHT);
		iconSignOut.setIcon(new ImageIcon(imag8));
		iconSignOut.setBounds(13, 243, 31, 45);
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
	public void getArrayData(ArrayList list) {
		try {
			Connection con = DriverManager.getConnection( "jdbc:ucanaccess://D:/DatabaseRMS.accdb");
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery("select * from Cashier_Account");

			while(result.next()) {
				String name = result.getString("Name");
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
			ResultSet result = statement.executeQuery("select * from Cashier_Account");
			
			while(result.next()) {
				String name = result.getString("Name");
				
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
			closeComboBox();
			disableEditAcc();
			changeColor(btn_dashboard, btn_Order, btn_EditAcc);
			disableOtherPanels(dashboard, order);
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
				|| textField_Username.getText().isBlank() || textField_Password.getText().isBlank()) {
				message.InputRequiredMessage(textField_Name, lblmessage_Name);
				message.InputRequiredMessage(textField_EmailAddress, lblmessage_EmailAddress);
				message.InputRequiredMessage(textField_ContactNumber, lblmessage_ContactNumber);
				message.InputRequiredMessage(textField_Address, lblmessage_Address);
				message.InputRequiredMessage(textField_Username, lblmessage_Username);
				message.InputRequiredMessage(textField_Password, lblmessage_Password);
					
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
					pst.setString(8, getcurrentID());
					pst.executeUpdate();
					
					setData(new Model_CurrentUser(image, "CASHIER", Name));
					setDataProfile(Name,"CASHIER", image);
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
	private void dashboard() {
		dashboard.cardsData();
		closeComboBox();
		disableEditAcc();
		changeColor(btn_dashboard, btn_Order, btn_EditAcc);
		disableOtherPanels(dashboard, order);
	}
	private void getDataTOEdit() {
		try {
			Connection con = DriverManager.getConnection( "jdbc:ucanaccess://D:/DatabaseRMS.accdb");
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery("select * from Cashier_Account");
			ResultSet resultRes = statement.executeQuery("select * from Restaurant_Details");
			
			Image imag = new ImageIcon(this.getClass().getResource("/img/noImage.png")).getImage().getScaledInstance(194, 194, Image.SCALE_SMOOTH);;
			
			while(result.next()) {
				String img = result.getString("Image");
				String name = result.getString("Name");
				String Address = result.getString("Address");
				String Email = result.getString("Email_Address");
				String ContactNum = result.getString("Contact_Number");
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
				
				lblResName.setText(name);
				
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
		getCurrentuser(userName.getText());
		
    }
	
	private void disableOtherPanels(JPanel enable, JPanel disable1) {
		enable.setVisible(true);
		disable1.setVisible(false);
	}
	private void changeColor(JPanel enable, JPanel disable1, JPanel disable2) {
		enable.setBackground(new Color(66, 50, 95));;
		disable1.setBackground(new Color(11, 31, 55));
		disable2.setBackground(new Color(11, 31, 55));
	}
	private void disableEditAcc() {
		EditAcc.setVisible(false);
		setEnableRec(panel_Windows, true);
	}
	private void closeComboBox() {
		ComboBox.setVisible(false);
		setEnableRec(panel_Windows,true);
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
