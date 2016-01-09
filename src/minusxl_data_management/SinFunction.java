package minusxl_data_management;

public class SinFunction extends MathFunction {

	private Cell[] input;

	public SinFunction(Cell[] input) {
		// The constructor creates a instance of AbsFunction Object
		// and holds the Cells in the input data.
		// DON'T FORGET: The "input" is CELL DATA!!!
		this.input = input;
	}

	@Override
	public Object calculateValue() {
		if(checkValidity(input) == true){
			// Takes the first object of the input, casts to a double value
			// converts to radians and then applies the Math.cos function
			return Math.sin((Math.toRadians((double) input[0].getCell())));
		} else {
			return null;
		}
	}

}
