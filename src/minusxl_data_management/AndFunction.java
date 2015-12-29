package minusxl_data_management;

public class AndFunction extends LogicalFunction {

	private Cell[] input;

	public AndFunction(Cell[] input) {
		// The constructor creates a instance of AbsFunction Object
		// and holds the Cells in the input data.
		// DON'T FORGET: The "input" is CELL DATA!!!
		this.input = input;
	}

	@Override
	public Object calculateValue() {
		// Multiplies the values of all the inputed objects together and returns the multiplication value:
		// We initialize the bool variable with the value of the first input cell.
		Boolean bool = (Boolean)input[0].getCell();
		int i = 1;
		while (i < input.length) {
			bool = bool && (Boolean) input[i].getCell();
			i++;
		}
		return bool;
	}

}
