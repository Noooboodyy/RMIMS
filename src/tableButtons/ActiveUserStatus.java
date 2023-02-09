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

public class ActiveUserStatus extends JPanel {
	
	Image imag;
	RoundButton btn_ActiveStatus;
	public ActiveUserStatus(String Selection) {
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 67, 67);
		setLayout(null);
		
		btn_ActiveStatus = new RoundButton("New button", 30);
		if(Selection.equals("Active")) {
			btn_ActiveStatus.setText(Selection);
			btn_ActiveStatus.setBackground(new Color(0, 204, 102 ));
		}else if(Selection.equals("Not Active")) {
			btn_ActiveStatus.setText(Selection);
			btn_ActiveStatus.setBackground(new Color(204, 51, 0));
		}
		btn_ActiveStatus.setForeground(Color.WHITE);
		btn_ActiveStatus.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btn_ActiveStatus.setFocusable(false);
		
		btn_ActiveStatus.setBounds(5, 17, 110, 31);
		add(btn_ActiveStatus);
	}
	public void initEvent(statusEvent event, int row) {
		btn_ActiveStatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.availability(row);
            }
        });
    }
}
