package minusxl_data_management;

public abstract class Cell<T> {

	private int row;
	private int column;
	
	// This constructor saves the position of every cell (in its Spreadsheet)
	// in its own instance. Thus, every cell is aware of where it belongs.
	Cell (int row, int column){
		this.row = row;
		this.column = column;
	}
	
	// This method returns the row where the Cell is positioned in its Spreadsheet
	public int getRow(){
		return row;
	}
	
	// This method returns the row where the Cell is positioned in its Spreadsheet
	public int getColumn(){
		return column;
	}
	
	public abstract T getCell();
	public abstract String getCellType();
	public abstract void setCell(Object input);
	
}
