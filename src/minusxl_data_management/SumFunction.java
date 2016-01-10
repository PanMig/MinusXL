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
		if(checkValidity(input) == true){
			// Adds the value of all the inputed objects and returns their sum:
			Float sum = 0f;
			int i = 0;
			while (i < input.length) {
				sum = (float) (sum + (double) input[i].getCell());
				i++;
			}
			return sum;
		} else {
			return null;
		}
	}

}
