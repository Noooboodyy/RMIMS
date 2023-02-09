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
import modifiedComponents.ComboBox;
import modifiedComponents.RoundButton;
import tableButtons.Actions;
import tableButtons.ActionsBtnTableActionCellEditor;
import tableButtons.Availability;
import tableButtons.actionEvent;

public class ExpensesManagement extends JPanel {
	private String idfinal;
	RoundedPanel panel_Add_UpdateTable;
	RoundedPanel panel_3;
	JTextField textField_ExpenseName;
	JTextField textField_Amount;
	Table table;
	JLabel lblmessage_Amount;
	JLabel lblmessage_ExpenseName;
	private JScrollPane scrollPaneExpenses;
	static String addORupdate;
	static String exemptedID;
	static String exemptedTableName;
	int row;
	ComboBox comboBox;
	actionEvent eventActions;
	Object value;
	Object valueTableName;
	private JLabel lblDate;
	private JLabel lblmessage_Date;
	private JLabel lblmessagePeriod;
	private JLabel lblPeriod;
	private JTextField textField_Date;
	private JButton btnFinish_1;
	DateChooser dateChooser;
	
	public ExpensesManagement() {
		setBackground(new Color(240, 240, 240));
		setBounds(0, 0, 944, 681);
		setLayout(null);
		
	     
		panel_Add_UpdateTable = new RoundedPanel(30);
		panel_Add_UpdateTable.setOpaque(false);
		panel_Add_UpdateTable.setBackground(new Color(255, 255, 255));
		panel_Add_UpdateTable.setBounds(125, 11, 700, 203);
		panel_Add_UpdateTable.setBorder(null);
		
		panel_Add_UpdateTable.setLayout(null);
		
		textField_ExpenseName = new JTextField();
		textField_ExpenseName.setColumns(10);
		textField_ExpenseName.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		textField_ExpenseName.setBackground(Color.WHITE);
		textField_ExpenseName.setBounds(25, 48, 252, 42);
		panel_Add_UpdateTable.add(textField_ExpenseName);
		
		JLabel lblExpenseName = new JLabel("Description");
		lblExpenseName.setHorizontalAlignment(SwingConstants.LEFT);
		lblExpenseName.setForeground(SystemColor.controlDkShadow);
		lblExpenseName.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblExpenseName.setBounds(27, 23, 322, 14);
		panel_Add_UpdateTable.add(lblExpenseName);
		
		textField_Amount = new JTextField();
		textField_Amount.setBounds(280, 48, 116, 42);
		panel_Add_UpdateTable.add(textField_Amount);
		textField_Amount.setColumns(10);
		textField_Amount.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		textField_Amount.setBackground(Color.WHITE);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(284, 18, 132, 25);
		panel_Add_UpdateTable.add(lblAmount);
		lblAmount.setHorizontalAlignment(SwingConstants.LEFT);
		lblAmount.setForeground(SystemColor.controlDkShadow);
		lblAmount.setFont(new Font("SansSerif", Font.BOLD, 15));
		
		RoundButton btnFinish = new RoundButton("Finish", 40);
		btnFinish.addActionListener(new btnFinished());
		btnFinish.setForeground(Color.WHITE);
		btnFinish.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnFinish.setFocusable(false);
		btnFinish.setBackground(new Color(11, 31, 55));
		btnFinish.setBounds(25, 115, 653, 42);
		panel_Add_UpdateTable.add(btnFinish);
		add(panel_Add_UpdateTable);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new btnBack());
		btnBack.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnBack.setFocusable(false);
		btnBack.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(25, 160, 653, 23);
		panel_Add_UpdateTable.add(btnBack);
		
		lblmessage_Amount = new JLabel("");
		lblmessage_Amount.setHorizontalAlignment(SwingConstants.LEFT);
		lblmessage_Amount.setForeground(new Color(220, 20, 60));
		lblmessage_Amount.setFont(new Font("Arial", Font.PLAIN, 10));
		lblmessage_Amount.setBounds(280, 90, 123, 14);
		panel_Add_UpdateTable.add(lblmessage_Amount);
		
		lblmessage_ExpenseName = new JLabel("");
		lblmessage_ExpenseName.setHorizontalAlignment(SwingConstants.LEFT);
		lblmessage_ExpenseName.setForeground(new Color(220, 20, 60));
		lblmessage_ExpenseName.setFont(new Font("Arial", Font.PLAIN, 10));
		lblmessage_ExpenseName.setBounds(25, 90, 194, 14);
		panel_Add_UpdateTable.add(lblmessage_ExpenseName);
		
		lblDate = new JLabel("Date");
		lblDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblDate.setForeground(SystemColor.controlDkShadow);
		lblDate.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblDate.setBounds(550, 18, 114, 25);
		panel_Add_UpdateTable.add(lblDate);
		
