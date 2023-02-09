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
import java.util.Random;

import javax.swing.table.DefaultTableCellRenderer.*;

import fileChooser.*;
import modifiedComponents.ComboBox;
import modifiedComponents.RoundButton;
import tableButtons.Actions;
import tableButtons.ActionsBtnTableActionCellEditor;
import tableButtons.Availability;
import tableButtons.StatusBtnTableActionCellEditor;
import tableButtons.actionEvent;
import tableButtons.statusEvent;

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

public class ProductManagement extends JPanel {
	MainFrame frame;
	private RoundedPanel panel_Add_UpdateProduct;
	private RoundedPanel panel;
	private JTextField textField_ProductName;
	private JTextField textField_Price;
	private Table table;
	private JLabel lblmessage_Price;
	private JLabel lblmessage_ProductName;
	private JLabel lblmessage_Category;
	private ComboBox comboBox_Category;
	private JLabel lblmessage_ProductID;
	private JScrollPane scrollPaneTableM;
	private JLabel productImage;
	static String addORupdate;
	static String exemptedID;
	static String exemptedTableName;
	static String category;
	static String image;
	private Image imag;
	private String idfinal;
	private JLabel lblimg;
	statusEvent eventStatus;
	actionEvent eventActions;
	int row;
	Object value;
	Object valueTableName;
	int count = 1;
	ArrayList av = new ArrayList();
	public ProductManagement() {
		setBackground(UIManager.getColor("CheckBox.background"));
		setBounds(0, 0, 944, 681);
		setLayout(null);

		lblimg = new JLabel("");
		lblimg.setBounds(0, 0, 64, 64);

		panel_Add_UpdateProduct = new RoundedPanel(30);
		panel_Add_UpdateProduct.setOpaque(false);
		panel_Add_UpdateProduct.setBackground(new Color(255, 255, 255));
		panel_Add_UpdateProduct.setBounds(211, 28, 501, 287);
		panel_Add_UpdateProduct.setBorder(null);

		panel_Add_UpdateProduct.setLayout(null);

		textField_ProductName = new JTextField();
		textField_ProductName.setFont(new Font("SansSerif", Font.PLAIN, 12));
		textField_ProductName.setColumns(10);
		textField_ProductName.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		textField_ProductName.setBackground(Color.WHITE);
		textField_ProductName.setBounds(189, 39, 287, 42);
		panel_Add_UpdateProduct.add(textField_ProductName);

		JLabel lblTableName = new JLabel("Product Name");
		lblTableName.setHorizontalAlignment(SwingConstants.LEFT);
		lblTableName.setForeground(SystemColor.controlDkShadow);
		lblTableName.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblTableName.setBounds(189, 21, 227, 14);
		panel_Add_UpdateProduct.add(lblTableName);

		textField_Price = new JTextField();
		textField_Price.setFont(new Font("SansSerif", Font.PLAIN, 12));
		textField_Price.setBounds(189, 123, 123, 42);
		panel_Add_UpdateProduct.add(textField_Price);
		textField_Price.setColumns(10);
		textField_Price.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		textField_Price.setBackground(Color.WHITE);

		JLabel lblTableCapacity = new JLabel("Price");
		lblTableCapacity.setBounds(190, 105, 132, 14);
		panel_Add_UpdateProduct.add(lblTableCapacity);
		lblTableCapacity.setHorizontalAlignment(SwingConstants.LEFT);
		lblTableCapacity.setForeground(SystemColor.controlDkShadow);
		lblTableCapacity.setFont(new Font("SansSerif", Font.BOLD, 12));

		RoundButton btnFinish = new RoundButton("Finish", 40);
		btnFinish.addActionListener(new btnFinished());
		btnFinish.setForeground(Color.WHITE);
		btnFinish.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnFinish.setFocusable(false);
		btnFinish.setBackground(new Color(11, 31, 55));
		btnFinish.setBounds(22, 185, 454, 42);
		panel_Add_UpdateProduct.add(btnFinish);
		add(panel_Add_UpdateProduct);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new btnBack());
		btnBack.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnBack.setFocusable(false);
		btnBack.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(22, 238, 458, 23);
		panel_Add_UpdateProduct.add(btnBack);

		lblmessage_Price = new JLabel("");
		lblmessage_Price.setHorizontalAlignment(SwingConstants.LEFT);
		lblmessage_Price.setForeground(new Color(220, 20, 60));
		lblmessage_Price.setFont(new Font("Arial", Font.PLAIN, 10));
		lblmessage_Price.setBounds(189, 169, 123, 14);
		panel_Add_UpdateProduct.add(lblmessage_Price);

