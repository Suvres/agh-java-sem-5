package main.JStudent;

import javax.swing.table.AbstractTableModel;
import java.util.HashMap;
import java.util.Map;

public class UniversityTableModel extends AbstractTableModel {
    private String[] columns;
    private Map<Integer, String[]> data;

    public UniversityTableModel(String[] columns) {
        this.columns = columns;
        this.data = new HashMap<>();
    }

    public void addData(Integer index, String[] data) {
        this.data.put(index, data);
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return this.columns.length;
    }

    @Override
    public Object getValueAt(int index, int columnIndex) {
        return this.data.get(index)[columnIndex];
    }

    public String getColumnName(int col) {
        return this.columns[col];
    }


}
