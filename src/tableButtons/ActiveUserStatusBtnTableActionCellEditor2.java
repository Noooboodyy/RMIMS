package tableButtons;


import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;


public class ActiveUserStatusBtnTableActionCellEditor2 extends DefaultCellEditor {

    private statusEvent event;

    public ActiveUserStatusBtnTableActionCellEditor2(statusEvent event) {
        super(new JCheckBox());
        this.event = event;
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int row, int column) {
        ActiveUserStatus action = new ActiveUserStatus("");
        action.initEvent(event, row);
        action.setBackground(jtable.getSelectionBackground());
        return action;
    }
}
