package minusxl_data_management;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class Spreadsheet extends AbstractTableModel {
	
	private Cell[][] data;
	private int rows, columns;
	
	// The data is a two-dimensional array: An Object array of Object arrays.

	public Spreadsheet(int rows, int columns){
		// Constructor for a new Array of Arrays of Cells.
		// Currently makes them all NumberCells.
		
		//Save the rows and columns sizes for later use:
		this.rows = rows;
		this.columns = columns;
		
		data = new Cell[rows][columns];
		
		//TESTING:
		System.out.println("Spreadsheet Inititalized (Constructor)");
		
		for(int i=0; i<rows; i++){
			for(int y=0; y<columns; y++){
				data[i][y]= new NumberCell();
			}
		}	
	}
	
	@Override
	public int getRowCount() {
		// Returns the size of the "row" array (containing the other arrays)
		return rows;
	}

	@Override
	public int getColumnCount() {
		// Returns the size of the "row" array (containing the other arrays)
		return columns;
	}

	@Override
	public Object getValueAt(int row, int column) {
		
        return data[row][column].getCell(); 
	}
	
	@Override
	public void setValueAt(Object value, int row, int column){
		
		// Check the type of the incoming input.
		// We're going to create the respective type of Cell
		// depending on the input that we take (eg. for Boolean input we're creating a BooleanCell)
		if( value.getClass() == Integer.class ){
				data[row][column] = new NumberCell();
			} else if ( value.getClass() == Boolean.class ) {
				data[row][column] = new BooleanCell();
			} else if ( value.getClass() == String.class) {
				data[row][column] = new StringCell();
			}
		
		data[row][column].setCell(value);
        fireTableCellUpdated(row, column);
	}
	
	
}
