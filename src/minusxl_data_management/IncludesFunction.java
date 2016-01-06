package minusxl_data_management;

public class IncludesFunction extends AlpharithmeticFunction {

	private Cell[] input;

	public IncludesFunction(Cell[] input) {
		// The constructor creates a instance of AbsFunction Object
		// and holds the Cells in the input data.
		// DON'T FORGET: The "input" is CELL DATA!!!
		this.input = input;
	}

	@Override
	public Object calculateValue() {
		
		// Take the first and second members of the input array (they are strings)
		// and hold them in temporary variables to make the string search:
		String string1 = input[0].getCell().toString();
		String string2 = input[1].getCell().toString();
		
		// If string1 includes string2 then return "true"
		if( string1.toLowerCase().contains(string2.toLowerCase()) == true ) {
			return true;
		} else {
			return false;
		}
	}
	
}
