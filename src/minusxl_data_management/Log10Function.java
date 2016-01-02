package minusxl_data_management;

public class Log10Function extends MathFunction {

	private Cell[] input;

	public Log10Function(Cell[] input) {
		// The constructor creates a instance of AbsFunction Object
		// and holds the Cells in the input data.
		// DON'T FORGET: The "input" is CELL DATA!!!
		this.input = input;
	}

	@Override
	public Object calculateValue() {
		// Gets the value of the first Cell object as double and applies the Math.log10 function to it:
		return Math.log10((double)input[0].getCell());
	}

}
