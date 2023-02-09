package restaurantManagementSystem;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class legend extends JPanel {

	/**
	 * Create the panel.
	 */
	public legend() {
		setLayout(null);
		
		RoundedPanel revene = new RoundedPanel(20);
		revene.setForeground(new Color(255, 255, 255));
		revene.setOpaque(false);
		revene.setBackground(new Color(245, 189, 135));
		revene.setBounds(88, 11, 15, 15);
		add(revene);
		
		JLabel lblRevenue = new JLabel("Revenue");
		lblRevenue.setForeground(new Color(87, 87, 87));
		lblRevenue.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblRevenue.setBounds(107, 11, 59, 14);
		add(lblRevenue);
		
		RoundedPanel expenses = new RoundedPanel(20);
		expenses.setOpaque(false);
		expenses.setForeground(Color.WHITE);
		expenses.setBackground(new Color(135, 189, 245));
		expenses.setBounds(195, 11, 15, 15);
		add(expenses);
		
		JLabel lblExpenses = new JLabel("Expense");
		lblExpenses.setForeground(new Color(87, 87, 87));
		lblExpenses.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblExpenses.setBounds(217, 11, 59, 14);
		add(lblExpenses);
		
		JLabel lblIncome = new JLabel("Income");
		lblIncome.setForeground(new Color(87, 87, 87));
		lblIncome.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblIncome.setBounds(325, 11, 59, 14);
		add(lblIncome);
		
		RoundedPanel Income = new RoundedPanel(20);
		Income.setOpaque(false);
		Income.setForeground(Color.WHITE);
		Income.setBackground(new Color(60, 176, 60));
		Income.setBounds(303, 11, 15, 15);
		add(Income);

	}
}
