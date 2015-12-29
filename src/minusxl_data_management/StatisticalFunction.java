package minusxl_data_management;

public abstract class StatisticalFunction extends Function {

	public abstract Object calculateValue();

	public boolean checkValidity(Object[] inputs) {

		for (int i = 0; i < inputs.length; i++) {
			// TODO: Checking if the values of the input are integers
			// Probably will have to change this later, to include double, float
			// etc.
			if ((inputs[i] instanceof Integer) == false || (inputs[i] instanceof Double) == false) {
				return (false);
			}
		}

		// Else...
		return (true);
	}
	
}
