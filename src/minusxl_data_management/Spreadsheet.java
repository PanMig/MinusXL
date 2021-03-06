package minusxl_data_management;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class Spreadsheet extends AbstractTableModel {

	// The data is a two-dimensional array: An Cell array of Cell arrays.
	private Cell[][] data;
	private int rows, columns;

	public Spreadsheet(int rows, int columns) {
		// Constructor for a new Array of Arrays of Cells.
		// Currently makes them all NumberCells.

		// Save the rows' and columns' sizes for later use:
		this.rows = rows;
		this.columns = columns;

		data = new Cell[rows][columns];

		for (int i = 0; i < rows; i++) {
			for (int y = 0; y < columns; y++) {
				data[i][y] = new StringCell(i, y);
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
	// Override this method so that all the Jtable cells become editable:
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

	@Override
	// Return the value inside the selected Cell (depending on its type):
	public Object getValueAt(int row, int column) {
		return data[row][column].getCell();
	}

	@Override
	public void setValueAt(Object value, int row, int column) {
		
		// Here, we will check the type of the incoming input:
		
		// Because the input is always a string, if the user wants to input a number
		// we first convert it to a Double (we only use Doubles).
		// The same happens for the Boolean type:
		
		// TODO: Maybe make this should not use an exception?
		try {
			value = Double.parseDouble(value.toString());
			// Runs if it's a double
		} catch (NumberFormatException e) {
			// Exception if it's not a double.
			// Just keep going.
		}

		if (value.equals("true") || value.equals("false")) {
			// If the input String is "true" of "false", make it a Boolean:
			value = Boolean.parseBoolean(value.toString());
		}

		// We're going to create the respective type of Cell
		// depending on the input that we take
		// (eg. for Boolean input we're creating a BooleanCell)
		// Also, we pass the position of the Cell instances to the instances
		// themselves.
		if (value.getClass() == Integer.class) {
			data[row][column] = new NumberCell(row, column);
			// Here is a stupid hack to definitely get a double value
			// from a possible integer input value:
			Integer temp_integer = (Integer) value;
			data[row][column].setCell(temp_integer.doubleValue());
		} else if (value.getClass() == Double.class) {
			data[row][column] = new NumberCell(row, column);
			data[row][column].setCell(value);
		} else if (value.getClass() == Boolean.class) {
			data[row][column] = new BooleanCell(row, column);
			data[row][column].setCell((Boolean) value);
		} else if (value.getClass() == String.class) {
			data[row][column] = new StringCell(row, column);
			data[row][column].setCell((String) value);
		} else {
			// This is the default action. If something goes wrong
			// we will make a StringCell by default, containing
			// the empty string value:
			data[row][column] = new StringCell(row, column);
			data[row][column].setCell("");
		}

		// TODO To be implemented: We can add an exception on the previous block
		// if an incoming "value" is not of any compatible (with the Cells) type

		fireTableCellUpdated(row, column);
	}

	// TODO: This method has the same name with the one of Cell class.
	// Currently, it's used for giving Cells to Functions (through the UI call)
	public Cell getCell(int row, int column) {
		return data[row][column];
	}

	public void useFunction(Cell[] input_cells, String function, Cell output_cell) {

		// TODO: output "cell" must be different from input "cell"

		// To explain the data[output_cell.getRow] etc: To initialize the
		// function Cell
		// we use the output_cell data to get the location with the getRow and
		// getColumn

		data[output_cell.getRow()][output_cell.getColumn()] = new FunctionCell(output_cell.getRow(),
				output_cell.getColumn(), input_cells, function);
		// So, what does the big line here do? Simple. When we want to use a
		// function on a Cell
		// it creates a new FunctionCell at the position of the previous Cell
		// (the "output")
		// and passes the "input_cells" (the data for the function's input) and
		// the name of the function
		// that we want to use.

	}
	
//	public void useFunction(Cell output_cell){
//		if(data[output_cell.getRow()][output_cell.getColumn()] instanceof FunctionCell){
//			data[output_cell.getRow()][output_cell.getColumn()].calculateValue;
//		}
//	}
	
	public void createChart() {
		// TODO: This method will call the Charts Manager package
		// -- To be implemented --
	}

}
