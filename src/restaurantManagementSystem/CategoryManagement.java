package restaurantManagementSystem;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import dateChooser.DateChooser;
import modifiedComponents.RoundButton;
import restaurantManagementSystem.ProductManagement.StatusBtnCellRenderer;
import tableButtons.Actions;
import tableButtons.ActionsBtnTableActionCellEditor;
import tableButtons.Availability;
import tableButtons.StatusBtnTableActionCellEditor;
import tableButtons.actionEvent;
import tableButtons.statusEvent;

public class CategoryManagement extends JPanel {
	private String idfinal;
	RoundedPanel panel_Add_UpdateTable;
	RoundedPanel panel_3;
	JTextField textField_CategoryName;
	Table table;
	JLabel lblmessage_ExpenseName;
	private JScrollPane scrollPaneCategory;
	static String addORupdate;
	static String exemptedID;
	static String exemptedTableName;
	int row;
	actionEvent eventActions;
	Object value;
	Object valueTableName;
	DateChooser dateChooser;
	statusEvent eventStatus;
	private RoundedPanel DialogBox;
	private ArrayList <String> IDtoDELorUP = new ArrayList<>();
	private JLabel message_DialogBox;
	private String operation;
	
	public CategoryManagement() {
		setBackground(new Color(240, 240, 240));
		setBounds(0, 0, 944, 681);
		setLayout(null);
		
	     
		panel_Add_UpdateTable = new RoundedPanel(30);
		panel_Add_UpdateTable.setOpaque(false);
		panel_Add_UpdateTable.setBackground(new Color(255, 255, 255));
		panel_Add_UpdateTable.setBounds(313, 21, 299, 203);
		panel_Add_UpdateTable.setBorder(null);
		
		panel_Add_UpdateTable.setLayout(null);
		
		textField_CategoryName = new JTextField();
		textField_CategoryName.setColumns(10);
		textField_CategoryName.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		textField_CategoryName.setBackground(Color.WHITE);
		textField_CategoryName.setBounds(25, 48, 252, 42);
		panel_Add_UpdateTable.add(textField_CategoryName);
		
		JLabel lblCategoryName = new JLabel("Category Name");
		lblCategoryName.setHorizontalAlignment(SwingConstants.LEFT);
		lblCategoryName.setForeground(SystemColor.controlDkShadow);
		lblCategoryName.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblCategoryName.setBounds(27, 23, 252, 14);
		panel_Add_UpdateTable.add(lblCategoryName);
		
		RoundButton btnFinish = new RoundButton("Finish", 40);
		btnFinish.addActionListener(new btnFinished());
		
		DialogBox = new RoundedPanel(20);
		DialogBox.setBackground(new Color(255, 255, 255));
		DialogBox.setBounds(270, 200, 410, 191);
		DialogBox.setOpaque(false);
		DialogBox.setVisible(false);
		add(DialogBox);
		DialogBox.setLayout(null);
		
		RoundButton rndbtnCancel = new RoundButton("Finish", 40);
		rndbtnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operation = null;
				setEnableRec(panel_3, true);
				message_DialogBox.setText(null);
				DialogBox.setVisible(false);
			}
		});
		rndbtnCancel.setText("Cancel");
		rndbtnCancel.setForeground(Color.WHITE);
		rndbtnCancel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		rndbtnCancel.setFocusable(false);
		rndbtnCancel.setBackground(Color.LIGHT_GRAY);
		rndbtnCancel.setBounds(47, 137, 141, 32);
		DialogBox.add(rndbtnCancel);
		
		RoundButton rndbtnOkay = new RoundButton("Finish", 40);
		rndbtnOkay.addActionListener(new btnOkay());
		rndbtnOkay.setText("Okay");
		rndbtnOkay.setForeground(Color.WHITE);
		rndbtnOkay.setFont(new Font("SansSerif", Font.PLAIN, 12));
		rndbtnOkay.setFocusable(false);
		rndbtnOkay.setBackground(new Color(11, 31, 55));
		rndbtnOkay.setBounds(211, 137, 137, 32);
		DialogBox.add(rndbtnOkay);
		
		message_DialogBox = new JLabel();
		message_DialogBox.setText("confirm");
		message_DialogBox.setHorizontalAlignment(SwingConstants.CENTER);
		message_DialogBox.setFont(new Font("SansSerif", Font.PLAIN, 12));
		message_DialogBox.setBounds(10, 86, 390, 29);
		DialogBox.add(message_DialogBox);
		
		Image alert = new ImageIcon(this.getClass().getResource("/img/alert.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		JLabel AlertIcon = new JLabel("");
		AlertIcon.setIcon(new ImageIcon(alert));
		AlertIcon.setHorizontalAlignment(SwingConstants.CENTER);
		AlertIcon.setBounds(10, 11, 390, 64);
		DialogBox.add(AlertIcon);
		
		btnFinish.setForeground(Color.WHITE);
		btnFinish.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnFinish.setFocusable(false);
		btnFinish.setBackground(new Color(11, 31, 55));
		btnFinish.setBounds(25, 115, 252, 42);
		panel_Add_UpdateTable.add(btnFinish);
		add(panel_Add_UpdateTable);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new btnBack());
		btnBack.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnBack.setFocusable(false);
		btnBack.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(25, 160, 252, 23);
		panel_Add_UpdateTable.add(btnBack);
		
		lblmessage_ExpenseName = new JLabel("");
		lblmessage_ExpenseName.setHorizontalAlignment(SwingConstants.LEFT);
		lblmessage_ExpenseName.setForeground(new Color(220, 20, 60));
		lblmessage_ExpenseName.setFont(new Font("Arial", Font.PLAIN, 10));
		lblmessage_ExpenseName.setBounds(25, 90, 194, 14);
		panel_Add_UpdateTable.add(lblmessage_ExpenseName);
		
		addItemsPeriods();
		panel_Add_UpdateTable.setVisible(false);
		
		JLabel lblNewLabel_1_1 = new JLabel("Category Management");
		lblNewLabel_1_1.setToolTipText("");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setForeground(new Color(11, 31, 55));
		lblNewLabel_1_1.setFont(new Font("SansSerif", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(20, 11, 283, 42);
		add(lblNewLabel_1_1);
		
		panel_3 = new RoundedPanel(25);
		panel_3.setForeground(new Color(255, 255, 255));
		panel_3.setOpaque(false);
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(20, 51, 910, 619);
		add(panel_3);
		panel_3.setLayout(null);
		
		RoundButton btn_Add = new RoundButton("New button", 30);
		btn_Add.setFocusable(false);
		btn_Add.addActionListener(new btnAdd());
		btn_Add.setIcon(new ImageIcon(this.getClass().getResource("/img/Add.png")));
		btn_Add.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btn_Add.setBackground(new Color(0, 204, 102));
		btn_Add.setForeground(new Color(255, 255, 255));
		btn_Add.setText(" Add");
		btn_Add.setBounds(20, 11, 89, 31);
		panel_3.add(btn_Add);
		
		scrollPaneCategory = new JScrollPane();
		scrollPaneCategory.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneCategory.setBounds(12, 53, 888, 555);
		panel_3.add(scrollPaneCategory);
		
		
		
		displayDataCategory();
	}
	public void addItemsPeriods() {
		
		dateChooser = new DateChooser();
	}
	class btnAdd implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			scrollPaneCategory.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
			panel_Add_UpdateTable.setVisible(true);
			setEnableRec(panel_3,false);
			addORupdate = "add";
			exemptedID = "";
			exemptedTableName = "";
		}
	}
	class btnOkay implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(operation.equals("Delete")) {
				row = table.getSelectedRow();
				value = table.getValueAt(row, 0);
				String category = table.getValueAt(row, 1).toString();
				getProToEdUp(category);

				try {
					Connection con = DriverManager.getConnection( "jdbc:ucanaccess://D:/DatabaseRMS.accdb");
					PreparedStatement pstcat = con.prepareStatement("delete from Categories_Record where ID = ?");
					
					pstcat.setString(1, value.toString());
					pstcat.executeUpdate();
					
					PreparedStatement pstprod = con.prepareStatement("delete from Products_Record where ID = ?");
					for (int i = 0; i < IDtoDELorUP.size(); i++) {
						
						pstprod.setString(1, IDtoDELorUP.get(i));
						pstprod.executeUpdate();
					}
					operation = "";
					setEnableRec(panel_3, true);
					message_DialogBox.setText(null);
					DialogBox.setVisible(false);
					
					displayDataCategory();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}else if(operation.equals("Update")) {
				
				row = table.getSelectedRow();
				value = table.getValueAt(row, 0);
				String category = table.getValueAt(row, 1).toString();
				getProToEdUp(category);
						
				try {
					Connection con = DriverManager.getConnection( "jdbc:ucanaccess://D:/DatabaseRMS.accdb");
					PreparedStatement pstcat = con.prepareStatement("UPDATE Categories_Record set Category_Name = ?  where ID = ?");
			
					pstcat.setString(1, textField_CategoryName.getText());
					pstcat.setString(2, value.toString());
					pstcat.executeUpdate();
					
					PreparedStatement pstprod = con.prepareStatement("UPDATE Products_Record set Category = ?  where ID = ?");
					for (int i = 0; i < IDtoDELorUP.size(); i++) {
						
						pstprod.setString(1, textField_CategoryName.getText());
						pstprod.setString(2, IDtoDELorUP.get(i));
						pstprod.executeUpdate();
						
					}
				operation = "";
				setEnableRec(panel_3, true);
				message_DialogBox.setText(null);
				DialogBox.setVisible(false);
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
				panel_Add_UpdateTable.setVisible(false);
				setEnableRec(panel_3,true);
				displayDataCategory();
				reset();
			}
			IDtoDELorUP.clear();
			

		}
	}
	
	class btnBack implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			scrollPaneCategory.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			reset();		
			panel_Add_UpdateTable.setVisible(false);
			setEnableRec(panel_3,true);
		}
	}
	class StatusBtnCellRenderer implements TableCellRenderer{

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			String nm = value.toString();

			return new Availability(nm);
		}

	}
	class btnFinished implements ActionListener{
		InvalidInputs message = new InvalidInputs();
		ArrayList <String> IDvalues = new ArrayList<>();
		ArrayList <String> tableNamevalues = new ArrayList<>();
		
		@Override
		public void actionPerformed(ActionEvent e) {
			getArrayData(IDvalues, 0);
			getArrayData(tableNamevalues, 1);
			IDvalues.remove(exemptedID);
			tableNamevalues.remove(exemptedTableName);
			
			
			if(textField_CategoryName.getText().isBlank()) {
				message.InputRequiredMessage(textField_CategoryName, lblmessage_ExpenseName);
			}else if(message.checkExistingData(tableNamevalues, textField_CategoryName, lblmessage_ExpenseName) ) {
				
				if(message.checkExistingData(tableNamevalues, textField_CategoryName, lblmessage_ExpenseName)) {
					textField_CategoryName.setBorder(new LineBorder(Color.RED, 1, true));
					lblmessage_ExpenseName.setText("Table name is already used");
				}
				IDvalues.clear();
				tableNamevalues.clear();
			}else {
				String expenseName = textField_CategoryName.getText();
				if(addORupdate.equalsIgnoreCase("add")) {
					checkID(IDvalues);
						try {
							Connection con = DriverManager.getConnection( "jdbc:ucanaccess://D:/DatabaseRMS.accdb");
							PreparedStatement pst = con.prepareStatement("insert into Categories_Record(ID, Category_Name, Status)values(?, ?, ?)");
							pst.setString(1, idfinal);
							pst.setString(2, expenseName);
							pst.setBoolean(3, true);
							pst.executeUpdate();
								
						} catch (SQLException ex) {
							ex.printStackTrace();
						}
						panel_Add_UpdateTable.setVisible(false);
						setEnableRec(panel_3,true);
						displayDataCategory();
						reset();
						
				}else if(addORupdate.equalsIgnoreCase("update")) {
					operation = "Update";
					setEnableRec(panel_3, false);
					message_DialogBox.setText("All the the category of the product under this category also rename");
					DialogBox.setVisible(true);	
						
				}
				scrollPaneCategory.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				IDvalues.clear();
				tableNamevalues.clear();
				new incomeMonitoringPanel().removeAll();
			}
			
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
	
	class ActionsBtnCellRenderer implements TableCellRenderer{

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			return new Actions();
		}

	}
	
	public void displayDataCategory() {

		table = new Table();
		table.setShowVerticalLines(false);
		table.setFont(new Font("SansSerif", Font.PLAIN, 14));

		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"ID no.","Category Name", "Status", "Actions"
				}
				)
		{
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });

		table.fixTable(scrollPaneCategory);
		scrollPaneCategory.setViewportView(table);
		Connection con;
		Availability btn = new Availability("");
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			con = DriverManager.getConnection( "jdbc:ucanaccess://D:/DatabaseRMS.accdb");
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery("select * from Categories_Record");

			while(result.next()) {
				String ID = result.getString("ID");
				String expenseName = result.getString("Category_name");
				boolean status = result.getBoolean("Status");
				String Status;

				if(status == true) {
					Status = "Available";

				}else {
					Status = "Not Available";
				}
				
				table.addRow(new Object[]{ID ,expenseName, Status, null}) ;
				continue;
			}
			actions();
			availability();
			table.setSelectionBackground(Color.WHITE);
			table.setFont(new Font("SansSerif", Font.PLAIN, 14));
			table.setRowHeight(60);
			table.getColumn("Status").setCellRenderer(new StatusBtnCellRenderer());
			table.getColumn("Status").setCellEditor(new StatusBtnTableActionCellEditor(eventStatus));
			table.getColumn("Actions").setCellRenderer(new ActionsBtnCellRenderer());
			table.getColumn("Actions").setCellEditor(new ActionsBtnTableActionCellEditor(eventActions));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void setAvailability(boolean available) {
		row = table.getSelectedRow();
		value = table.getValueAt(row, 0);

		try {
			Connection con = DriverManager.getConnection( "jdbc:ucanaccess://D:/DatabaseRMS.accdb");
			PreparedStatement pst = con.prepareStatement("UPDATE Categories_Record set Status = ? where ID = ?");
			pst.setBoolean(1, available);
			pst.setString(2, value.toString());
			pst.executeUpdate();
			new categoryDisabledEnable(available);
			displayDataCategory();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	public void availability() {

		eventStatus = new statusEvent() {
			@Override
			public void availability(int row) {

				value = table.getValueAt(row, 0).toString();
				String valueAv = table.getValueAt(row, 2).toString();
				
				if(valueAv.toString().equals("Available")) {
					setAvailability(false);
				}else if(valueAv.toString().equals("Not Available")) {
					setAvailability(true);
				}	
				displayDataCategory();
			}

		};

	}
	
	public void actions() {

		eventActions = new actionEvent() {

			@Override
			public void onEdit(int row) {
				scrollPaneCategory.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
				panel_Add_UpdateTable.setVisible(true);
				setEnableRec(panel_3,false);
				
				row = table.getSelectedRow();
				value = table.getValueAt(row, 0);
				valueTableName = table.getValueAt(row, 1);
				textField_CategoryName.setText(table.getValueAt(row, 1).toString());
				
				
				addORupdate = "update";
				exemptedID = value.toString();
				exemptedTableName = valueTableName.toString();

			}

			@Override
			public void onDelete(int row) {
				operation = "Delete";
				setEnableRec(panel_3, false);
				message_DialogBox.setText("All Products under this Category will be remove");
				DialogBox.setVisible(true);
				
				
			}

		};

	}
	private void getProToEdUp(String Category) {
		try {
			Connection con = DriverManager.getConnection( "jdbc:ucanaccess://D:/DatabaseRMS.accdb");
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery("select * from Products_Record");

			while(result.next()) {
				String ID = result.getString("ID");
				String category = result.getString("Category");
				boolean status = result.getBoolean("Status");
				String Status;
				
				if(Category.equals(category)) {
					IDtoDELorUP.add(ID);
				}

				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
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
		textField_CategoryName.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		textField_CategoryName.setText(null);
		lblmessage_ExpenseName.setText(null);
	}
}
