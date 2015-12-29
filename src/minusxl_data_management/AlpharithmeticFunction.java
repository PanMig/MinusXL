package minusxl_data_management;

public abstract class AlpharithmeticFunction extends Function {
	
	public abstract Object calculateValue();

	public boolean checkValidity(Object[] inputs) {

		for (int i = 0; i < inputs.length; i++) {
			// Checking if the values of the input are strings:
			if ((inputs[i] instanceof String) == false ) {
				return (false);
			}
		}

		// Else...
		return (true);
	}

}
