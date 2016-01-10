package minusxl_data_management;

public abstract class AlpharithmeticFunction extends Function {

	public abstract Object calculateValue();

	public boolean checkValidity(Cell[] inputs) {

		if (inputs != null) {
			for (int i = 0; i < inputs.length; i++) {

				// Checking if the values of the input cells are NOT strings:
				if ((inputs[i] instanceof StringCell) == false) {

					System.out.println("Error: The input data are not alpharithmetic values.");
					return (false);
				}

				if (inputs[i].getCell() == null) {
					System.out.println("Error: The input data contains null values.");
					return (false);
				}
			}

			// Else (if everything is OK)...
			return (true);
		} else {
			// This happens if "inputs" is NULL:
			return (false);
		}
	}
}
