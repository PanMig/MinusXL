package minusxl_data_management;

public abstract class AlpharithmeticFunction extends Function {

	public abstract Object calculateValue();

	public boolean checkValidity(Cell[] inputs) {

		for (int i = 0; i < inputs.length; i++) {

			// Checking if the values of the input cells are strings:
			if ((inputs[i] instanceof StringCell) == false ) {

				System.out.println("Error: The input data are not alpharithmetic values.");
				return (false);
			}
		}

		// Else...
		return (true);
	}

}
