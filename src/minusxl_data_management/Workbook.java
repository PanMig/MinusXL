package minusxl_data_management;

import java.util.ArrayList;

public class Workbook {
	// The Workbook class is the basis of the Data Management system. It contains a List of Spreadsheets and
	// all the necessary methods to act on the data.
	// The GUI takes a Current Workbook object and just displays what it sees, or changes data on it through
	// the contained methods.
	
	private String name="MinusXL_Workbook";
	// The name of the Workbook. Default name given here. Optionally initialized through the constructor.
	
	private ArrayList<Spreadsheet> spreadsheets = new ArrayList<Spreadsheet>();
	// This is the List of Spreadsheets that makes up the data of the Workbook.
	
	public Workbook(String name, int rows, int columns){
	// The constructor creates a Workbook with a Name, and one attached spreadsheet with x rows and y columns
			
		spreadsheets.add(
				new Spreadsheet(rows, columns)
				);
		
	};
	
	
	public Workbook(int rows, int columns){
	// This polymorphic constructor doesn't have a name argument, thus uses the Default name
	// and creates a Workbook with one attached spreadsheet with x rows and y columns
		
	};

	public static void main(String[] args) {

		
		
	}

}
