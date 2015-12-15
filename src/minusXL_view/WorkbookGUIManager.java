package minusXL_view;

import minusxl_data_management.Workbook;


//  A class that is used to add,hold,remove and show imformation for the workbook
// ,it is used from the GUI class and it uses the Workbook class

public class WorkbookGUIManager {
	private String workBookName;
	private int sheetRows;
	private int sheetColumns;
	private Workbook wbManager=null;
	
	public WorkbookGUIManager(String workBookName, int sheetRows, int sheetColumns) {
		this.setWorkBookName(workBookName);
		this.setSheetRows(sheetRows);
		this.setSheetColumns(sheetColumns);
	} 
	
   //creates a workbook instance with name,rows and columns for the first sheet	
   public void CreateWorkbook(String workBookName,int rows,int columns){
		Workbook wb=new Workbook(workBookName,rows,columns);
		wbManager=wb;
	}
	//the following two use polymorphism of the previous method
   
    public void CreateWorkbook(int rows,int columns){
		Workbook wb=new Workbook(rows,columns);
		wbManager=wb;
	}
	public void CreateWorkbook(){
		Workbook wb=new Workbook();
		wbManager=wb;
	}
	//it adds a spreadsheet to the workbook,the new spreadsheet is being added to the list of spreadsheets
	public void addSpreadsheet(int rows ,int columns){
		wbManager.addSpreadsheet(rows,columns);
	}
	//deletes a spreadsheet from the list
	public void deleteSpreadsheet(int spreadsheetNumber){
		wbManager.deleteSpreadsheet(spreadsheetNumber);
	}
	//prints the spreadsheets list size
	public void getListLength(){
		wbManager.getListLength();
	}

	//getters and setters
	
	public String getWorkBookName() {
		return workBookName;
	}

	public void setWorkBookName(String workBookName) {
		this.workBookName = workBookName;
	}

	public int getSheetRows() {
		return sheetRows;
	}

	public void setSheetRows(int sheetRows) {
		this.sheetRows = sheetRows;
	}

	public int getSheetColumns() {
		return sheetColumns;
	}

	public void setSheetColumns(int sheetColumns) {
		this.sheetColumns = sheetColumns;
	}
	
	
	


	
}
