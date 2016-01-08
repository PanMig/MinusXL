package minusxl_data_management;

public class TrimFunction extends AlpharithmeticFunction {

	private Cell[] input;

	public TrimFunction(Cell[] input) {
		// The constructor creates a instance of AbsFunction Object
		// and holds the Cells in the input data.
		// DON'T FORGET: The "input" is CELL DATA!!!
		if (checkValidity(input) == true) {
			this.input = input;
		}
	}

	@Override
	public Object calculateValue() {
		// Trim whitespace from the selected string:
		String string1 = (String) input[0].getCell();
		return(string1.trim());
	}

}
