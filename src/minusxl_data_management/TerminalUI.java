package minusxl_data_management;

public class TerminalUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("-- Beginning of testing program: --");
		System.out.println("Creating a new Workbook");

		Workbook workbook = new Workbook(10, 10);

		System.out.println("Setting a value: 20");
		workbook.getSpreadsheet(0).setValueAt(20, 1, 1);

		System.out.println("Must print 20:");
		System.out.println(workbook.getSpreadsheet(0).getValueAt(1, 1));

		System.out.println("Setting a value: 43");
		workbook.getSpreadsheet(0).setValueAt(43, 5, 4);

		System.out.println("Setting a value: Barbamitsos");
		workbook.getSpreadsheet(0).setValueAt("Barbamitsoooos!", 5, 4);

		System.out.println("Must print 43:");
		System.out.println(workbook.getSpreadsheet(0).getValueAt(5, 4));

		System.out.println("And attach a new spreadsheet with the value 888 at (5,4)");
		workbook.addSpreadsheet(13, 13);
		workbook.getSpreadsheet(1).setValueAt(888, 5, 4);

		workbook.getSpreadsheet(0).setValueAt(3, 0, 0);
		workbook.getSpreadsheet(0).setValueAt(4, 0, 1);
		workbook.getSpreadsheet(0).setValueAt(6, 0, 2);

		Cell[] inputsforfunction = new Cell[3];
		inputsforfunction[0] = workbook.getSpreadsheet(0).getCell(0, 0);
		inputsforfunction[1] = workbook.getSpreadsheet(0).getCell(0, 1);
		inputsforfunction[2] = workbook.getSpreadsheet(0).getCell(0, 2);
		
		workbook.getSpreadsheet(0).useFunction(inputsforfunction, "Mult", workbook.getSpreadsheet(0).getCell(0, 3));
		
		inputsforfunction[0] = workbook.getSpreadsheet(0).getCell(0, 3);
		
		workbook.getSpreadsheet(0).useFunction(inputsforfunction, "Trim", workbook.getSpreadsheet(0).getCell(1,0));

		System.out.println("And now we'll print everything:");

		// Testing: Print all spreadsheets and their data
		int w = 0;
		while (w < workbook.getAttachedSpreadsheets()) {

			System.out.println(" ");
			System.out.println("Spreadsheet #" + (w + 1) + ":");

			for (int i = 0; i < workbook.getSpreadsheet(w).getRowCount(); i++) {
				for (int y = 0; y < workbook.getSpreadsheet(w).getColumnCount(); y++) {
					System.out.print(workbook.getSpreadsheet(w).getValueAt(i, y) + " ");
				}
				System.out.println(" ");
			}

			w++;
		}

		System.out.println("-- End of testing program --");

	}

}
