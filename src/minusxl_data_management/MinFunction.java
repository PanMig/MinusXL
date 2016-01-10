package minusxl_data_management;

public class MinFunction extends StatisticalFunction {

	private Cell[] input;

	public MinFunction(Cell[] input) {
		// The constructor creates a instance of AbsFunction Object
		// and holds the Cells in the input data.
		// DON'T FORGET: The "input" is CELL DATA!!!
		this.input = input;
	}

	@Override
	public Object calculateValue() {
		if (checkValidity(input) == true){
			// A simple search for the min in the list of Cell values:
			double min = (double) input[0].getCell();
	
			for (int i = 1; i < input.length; i++) {
				if ((double) input[i].getCell() < min) {
					min = (double) input[i].getCell();
				}
			}
	
			return (min);
		} else {
			return false;
		}
	}

}
