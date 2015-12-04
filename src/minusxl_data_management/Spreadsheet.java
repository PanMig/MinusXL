package minusxl_data_management;

import java.lang.reflect.Array;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class Spreadsheet extends AbstractTableModel {
	
	private String[] columnNames;
	private Object[][] cells;

	public void Spreadsheet(int rows, int columns){
		
		cells = new Cell[rows][columns];
		
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
