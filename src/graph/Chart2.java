package graph;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Chart2 extends javax.swing.JPanel {

    private List<ModelLegend> legends = new ArrayList<>();
    private List<ModelChart> model = new ArrayList<>();
    private final int seriesSize = 12;
    private final int seriesSpace = 6;

    public Chart2() {
    	 initComponents();
         blankPlotChart.setBlankPlotChatRender(new BlankPlotChatRender2() {
             @Override
             public String getLabelText(int index) {
                 return model.get(index).getLabel();
             }

             @Override
             public void renderSeries(BlankPlotChart2 chart, Graphics2D g2, SeriesSize size, int index) {
                 double totalSeriesWidth = (seriesSize * legends.size()) + (seriesSpace * (legends.size() - 1));
                 double x = (size.getWidth() - totalSeriesWidth) / 2;
                 for (int i = 0; i < legends.size(); i++) {
                     ModelLegend legend = legends.get(i);
                     g2.setColor(legend.getColor());
                     double seriesValues = chart.getSeriesValuesOf(model.get(index).getValues()[i], size.getHeight());
                     g2.fillRect((int) (size.getX() + x), (int) (size.getY() + size.getHeight() - seriesValues), seriesSize, (int) seriesValues);
                     x += seriesSpace + seriesSize;
                 }
             }
         });
     }

     public void addLegend(String name, Color color) {
         ModelLegend data = new ModelLegend(name, color);
         legends.add(data);
     }

    public void addData(ModelChart data) {
        model.add(data);
        blankPlotChart.setLabelCount(model.size());
        double max = data.getMaxValues();
        if (max > blankPlotChart.getMaxValues()) {
            blankPlotChart.setMaxValues(max);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        blankPlotChart = new BlankPlotChart2();

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(blankPlotChart, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(blankPlotChart, GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE))
        );
        this.setLayout(layout);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private BlankPlotChart2 blankPlotChart;
    // End of variables declaration//GEN-END:variables
}
