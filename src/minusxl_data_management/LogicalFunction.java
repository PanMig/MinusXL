package minusxl_data_management;

public abstract class LogicalFunction extends Function {

	public abstract Object calculateValue();

	public boolean checkValidity(Cell[] inputs) {

		if(inputs != null){
			for (int i = 0; i < inputs.length; i++) {
				// Checking if the values of the input cells are boolean values:
				if ((inputs[i] instanceof BooleanCell) == false) {
					System.out.println("Error: The input data are not boolean values.");
					return (false);
				}
				
				if(inputs[i].getCell() == null){
					System.out.println("Error: The input data contains null values.");
					return (false);
				}
			}
	
			// Else...
			return (true);
		} else {
		// This happens if "inputs" is NULL:
		return (false);
		}
	}
}
