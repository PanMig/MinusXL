package minusxl_data_management;

import java.util.ArrayList;
import java.util.Collections;

public class MedianFunction extends StatisticalFunction {

	private Cell[] input;

	public MedianFunction(Cell[] input) {
		// The constructor creates a instance of AbsFunction Object
		// and holds the Cells in the input data.
		// DON'T FORGET: The "input" is CELL DATA!!!
		this.input = input;
	}

	@Override
	public Object calculateValue() {

		if(checkValidity(input) == true){
			
			// First we have to sort the array.
			// To sort, we copy the input[] to an ArrayList:
			ArrayList<Double> inputArray = new ArrayList<Double>();
			
			for(int i=0; i<input.length; i++){
				inputArray.add((Double)input[i].getCell());
			}
			
			// Sort the temporary array:
			Collections.sort(inputArray);
			
			// Then use the MEDIAN value algorithm
			// where we take the value in the middle
			// of the list:
			int middle = (inputArray.size())/2;
			
		    if ((inputArray.size()) %2 == 1) {
		        return inputArray.get(middle);
		    } else {
		        return (( inputArray.get(middle-1) + inputArray.get(middle)) / 2.0 );
		    }
		    
		} else {
			return null;
		}
	}

}
