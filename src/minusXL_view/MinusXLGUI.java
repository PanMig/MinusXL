package minusXL_view;

import minusxl_data_management.Spreadsheet;
import minusxl_data_management.Workbook;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
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
import javax.swing.UIManager;

public class MinusXLGUI {

	private JFrame frame;//the window
	
	private String workBookName;
	
	private String sheetName;//name of the spreadsheet
    private int sheetRows;
	private int sheetColumns;
	private int sheetNumber=0;
	
	private Workbook wbManager;
	
	private Spreadsheet spManager;
	
	//objects for opening files and creating a tabbed pane
	JFileChooser fileChooser = new JFileChooser();
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
		
		//initialize the frame,select Layout
		sheetNumber=0;
		frame = new JFrame();
		frame.setBounds(100, 100, 571, 412);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		//add tabbed pane to the center of the borderLayout
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		//create all the buttons in the bottom of the screen
		spreadsheetActionPanel();
		
		//create the menu bar in the top of the screen
		createMenuBar();
		
		//add a new workbook and a sheet in the workbook when the program opens for the first time
		
		initWorkbook();
}
	
	//initiate the first workbook when the program opens for the first time
	public void initWorkbook(){
		Workbook wb=new Workbook();
		wbManager=wb;
		spManager=wbManager.getSpreadsheet(wb.getAttachedSpreadsheets()-1);
		spManager.setValueAt(5,0,0);
		spManager.setValueAt(true,2,2);
		addSheet();
	}


