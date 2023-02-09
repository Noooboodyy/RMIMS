package tableButtons;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Actions extends JPanel {

	private JButton cmdDelete;
    private JButton cmdEdit;
    private JButton cmdView;
    public Actions() {
    	setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 130, 67);
		
    	 cmdEdit = new JButton();
    	 cmdEdit.setBackground(new Color(255, 255, 255));
    	 cmdEdit.setBounds(0, 11, 47, 47);
    	 cmdEdit.setFocusable(false);
    	 cmdEdit.setBorder(null);
         cmdDelete = new JButton();
         cmdDelete.setBackground(new Color(255, 255, 255));
         cmdDelete.setBounds(52, 11, 47, 47);
         cmdDelete.setFocusable(false);   
         cmdDelete.setBorder(null);
         setLayout(null);

         cmdEdit.setIcon(new ImageIcon(getClass().getResource("/img/edit.png"))); 
         add(cmdEdit);
         cmdDelete.setIcon(new ImageIcon(getClass().getResource("/img/delete.png"))); 
         add(cmdDelete);
    }

    public void initEvent(actionEvent event, int row) {
        cmdEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.onEdit(row);
            }
        });
        cmdDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.onDelete(row);
            }
        });
    }


}
