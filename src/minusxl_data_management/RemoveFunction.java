package minusxl_data_management;

public class RemoveFunction extends AlpharithmeticFunction {

	private Cell[] input;

	public RemoveFunction(Cell[] input) {
		// The constructor creates a instance of AbsFunction Object
		// and holds the Cells in the input data.
		// DON'T FORGET: The "input" is CELL DATA!!!
		this.input = input;
	}

	@Override
	public Object calculateValue() {
		
		// Take the first and second member of the input array and save them
		// in temporary variables:
		String string1 = (String) input[0].getCell();
		String string2 = (String) input[1].getCell();
		
		// Replace the occurrence of string2 found in string1 with the empty string
		// It's the same as deleting it:
		string1.replace(string2, "");
		
		return string1;
	}

}
