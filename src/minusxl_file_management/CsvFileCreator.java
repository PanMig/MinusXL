package minusxl_file_management;

import java.io.FileWriter;
import java.util.ArrayList;

import com.opencsv.CSVWriter;

import minusxl_data_management.*;

public class CsvFileCreator {

	public static void createCsvFile(Workbook workbook, String saveLocation) throws Exception
	   {
		
		// We will take a Workbook and iterate through every Spreadsheet
		// and write each of those Spreadsheets to a file, using the name
		// of the Workbook and a number next to it for each of the Spreadsheets:
		
		// Here we see how many Spreadsheets (from the current Workbook)
		// we will go through in the upcoming loop - and the name of the workbook:
		int numberOfSpreadsheets = workbook.getAttachedSpreadsheets();
		String workbookName = workbook.getWorkbookName();
		
		// All-encompassing loop: Go through every spreadsheet:
		for(int i=0; i<numberOfSpreadsheets; i++){
			
			Spreadsheet spreadsheet = workbook.getSpreadsheet(i);
			
			// Get rows and columns of the spreadsheet:
			int rows = spreadsheet.getRowCount();
			int columns = spreadsheet.getColumnCount();
			
			// We take the folder "save location" as an argument in
			// the method call of the class. And we append the name
			// of the file to that, in the FileWriter:
		    String csv = saveLocation+workbookName+"-"+i+".csv";
		    CSVWriter writer = new CSVWriter(new FileWriter(csv),';',' ');
		    
		    // The writeAll (of openCSV) needs a List of String[]:
		    ArrayList<String[]> record = new ArrayList<String[]>(); 
		    
		    // Outside loop: Go through every row:
		    for(int j=0; j<rows; j++){
		    	
			    // Used for the record of row data:
			    String[] lineData = new String[columns]; 
		    	
		    	// Inside loop: Read every column in the current row
		    	for(int k=0; k<columns; k++){
		    			//Create record and check for NULL cells (because they can't be converted to String):
		    			if( spreadsheet.getValueAt(j, k) == null){
		    				lineData[k] = "";
		    			} else {
		    				lineData[k] = spreadsheet.getValueAt(j, k).toString();
		    			}
		    		}
		    	
			    record.add(lineData);
			    
			    // Clear the pointer:
			    lineData = null;
		    	}
		    
	    	//Write the whole list of lines and columns to the file:
		    writer.writeAll(record);
		        
		    //close the writer
		    writer.close();
			}
	   }
}
