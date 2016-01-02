package minusxl_data_management;

public class StdDevFunction extends StatisticalFunction {

	private Cell[] input;

	public StdDevFunction(Cell[] input) {
		// The constructor creates a instance of AbsFunction Object
		// and holds the Cells in the input data.
		// DON'T FORGET: The "input" is CELL DATA!!!
		this.input = input;
	}

	@Override
	public Object calculateValue() {
		// TODO Implement the Standard Deviation algorithm:
		return null;
	}

}
