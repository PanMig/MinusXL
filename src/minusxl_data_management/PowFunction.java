package minusxl_data_management;

public class PowFunction extends MathFunction {

	private Cell[] input;

	// TODO: Maybe move the "checkValidity()" inside the child-classes

	public PowFunction(Cell[] input) {
		// The constructor creates a instance of AbsFunction Object
		// and holds the Cells in the input data.
		// DON'T FORGET: The "input" is CELL DATA!!!
		if (checkValidity(input) == true) {
			this.input = input;
		}
	}

	@Override
	public Object calculateValue() {

		Double pow = (Double) input[0].getCell();
		int i = 1;
		while (i < input.length) {
			pow = Math.pow(pow, (Double) input[i].getCell());
			i++;
		}
		return pow;
	}

}
