package tableButtons;


import javax.swing.JPanel;

import modifiedComponents.RoundButton;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Availability extends JPanel {
	
	Image imag;
	RoundButton btn_Availability;
	public Availability(String Selection) {
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 67, 67);
		setLayout(null);
		
		btn_Availability = new RoundButton("New button", 30);
		if(Selection.equals("Available")) {
			btn_Availability.setText(Selection);
			btn_Availability.setBackground(new Color(0, 204, 102 ));
		}else if(Selection.equals("Not Available")) {
			btn_Availability.setText(Selection);
			btn_Availability.setBackground(new Color(204, 51, 0));
		}
		btn_Availability.setForeground(Color.WHITE);
		btn_Availability.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btn_Availability.setFocusable(false);
		
		btn_Availability.setBounds(5, 17, 110, 31);
		add(btn_Availability);
	}
	public void initEvent(statusEvent event, int row) {
		btn_Availability.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.availability(row);
            }
        });
    }
}
