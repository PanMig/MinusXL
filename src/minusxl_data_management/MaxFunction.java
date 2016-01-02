package minusxl_data_management;

public class MaxFunction extends StatisticalFunction {

	private Cell[] input;

	public MaxFunction(Cell[] input) {
		// The constructor creates a instance of AbsFunction Object
		// and holds the Cells in the input data.
		// DON'T FORGET: The "input" is CELL DATA!!!
		this.input = input;
	}

	@Override
	public Object calculateValue() {
		// A simple search for the max in the list of Cell values:
		double max = (double)input[0].getCell();

		for (int i = 1; i < input.length; i++) {
		    if ((double)input[i].getCell() > max) {
		      max = (double)input[i].getCell();
		    }
		}
		
		return(max);
	}

}
