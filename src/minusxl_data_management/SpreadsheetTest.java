package minusxl_data_management;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class SpreadsheetTest {
	
	Spreadsheet spreadsheet;

	@Before
	public void setUp() throws Exception {
		spreadsheet = new Spreadsheet(50,60);
	}

	@Test
	public void testGetRowCount() {
		assertEquals(50, spreadsheet.getRowCount());
	}

	@Test
	public void testGetColumnCount() {
		assertEquals(60, spreadsheet.getColumnCount());
	}

	@Test
	public void testGetValueAt() {
		spreadsheet.setValueAt(150, 1, 1);
		assertEquals(150.0, spreadsheet.getValueAt(1, 1));
	}

	@Test
	public void testSetValueAt() {
		spreadsheet.setValueAt("blah", 1, 1);
		assertEquals("blah", (String)spreadsheet.getValueAt(1, 1));
	}

	@Test
	public void testGetCell() {
		spreadsheet.setValueAt("blah", 1, 1);
		assertTrue(spreadsheet.getCell(1, 1) instanceof StringCell);
	}

}
