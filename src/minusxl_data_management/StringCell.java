package minusxl_data_management;

public class StringCell extends Cell{

	float value;
	final String cellType = "String";
	
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
	}
	
	
}
