package minusxl_data_management;

public class BooleanCell extends Cell<Boolean>{

	boolean value;
	final String cellType = "Boolean";
	
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
