package minusxl_data_management;

public abstract class StatisticalFunction extends Function {

	public abstract Object calculateValue();

	public boolean checkValidity(Object[] inputs) {

		for (int i = 0; i < inputs.length; i++) {
			// TODO: Checking if the values of the input are integers
			// Probably will have to change this later, to include double, float
			// etc.
			if ((inputs[i] instanceof NumberCell) == false) {
				System.out.println("Error: The input data are not number values.");
				return (false);
			}
		}

		// Else...
		return (true);
	}

}
