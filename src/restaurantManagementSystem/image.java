package restaurantManagementSystem;

import javax.swing.JPanel;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;

public class image extends JPanel {
	
	Image imag;
	public image(String Img) {
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 67, 67);
		setLayout(null);
		File f = new File(Img);
		if(Img.equals("no image") || !f.exists()) {
			imag = new ImageIcon(this.getClass().getResource("/img/noImage.png")).getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
		}else {
			imag = new ImageIcon(Img).getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
		}
		
		JLabel img = new JLabel("");
		img.setBounds(2, 2, 64, 64);
		img.setIcon(new ImageIcon(imag));
		add(img);
	}
}
