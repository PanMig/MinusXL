package minusxl_data_management;

public class StdDevFunction extends StatisticalFunction {

	private Cell[] input;

	public StdDevFunction(Cell[] input) {
		this.input = input;
	}

	@Override
	public Object calculateValue() {

		if (checkValidity(input) == true){
			//Get the mean:
			int size = input.length;
			
			Double sum = 0.0;
			
			for (int i = 0; i < input.length; i++) {
				sum = sum + (double) input[i].getCell();
			}
	        
	        Double mean = sum/size;
	        
			//Get the variance
		    Double temp = 0d;
		    
		    for (int i = 0; i < input.length; i++) {
				temp = temp + (mean - (Double) input[i].getCell()) * (mean - (Double) input[i].getCell());
			}
		    
		    Double variance = temp/size;
	
		    //Get the standard deviation
		    return Math.sqrt(variance);
		} else {
			return null;
		}
	}
}
