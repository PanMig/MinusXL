package minusxl_data_management;

public class NumberCell extends Cell{

	float value;
	int intvalue;
	final String cellType = "Number";
	
	@Override
	public Object getCell() {
		return value;
	}
	@Override
	public String getCellType() {
		return cellType;
	}
	@Override
	public void setCell(Object input) {
		value = (float) input;
		intvalue = (int) value;
	}
	
	
}
