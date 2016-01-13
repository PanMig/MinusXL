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
		
		if(checkValidity(input) == true){
			
			// Values to be used if the next step doesn't go through:
			String tempString1 = "";
			String tempString2 = "a";
			
			// Doing this to be absolutely sure that
			// we're getting String values:
			if(input[0].getCell() instanceof String && input[1].getCell() instanceof String){
				tempString1 = (String)input[0].getCell();
				tempString2 = (String)input[1].getCell();
			}
			
			// Check if tempString1 (the first member of the input array) contains
			// tempString2 (the second member of the input array):
			return (tempString1.toLowerCase().contains(tempString2.toLowerCase()));
			
		} else {
			return null;
		}
	}
}
