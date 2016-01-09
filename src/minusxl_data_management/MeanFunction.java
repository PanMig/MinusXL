package minusxl_data_management;

public class MeanFunction extends StatisticalFunction {

	private Cell[] input;

	public MeanFunction(Cell[] input) {
		// The constructor creates a instance of AbsFunction Object
		// and holds the Cells in the input data.
		// DON'T FORGET: The "input" is CELL DATA!!!
		this.input = input;
	}

	@Override
	public Object calculateValue() {
		if (checkValidity(input) == true) {
			// A simple search for the mean in the list of Cell values:
			double sum = 0;

			for (int i = 1; i < input.length; i++) {
				sum = sum + (double) input[i].getCell();
			}

			return (sum / input.length);
		} else {
			return null;
		}
	}

}
