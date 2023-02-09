package restaurantManagementSystem;

import javax.swing.JPanel;
import javax.swing.UIManager;

import java.awt.*;
import java.awt.SystemColor;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import modifiedComponents.ComboBox;
import modifiedComponents.RoundButton;
import restaurantManagementSystem.SystemUsers.AddressContactBtnCellRenderer;
import restaurantManagementSystem.SystemUsers.StatusBtnCellRenderer;
import restaurantManagementSystem.SystemUsers.tableCellRenderer;

import javax.swing.SwingConstants;
import javax.swing.ScrollPaneConstants;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class Order extends JPanel {

	
	JScrollPane scrollPane;
	JPanel panel;
	private JLabel productName;
	private ComboBox comboBox_Category;
	private JPanel panel_orderDetail;
	private JPanel panel_Products;
	private product product;
	private JScrollPane scrollPaneOrderDetails;
	private Table table;
	private String orderDetails;
	private ArrayList <String[]> split = new ArrayList();
	ArrayList tableData = new ArrayList();
	ArrayList pricePro = new ArrayList();
	ArrayList name = new ArrayList();
	JLabel Total;
	private JTextField textField_PaymentAmount;
	private JTextField textField_DiscountAmount;
	private JPanel Payment;
	private RoundButton btn_Pay;
	private JLabel Change;
	private JLabel netAmount;
	private boolean paying;
	private JLabel lblmessage_Payment;
	private RoundedPanel messageDialogBox;
	private JLabel message_DialogBox;
	private String idfinal;
	private JLabel AlertIcon;
	private JPanel Reciept;
	private JScrollPane scrollPaneOrderDetailsReciepts;
	private Table tableReciept;
	private JLabel lblChangeRecieptVAL;
	private JLabel lblNewTotalRecieptVAL;
	private JLabel lblPaymentAmountVAL;
	private JLabel lblNewDiscountRecieptVAL;
	private String resName;
	private String resAddress;
	private JLabel lblResNameReciept;
	private JLabel lblResAddReciept;
	
	
	public Order() {
		
		setBackground(UIManager.getColor("CheckBox.background"));
		setBounds(0, 0, 944, 681);
		setLayout(null);
		
		Payment = new JPanel();
		Payment.setForeground(new Color(107, 107, 107));
		Payment.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(134, 134, 134)));
		Payment.setVisible(false);
		
		messageDialogBox = new RoundedPanel(20);
		messageDialogBox.setOpaque(false);
		messageDialogBox.setForeground(new Color(120, 120, 120));
		messageDialogBox.setBackground(new Color(255, 255, 255));
		messageDialogBox.setBounds(256, 189, 410, 191);
		messageDialogBox.setVisible(false);
		
		Reciept = new JPanel();
		Reciept.setBackground(new Color(255, 255, 255));
		Reciept.setBounds(609, 0, 335, 681);
		Reciept.setVisible(false);
		add(Reciept);
		Reciept.setLayout(null);
		
		
		add(messageDialogBox);
		
		messageDialogBox.setLayout(null);
		
		message_DialogBox = new JLabel();
		message_DialogBox.setText("select a product");
		message_DialogBox.setHorizontalAlignment(SwingConstants.CENTER);
		message_DialogBox.setFont(new Font("SansSerif", Font.PLAIN, 12));
		message_DialogBox.setBounds(10, 88, 390, 29);
		messageDialogBox.add(message_DialogBox);
		
		RoundButton rndbtnOk = new RoundButton("Finish", 40);
		rndbtnOk.addActionListener(new btnOkay());
		rndbtnOk.setText("Ok");
		rndbtnOk.setForeground(Color.WHITE);
		rndbtnOk.setFont(new Font("SansSerif", Font.PLAIN, 12));
		rndbtnOk.setFocusable(false);
		rndbtnOk.setBackground(new Color(11, 31, 55));
		rndbtnOk.setBounds(87, 128, 236, 32);
		messageDialogBox.add(rndbtnOk);
		
		
		Image alert = new ImageIcon(this.getClass().getResource("/img/alert.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		AlertIcon = new JLabel("");
		AlertIcon.setHorizontalAlignment(SwingConstants.CENTER);
		AlertIcon.setIcon(new ImageIcon(alert));
		AlertIcon.setBounds(10, 13, 390, 64);
		messageDialogBox.add(AlertIcon);
		Payment.setBackground(new Color(255, 255, 255));
		Payment.setBounds(609, 355, 335, 321);
		add(Payment);
		Payment.setLayout(null);
		
		textField_PaymentAmount = new JTextField();
		textField_PaymentAmount.getDocument().addDocumentListener(new inputChanged());;
		textField_PaymentAmount.setFont(new Font("SansSerif", Font.PLAIN, 12));
		textField_PaymentAmount.setColumns(10);
		textField_PaymentAmount.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		textField_PaymentAmount.setBackground(Color.WHITE);
		textField_PaymentAmount.setBounds(10, 34, 315, 42);
		Payment.add(textField_PaymentAmount);
		
		JLabel lblPaidAmount = new JLabel("Payment Amount");
		lblPaidAmount.setHorizontalAlignment(SwingConstants.LEFT);
		lblPaidAmount.setForeground(SystemColor.controlDkShadow);
		lblPaidAmount.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblPaidAmount.setBounds(10, 12, 227, 14);
		Payment.add(lblPaidAmount);
		
		textField_DiscountAmount = new JTextField();
		textField_DiscountAmount.getDocument().addDocumentListener(new inputChanged());;
		textField_DiscountAmount.setFont(new Font("SansSerif", Font.PLAIN, 12));
		textField_DiscountAmount.setColumns(10);
		textField_DiscountAmount.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		textField_DiscountAmount.setBackground(Color.WHITE);
		textField_DiscountAmount.setBounds(10, 114, 315, 42);
		Payment.add(textField_DiscountAmount);
		
		JLabel lblDiscountAmount = new JLabel("Discount Amount");
		lblDiscountAmount.setHorizontalAlignment(SwingConstants.LEFT);
		lblDiscountAmount.setForeground(SystemColor.controlDkShadow);
		lblDiscountAmount.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblDiscountAmount.setBounds(10, 92, 227, 14);
		Payment.add(lblDiscountAmount);
		
		JLabel lblNetAmount = new JLabel("Net amount :");
		lblNetAmount.setForeground(new Color(105, 105, 105));
		lblNetAmount.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNetAmount.setBounds(10, 172, 102, 23);
		Payment.add(lblNetAmount);
		
		JLabel lblChange = new JLabel("Change :");
		lblChange.setForeground(SystemColor.controlDkShadow);
		lblChange.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblChange.setBounds(10, 206, 102, 23);
		Payment.add(lblChange);
		
		Change = new JLabel("₱ 0.0");
		Change.setHorizontalAlignment(SwingConstants.RIGHT);
		Change.setForeground(new Color(93, 93, 93));
		Change.setFont(new Font("SansSerif", Font.BOLD, 12));
		Change.setBounds(218, 206, 102, 23);
		Payment.add(Change);
		
		netAmount = new JLabel("₱ 0.0");
		netAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		netAmount.setForeground(new Color(93, 93, 93));
		netAmount.setFont(new Font("SansSerif", Font.BOLD, 12));
		netAmount.setBounds(218, 172, 102, 23);
		Payment.add(netAmount);
		
		RoundButton btnFinish = new RoundButton("Finish", 40);
		btnFinish.addActionListener(new btnFinish());
		btnFinish.setForeground(Color.WHITE);
		btnFinish.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnFinish.setFocusable(false);
		btnFinish.setBackground(new Color(11, 31, 55));
		btnFinish.setBounds(10, 240, 315, 42);
		Payment.add(btnFinish);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new btnBack());
		btnBack.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnBack.setFocusable(false);
		btnBack.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(10, 289, 315, 23);
		Payment.add(btnBack);
		
		lblmessage_Payment = new JLabel("");
		lblmessage_Payment.setHorizontalAlignment(SwingConstants.LEFT);
		lblmessage_Payment.setForeground(new Color(220, 20, 60));
		lblmessage_Payment.setFont(new Font("Arial", Font.PLAIN, 10));
		lblmessage_Payment.setBounds(10, 76, 194, 14);
		Payment.add(lblmessage_Payment);
		
		panel_Products = new JPanel();
		panel_Products.setForeground(new Color(255, 255, 255));
		panel_Products.setBackground(new Color(255, 255, 255));
		panel_Products.setBounds(0, 0, 605, 681);
		add(panel_Products);
		panel_Products.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 57, 601, 624);
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setVerticalScrollBar(new ScrollBar());
		scrollPane.getVerticalScrollBar().setBackground(Color.WHITE);
		scrollPane.getViewport().setBackground(Color.WHITE);
	    JPanel p = new JPanel();
	    p.setBackground(Color.WHITE);
	    scrollPane.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
		panel_Products.add(scrollPane);
		
		
		panel_orderDetail = new JPanel();
		panel_orderDetail.setForeground(Color.WHITE);
		panel_orderDetail.setBackground(Color.WHITE);
		panel_orderDetail.setBounds(609, 0, 335, 681);
		add(panel_orderDetail);
		panel_orderDetail.setLayout(null);
		
		JLabel lblTable_1 = new JLabel("Table");
		lblTable_1.setBounds(502, 11, 99, 19);
		lblTable_1.setForeground(new Color(69, 69, 69));
		lblTable_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		panel_orderDetail.add(lblTable_1);
		
		btn_Pay = new RoundButton("New button", 0);
		btn_Pay.addActionListener(new btnPay());
		btn_Pay.setText("Payment");
		btn_Pay.setForeground(Color.WHITE);
		btn_Pay.setFont(new Font("SansSerif", Font.BOLD, 15));
		btn_Pay.setFocusable(false);
		btn_Pay.setBackground(new Color(35, 151, 15));
		btn_Pay.setBounds(10, 605, 315, 65);
		panel_orderDetail.add(btn_Pay);
		scrollPaneOrderDetails = new JScrollPane();
		scrollPaneOrderDetails.setBounds(10, 59, 315, 501);
		scrollPaneOrderDetails.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		panel_orderDetail.add(scrollPaneOrderDetails);
		
		table = new Table();
		table.setShowHorizontalLines(false);
		table.fixTable(scrollPaneOrderDetails);
		table.setShowVerticalLines(false);
		table.setSelectionBackground(Color.WHITE);
		table.setFont(new Font("SansSerif", Font.PLAIN, 12));
		scrollPaneOrderDetails.setViewportView(table);
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Product", "Quantity", "Price"
				}
				)
		{
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setForeground(new Color(81, 81, 81));
		lblTotal.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblTotal.setBounds(33, 571, 62, 23);
		panel_orderDetail.add(lblTotal);
		
		Total = new JLabel("₱ 0.0");
		Total.setHorizontalAlignment(SwingConstants.RIGHT);
		Total.setForeground(new Color(81, 81, 81));
		Total.setFont(new Font("SansSerif", Font.BOLD, 15));
		Total.setBounds(80, 571, 221, 23);
		panel_orderDetail.add(Total);
		
		RoundButton btn_add = new RoundButton("New button", 0);
		btn_add.addActionListener(new btnAdd());
		btn_add.setText("");
		btn_add.setIcon(new ImageIcon(this.getClass().getResource("/img/add2.png")));
		btn_add.setForeground(Color.WHITE);
		btn_add.setFont(new Font("SansSerif", Font.BOLD, 15));
		btn_add.setFocusable(false);
		btn_add.setBackground(new Color(0, 204, 102));
		btn_add.setBounds(10, 11, 90, 45);
		panel_orderDetail.add(btn_add);
		
		RoundButton btn_minus = new RoundButton("New button", 0);
		btn_minus.addActionListener(new btnMinus());
		btn_minus.setIcon(new ImageIcon(this.getClass().getResource("/img/minus.png")));
		btn_minus.setText("");
		btn_minus.setForeground(Color.WHITE);
		btn_minus.setFont(new Font("SansSerif", Font.BOLD, 15));
		btn_minus.setFocusable(false);
		btn_minus.setBackground(new Color(176, 45, 45));
		btn_minus.setBounds(103, 11, 90, 45);
		panel_orderDetail.add(btn_minus);
		
		RoundButton btn_Remove = new RoundButton("New button", 0);
		btn_Remove.addActionListener(new btnRemoveItem());
		btn_Remove.setText("Remove ");
		btn_Remove.setForeground(Color.WHITE);
		btn_Remove.setFont(new Font("SansSerif", Font.BOLD, 12));
		btn_Remove.setFocusable(false);
		btn_Remove.setBackground(new Color(123, 32, 32));
		btn_Remove.setBounds(196, 11, 129, 45);
		panel_orderDetail.add(btn_Remove);
		table.getColumn("Product").setPreferredWidth(100);
		table.getColumn("Quantity").setPreferredWidth(50);
		
		comboBox_Category = new ComboBox();
		comboBox_Category.setForeground(new Color(107, 107, 107));
		comboBox_Category.setOpaque(true);
		comboBox_Category.setMaximumRowCount(100);
		comboBox_Category.setFont(new Font("SansSerif", Font.PLAIN, 15));
		comboBox_Category.setFocusable(false);
		comboBox_Category.setEditable(false);
		comboBox_Category.setBorder(null);
		comboBox_Category.setBackground(new Color(245, 245, 245));
		comboBox_Category.setBounds(5, 11, 595, 47);
		comboBox_Category.addActionListener(new selectCategory());
		panel_Products.add(comboBox_Category);
		
		scrollPaneOrderDetails = new JScrollPane();
		scrollPaneOrderDetails.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPaneOrderDetails.setBounds(10, 147, 315, 343);
		Reciept.add(scrollPaneOrderDetails);
		
		tableReciept = new Table();
		tableReciept.fixTable(scrollPaneOrderDetails);
		
		RoundButton rndbtnClose = new RoundButton("Finish", 40);
		rndbtnClose.addActionListener(new btnOkay());
		rndbtnClose.setText("Close");
		rndbtnClose.setForeground(Color.WHITE);
		rndbtnClose.setFont(new Font("SansSerif", Font.PLAIN, 12));
		rndbtnClose.setFocusable(false);
		rndbtnClose.setBackground(new Color(11, 31, 55));
		rndbtnClose.setBounds(55, 638, 236, 32);
		Reciept.add(rndbtnClose);
		
		lblResNameReciept = new JLabel("Restaurant name");
		lblResNameReciept.setForeground(new Color(108, 108, 108));
		lblResNameReciept.setHorizontalAlignment(SwingConstants.CENTER);
		lblResNameReciept.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblResNameReciept.setBounds(10, 11, 315, 32);
		Reciept.add(lblResNameReciept);
		
		lblResAddReciept = new JLabel("Address");
		lblResAddReciept.setForeground(new Color(108, 108, 108));
		lblResAddReciept.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblResAddReciept.setHorizontalAlignment(SwingConstants.CENTER);
		lblResAddReciept.setBounds(10, 38, 315, 19);
		Reciept.add(lblResAddReciept);
		
		JLabel lblNewLabel_1_1 = new JLabel("Reciept");
		lblNewLabel_1_1.setForeground(new Color(108, 108, 108));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(10, 95, 315, 32);
		Reciept.add(lblNewLabel_1_1);
		
		JLabel lblNewTotalReciept = new JLabel("Total: ");
		lblNewTotalReciept.setForeground(new Color(108, 108, 108));
		lblNewTotalReciept.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewTotalReciept.setBounds(21, 551, 78, 14);
		Reciept.add(lblNewTotalReciept);
		
		JLabel lblPaymentAmount = new JLabel("Payment Amount: ");
		lblPaymentAmount.setForeground(new Color(108, 108, 108));
		lblPaymentAmount.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblPaymentAmount.setBounds(20, 507, 130, 14);
		Reciept.add(lblPaymentAmount);
		
		JLabel lblChangeReciept = new JLabel("Change:");
		lblChangeReciept.setForeground(new Color(108, 108, 108));
		lblChangeReciept.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblChangeReciept.setBounds(21, 571, 78, 19);
		Reciept.add(lblChangeReciept);
		
		lblChangeRecieptVAL = new JLabel("00");
		lblChangeRecieptVAL.setForeground(new Color(108, 108, 108));
		lblChangeRecieptVAL.setHorizontalAlignment(SwingConstants.RIGHT);
		lblChangeRecieptVAL.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblChangeRecieptVAL.setBounds(185, 571, 129, 19);
		Reciept.add(lblChangeRecieptVAL);
		
		lblNewTotalRecieptVAL = new JLabel("00");
		lblNewTotalRecieptVAL.setForeground(new Color(108, 108, 108));
		lblNewTotalRecieptVAL.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewTotalRecieptVAL.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNewTotalRecieptVAL.setBounds(185, 551, 129, 14);
		Reciept.add(lblNewTotalRecieptVAL);
		
		lblPaymentAmountVAL = new JLabel("00");
		lblPaymentAmountVAL.setForeground(new Color(108, 108, 108));
		lblPaymentAmountVAL.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPaymentAmountVAL.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblPaymentAmountVAL.setBounds(184, 507, 130, 14);
		Reciept.add(lblPaymentAmountVAL);
		
		JLabel lblDiscount = new JLabel("Discount: ");
		lblDiscount.setForeground(new Color(108, 108, 108));
		lblDiscount.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblDiscount.setBounds(21, 529, 78, 14);
		Reciept.add(lblDiscount);
		
		lblNewDiscountRecieptVAL = new JLabel("00");
		lblNewDiscountRecieptVAL.setForeground(new Color(108, 108, 108));
		lblNewDiscountRecieptVAL.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewDiscountRecieptVAL.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNewDiscountRecieptVAL.setBounds(185, 529, 129, 14);
		Reciept.add(lblNewDiscountRecieptVAL);
		
		JPanel line1 = new JPanel();
		line1.setBackground(new Color(108, 108, 108));
		line1.setBounds(10, 83, 315, 2);
		Reciept.add(line1);
		
		JPanel line1_1 = new JPanel();
		line1_1.setBackground(new Color(108, 108, 108));
		line1_1.setBounds(10, 135, 315, 2);
		Reciept.add(line1_1);
		
		JPanel line1_1_1 = new JPanel();
		line1_1_1.setBackground(new Color(108, 108, 108));
		line1_1_1.setBounds(10, 496, 315, 2);
		Reciept.add(line1_1_1);
		
	}
	
	public void orderDetails() {
		
			split.add(orderDetails.split("-"));
			String [] Split = split.get(0);
			String product = Split[0];
			String price = Split[1];
			
			if(tableData.contains(product)) {
				 int row = -1;
				    for(int i=0; i<table.getRowCount(); i++){
				       if(table.getValueAt(i,0).equals(product)){
				           row = i;
				           break;
				       }
				    }
				table.setValueAt((Integer.valueOf(table.getValueAt(row, 1).toString()) + 1), row, 1);
				table.setValueAt("₱ " + (Double.valueOf(table.getValueAt(row, 2).toString().replaceAll("\\p{Sc}", "").stripLeading())+ Double.valueOf(price) ), row, 2);
			}else {
				table.addRow(new Object[]{product, 1, "₱ " + price});
			}
			
			split.clear();
			tableData.clear();
		
	}
	public void displayProducts() {
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		scrollPane.setViewportView(panel);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 6, 8));
		
		Connection con;
		 try {
				con = DriverManager.getConnection( "jdbc:ucanaccess://D:/DatabaseRMS.accdb");
				Statement statement = con.createStatement();
				ResultSet result = statement.executeQuery("select * from Products_Record");
				
				while(result.next()) {

					String category = result.getString("Category");
					name.add(result.getString("Product_Name"));
			        pricePro.add(result.getDouble("Price"));
					if(category.equals(comboBox_Category.getSelectedItem())) {
						scrollPane.setVisible(true);
						getProducts(result);
					}else if(comboBox_Category.getSelectedItem() == "All"){
						getProducts(result);
						scrollPane.setVisible(true);
					}
					continue;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }
	public void getData() {
		for (int i = 0; i < table.getRowCount(); i++) {
			tableData.add(table.getValueAt(i, 0));
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
	public Double getTotal() {
		Double total = 0.0;
		for (int i = 0; i < table.getRowCount(); i++) {
			total += Double.valueOf(table.getValueAt(i, 2).toString().replaceAll("\\p{Sc}", "").stripLeading());
		}
		return total;
	}
	
	public double getNetAmount() {
		double netAmount = getTotal();
		try {
		if(!textField_DiscountAmount.getText().isEmpty()) {
			if(Double.valueOf(textField_DiscountAmount.getText()) >= getTotal()) {
				netAmount = 0;
			}else {
				netAmount = (getTotal() - Double.valueOf(textField_DiscountAmount.getText()));
			}	
		}
		}catch(Exception ex) {}
		
		return netAmount;
	}
	public double getChange() {
		double change = 0;
		try {
		if(getNetAmount() < Double.valueOf(textField_PaymentAmount.getText())) {
			change = (Double.valueOf(textField_PaymentAmount.getText()) - getNetAmount());
		}
		}catch(Exception ex) {}
		return change;
	}
	private void reciept() {
		
		tableReciept.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Product", "Quantity", "Amount"
			}
		));
		getRestaurantData();
		lblResAddReciept.setText(resAddress);
		lblResNameReciept.setText(resName);
		tableReciept.setShowVerticalLines(false);
		tableReciept.setShowHorizontalLines(false);
		tableReciept.setSelectionBackground(Color.WHITE);
		tableReciept.setFont(new Font("SansSerif", Font.PLAIN, 12));
		scrollPaneOrderDetails.setViewportView(tableReciept);
	}
	private void getRestaurantData() {
		Connection con;
		String name = null;
		String address = null;
		try {
			con = DriverManager.getConnection( "jdbc:ucanaccess://D:/DatabaseRMS.accdb");
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery("select * from Restaurant_Details");
			
			while(result.next()) {
				 name = result.getString("Restaurant_Name");
				 address= result.getString("Restaurant_address");
			}
			resName = name;
			resAddress = address;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void getProducts(ResultSet result) throws SQLException {
		Boolean Status = result.getBoolean("Status");
		if(Status == true) {
			productName = new JLabel(result.getString("Product_Name"));
			productName.setFont(new Font("SansSerif", Font.PLAIN, 15));
			double price = result.getDouble("Price");
            String image = result.getString("Image");
            String id = result.getString("ID");
           
            Image img;
			product = new product(10);
			product.setName(productName.getText() + "-" + price);
			product.setOpaque(false);
			product.setPreferredSize(new Dimension(142, 194));
			
			File f = new File(image);
			if(image.equals("no image") || !f.exists()) {
				img = new ImageIcon(this.getClass().getResource("/img/noImage.png")).getImage().getScaledInstance(142, 142, Image.SCALE_SMOOTH);
			}else {
				img = new ImageIcon(image).getImage().getScaledInstance(142, 142, Image.SCALE_SMOOTH);
			}
				
			product.setData(new Model_Product(new ImageIcon(img), productName.getText(), "₱ " + String.valueOf(price)));
			
            panel.add(product);
            panel.revalidate();
            panel.repaint();
            
            panel.setPreferredSize(new Dimension(320, (checkDecimal((double)panel.getComponentCount() / 4) * 206)));
            product.addMouseListener(new MouseAdapter() {
            	@Override
            	public void mouseClicked(MouseEvent e) {
            		if(paying == false) {
            			JPanel panel = (JPanel) e.getSource();
                        orderDetails = panel.getName();
                        getData();
                        orderDetails();
                        Total.setText("₱ " + getTotal().toString());
            		}
            		
                    
            	}
            });
            
            
		}
	}
	public int checkDecimal(double number) {
			int num = (int) Math.ceil(number);
			String numberString = String.valueOf(number);	
			int decimalPosition = numberString.indexOf('.');
			String decimalPart = numberString.substring(decimalPosition + 1);
			
			if(Integer.valueOf(decimalPart) > 0) {
				num = (int) Math.ceil(number);
			}
			return num;
			
		
	}
	private void addProductSales() {
		LocalDate currDate = LocalDate.now();
		Date current = Date.valueOf(currDate);
		reciept();
		try {
			Connection con = DriverManager.getConnection( "jdbc:ucanaccess://D:/DatabaseRMS.accdb");
			PreparedStatement pst = con.prepareStatement("insert into ProductSales_Record(ID, Product, Quantity, Amount, Date)values(?, ?, ?, ?, ?)");
			for (int i = 0; i < table.getRowCount(); i++) {
				checkID(getProductSalesID());
				pst.setString(1, idfinal);
				pst.setString(2, table.getValueAt(i, 0).toString());
				pst.setInt(3, Integer.valueOf(table.getValueAt(i, 1).toString()));
				pst.setDouble(4, Double.valueOf(table.getValueAt(i, 2).toString().replaceAll("\\p{Sc}", "").stripLeading()));
				pst.setDate(5, current);
				pst.executeUpdate();
				tableReciept.addRow(new Object[]{table.getValueAt(i, 0).toString() ,table.getValueAt(i, 1).toString(), table.getValueAt(i, 2).toString()}) ;
			}
			lblChangeRecieptVAL.setText("₱ " + String.valueOf(getChange()));
			lblNewTotalRecieptVAL.setText("₱ " + String.valueOf(getNetAmount()));
			lblPaymentAmountVAL.setText("₱ " + textField_PaymentAmount.getText());
			if(textField_DiscountAmount.getText().isBlank()) {
				lblNewDiscountRecieptVAL.setText("₱ " + "0.0");
			}else {
				lblNewDiscountRecieptVAL.setText("₱ " + textField_DiscountAmount.getText());
			}
	
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	private ArrayList getProductSalesID() {
		ArrayList list = new ArrayList();
		try {
			Connection con = DriverManager.getConnection( "jdbc:ucanaccess://D:/DatabaseRMS.accdb");
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery("select * from ProductSales_Record");
			
			while(result.next()) {
				String ID = result.getString("ID");
				list.add(ID);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	public void getCategories() {
		comboBox_Category.removeAllItems();
		Connection con;
		comboBox_Category.addItem("All");
		try {
			con = DriverManager.getConnection( "jdbc:ucanaccess://D:/DatabaseRMS.accdb");
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery("select * from Categories_Record");
			
			while(result.next()) {

				String categoryName = result.getString("Category_Name");
				boolean status = result.getBoolean("Status");
				if(status == true) {
					comboBox_Category.addItem(categoryName);
					
				}
				continue;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void clearPayFields() {
		lblmessage_Payment.setText(null);
		textField_PaymentAmount.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		textField_PaymentAmount.setText(null);
		textField_DiscountAmount.setText(null);
		Change.setText("₱ 0.0");
		netAmount.setText("₱ 0.0");
	}
	
	private void checkID(ArrayList ID) {
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
	private String generateId() {
		Random random = new Random();
		int first = random.nextInt(999);
		int second = random.nextInt(999);
		int third = random.nextInt(999);
		return first + "-" + second + "-" + third;
	 }
	
	public void addRecords() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		LocalDate currDate = LocalDate.now();  
		ArrayList <Date> dates = new ArrayList<>();
		ArrayList <String> ids = new ArrayList<>();
		ArrayList <Double> incomes = new ArrayList<>();
		
		try {
			Connection con = DriverManager.getConnection( "jdbc:ucanaccess://D:/DatabaseRMS.accdb");
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery("select * from Revenue_Record");
			PreparedStatement add = con.prepareStatement("insert into Revenue_Record(ID, Date, Income)values(?, ?, ?)");
			PreparedStatement update = con.prepareStatement("UPDATE Revenue_Record set Income = ? where ID = ?");

			while(result.next()) {
				Date date = result.getDate("Date");	
				String ID = result.getString("ID");
				Double income = result.getDouble("Income");
				
				dates.add(date);
				ids.add(ID);
				incomes.add(income);
			}
			checkID(ids);
			Date current = Date.valueOf(currDate);
			String match = "";
			for (int i = 0; i < ids.size(); i++) {
				
				if(dateFormat.format(dates.get(i)).equals(dateFormat.format(current)) ) {
					match = String.valueOf(i);
				}
			}
			if(match.isBlank() == true) {
				add.setString(1, idfinal);
				add.setDate(2, current);
				add.setDouble(3, Double.valueOf(netAmount.getText().replaceAll("\\p{Sc}", "").stripLeading()));
				add.executeUpdate();
			}else if(match.isBlank() == false){
				update.setDouble(1, (incomes.get(Integer.valueOf(match))) + Double.valueOf(netAmount.getText().replaceAll("\\p{Sc}", "").stripLeading()));
				update.setString(2, ids.get(Integer.valueOf(match)));
				update.executeUpdate();
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	class btnPay implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(table.getRowCount() != 0) {
				paying = true;
				setEnableRec(panel_orderDetail,false);
				setEnableRec(Payment,true);
				Payment.setVisible(true);
				netAmount.setText("₱ " + String.valueOf(getTotal())); 
				
			}else {
				paying = true;
				scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
				setEnableRec(panel_orderDetail,false);
				setEnableRec(messageDialogBox,true);
				message_DialogBox.setText("No product has been added");
				messageDialogBox.setVisible(true);
			}
		}
	}
	class btnOkay implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			paying = false;
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
			Reciept.setVisible(false);
			setEnableRec(panel_orderDetail,true);
			setEnableRec(messageDialogBox,false);
			Image alert = new ImageIcon(this.getClass().getResource("/img/alert.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
			AlertIcon.setIcon(new ImageIcon(alert));
			message_DialogBox.setText(null);
			messageDialogBox.setVisible(false);
		}
	}
	
	
	class btnBack implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			paying = false;
			clearPayFields();
			setEnableRec(panel_orderDetail,true);
			Payment.setVisible(false);
			setEnableRec(Payment,false);
		}
	}
	
	class btnAdd implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
			int row = table.getSelectedRow();
			getData();
			double origPrice = 0.0;
			String quantity = table.getValueAt(row, 1).toString();
			table.setValueAt((Integer.valueOf(quantity) + 1), row, 1);
			
			origPrice = Double.valueOf(pricePro.get(name.indexOf(table.getValueAt(row, 0))).toString());
			table.setValueAt("₱ " + (Double.valueOf(table.getValueAt(row, 2).toString().replaceAll("\\p{Sc}", "").stripLeading())+ origPrice), row, 2);
			Total.setText("₱ " + getTotal().toString());
			}catch(Exception ex) {
				paying = true;
				scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
				setEnableRec(panel_orderDetail,false);
				setEnableRec(messageDialogBox,true);
				message_DialogBox.setText("Please select from the list of product you added");
				messageDialogBox.setVisible(true);
			}
			
		}
	}
	
	class btnMinus implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
			int row = table.getSelectedRow();
			getData();
			double origPrice = 0.0;
			if(Integer.valueOf(table.getValueAt(row, 1).toString()) != 1) {
				String quantity = table.getValueAt(row, 1).toString();
				table.setValueAt((Integer.valueOf(quantity) - 1), row, 1);
				
				origPrice = Double.valueOf(pricePro.get(name.indexOf(table.getValueAt(row, 0))).toString());
				table.setValueAt("₱ " + (Double.valueOf(table.getValueAt(row, 2).toString().replaceAll("\\p{Sc}", "").stripLeading())- Double.valueOf(origPrice) ), row, 2);
				Total.setText(getTotal().toString());
			}
			}catch(Exception ex) {
				paying = true;
				scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
				setEnableRec(panel_orderDetail,false);
				setEnableRec(messageDialogBox,true);
				message_DialogBox.setText("Please select from the list of product you added");
				messageDialogBox.setVisible(true);
			}
			
			
		}
	}
	class btnRemoveItem implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			int row = table.getSelectedRow();
			model.removeRow(row);
			tableData.clear();
			Total.setText(getTotal().toString());
			}catch(Exception ex) {
				scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
				paying = true;
				setEnableRec(panel_orderDetail,false);
				setEnableRec(messageDialogBox,true);
				message_DialogBox.setText("Please select from the list of product you added");
				messageDialogBox.setVisible(true);
			}
				        
		}
	}
	
	class btnFinish implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(Double.valueOf(textField_PaymentAmount.getText()) < Double.valueOf(netAmount.getText().replaceAll("\\p{Sc}", "").stripLeading())) {
				lblmessage_Payment.setText("Payment is not enough");
				textField_PaymentAmount.setBorder(new LineBorder(Color.RED, 1, true));
			}else {
				addRecords();
				addProductSales();
				Reciept.setVisible(true);
				paying = false;
				clearPayFields();
				tableData.clear();
				setEnableRec(panel_orderDetail,false);
				Payment.setVisible(false);
				setEnableRec(Payment,false);
				Total.setText("₱ 0.0");
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);;
				
			}
				        
		}
	}
	
	
	class selectCategory implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			displayProducts();
			
		}
	}
	

  class inputChanged implements DocumentListener{

	@Override
	public void insertUpdate(DocumentEvent e) {
		updateFieldState();
		
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		updateFieldState();
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		updateFieldState();
		
	}
	protected void updateFieldState() {
		
		Change.setText("₱ " + String.valueOf(getChange())); 
		netAmount.setText("₱ " + String.valueOf(getNetAmount()));
		
    }
		
	}
}