		lblmessage_Date = new JLabel("");
		lblmessage_Date.setHorizontalAlignment(SwingConstants.LEFT);
		lblmessage_Date.setForeground(new Color(220, 20, 60));
		lblmessage_Date.setFont(new Font("Arial", Font.PLAIN, 10));
		lblmessage_Date.setBounds(542, 90, 113, 14);
		panel_Add_UpdateTable.add(lblmessage_Date);
		
		lblmessagePeriod = new JLabel("");
		lblmessagePeriod.setHorizontalAlignment(SwingConstants.LEFT);
		lblmessagePeriod.setForeground(new Color(220, 20, 60));
		lblmessagePeriod.setFont(new Font("Arial", Font.PLAIN, 10));
		lblmessagePeriod.setBounds(400, 90, 123, 14);
		panel_Add_UpdateTable.add(lblmessagePeriod);
		
		lblPeriod = new JLabel("Period");
		lblPeriod.setHorizontalAlignment(SwingConstants.LEFT);
		lblPeriod.setForeground(SystemColor.controlDkShadow);
		lblPeriod.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblPeriod.setBounds(404, 18, 136, 25);
		panel_Add_UpdateTable.add(lblPeriod);
		
		addItemsPeriods();
		panel_Add_UpdateTable.setVisible(false);
		
		JLabel lblNewLabel_1_1 = new JLabel("Expense Management");
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
		btn_Add.setBounds(20, 11, 82, 31);
		panel_3.add(btn_Add);
		
		scrollPaneExpenses = new JScrollPane();
		scrollPaneExpenses.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneExpenses.setBounds(12, 53, 888, 555);
		panel_3.add(scrollPaneExpenses);
		
		
		
