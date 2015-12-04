package minusxl_data_management;

import java.util.ArrayList;

public class Workbook {
	// The Workbook class is the basis of the Data Management system. It contains a List of Spreadsheets and
	// all the necessary methods to act on the data.
	// The GUI takes a Current Workbook object and just displays what it sees, or changes data on it through
	// the contained methods.
	
	private final int DEFAULT_ROWS=100;
	private final int DEFAULT_COLUMNS=100;
	
	private String name="MinusXL_Workbook";
	// The name of the Workbook. Default name given here. Optionally initialized through the constructor.
	
	private ArrayList<Spreadsheet> spreadsheets;
	// This is the List of Spreadsheets that makes up the data of the Workbook.
	
	public Workbook(){
		spreadsheets = new ArrayList<Spreadsheet>();
		spreadsheets.add( new Spreadsheet(DEFAULT_ROWS, DEFAULT_COLUMNS) );
		// Constructor without parameters, creates a default valued spreadsheet.
	}
	
	public Workbook(String name, int rows, int columns){
	// The constructor creates a Workbook with a Name, and one attached spreadsheet with x rows and y columns
		spreadsheets = new ArrayList<Spreadsheet>();
		spreadsheets.add( new Spreadsheet(rows, columns) );
		this.name = name;
	}
	
	public Workbook(int rows, int columns){
	// This polymorphic constructor doesn't have a name argument, thus uses the Default name
	// and creates a Workbook with one attached spreadsheet with x rows and y columns
		spreadsheets = new ArrayList<Spreadsheet>();
		spreadsheets.add( new Spreadsheet(rows, columns) );
		
		//TESTING:
		System.out.println("Workbook Object Inititalized (Constructor)");
		
	}
	
	public void addSpreadsheet(int rows, int columns){
		// Creating a new spreadsheet and attaching it to the last position in our list
		spreadsheets.add( new Spreadsheet(rows, columns) );
	}
	
	public void addSpreadsheet(Spreadsheet spreadsheet){
		// Attaching an existing spreadsheet to the last position in our list
		spreadsheets.add( spreadsheet );
	}
	
	public void deleteSpreadsheet(int spreadsheetNumber){
		// Removes a spreadsheet from a specific position in our list
		spreadsheets.remove(spreadsheetNumber);
	}
	
	public Spreadsheet getSpreadsheet(int spreadsheetNumber){
		// Returns the spreadsheet in a specific position
		return spreadsheets.get(spreadsheetNumber);
	}
	
	public int getAttachedSpreadsheets(){
		// Returns how many spreadsheets are currently attached
		return spreadsheets.size();
	}
	
	public void saveWorkbook(){
		// To be implemented later.
	}
	
	public void importSpreadsheet(){
		// To be implemented later.
	}

}
