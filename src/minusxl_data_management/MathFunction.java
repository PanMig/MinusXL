package minusxl_data_management;

public abstract class MathFunction extends Function {

	public abstract Object calculateValue();

	public boolean checkValidity(Cell[] inputs) {

		for (int i = 0; i < inputs.length; i++) {
			// Checking if the values of the input are NumberCells
			// (which contain Double values).
			// For the sake of simplicity, we have made a design choice
			// to only deal with Double values, which can always be converted
			// to an Integer, if some need arises:
			if ((inputs[i] instanceof NumberCell) == false) {
				System.out.println("Error: The input data are not number values.");
				return (false);
			}
		}

		// Else...
		return (true);
	}

}