		lblmessage_ProductName = new JLabel("");
		lblmessage_ProductName.setHorizontalAlignment(SwingConstants.LEFT);
		lblmessage_ProductName.setForeground(new Color(220, 20, 60));
		lblmessage_ProductName.setFont(new Font("Arial", Font.PLAIN, 10));
		lblmessage_ProductName.setBounds(189, 82, 194, 14);
		panel_Add_UpdateProduct.add(lblmessage_ProductName);

		lblmessage_ProductID = new JLabel("");
		lblmessage_ProductID.setHorizontalAlignment(SwingConstants.LEFT);
		lblmessage_ProductID.setForeground(new Color(220, 20, 60));
		lblmessage_ProductID.setFont(new Font("Arial", Font.PLAIN, 10));
		lblmessage_ProductID.setBounds(230, 103, 136, 14);
		panel_Add_UpdateProduct.add(lblmessage_ProductID);

		JLabel lblCategory = new JLabel("Category");
		lblCategory.setHorizontalAlignment(SwingConstants.LEFT);
		lblCategory.setForeground(SystemColor.controlDkShadow);
		lblCategory.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblCategory.setBounds(332, 102, 119, 23);
		panel_Add_UpdateProduct.add(lblCategory);

		comboBox_Category = new ComboBox();
		comboBox_Category.setForeground(new Color(112, 112, 112));
		comboBox_Category.setFont(new Font("SansSerif", Font.PLAIN, 12));
		comboBox_Category.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		comboBox_Category.setMaximumRowCount(100);
		comboBox_Category.setBackground(new Color(255, 255, 255));
		comboBox_Category.setBounds(327, 123, 149, 42);
		comboBox_Category.setFocusable(false);
		comboBox_Category.setEditable(false);
		comboBox_Category.setOpaque(true);

		comboBox_Category.setBorder(new LineBorder(new Color(227, 227, 227)));
		
		panel_Add_UpdateProduct.add(comboBox_Category);

		lblmessage_Category = new JLabel("");
		lblmessage_Category.setHorizontalAlignment(SwingConstants.LEFT);
		lblmessage_Category.setForeground(new Color(220, 20, 60));
		lblmessage_Category.setFont(new Font("Arial", Font.PLAIN, 10));
		lblmessage_Category.setBounds(328, 165, 105, 14);
		panel_Add_UpdateProduct.add(lblmessage_Category);

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
		panel_Add_UpdateProduct.add(productImage);
		panel_Add_UpdateProduct.setVisible(false);

		JLabel lblNewLabel_1_1 = new JLabel("Product Management");
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

		RoundButton btn_Add = new RoundButton("New button", 30);
		btn_Add.setFocusable(false);
		btn_Add.addActionListener(new btnAdd());
		btn_Add.setIcon(new ImageIcon(this.getClass().getResource("/img/Add.png")));
		btn_Add.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btn_Add.setBackground(new Color(0, 204, 102));
		btn_Add.setForeground(new Color(255, 255, 255));
		btn_Add.setText(" Add");
		btn_Add.setBounds(20, 11, 95, 31);
		panel.add(btn_Add);

		scrollPaneTableM = new JScrollPane();
		scrollPaneTableM.setBounds(12, 53, 888, 555);
		panel.add(scrollPaneTableM);