//add to the tabbed pane a spreadsheet (jtable) with default rows and columns.
//This method is only for the GUI class it does not affect other classes 

	public void addSheet(){
		
	//create scroll and tabbed panes
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("sheet", null, scrollPane, null);
		
		JTable table=new JTable();
		//attach jtable to the spreadsheet instance that we create in the above line
		table.setModel(spManager);
		////attach to the scrool pane the Jtable
		scrollPane.setViewportView(table);
		table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
		
		sheetNumber+=1;		
	}


	public void addSheet(String sheetName,int rows,int columns){
		//create scroll and tabbed panes
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab(sheetName, null, scrollPane, null);
		
		spManager=wbManager.getSpreadsheet(wbManager.getAttachedSpreadsheets()-1);
		JTable table=new JTable();
		
		//attach jtable to the spreadsheet instance that we create in the above line
		table.setModel(spManager);
		
		//attach to the scrool pane the Jtable
		scrollPane.setViewportView(table);
		table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
		
		sheetNumber+=1;

	}


	
	private void spreadsheetActionPanel(){
		
		//init panel
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{41, 8, 95, 83, 0};
		gbl_panel.rowHeights = new int[]{23, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		//delete button,deletes a spreadsheet from the tabbed pane
		JButton btnDeleteSpreadsheet = new JButton("Delete spreadsheet");
		//select color for the button
		btnDeleteSpreadsheet.setBackground(UIManager.getColor("Button.light"));
		btnDeleteSpreadsheet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int option;
				int tabIndex=tabbedPane.getSelectedIndex();//holds the selected tab
				//option holds the choice of the user, 0 is yes ,1 is no , 2 is cancel
				option=JOptionPane.showConfirmDialog(tabbedPane,"Do you want to delete the choosen spreadsheet?");
				if(option==0){
					tabbedPane.remove(tabIndex);//remove tab from the tabbed pane
					wbManager.deleteSpreadsheet(tabIndex);//delete spreadsheet from the list of spreadsheets
					sheetNumber-=1;
				}
			}
		});
		
		//button that adds a spreadsheet
		JButton addButton = new JButton("+");
		addButton.setBackground(UIManager.getColor("Button.light"));
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sheetName=JOptionPane.showInputDialog("Enter a name for spreadsheet");
				if(sheetName.length()==0){
					sheetName="sheet"+sheetNumber;
				}
				
				String StringsheetRows = JOptionPane.showInputDialog("Enter rows for your spreadsheet");
					if(StringsheetRows.length()==0) sheetRows=100;
					//TODO CHECK IF USERS PUTS STRING that's not an number
					else	sheetRows=Integer.parseInt(StringsheetRows);
			
				String StringsheetColumns = JOptionPane.showInputDialog("Enter columns for your spreadsheet");
					if(StringsheetColumns.length()==0) sheetColumns=26;
					//TODO CHECK IF USERS PUTS STRING that's not an number
					else	sheetColumns=Integer.parseInt(StringsheetColumns);
				
				wbManager.addSpreadsheet(sheetRows, sheetColumns);//add spreadsheet to the list
				addSheet(sheetName,sheetRows,sheetColumns);//add tab to the tabbed pane
				
			}
		});
		addButton.setForeground(Color.RED);
		GridBagConstraints gbc_addButton = new GridBagConstraints();
		gbc_addButton.anchor = GridBagConstraints.NORTHWEST;
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
		
		JButton btnImportSheet = new JButton("Import Sheet");
		btnImportSheet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_ImportSheet = new GridBagConstraints();
		gbc_ImportSheet.gridx = 3;
		gbc_ImportSheet.gridy = 0;
		panel.add(btnImportSheet, gbc_ImportSheet);
		
	
	}
	

	
	private  void createMenuBar(){
	
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		//New Workbook button
		JButton btnNew = new JButton("New WorkBook");//"New workbook"
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//holds workbok name
				workBookName=JOptionPane.showInputDialog("Enter new workBook name");
				if(workBookName.length()==0) workBookName="Workbook";
				//holds rows for the new sheet
				String StringsheetRows = JOptionPane.showInputDialog("Enter rows for your spreadsheet");
					if(StringsheetRows.length()==0) sheetRows=100;
					//TODO CHECK IF USERS PUTS STRING that's not an number
					else	sheetRows=Integer.parseInt(StringsheetRows);
				//holds columns for sheet
				String StringsheetColumns = JOptionPane.showInputDialog("Enter columns for your spreadsheet");
					if(StringsheetColumns.length()==0) sheetColumns=26;
					//TODO CHECK IF USERS PUTS STRING that's not an number
					else	sheetColumns=Integer.parseInt(StringsheetColumns);
					
				//multiple cases where the user either insert a value at the input dialog and presses "ok" or just presses "ok"
				if(workBookName.length()==0 && StringsheetRows.length()==0 && StringsheetColumns.length()==0 ){
					sheetNumber=0;
					Workbook wb =new Workbook();
					wbManager=wb;//the reference now points to that specific object
					tabbedPane.removeAll();
					addSheet();
	
				}
				else if(workBookName.length()==0 && StringsheetRows.length()!=0 && StringsheetColumns.length()!=0 ){
					sheetNumber=0;
					Workbook wb =new Workbook(sheetRows,sheetColumns);
					wbManager=wb;
					tabbedPane.removeAll();
					addSheet("sheet",sheetRows,sheetColumns);
				}
				else{
					sheetNumber=0;
					Workbook wb =new Workbook(workBookName,sheetRows,sheetColumns);
					wbManager=wb;
					tabbedPane.removeAll();
					addSheet("sheet",sheetRows,sheetColumns);
				}
			}
		}
		);
		menuBar.add(btnNew);
		
		//Open button
		JButton btnOpen = new JButton("Open");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileChooser.showOpenDialog(null);//opens files for inserting a workbook
				
			}
		});
		menuBar.add(btnOpen);
		
		//Save button
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//JOptionPane.showInputDialog("Enter a name for the workbook");
				fileChooser.showSaveDialog(null);
			}
		});
		menuBar.add(btnSave);
		
		JLabel functionLabel =new JLabel("   Function : ");
		menuBar.add(functionLabel);
		
		//Function and charts button
		JComboBox funcBox = new JComboBox();
		funcBox.setModel(new DefaultComboBoxModel(new String[] {"abs", "cos", "sin", "tan", "pow", "sum", "mult", "log", "log10", "and", "or", "not", "xor", "max", "min", "Mean", "Median", "Stddev", "Concat", "includes", "Trim", "Remove"}));
		menuBar.add(funcBox);
		
		final JComboBox chartBox = new JComboBox();
		chartBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			
			
			}
		});
		JLabel chartLabel =new JLabel("   Chart : ");
		menuBar.add(chartLabel);
		chartBox.setModel(new DefaultComboBoxModel(new String[] {"Line chart", "Bar chart"}));
		menuBar.add(chartBox);
		
		//help button
		JButton btnHelp = new JButton("?");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HelpBtnGui helpWindow=new HelpBtnGui();
				helpWindow.setVisible(true);
			}
		});
		menuBar.add(btnHelp);
	
	}
	
}

