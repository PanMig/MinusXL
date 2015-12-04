package minusxl_data_management;

public abstract class Cell<T> {

	public abstract T getCell();
	public abstract String getCellType();
	public abstract void setCell(Object input);
	
}
