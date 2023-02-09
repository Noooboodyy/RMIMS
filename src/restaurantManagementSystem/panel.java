package restaurantManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class panel extends javax.swing.JPanel {

	 private JLabel lbIcon;
	 private JLabel lbTitle;
	 private JLabel lbValues;

	public Color getColor1() {
	    return color1;
	}
	
	public void setColor1(Color color1) {
	    this.color1 = color1;
	}
	
	public Color getColor2() {
	    return color2;
	}
	
	public void setColor2(Color color2) {
	    this.color2 = color2;
	}
	
	private Color color1;
	private Color color2;
	
	public panel() {
	    initComponents();
	    setOpaque(false);
	    color1 = Color.BLACK;
	    color2 = Color.WHITE;
	}
	
	public void setData(Model_Card data) {
	    lbIcon.setIcon(data.getIcon());
	    lbTitle.setText(data.getTitle());
	    lbValues.setText(data.getValues());
	}
	
	private void initComponents() {
	
	    lbIcon = new javax.swing.JLabel();
	    lbTitle = new javax.swing.JLabel();
	    lbValues = new javax.swing.JLabel();
	
	    lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/profit.png"))); // NOI18N
	
	    lbTitle.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
	    lbTitle.setForeground(new java.awt.Color(255, 255, 255));
	
	    lbValues.setFont(new Font("SansSerif", Font.PLAIN, 11)); // NOI18N
	    lbValues.setForeground(new java.awt.Color(255, 255, 255));
	    lbValues.setText("Values");
	
	    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
	    layout.setHorizontalGroup(
	    	layout.createParallelGroup(Alignment.LEADING)
	    		.addGroup(layout.createSequentialGroup()
	    			.addGroup(layout.createParallelGroup(Alignment.LEADING)
	    				.addGroup(layout.createSequentialGroup()
	    					.addContainerGap()
	    					.addComponent(lbTitle))
	    				.addGroup(layout.createSequentialGroup()
	    					.addContainerGap()
	    					.addComponent(lbValues))
	    				.addGroup(layout.createSequentialGroup()
	    					.addContainerGap()
	    					.addComponent(lbIcon)))
	    			.addContainerGap(72, Short.MAX_VALUE))
	    );
	    layout.setVerticalGroup(
	    	layout.createParallelGroup(Alignment.LEADING)
	    		.addGroup(layout.createSequentialGroup()
	    			.addContainerGap()
	    			.addComponent(lbIcon)
	    			.addPreferredGap(ComponentPlacement.RELATED)
	    			.addComponent(lbTitle)
	    			.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
	    			.addComponent(lbValues)
	    			.addGap(19))
	    );
	    this.setLayout(layout);
	}
	
	@Override
	protected void paintComponent(Graphics grphcs) {
	    Graphics2D g2 = (Graphics2D) grphcs;
	    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    GradientPaint g = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
	    g2.setPaint(g);
	    g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
	    g2.setColor(new Color(255, 255, 255, 50));
	    g2.fillOval(getWidth() - (getHeight() / 2), 10, getHeight(), getHeight());
	    g2.fillOval(getWidth() - (getHeight() / 2) - 20, getHeight() / 2 + 20, getHeight(), getHeight());
	    super.paintComponent(grphcs);
	}
	
	}
	
	
	
