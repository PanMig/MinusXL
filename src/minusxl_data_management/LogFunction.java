package minusxl_data_management;

public class LogFunction extends MathFunction {

	private Cell[] input;

	public LogFunction(Cell[] input) {
		// The constructor creates a instance of AbsFunction Object
		// and holds the Cells in the input data.
		// DON'T FORGET: The "input" is CELL DATA!!!
		this.input = input;
	}

	@Override
	public Object calculateValue() {
		// Gets the value of the first Cell object as double and applies the
		// Math.log function to it:
		if(checkValidity(input) == true){
			return Math.log((double) input[0].getCell());
		} else {
			return null;
		}
	}
}
