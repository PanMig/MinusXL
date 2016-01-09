package minusxl_data_management;

public abstract class StatisticalFunction extends Function {

	public abstract Object calculateValue();

	public boolean checkValidity(Cell[] inputs) {

		if (inputs != null){
			for (int i = 0; i < inputs.length; i++) {
				// Checking if the values of the input are NumberCells
				// (which contain Double values).
				if ((inputs[i] instanceof NumberCell) == false) {
					System.out.println("Error: The input data are not number values.");
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
			// This happens if "inputs" is null:
			return (false);
		}
	}
}
