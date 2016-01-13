package minusxl_data_management;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaxFunctionTest {

	@Test
	public void testCalculateValue() {
		
		Cell[] input = new Cell[5];
		input[0] = new NumberCell(0,0);
		input[1] = new NumberCell(0,0);
		input[2] = new NumberCell(0,0);
		input[3] = new NumberCell(0,0);
		input[4] = new NumberCell(0,0);
		
		input[0].setCell(1.0);
		input[1].setCell(2.0);
		input[2].setCell(5.0);
		input[3].setCell(100.0);
		input[4].setCell(49.0);
		
		Function maxFunction = new MaxFunction(input);
		
		assertEquals(100.0, maxFunction.calculateValue());
	
	}

}
