package modifiedComponents;



import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Color;

public class ColorTable extends DefaultTableCellRenderer{
    public ColorTable(JTable table) {
        for (int i = 0; i < table.getRowCount(); i++) {
            String value = (String) table.getValueAt(i, 2);
            if (value.equals("Available")) {
                setForeground(Color.GREEN);
            } else {
                setForeground(Color.BLACK);
            }
            table.getColumnModel().getColumn(2).setCellRenderer(this);
        }
    }
}