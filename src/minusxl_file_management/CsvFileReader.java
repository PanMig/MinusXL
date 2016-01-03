package minusxl_file_management;

import java.io.IOException;
import java.io.InputStreamReader;

import com.opencsv.CSVReader;

public class CsvFileReader {
	
	/**
	   * @param args
	   * @throws IOException 
	   */
	  public static void readCsvFile(String filepath) throws IOException {
	    
	    CSVReader csvReader = new CSVReader(new InputStreamReader(
	        CsvFileReader.class.getClassLoader().getResourceAsStream(filepath)),';');
	    
	      String [] rowAsTokens;
	      while ((rowAsTokens = csvReader.readNext()) != null) {
	        for (String token : rowAsTokens) {
	          System.out.print(token + "");
	        }
	        System.out.println();
	        System.out.println("End of loop");
	        
	      }
	      csvReader.close();
	  }
}
