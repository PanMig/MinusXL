package minusxl_data_management;

public class FunctionCell extends Cell<Object>{

	Object value;
	final String cellType = "Function";
	
	@Override
	public Object getCell() {
		return value;
	}
	@Override
	public String getCellType() {
		return cellType;
	}

// -- Trying to figure out the Function cells:
//	public void setCellType(String input){
//		cellType = input;
//	}
	
	@Override
	public void setCell(Object input) {
		value = input.toString();
	}
	
	
}
