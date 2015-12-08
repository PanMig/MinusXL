package minusxl_data_management;

public class BooleanCell extends Cell<Boolean>{

	boolean value;
	final String cellType = "Boolean";
	
	// This constructor takes in consideration the constructor of the super-class (Cell)
	BooleanCell(int row, int column) {
		super(row, column);
	}
	
	public Boolean getCell() {
		return value;
	}
	
	public String getCellType() {
		return cellType;
	}
	
	public void setCell(Object input) {
		value = (boolean)input;
	}
	
}
