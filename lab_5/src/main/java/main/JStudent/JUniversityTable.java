package main.JStudent;

import java.awt.event.MouseListener;

public class JUniversityTable extends javax.swing.JTable {

    public void setModel(UniversityTableModel dataModel) {
        super.setModel(dataModel);
    }

    @Override
    public synchronized void addMouseListener(MouseListener l) {
        super.addMouseListener(l);
    }
}
