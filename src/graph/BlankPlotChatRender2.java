package graph;

import java.awt.Graphics2D;

public abstract class BlankPlotChatRender2 {

    public abstract String getLabelText(int index);

    public abstract void renderSeries(BlankPlotChart2 chart, Graphics2D g2, SeriesSize size, int index);
}
