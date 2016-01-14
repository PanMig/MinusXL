package minusxl_data_management;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class IncludesFunctionTest {

	@Test
	public void testCalculateValue() {
		
		Cell[] input = new Cell[2];
		input[0] = new StringCell(0,0);
		input[1] = new StringCell(0,0);
		
		input[0].setCell("abcdefghijk");
		input[1].setCell("lmnopqrs");
		
		Function includesFunction = new IncludesFunction(input);
		assertFalse((Boolean)includesFunction.calculateValue());
		
		input[0].setCell("abcd");
		input[1].setCell("cdef");
		
		includesFunction = new IncludesFunction(input);
		assertFalse((Boolean)includesFunction.calculateValue());
		
		input[0].setCell("abcdefg");
		input[1].setCell("efg");
		
		includesFunction = new IncludesFunction(input);
		assertTrue((Boolean)includesFunction.calculateValue());
		
		input[0].setCell("abcd");
		input[1].setCell("333");
		
		includesFunction = new IncludesFunction(input);
		assertFalse((Boolean)includesFunction.calculateValue());
	
	}

}
