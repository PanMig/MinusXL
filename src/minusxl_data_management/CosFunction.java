package minusxl_data_management;

public class CosFunction extends MathFunction {

	private Cell[] input;

	public CosFunction(Cell[] input) {
		// The constructor creates a instance of AbsFunction Object
		// and holds the Cells in the input data.
		// DON'T FORGET: The "input" is CELL DATA!!!
		this.input = input;
	}

	@Override
	public Object calculateValue() {
		// Takes the first object of the input, casts to a double value
		// converts to radians and then applies the Math.cos function
		return Math.cos((Math.toRadians((double) input[0].getCell())));
	}

}
