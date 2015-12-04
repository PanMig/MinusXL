package minusxl_data_management;

public class NumberCell extends Cell<Integer>{

	Integer value;
	final String cellType = "Number";
	
	NumberCell(){
		// Constructor
	}
	
	public String getCellType() {
		return cellType;
	}
	
	public Integer getCell() {
		return value;
	}
	
	public void setCell(Object input) {
		value = (Integer)input;
	}

	
}
