package modifiedComponents;


import java.awt.*;
import javax.swing.*;

public class RoundButton extends JButton {
	private int roundness;
	
    public RoundButton(String label, int roundness) {
        super(label);
        this.roundness = roundness;
        Dimension size = getPreferredSize();
        size.width = size.height = Math.max(size.width, size.height);
        setPreferredSize(size);
        setContentAreaFilled(false);
    }

    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.lightGray);
        } else {
            g.setColor(getBackground());
        }
        g.fillRoundRect(0, 0, getSize().width - 1, getSize().height - 1, roundness, roundness);
        super.paintComponent(g);
    }

    protected void paintBorder(Graphics g) {
        g.setColor(getBackground());
        g.drawRoundRect(0, 0, getSize().width - 1, getSize().height - 1, roundness, roundness);
    }
}
