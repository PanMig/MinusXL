package minusxl_file_management;

import java.io.IOException;
import java.io.InputStreamReader;

import com.opencsv.CSVReader;

public class CsvFileReader {
	
	/**
	   * @param args
	   * @throws IOException 
	   */
	  public static void main(String[] filename) throws IOException {
	    /**
	     * Load CSV from classpath
	     */
	    CSVReader csvReader = new CSVReader(new InputStreamReader(
	        CsvFileReader.class.getClassLoader().getResourceAsStream("csvtest.txt")),';');
	    
	      String [] rowAsTokens;
	      while ((rowAsTokens = csvReader.readNext()) != null) {
	        for (String token : rowAsTokens) {
	          System.out.print(token + "#");
	        }
	        System.out.println();
	      }
	      csvReader.close();
	  }
}
