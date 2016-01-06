package minusxl_data_management;

public class StdDevFunction extends StatisticalFunction {

	private Cell[] input;

	public StdDevFunction(Cell[] input) {
		// The constructor creates a instance of AbsFunction Object
		// and holds the Cells in the input data.
		// DON'T FORGET: The "input" is CELL DATA!!!
		this.input = input;
	}

	@Override
	public Object calculateValue() {

		//Get the mean:
		int size = input.length;
		
		double sum = 0.0;
        for(Cell<NumberCell> a : input){
            sum += a.getCell().getCell();
        	}
        double mean = sum/size;
        
		//Get the variance
	    double temp = 0;
	    for(Cell<NumberCell> a :input){
	        temp += (mean-a.getCell().getCell())*(mean-a.getCell().getCell());
	    	}
	    double variance = temp/size;

	    //Get the standard deviation
	    return Math.sqrt(variance);
	}
}
