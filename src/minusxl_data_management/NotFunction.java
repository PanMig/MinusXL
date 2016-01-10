package minusxl_data_management;

public class NotFunction extends LogicalFunction {

	private Cell[] input;

	public NotFunction(Cell[] input) {
		// The constructor creates a instance of AbsFunction Object
		// and holds the Cells in the input data.
		// DON'T FORGET: The "input" is CELL DATA!!!
		this.input = input;
	}

	@Override
	public Object calculateValue() {

		if (checkValidity(input) == true){
			// Here we use only the first value of our list of Cell inputs:
			Boolean bool = (Boolean) input[0].getCell();
	
			if (bool == true) {
				return (false);
			} else {
				return (true);
			}
		} else {
			return "";
		}

	}

}
