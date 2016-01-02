package minusxl_file_management;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class CsvFileCreator {
	
	public static void main(String[] args) throws Exception
	   {
	      String csv = "data.csv";
	      CSVWriter writer = new CSVWriter(new FileWriter(csv));
	        
	      //Create record
	      String [] record = "4,David,Miller,Australia,30".split(",");
	      //Write the record to file
	      writer.writeNext(record);
	        
	      //close the writer
	      writer.close();
	   }

}
