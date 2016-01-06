package minusxl_file_management;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.opencsv.CSVReader;

import minusxl_data_management.Spreadsheet;

public class CsvFileReader {

	public static Spreadsheet readCsvFile(String filepath) throws IOException {

		CSVReader csvReader = new CSVReader(
				new InputStreamReader(CsvFileReader.class.getClassLoader().getResourceAsStream(filepath)), ';');
				
		List<String[]> myEntries = csvReader.readAll();
		
		// First I want to find the rows and columns of the CSV file:
		int rows = myEntries.size();
		int columns = myEntries.get(0).length;
		
		// Then, I want to create a Spreadsheet with that number
		// of rows and columns:
		Spreadsheet importedCSV = new Spreadsheet(rows, columns);
		
		// Then, I want to iterate through the imported data
		// and copy them to the importedCSV temporary Spreadsheet.
		// When reusing this code, be careful to look at it with attention,
		// to understand it
		// since the list of lists and the arrays together can be confusing:
		for(int i=0; i<myEntries.size(); i++){
			for(int y=0; y<myEntries.get(i).length; y++){
				importedCSV.setValueAt(myEntries.get(i)[y], i, y);
			}
	     }
		
		// Close the reader:
		csvReader.close();
		
		// Returns a Spreadsheet with all the data.
		// In the UI, you just have to take what this Class returns
		// and attach it to the last place of the current Workbook:
		return importedCSV;
		
		// Hohohoho! Eimai kai poli gamatos programmer. >:D
		
	}
}
