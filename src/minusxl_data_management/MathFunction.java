package minusxl_data_management;

public abstract class MathFunction extends Function {

	public abstract Object calculateValue();

	public boolean checkValidity(Cell[] inputs) {

		if(inputs != null){
			for (int i = 0; i < inputs.length; i++) {
				// Checking if the values of the input are NumberCells
				// (which contain Double values).
				// For the sake of simplicity, we have made a design choice
				// to only deal with Double values, which can always be converted
				// to an Integer, if some need arises:
				
				if(inputs[i] == null){
					System.out.println("Error: The input data contains null values.");
					return (false);
				}
				
				if ((inputs[i] instanceof NumberCell) == false) {
					System.out.println("Error: The input data are not number values.");
					return (false);
					}
				
				if(inputs[i].getCell() == null){
					System.out.println("Error: The input data contains null values.");
					return (false);
				}
			}
	
			// This only happens if "inputs" is not NULL, and no
			// exception situation arises:
			return (true);
		} else {
			// This happens if the "inputs" had null value:
			return (false);
		}
	}
}
