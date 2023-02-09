package modifiedComponents;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class GradientColorPanel extends JPanel {
    private Color color1 = Color.RED;
    private Color color2 = Color.BLUE;

    public GradientColorPanel() {
        setOpaque(false);
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth();
        int height = getHeight();
        g2.setPaint(new GradientPaint(0, 0, color1, width, 0, color2));
        g2.fillRect(0, 0, width, height);
        g2.dispose();
        super.paintComponent(g);
    }
}