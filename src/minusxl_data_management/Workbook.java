package minusxl_data_management;

import java.io.IOException;
import java.util.ArrayList;

import minusxl_file_management.CsvFileCreator;
import minusxl_file_management.CsvFileReader;

public class Workbook {
	// The Workbook class is the basis of the Data Management system. It
	// contains a List of Spreadsheets and
	// all the necessary methods to act on the data.
	// The GUI takes a Current Workbook object and just displays what it sees,
	// or changes data on it through
	// the contained methods.

	private final int DEFAULT_ROWS = 100;
	private final int DEFAULT_COLUMNS = 26;

	private String name = "MinusXL_Workbook";
	// The name of the Workbook. Default name given here. Optionally initialized
	// through the constructor.

	private ArrayList<Spreadsheet> spreadsheets;
	// This is the List of Spreadsheets that makes up the data of the Workbook.

	public Workbook() {
		spreadsheets = new ArrayList<Spreadsheet>();
		spreadsheets.add(new Spreadsheet(DEFAULT_ROWS, DEFAULT_COLUMNS));
		// Constructor without parameters, creates a default valued spreadsheet.

		System.out.println("Workbook Object Inititalized (Constructor)");
	}

	public Workbook(String name, int rows, int columns) {
		// The constructor creates a Workbook with a Name, and one attached
		// spreadsheet with x rows and y columns
		spreadsheets = new ArrayList<Spreadsheet>();
		spreadsheets.add(new Spreadsheet(rows, columns));
		this.name = name;

		System.out.println("Workbook Object Inititalized (Constructor)");
	}

	public Workbook(int rows, int columns) {
		// This polymorphic constructor doesn't have a name argument, thus uses the Default name
		// and creates a Workbook with one attached spreadsheet with x rows and y columns
		spreadsheets = new ArrayList<Spreadsheet>();
		spreadsheets.add(new Spreadsheet(rows, columns));

		// TESTING:
		System.out.println("Workbook Object Inititalized (Constructor)");
	}

	public void addSpreadsheet(int rows, int columns) {
		// Creating a new spreadsheet and attaching it to the last position in
		// our list
		spreadsheets.add(new Spreadsheet(rows, columns));
	}

	public void getListLength(){
		System.out.println(spreadsheets.size());
	}

	public void addSpreadsheet(Spreadsheet spreadsheet) {
		// Attaching an existing spreadsheet to the last position in our list
		spreadsheets.add(spreadsheet);
	}

	public void deleteSpreadsheet(int spreadsheetNumber) {
		// Removes a spreadsheet from a specific position in our list
		spreadsheets.remove(spreadsheetNumber);
	}

	public Spreadsheet getSpreadsheet(int spreadsheetNumber) {
		// Returns the spreadsheet in a specific position
		return spreadsheets.get(spreadsheetNumber);
	}

	public int getAttachedSpreadsheets() {
		// Returns how many spreadsheets are currently attached
		return spreadsheets.size();
	}

	public String getWorkbookName() {
		// Returns the name of the workbook
		return name;
	}
	
	public void saveWorkbook(String saveLocation) {
		// If we want to SAVE/Export the Workbook as CSV Files (one for each of its Spreadsheets)
		// we pass the "this" argument (that refers to the Workbook object itself) to the static
		// CSV File Creator.
		try {
			// The "saveLocation" argument refers to the filesystem folder where we want
			// the files to be saved. We should pass this as a String from the GUI call:
			CsvFileCreator.createCsvFile(this, saveLocation);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void importSpreadsheet(String filepath) {
		// If we want to import a Spreadsheet from a CSV file, we pass the file's "filepath"
		// to this method from the GUI, and the new Spreadsheet is automatically attached to
		// the current Workbook:
		try {
			addSpreadsheet(CsvFileReader.readCsvFile(filepath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void openSpreadsheet(String filepath) {
		// The OpenSpreadsheet method is different to the importSpreadsheet
		// in that it creates a whole new Workbook and then imports and attaches
		// the chosen CSV File. (In contrast, the "importSpreadsheet" one, attaches
		// the imported file to the current open workbook)
		try {
			// Clear the current list of spreadsheets, and attach only the imported one:
			spreadsheets.clear();
			addSpreadsheet(CsvFileReader.readCsvFile(filepath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
