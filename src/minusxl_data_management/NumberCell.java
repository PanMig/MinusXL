package minusxl_data_management;

public class NumberCell extends Cell<Double> {

	Double value;
	final String cellType = "Number";

	// This constructor takes in consideration the constructor of the
	// super-class (Cell)
	NumberCell(int row, int column) {
		super(row, column);
	}

	public String getCellType() {
		return cellType;
	}

	public Double getCell() {
		return value;
	}

	public void setCell(Object input) {
		value = (Double) input;
	}

}
