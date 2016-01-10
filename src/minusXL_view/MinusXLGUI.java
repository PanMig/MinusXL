package minusXL_view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;

import minusXl_charts_managment.ChartManager;
import minusxl_data_management.Cell;
import minusxl_data_management.Spreadsheet;
import minusxl_data_management.Workbook;
import minusxl_file_management.CsvFileCreator;
import minusxl_file_management.CsvFileReader;

public class MinusXLGUI {

	private JFrame frame;// the window

	private String workBookName;

	private String sheetName;// name of the spreadsheet
	private int sheetRows;
	private int sheetColumns;
	private int sheetNumber = 0;// keeps the number of the spreadsheet,becomes
								// zero
	// when new workbook is created

	private Workbook workbookManager;

	private Spreadsheet sheetManager;

	private JTable tableManager;

	// list to keep the selected cells values
	private ArrayList<Cell> selectedCellsList;

	// list of the jtables used,created for the correct referencing to the
	// selected jtable
	private ArrayList<JTable> tableList;

	// objects for opening files and creating a tabbed pane
	JFileChooser fileChooser = new JFileChooser("C:\\Users\\Panos\\git\\MinusXL\\bin");
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MinusXLGUI window = new MinusXLGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MinusXLGUI() {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		// initialize the frame,select Layout
		sheetNumber = 0;
		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().setBackground(UIManager.getColor("Button.background"));
		frame.setForeground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 571, 412);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		// when mouse clicked on the tabbed pane make the spreadsheet reference
		// to look
		// at the correct spreadsheet
		tabbedPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// make spreadsheet reference point to the correct spreadsheet
				// on the list
				sheetManager = workbookManager.getSpreadsheet(tabbedPane.getSelectedIndex());
				// make jtable reference point to the correct jtable on the list
				tableManager = tableList.get(tabbedPane.getSelectedIndex());
			}
		});
		

		// add tabbed pane to the center of the borderLayout
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		// create all the buttons in the bottom of the screen
		spreadsheetActionPanel();

		// create the menu bar in the top of the screen
		createMenuBar();

		// add a new workbook and a sheet in the workbook when the program opens
		// for the first time

		initWorkbook();
	}

	// initiate the first workbook when the program opens for the first time
	public void initWorkbook() {
		Workbook wb = new Workbook();
		// creates a new list of jtable,used to keep the reference pointing to
		// the correct table
		tableList = new ArrayList<JTable>();
		// make the workbook reference point to the correct workbook
		workbookManager = wb;
		// make the spreadsheet reference point to the correct spreasheet in the
		// list
		// of spreadsheets
		sheetManager = workbookManager.getSpreadsheet(wb.getAttachedSpreadsheets() - 1);
		addSheet();
	}

	// add to the tabbed pane a spreadsheet (jtable) with default rows and
	// columns.
	// This method is only for the GUI class it does not affect other classes

	public void addSheet() {

		// create scroll and tabbed panes
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("sheet", null, scrollPane, null);

		JTable table = new JTable();
		
		// Make the Grid lines show up in MAC:
		table.setGridColor(Color.GRAY);

		// add table to the list
		tableList.add(table);
		// make the reference point to the correct table
		tableManager = tableList.get(0);
		// attach jtable to the spreadsheet instance that we create in the above
		// line
		table.setModel(sheetManager);
		
		// cannot select an entire row
		table.setRowSelectionAllowed(false);
		// select multiple cells in the array
		table.getColumnModel().setColumnSelectionAllowed(true);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		// enables individual cell selection
		table.setCellSelectionEnabled(true);
		//// attach to the scrool pane the Jtable
		scrollPane.setViewportView(table);
		table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
		sheetNumber += 1;// its an number that keeps the amount of the
							// spreadsheets
		// in the current workbook
	}

	public void addSheet(String sheetName, int rows, int columns) {
		// create scroll and tabbed panes
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab(sheetName, null, scrollPane, null);
		// when tab is added make the tabbed pane selection to the last added
		// tab
		tabbedPane.setSelectedIndex(workbookManager.getAttachedSpreadsheets() - 1);
		
		// Make the table lines seen on Mac:
		tableManager.setGridColor(Color.GRAY);

		sheetManager = workbookManager.getSpreadsheet(workbookManager.getAttachedSpreadsheets() - 1);
		JTable table = new JTable();
		table.getColumnModel().setColumnSelectionAllowed(true);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		// add table to the list
		tableList.add(table);
		// make the reference point to the correct table
		tableManager = tableList.get(tableList.size() - 1);
		// attach jtable to the spreadsheet instance that we create in the above
		// line
		tableManager.setGridColor(Color.GRAY);
		table.setModel(sheetManager);
		table.setRowSelectionAllowed(false);
		table.setCellSelectionEnabled(true);

		// attach to the scrool pane the Jtable
		scrollPane.setViewportView(table);
		table.setAutoResizeMode(table.AUTO_RESIZE_OFF);

		sheetNumber += 1;
	}

	private void spreadsheetActionPanel() {

		// init panel
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 28, 8, 95, 83, 0 };
		gbl_panel.rowHeights = new int[] { 23, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		// delete button,deletes a spreadsheet from the tabbed pane
		JButton btnDeleteSpreadsheet = new JButton("Delete spreadsheet");
		btnDeleteSpreadsheet.setToolTipText("press to delete a spreadsheet");

		// select color for the button
		btnDeleteSpreadsheet.setBackground(UIManager.getColor("Button.light"));
		btnDeleteSpreadsheet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int option;
				int tabIndex = tabbedPane.getSelectedIndex();// holds the
																// selected tab
				// option holds the choice of the user, 0 is yes ,1 is no , 2 is
				// cancel
				option = JOptionPane.showConfirmDialog(tabbedPane, "Do you want to delete the choosen spreadsheet?");
				if (option == 0) {
					tabbedPane.remove(tabIndex);// remove tab from the tabbed
												// pane
					workbookManager.deleteSpreadsheet(tabIndex);// delete
																// spreadsheet
																// from the list
																// of
																// spreadsheets
					sheetNumber -= 1;
				}
			}
		});

		
		// button that adds a spreadsheet
		JButton addButton = new JButton("+");
		// when mouse mouse above the button shows a message.
		addButton.setToolTipText("Press to add spreadsheet");
		addButton.setBackground(UIManager.getColor("Button.light"));
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//this part of the code add a new spreadsheet to the tabbebPane
				//the multiple if's are used to handle the cases where the user
				//presses cancel or closes the inputDialog
				sheetName = JOptionPane.showInputDialog("Enter a name for spreadsheet");
			if(sheetName!=null){	
				
				if (sheetName.length() == 0) {
					sheetName = "sheet" + sheetNumber;
				}

				String StringsheetRows = JOptionPane.showInputDialog(null, "Enter rows for your spreadsheet",
					"100");
				
				if(StringsheetRows!=null){
					
				
					if (StringsheetRows.length() == 0)
						sheetRows = 100;
					// TODO CHECK IF USERS PUTS STRING that's not an number
					else
						sheetRows = Integer.parseInt(StringsheetRows);
	
					String StringsheetColumns = JOptionPane.showInputDialog(null,"Enter columns for your spreadsheet",
					"26");
					
					if(StringsheetColumns!=null){
					
						if (StringsheetColumns.length() == 0)
							sheetColumns = 26;
						// TODO CHECK IF USERS PUTS STRING that's not an number
						else
							sheetColumns = Integer.parseInt(StringsheetColumns);
		
						workbookManager.addSpreadsheet(sheetRows, sheetColumns);// add
																				// spreadsheet
																				// to
																				// the
																				// list
						addSheet(sheetName, sheetRows, sheetColumns);// add tab to the  tabbed pane
					}
				}
			}
			
		}
	});
		addButton.setForeground(Color.RED);
		GridBagConstraints gbc_addButton = new GridBagConstraints();
		gbc_addButton.anchor = GridBagConstraints.NORTHEAST;
		gbc_addButton.insets = new Insets(0, 0, 0, 5);
		gbc_addButton.gridx = 0;
		gbc_addButton.gridy = 0;
		panel.add(addButton, gbc_addButton);

		GridBagConstraints gbc_btnDeleteSpreadsheet = new GridBagConstraints();
		gbc_btnDeleteSpreadsheet.gridwidth = 2;
		gbc_btnDeleteSpreadsheet.insets = new Insets(0, 0, 0, 5);
		gbc_btnDeleteSpreadsheet.gridx = 1;
		gbc_btnDeleteSpreadsheet.gridy = 0;
		panel.add(btnDeleteSpreadsheet, gbc_btnDeleteSpreadsheet);

		//this part implements the insertion of a spreasheet from a file
		//to the workBook
		JButton btnImportSheet = new JButton("Import Sheet");
		btnImportSheet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileChooser.showOpenDialog(null);
				File choosenFile = fileChooser.getSelectedFile();
				//check if user presses cancel or close
				if(choosenFile!=null){
				
					try {
						//add to workBook
						workbookManager.addSpreadsheet(CsvFileReader.readCsvFile(choosenFile.getName()));
						//fix reference
						sheetManager = workbookManager.getSpreadsheet(workbookManager.getAttachedSpreadsheets() - 1);
						//add to the jtable
						addSheet("Imported sheet", sheetManager.getRowCount(), sheetManager.getColumnCount());
						// update the ui so the table will reviece the cchange and
						// print it
						// imediatly
						tableManager.updateUI();
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Import failed");
						e1.printStackTrace();
					}
				}
			}
		});
		GridBagConstraints gbc_ImportSheet = new GridBagConstraints();
		gbc_ImportSheet.gridx = 3;
		gbc_ImportSheet.gridy = 0;
		panel.add(btnImportSheet, gbc_ImportSheet);

	}

	private void createMenuBar() {

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		// New Workbook button

		JButton btnNew = new JButton("New WorkBook");// "New workbook"
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//add a new workBook to the program
				
				// holds workbook name
				workBookName = JOptionPane.showInputDialog("Enter new workBook name", "Workbook");
				
				if(workBookName!=null){
				
					if (workBookName.length() == 0)
						workBookName = "Workbook";
					
					// holds rows for the new sheet
					String StringsheetRows = JOptionPane.showInputDialog("Enter rows for your spreadsheet", "100");
					
					if(StringsheetRows!=null){
					
						if (StringsheetRows.length() == 0)
							sheetRows = 100;
						// TODO CHECK IF USERS PUTS STRING that's not an number
						else
							sheetRows = Integer.parseInt(StringsheetRows);
						// holds columns for sheet
						String StringsheetColumns = JOptionPane.showInputDialog("Enter columns for your spreadsheet", "26");
						
						if(StringsheetColumns!=null){
						
							if (StringsheetColumns.length() == 0)
								sheetColumns = 26;
							// TODO CHECK IF USERS PUTS STRING that's not an number
							else
								sheetColumns = Integer.parseInt(StringsheetColumns);
			
							// multiple cases where the user either insert a value at the
							// input dialog and presses "ok" or just presses "ok"
							if (workBookName.length() == 0 && StringsheetRows.length() == 0 && StringsheetColumns.length() == 0) {
								sheetNumber = 0;
								Workbook wb = new Workbook();
								// create a new tables list
								tableList = new ArrayList<JTable>();
								// created
								workbookManager = wb;// the reference now points to that
														// specific object
								tabbedPane.removeAll();
								addSheet();
			
							} else if (workBookName.length() == 0 && StringsheetRows.length() != 0
									&& StringsheetColumns.length() != 0) {
								sheetNumber = 0;
								Workbook wb = new Workbook(sheetRows, sheetColumns);
								// create a new tables list
								tableList = new ArrayList<JTable>();
								// created
								workbookManager = wb;
								tabbedPane.removeAll();
								addSheet("sheet", sheetRows, sheetColumns);
							} 
							else {
								sheetNumber = 0;
								Workbook wb = new Workbook(workBookName, sheetRows, sheetColumns);
								// create a new tables list
								tableList = new ArrayList<JTable>();
								// created
								workbookManager = wb;
								tabbedPane.removeAll();
								addSheet("sheet", sheetRows, sheetColumns);
							}
						}
					}
			}
			}
		});
		menuBar.add(btnNew);

		// Open button
		JButton btnOpen = new JButton("Open");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileChooser.showOpenDialog(null);// opens files for inserting a
													// workbook

			}
		});
		menuBar.add(btnOpen);

		// Save button
		JButton btnSave = new JButton("Save");
		btnSave.setIcon(
				new ImageIcon(MinusXLGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/FloppyDrive.gif")));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// JOptionPane.showInputDialog("Enter a name for the workbook");
				fileChooser.showSaveDialog(null);
				try {
					System.out.println("file ready to save");
					CsvFileCreator.createCsvFile(workbookManager,"");
					JOptionPane.showMessageDialog(null, "Workbook Saved");
				} catch (Exception e) {
					System.out.println("file not saved");
					JOptionPane.showMessageDialog(null, "Error saving the Workbook");
					e.printStackTrace();
				}
			}
		});
		menuBar.add(btnSave);

		JLabel functionLabel = new JLabel("   Function : ");
		menuBar.add(functionLabel);

		// Function and charts button
		final JComboBox funcBox = new JComboBox();
		funcBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// holds the selected function string
				String funcOption = (String) funcBox.getSelectedItem();

				// the list that holds all the selected cells
				selectedCellsList = new ArrayList<Cell>();
				// add the cells to the list
				for (int i = 0; i < sheetManager.getRowCount(); i++) {
					for (int j = 0; j < sheetManager.getColumnCount(); j++) {
						if (tableManager.isCellSelected(i, j)) {
							selectedCellsList.add(sheetManager.getCell(i, j));
						}
					}
				}

				// copy arraylist elements to an array
				// because usefunction method uses an array
				Cell[] cellArray = new Cell[selectedCellsList.size()];
				for (int i = 0; i < selectedCellsList.size(); i++) {
					cellArray[i] = selectedCellsList.get(i);

				}
				
				// for the output cell in usefunction method
				Cell outputcell;
				
				// ask the user to choose the cell(row and column) to print the
				// function output
				String outputCellRow=null;
				String outputCellColumn=null;
				
				outputCellRow= JOptionPane.showInputDialog("Enter function cell row"
						+ ",counting starts from zero(Left to right and top to bottom)", 1);
				outputCellColumn = JOptionPane.showInputDialog("Enter function cell column", 1);
				
				if(outputCellRow!=null && outputCellColumn!=null){//check if user presses cancel or closes the window 
					
					
					int outCellRow = Integer.parseInt(outputCellRow);
					int outCellColumn = Integer.parseInt(outputCellColumn);
					
					/*
					 * check if the dimensions that the user inserted are in bounds
					 * of the table
					 */
					if (outCellRow > 0 &&outCellRow <= sheetManager.getRowCount()
							&& outCellColumn > 0 && outCellColumn <= sheetManager.getColumnCount()) {
	
						outputcell = sheetManager.getCell(outCellRow-1, outCellColumn-1);
						// call the function method that prints an oitput to the
						// table
						sheetManager.useFunction(cellArray, funcOption, outputcell);
						// updates the gui,used when new values to the table are
						// inserted
						tableManager.updateUI();
					}
					// reports that the user has inserted wrong dimensions for the
					// output cell
					else {
						JOptionPane.showMessageDialog(null, "Wrong dimensions have been given!!");
					}
				
			}
			
			}
			
			
		});
		// the function chart box
		funcBox.setModel(new DefaultComboBoxModel(
				new String[] { "Abs", "Cos", "Sin", "Tan", "Pow", "Sum", "Mult", "Log", "Log10", "And", "Or", "Not",
						"Xor", "Max", "Min", "Mean", "Median", "Stddev", "Concat", "Includes", "Trim", "Remove" }));
		menuBar.add(funcBox);

		final JComboBox chartBox = new JComboBox();

		chartBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// holds the selected chart string
				String chartOption = (String) chartBox.getSelectedItem();

				//list that holds the keys in the chart
				//keys correspond the number of different bars in the chart
				//each bar has its unique color.So you can
				//distinguish keys by their color
				//also keys are located in the first row of all the
				//selected data(cells) for the chart
				ArrayList<Cell> selectedChartKeys = new ArrayList<Cell>();

				// TODO make all selected cells unselected
				String rowOfKeysStr = JOptionPane.showInputDialog("Enter the row that your keys are located", "1");
				String columnOfFirstKeyStr = JOptionPane.showInputDialog("Enter the column that your first key is located", "2");
				
				
			if(rowOfKeysStr!=null && columnOfFirstKeyStr!=null ){
					// holds the row in the table where the keys are located,they
					// must be in sequenece,also holds the column that the first key is located
					int rowOfKeys = Integer.parseInt(rowOfKeysStr);
					int columnOfFirstKey = Integer.parseInt(columnOfFirstKeyStr);
					
					rowOfKeys--;
					columnOfFirstKey--;
				//Jtable starts from zero so,to be user friendly we make the user feel that counting start from 1
				if(rowOfKeys>=0 && rowOfKeys<=sheetManager.getRowCount() && columnOfFirstKey>=0
				&&columnOfFirstKey<=sheetManager.getColumnCount()){
					//add the keys to the list,the row is given by the user
					//so the check is only for the columns
					
					//COLOR KEYS list
					for (int j = columnOfFirstKey; j < sheetManager.getColumnCount(); j++) {
						if (tableManager.isCellSelected(rowOfKeys, j) 
						 && sheetManager.getCell(rowOfKeys, j).getCellType()!="null") {
							
							selectedChartKeys.add(sheetManager.getCell(rowOfKeys, j));
						}
					}
					/*for(int i=0;i<selectedChartKeys.size();i++){
						System.out.println(selectedChartKeys.get(i).getCellType());
					}*/
	
					//the rest of the data for the chat is holded here
					//like column keys,datavalues(always type number)
					ArrayList<Cell> selectedChartData = new ArrayList<Cell>();
	
					
					//list that hold all the column keys
					/*for (int i = rowOfKeys + 1; i < sheetManager.getRowCount(); i++) {
					
							if (tableManager.isCellSelected(i, columnOfFirstKey-1)) {
									selectedColumnKeys.add(sheetManager.getCell(i,columnOfFirstKey-1));
	
							}
					}*/
					
					for (int i = rowOfKeys + 1; i < sheetManager.getRowCount(); i++) {
						for(int j=columnOfFirstKey-1;j<sheetManager.getColumnCount();j++){
							if (tableManager.isCellSelected(i,j) && 
								sheetManager.getCell(i,j).getCell().toString().length()>0) {
								selectedChartData.add(sheetManager.getCell(i,j));
							}
						}
					}
					
					/*for(int i=0;i<selectedColumnKeys.size();i++){
						System.out.println(selectedColumnKeys.get(i).getCell());
					}*/
					
	
					// create charts
	
					if (chartOption.equals("Bar chart")) {
						ChartManager.createBarChart(selectedChartKeys, selectedChartData);
					}
					 else ChartManager.createLineChart(selectedChartKeys, selectedChartData);
			}
				else{
					JOptionPane.showMessageDialog(null,"Wrong dimension have been given");
				}
		}
				
				
		}
	});
		JLabel chartLabel = new JLabel("   Chart : ");
		menuBar.add(chartLabel);
		chartBox.setModel(new DefaultComboBoxModel(new String[] { "Line chart", "Bar chart" }));
		menuBar.add(chartBox);

		// help button
		JButton btnHelp = new JButton();
		btnHelp.setIcon(
				new ImageIcon(MinusXLGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/question.png")));
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HelpBtnGui helpWindow = new HelpBtnGui();
				helpWindow.setVisible(true);
			}
		});
		menuBar.add(btnHelp);

	}

}
