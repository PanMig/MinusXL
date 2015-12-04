package minusxl_data_management;

import java.lang.reflect.Array;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class Spreadsheet extends AbstractTableModel {
	
	private Cell[][] data;
	
	// The data is a two-dimensional array: An Object array of Object arrays.

	public Spreadsheet(int rows, int columns){
		// Constructor for a new Array of Arrays of Cells.
		// Currently makes them all NumberCells.
		
		data = new Cell[rows][columns];
		
		for(int i=0; i<rows; i++){
			for(int y=0; y<columns; y++){
				data[i][y]= new NumberCell();
			}
		}	
	}
	
	@Override
	public int getRowCount() {
		// Returns the size of the "row" array (containing the other arrays)
		return(0);
	}

	@Override
	public int getColumnCount() {
		// Returns the size of the "row" array (containing the other arrays)
		return(0);
	}

	@Override
	public Object getValueAt(int row, int column) {
        return data[row][column].getCell();
	}
	
	public void setValueAt(Cell value, int row, int column){
		data[row][column].setCell(value);
        fireTableCellUpdated(row, column);
	}
	
	
}
