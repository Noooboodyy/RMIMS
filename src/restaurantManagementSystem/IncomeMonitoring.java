package restaurantManagementSystem;

import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import graph.*;
import javax.swing.border.EmptyBorder;
import javax.swing.ScrollPaneConstants;

public class IncomeMonitoring extends JPanel {

	incomeMonitoringPanel report;
	public IncomeMonitoring() {
		setBackground(UIManager.getColor("CheckBox.background"));
		setBounds(0, 0, 944, 681);
		setFocusable(false);
		setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Income Monitoring");
		lblNewLabel_1_1.setToolTipText("");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setForeground(new Color(11, 31, 55));
		lblNewLabel_1_1.setFont(new Font("SansSerif", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(20, 11, 265, 42);
		add(lblNewLabel_1_1);
		
		report = new incomeMonitoringPanel();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setVerticalScrollBar(new ScrollBar());
		scrollPane.getVerticalScrollBar().setBackground(Color.WHITE);
		scrollPane.getViewport().setBackground(Color.WHITE);
	    JPanel p = new JPanel();
	    p.setBackground(Color.WHITE);
	    scrollPane.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
		scrollPane.setBounds(0, 49, 944, 632);
		scrollPane.setViewportView(report);
		add(scrollPane);
		
	}
}
