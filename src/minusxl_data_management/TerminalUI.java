package minusxl_data_management;

public class TerminalUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("-- Beginning of testing program: --");	
		
		System.out.println("Creating a new Workbook");
		
		Workbook workbook = new Workbook(50,50);
		
		System.out.println("Setting a value: 20");
		workbook.getSpreadsheet(0).setValueAt(20, 20, 20);
		
		System.out.println("Setting a value: 33");
		workbook.getSpreadsheet(0).setValueAt(33, 21, 21);
		
		System.out.println("Printing the value back:");
		
		System.out.println(" ");
		System.out.println("Must print 20:");
		System.out.println(workbook.getSpreadsheet(0).getValueAt(20, 20));
		
		System.out.println("Must print 33:");
		System.out.println(workbook.getSpreadsheet(0).getValueAt(21, 21));
		
		System.out.println("-- End of testing program --");

		
	}

}
