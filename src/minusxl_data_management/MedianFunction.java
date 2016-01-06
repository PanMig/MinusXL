package minusxl_data_management;

import java.util.Arrays;

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
		
		// First we have to sort the array:
		Arrays.sort(input);
		
		// The median is the middle number in a sorted series of numbers:
		Double median;
		
		// If the array is even or odd numbered, we search in a different way:
		if (input.length % 2 == 0) {
		    median = ((Double)input[input.length/2].getCell() + (Double)input[input.length/2 - 1].getCell())/2;
		}
		else {
		    median = (Double) input[input.length/2].getCell();
		}
		
		return median;
	}

}