		displayDataExpenses();
	}
	public void addItemsPeriods() {
		comboBox= new ComboBox();
		comboBox.setOpaque(true);
		comboBox.setMaximumRowCount(100);
		comboBox.setFont(new Font("SansSerif", Font.PLAIN, 12));
		comboBox.setFocusable(false);
		comboBox.setBorder(new LineBorder(new Color(227, 227, 227)));
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(400, 48, 136, 42);
		panel_Add_UpdateTable.add(comboBox);
		comboBox.addItem("Select a Period");
		comboBox.addItem("Day");
		comboBox.addItem("Week");
		comboBox.addItem("Month");
		comboBox.addItem("Year");
		
		textField_Date = new JTextField();
		textField_Date.setEditable(false);
		textField_Date.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		textField_Date.setBackground(Color.WHITE);
		textField_Date.setBounds(541, 48, 112, 42);
		panel_Add_UpdateTable.add(textField_Date);
		
		btnFinish_1 = new JButton("...");
		btnFinish_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonActionPerformed(e);
			}
		});
		btnFinish_1.setForeground(Color.WHITE);
		btnFinish_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnFinish_1.setFocusable(false);
		btnFinish_1.setBackground(new Color(128, 128, 128));
		btnFinish_1.setBounds(653, 48, 25, 42);
		panel_Add_UpdateTable.add(btnFinish_1);
		
		dateChooser = new DateChooser();
		dateChooser.setTextRefernce(textField_Date);
	}
	private void jButtonActionPerformed(ActionEvent evt) {
		dateChooser.showPopup();
    }
	class btnAdd implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			scrollPaneExpenses.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
			panel_Add_UpdateTable.setVisible(true);
			setEnableRec(panel_3,false);
			addORupdate = "add";
			exemptedID = "";
			exemptedTableName = "";
		}
	}
	
	class btnBack implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			scrollPaneExpenses.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			reset();
			panel_Add_UpdateTable.setVisible(false);
			setEnableRec(panel_3,true);
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
			
			String period = comboBox.getSelectedItem().toString();
			
			if(textField_ExpenseName.getText().isBlank() || textField_Amount.getText().isBlank() || period.equals("Select a Period")) {
				message.InputRequiredMessage(textField_ExpenseName, lblmessage_ExpenseName);
				message.InputRequiredMessage(textField_Amount, lblmessage_Amount);
				message.InvalidSelection(comboBox, period, lblmessagePeriod, "Select a Period", "Invalid Period");
			}else if(message.checkExistingData(tableNamevalues, textField_ExpenseName, lblmessage_ExpenseName) 
					|| !textField_Amount.getText().matches("^[0-9]*[.]?[0-9]+$") ) {
				message.InvalidInput(textField_Amount, lblmessage_Amount, "^[0-9]*[.]?[0-9]+$");
				if(message.checkExistingData(tableNamevalues, textField_ExpenseName, lblmessage_ExpenseName)) {
					textField_ExpenseName.setBorder(new LineBorder(Color.RED, 1, true));
					lblmessage_ExpenseName.setText("Table name is already used");
				}
				IDvalues.clear();
				tableNamevalues.clear();
			}else {
				String expenseName = textField_ExpenseName.getText();
				double Amaount = Double.valueOf(textField_Amount.getText());
				System.out.print(textField_Date.getText());
				java.sql.Date date = java.sql.Date.valueOf(textField_Date.getText());
				if(addORupdate.equalsIgnoreCase("add")) {
					checkID(IDvalues);
						try {
							Connection con = DriverManager.getConnection( "jdbc:ucanaccess://D:/DatabaseRMS.accdb");
							PreparedStatement pst = con.prepareStatement("insert into Expenses_Record(ID, Date,Expense_name,Amount,Expense_period)values(?, ?, ?, ?, ?)");
							pst.setString(1, idfinal);
							pst.setDate(2, date);
							pst.setString(3, expenseName);
							pst.setDouble(4, Amaount);
							pst.setString(5, period);
							pst.executeUpdate();
								
						} catch (SQLException ex) {
							ex.printStackTrace();
						}
						panel_Add_UpdateTable.setVisible(false);
						setEnableRec(panel_3,true);
						displayDataExpenses();
						reset();
						
				}else if(addORupdate.equalsIgnoreCase("update")) {
					row = table.getSelectedRow();
					value = table.getValueAt(row, 0);				
							
					try {
						Connection con = DriverManager.getConnection( "jdbc:ucanaccess://D:/DatabaseRMS.accdb");
						PreparedStatement pst = con.prepareStatement("UPDATE Expenses_Record set Date = ?, Expense_name = ?,Amount = ?, Expense_period = ?  where ID = ?");
						pst.setDate(1, date);
						pst.setString(2, expenseName);
						pst.setDouble(3, Amaount);
						pst.setString(4, period);
						pst.setString(5, value.toString());
						pst.executeUpdate();
								
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
					panel_Add_UpdateTable.setVisible(false);
					setEnableRec(panel_3,true);
					displayDataExpenses();
					reset();	
						
				}
				scrollPaneExpenses.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
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
	public void displayDataExpenses() {

		table = new Table();
		table.setShowVerticalLines(false);
		table.setFont(new Font("SansSerif", Font.PLAIN, 14));

		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"ID no.", "Date", "Description", "Amaount", "Period", "Actions"
				}
				)
		{
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });

		table.fixTable(scrollPaneExpenses);
		scrollPaneExpenses.setViewportView(table);
		Connection con;
		Availability btn = new Availability("");
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			con = DriverManager.getConnection( "jdbc:ucanaccess://D:/DatabaseRMS.accdb");
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery("select * from Expenses_Record");

			while(result.next()) {
				String ID = result.getString("ID");
				String expenseName = result.getString("Expense_name");
				double amount = result.getDouble("Amount");
				String period = result.getString("Expense_period");
				Date date = result.getDate("Date");
				String status;

				table.addRow(new Object[]{ID , dateFormat.format(date), expenseName, "₱ "+ amount, period, null}) ;
				continue;
			}
			actions();
			table.setSelectionBackground(Color.WHITE);
			table.setFont(new Font("SansSerif", Font.PLAIN, 14));
			table.setRowHeight(60);
			table.getColumn("Actions").setCellRenderer(new ActionsBtnCellRenderer());
			table.getColumn("Actions").setCellEditor(new ActionsBtnTableActionCellEditor(eventActions));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void actions() {

		eventActions = new actionEvent() {

			@Override
			public void onEdit(int row) {
				scrollPaneExpenses.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
				panel_Add_UpdateTable.setVisible(true);
				setEnableRec(panel_3,false);
				
				row = table.getSelectedRow();
				value = table.getValueAt(row, 0);
				valueTableName = table.getValueAt(row, 1);
				
				java.sql.Date date = java.sql.Date.valueOf(table.getValueAt(row, 1).toString());
				dateChooser.setSelectedDate(date);
				textField_ExpenseName.setText(table.getValueAt(row, 2).toString());
				textField_Amount.setText(table.getValueAt(row, 3).toString().replaceAll("\\p{Sc}", "").stripLeading());
				comboBox.setSelectedItem(table.getValueAt(row, 4));
				
				addORupdate = "update";
				exemptedID = value.toString();
				exemptedTableName = valueTableName.toString();

			}

			@Override
			public void onDelete(int row) {
				row = table.getSelectedRow();
				value = table.getValueAt(row, 0);
				
				try {
					Connection con = DriverManager.getConnection( "jdbc:ucanaccess://D:/DatabaseRMS.accdb");
					PreparedStatement pst = con.prepareStatement("delete from Expenses_Record where ID = ?");
					pst.setString(1, value.toString());
					pst.executeUpdate();
					displayDataExpenses();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}

			}

		};

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
		textField_ExpenseName.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		textField_ExpenseName.setText(null);
		lblmessage_ExpenseName.setText(null);
		textField_Amount.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		textField_Amount.setText(null);
		lblmessage_Amount.setText(null);
		comboBox.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		comboBox.setSelectedItem("Select Category");
		lblmessagePeriod.setText(null);
	}
}
