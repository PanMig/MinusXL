package minusxl_data_management;

public class SumFunction extends MathFunction {

	private Cell[] input;

	public SumFunction(Cell[] input) {
		// The constructor creates a instance of AbsFunction Object
		// and holds the Cells in the input data.
		// DON'T FORGET: The "input" is CELL DATA!!!
		this.input = input;
	}

	@Override
	public Object calculateValue() {
		Float sum = 0f;
		int i = 0;
		while (i < input.length) {
			sum = sum + (float) input[i].getCell();
			i++;
		}
		return sum;
	}

}
