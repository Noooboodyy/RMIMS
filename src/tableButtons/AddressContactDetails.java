package tableButtons;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class AddressContactDetails extends JPanel {
    private JButton Info;
    private JButton cmdView;
    public AddressContactDetails() {
    	setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 130, 67);
		
    	 Info = new JButton();
    	 Info.setBackground(new Color(255, 255, 255));
    	 Info.setBounds(0, 11, 47, 47);
    	 Info.setFocusable(false);
    	 Info.setBorder(null);
         setLayout(null);

         Info.setIcon(new ImageIcon(getClass().getResource("/img/moreInfo.png"))); 
         add(Info);
    }

    public void initEvent(statusEvent event, int row) {
        Info.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.availability(row);
            }
        });
        
    }


}
