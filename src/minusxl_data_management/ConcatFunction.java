package minusxl_data_management;

public class ConcatFunction extends AlpharithmeticFunction {

	private Cell[] input;

	public ConcatFunction(Cell[] input) {
		// The constructor creates a instance of AbsFunction Object
		// and holds the Cells in the input data.
		// DON'T FORGET: The "input" is CELL DATA!!!
		this.input = input;
	}

	@Override
	public Object calculateValue() {
		// Combines a series of strings into one:
		String concatenated = null;
		int i = 0;
		while (i < input.length) {
			concatenated = concatenated + (String) input[i].getCell();
			i++;
		}
		return concatenated;
	}

}
