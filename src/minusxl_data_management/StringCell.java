package minusxl_data_management;

public class StringCell extends Cell<String>{

	String value;
	final String cellType = "String";
	
	@Override
	public String getCell() {
		return value;
	}
	@Override
	public String getCellType() {
		return cellType;
	}
	@Override
	public void setCell(Object input) {
		value = input.toString();
	}
	
	
}
