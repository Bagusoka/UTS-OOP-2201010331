package toko;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;


public class ButtonEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {

    private JTable table;
    private JButton button;
    private String label;
    private boolean isPushed;
    private JDialog dialog;

    public ButtonEditor(JTable table) {
        this.table = table;
        this.button = new JButton("Edit");
        this.button.setOpaque(true);
        this.button.addActionListener(this);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.label = (value == null) ? "" : value.toString();
        this.button.setText(label);
        this.isPushed = true;
        return this.button;
    }

    @Override
    public Object getCellEditorValue() {
        return label;
    }

    @Override
    public boolean stopCellEditing() {
        isPushed = false;
        fireEditingStopped();
        return super.stopCellEditing();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fireEditingStopped();

        int index = table.getSelectedRow();
        Toko.frame.editDialog.fillInputs(index);

        Toko.frame.editDialog.setVisible(true);
    }
}
