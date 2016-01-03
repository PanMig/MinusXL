package minusxl_data_management;

public class AbsFunction extends MathFunction {

	private Cell[] input;

	public AbsFunction(Cell[] input) {
		// The constructor creates a instance of AbsFunction Object
		// and holds the Cells in the input data.
		// DON'T FORGET: The "input" is CELL DATA!!!
		this.input = input;
	}

	@Override
	public Object calculateValue() {
		/*if (checkValidity(input) == true) {
			return Math.abs((int) input[0].getCell());
		} else {
			return (null);
		}*/

		return Math.abs((double) input[0].getCell());
	}

}
