package tableButtons;


import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class AddressContactBtnTableActionCellEditor extends DefaultCellEditor {

    private statusEvent event;

    public AddressContactBtnTableActionCellEditor(statusEvent event) {
        super(new JCheckBox());
        this.event = event;
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int row, int column) {
        AddressContactDetails AddCon = new AddressContactDetails();
        AddCon.initEvent(event, row);
        AddCon.setBackground(jtable.getSelectionBackground());
        return AddCon;
    }
}
