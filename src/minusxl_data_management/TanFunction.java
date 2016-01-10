package minusxl_data_management;

public class TanFunction extends MathFunction {

	private Cell[] input;

	public TanFunction(Cell[] input) {
		// The constructor creates a instance of TanFunction Object
		// and holds the Cells in the input data.
		this.input = input;
	}

	@Override
	public Object calculateValue() {
		if(checkValidity(input) == true){
			// Takes the first object of the input, casts to a double value
			// converts to radians and then applies the Math.cos function
			return Math.tan((Math.toRadians((double) input[0].getCell())));
		} else {
			return null;
		}
	}

}