		displayDataProduct();
		

	}
	private void jButton1ActionPerformed(MouseEvent evt) {
		JnaFileChooser jnaCh = new JnaFileChooser();
		jnaCh.addFilter("Pictures", "jpg", "jpeg", "gif", "png", "bmp");
		boolean save = jnaCh.showOpenDialog(this.frame);
		if (save) {
			System.out.println(jnaCh.getSelectedFile());
			image = jnaCh.getSelectedFile().getAbsolutePath();
			Image background = new ImageIcon(jnaCh.getSelectedFile().getAbsolutePath()).getImage().getScaledInstance(194, 194, Image.SCALE_SMOOTH);
			productImage.setIcon(new ImageIcon(background));

		}
	}

	class btnAdd implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			scrollPaneTableM.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
			panel_Add_UpdateProduct.setVisible(true);
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
			scrollPaneTableM.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			panel_Add_UpdateProduct.setVisible(false);
			setEnableRec(panel,true);
			
		}
	}
	class btnFinished implements ActionListener{
		InvalidInputs message = new InvalidInputs();
		ArrayList <String> IDvalues = new ArrayList<>();
		ArrayList <String> productNamevalues = new ArrayList<>();

		@Override
		public void actionPerformed(ActionEvent e) {
			getArrayData(IDvalues, 0);
			getArrayData(productNamevalues, 2);
			IDvalues.remove(exemptedID);
			productNamevalues.remove(exemptedTableName);
			checkID(IDvalues);
			category = comboBox_Category.getSelectedItem().toString();
			if(image == null) {
				image = "no image";
			}
			if(textField_ProductName.getText().isBlank() || textField_Price.getText().isBlank() || category.equals("Select Category")) {
				message.InputRequiredMessage(textField_ProductName, lblmessage_ProductName);
				message.InputRequiredMessage(textField_Price, lblmessage_Price);
				
				message.InvalidSelection(comboBox_Category, category, lblmessage_Category, "Select Category", "Invalid Category");
			}else if(message.checkExistingData(productNamevalues, textField_ProductName, lblmessage_ProductName) 
					|| !textField_Price.getText().matches("^[0-9]*[.]?[0-9]+$")) {

				message.InvalidInput(textField_Price, lblmessage_Price, "^[0-9]*[.]?[0-9]+$");

				if(message.checkExistingData(productNamevalues, textField_ProductName, lblmessage_ProductName)) {
					textField_ProductName.setBorder(new LineBorder(Color.RED, 1, true));
					lblmessage_ProductName.setText("Product name is already used");
				}
				comboBox_Category.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
				lblmessage_Category.setText(null);
				IDvalues.clear();
				productNamevalues.clear();
			}else {
				String productName = textField_ProductName.getText();
				double price = Double.valueOf(textField_Price.getText());
				String productID = "";
				
				if(addORupdate.equalsIgnoreCase("add")) {
					try {
						Connection con = DriverManager.getConnection( "jdbc:ucanaccess://D:/DatabaseRMS.accdb");
						PreparedStatement pst = con.prepareStatement("insert into Products_Record(ID, Product_Name, Price, Category, Status, Image)values(?, ?, ?, ?, ?, ?)");
						pst.setString(1, idfinal);
						pst.setString(2, productName);
						pst.setDouble(3, price);
						pst.setString(4, category);
						pst.setBoolean(5, true);
						pst.setString(6, image);
						pst.executeUpdate();

					} catch (SQLException ex) {
						ex.printStackTrace();
					}
					panel_Add_UpdateProduct.setVisible(false);
					setEnableRec(panel,true);
					displayDataProduct();
					reset();

				}else if(addORupdate.equalsIgnoreCase("update")) {
					row = table.getSelectedRow();
					value = table.getValueAt(row, 0);				
					try {
						Connection con = DriverManager.getConnection( "jdbc:ucanaccess://D:/DatabaseRMS.accdb");
						PreparedStatement pst = con.prepareStatement("UPDATE Products_Record set Product_Name = ?, Price = ?, Category = ?, Image = ? where ID = ?");
						pst.setString(1, productName);
						pst.setDouble(2, price);
						pst.setString(3, category);
						pst.setString(4, image);
						pst.setString(5, value.toString());
						pst.executeUpdate();

					} catch (SQLException ex) {
						ex.printStackTrace();
					}
					panel_Add_UpdateProduct.setVisible(false);
					setEnableRec(panel,true);
					displayDataProduct();
					reset();

				}
				scrollPaneTableM.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				comboBox_Category.setSelectedItem("Select Category");
				IDvalues.clear();
				productNamevalues.clear();
			}


		}
	}

	public void setAvailability(boolean available) {
		row = table.getSelectedRow();
		value = table.getValueAt(row, 0);
		ArrayList disabledCategories = new ArrayList();

		try {
			Connection con = DriverManager.getConnection( "jdbc:ucanaccess://D:/DatabaseRMS.accdb");
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery("select * from Categories_Record");
			
			while(result.next()) {
				boolean categoryStatus = result.getBoolean("Status");
				String categoryName = result.getString("Category_Name");
				if(categoryStatus == false) {
					disabledCategories.add(categoryName);
				}
			}
			if(disabledCategories.contains(table.getValueAt(row, 4))) {
				System.out.println("The Category of its prodcut is disable");
			}else {
				PreparedStatement pst = con.prepareStatement("UPDATE Products_Record set Status = ? where ID = ?");
				pst.setBoolean(1, available);
				pst.setString(2, value.toString());
				pst.executeUpdate();
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
	public void getCategories() {
		//comboBox_Category
		Connection con;
		comboBox_Category.removeAllItems();
		comboBox_Category.addItem("Select Category");
		try {
			con = DriverManager.getConnection("jdbc:ucanaccess://D:/DatabaseRMS.accdb");
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

			return new Availability(nm);
		}

	}
	class ActionsBtnCellRenderer implements TableCellRenderer{

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			return new Actions();
		}

	}
	public void displayDataProduct() {

		table = new Table();
		table.setShowVerticalLines(false);
		table.setFont(new Font("SansSerif", Font.PLAIN, 14));

		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"ID no.", "Image", "Product name", "Price", "Category", "Status", "Actions"
				}
				)
		{
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
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
			ResultSet result = statement.executeQuery("select * from Products_Record");

			while(result.next()) {
				count++;
				String ID = result.getString("ID");
				String produtcName = result.getString("Product_Name");
				double price = result.getDouble("Price");
				String category = result.getString("Category");
				Boolean Status = result.getBoolean("Status");
				String Img = result.getString("Image");
				String status;

				if(Status == true) {
					status = "Available";

				}else {
					status = "Not Available";
				}

				table.addRow(new Object[]{ID , Img, produtcName, "₱ "+price, category, status, null}) ;
				continue;
			}
			actions();
			availability();
			table.getColumn("Actions").setPreferredWidth(60);
			table.getColumn("Product name").setPreferredWidth(140);
			table.getColumn("Image").setPreferredWidth(70);
			table.getColumn("Price").setPreferredWidth(70);
			table.getColumn("ID no.").setPreferredWidth(70);
			table.getColumn("Category").setPreferredWidth(70);
			
			
			table.getColumn("Status").setPreferredWidth(120);
			table.getColumn("Image").setCellRenderer(new tableCellRenderer());
			table.setSelectionBackground(Color.WHITE);
			table.getColumn("Status").setCellRenderer(new StatusBtnCellRenderer());
			table.getColumn("Status").setCellEditor(new StatusBtnTableActionCellEditor(eventStatus));
			table.setRowHeight(70);
			table.getColumn("Actions").setCellRenderer(new ActionsBtnCellRenderer());
			table.getColumn("Actions").setCellEditor(new ActionsBtnTableActionCellEditor(eventActions));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void availability() {

		eventStatus = new statusEvent() {
			@Override
			public void availability(int row) {

				value = table.getValueAt(row, 0).toString();
				String valueAv = table.getValueAt(row, 5).toString();

				if(valueAv.toString().equals("Available")) {
					setAvailability(false);
				}else if(valueAv.toString().equals("Not Available")) {
					setAvailability(true);
				}	
				displayDataProduct();
			}

		};

	}
	public void actions() {

		eventActions = new actionEvent() {

			@Override
			public void onEdit(int row) {
				scrollPaneTableM.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
				Image imag = new ImageIcon(this.getClass().getResource("/img/noImage.png")).getImage().getScaledInstance(194, 194, Image.SCALE_SMOOTH);;
				panel_Add_UpdateProduct.setVisible(true);
				setEnableRec(panel,false);

				value = table.getValueAt(row, 0).toString();
				
				valueTableName = table.getValueAt(row, 2);
				
				String imageEx = table.getValueAt(row, 1).toString();
				File f = new File(imageEx);
					if(imageEx.equals("no image") || !f.exists()) {
						imag = new ImageIcon(this.getClass().getResource("/img/noImage.png")).getImage().getScaledInstance(194, 194, Image.SCALE_SMOOTH);
					}else {
						imag = new ImageIcon(imageEx).getImage().getScaledInstance(194, 194, Image.SCALE_SMOOTH);
					}
					
				image = imageEx;
				productImage.setIcon(new ImageIcon(imag));
				textField_ProductName.setText(table.getValueAt(row, 2).toString());
				textField_Price.setText(table.getValueAt(row, 3).toString().replaceAll("\\p{Sc}", "").stripLeading());
				comboBox_Category.setSelectedItem(table.getValueAt(row, 4).toString());

				addORupdate = "update";
				exemptedID = value.toString();
				exemptedTableName = valueTableName.toString();

			}

			@Override
			public void onDelete(int row) {
				value = table.getValueAt(row, 0).toString();
				System.out.println(value);
				try {
					Connection con = DriverManager.getConnection("jdbc:ucanaccess://D:/DatabaseRMS.accdb");
					PreparedStatement pst = con.prepareStatement("delete from Products_Record where ID = ?");
					pst.setString(1, value.toString());
					pst.executeUpdate();
					displayDataProduct();
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
		Image background = new ImageIcon(this.getClass().getResource("/img/noImage.png")).getImage().getScaledInstance(194, 194, Image.SCALE_SMOOTH);
		productImage.setIcon(new ImageIcon(background));
		textField_ProductName.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		textField_ProductName.setText(null);
		lblmessage_ProductName.setText(null);
		textField_Price.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		textField_Price.setText(null);
		lblmessage_Price.setText(null);
		comboBox_Category.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		comboBox_Category.setSelectedItem("Select Category");
		lblmessage_Category.setText(null);
	}
}

