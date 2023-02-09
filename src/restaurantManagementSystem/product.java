package restaurantManagementSystem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.RenderingHints;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class product extends JPanel {

	private Color backgroundColor;
    private int cornerRadius = 15;
    private JLabel price;
    private JLabel image;
    private JLabel productName;

    public product(LayoutManager layout, int radius) {
        super(layout);
        cornerRadius = radius;
    }

    public product(LayoutManager layout, int radius, Color bgColor) {
        super(layout);
        cornerRadius = radius;
        backgroundColor = bgColor;
    }
    /**
	 * @wbp.parser.constructor
	 */
    public product(int radius) {
        super();
        setBackground(new Color(255, 255, 255));
        setForeground(new Color(166, 166, 166));
        cornerRadius = radius;
        setSize(new Dimension(142, 194));
        setLayout(null);
        
        productName = new JLabel("Burger");
        productName.setHorizontalAlignment(SwingConstants.LEFT);
        productName.setForeground(new Color(91, 91, 91));
        productName.setFont(new Font("SansSerif", Font.BOLD, 12));
        productName.setBounds(10, 148, 132, 19);
        add(productName);
        
        image = new JLabel("");
        image.setBounds(0, 0, 142, 142);
        add(image);
        
        price = new JLabel("$566");
        price.setForeground(new Color(91, 91, 91));
        price.setHorizontalAlignment(SwingConstants.LEFT);
        price.setFont(new Font("SansSerif", Font.PLAIN, 12));
        price.setBounds(10, 174, 124, 14);
        add(price);
    }
    public void setData(Model_Product product) {
    	productName.setText(product.getProductName());
    	image.setIcon(product.getIcon());
    	price.setText(product.getPrice());
    }

    public product(int radius, Color bgColor) {
        super();
        cornerRadius = radius;
        backgroundColor = bgColor;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension arcs = new Dimension(cornerRadius, cornerRadius);
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (backgroundColor != null) {
            graphics.setColor(backgroundColor);
        } else {
            graphics.setColor(getBackground());
        }
        graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); 
        graphics.setColor(getForeground());
        graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); 
    }
}
