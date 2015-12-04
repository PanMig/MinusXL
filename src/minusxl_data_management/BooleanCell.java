package minusxl_data_management;

public class BooleanCell extends Cell{

	float value;
	final String cellType = "Boolean";
	
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
