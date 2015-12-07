package minusxl_data_management;

public class PowFunction extends MathFunction {

	private Cell[] input;
	
	// TODO: Maybe move the "checkValidity()" inside the child-classes
	
	public PowFunction(Cell[] input){
		// The constructor creates a instance of AbsFunction Object
		// and holds the Cells in the input data.
		// DON'T FORGET: The "input" is CELL DATA!!!
		this.input = input;
	}
	
	@Override
	public Object calculateValue() {
		return Math.pow((float)input[0].getCell(), (float)input[1].getCell());
	}

}
