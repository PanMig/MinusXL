package minusXL_view;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.ScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JInternalFrame;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import java.awt.SystemColor;


public class GUI {
	

	private JFrame frame;
	private String sheetName;
	private String workBookName;
	private int sheetNumber=1;
	JFileChooser fileChooser = new JFileChooser();
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
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
	public GUI() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//initialize the frame
		sheetNumber=0;
		frame = new JFrame();
		frame.setBounds(100, 100, 571, 412);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		spreadsheetActionPanel();
		createMenuBar();
		addSheet("sheet1");

}

public void addSheet(String sheetName){
	JScrollPane scrollPane = new JScrollPane();
	tabbedPane.addTab(sheetName, null, scrollPane, null);
	JTable table=new JTable(100,26);
	
	table.getColumnModel().getColumn(0).setResizable(false);
	//table.getColumnModel().getColumn(0).setPreferredWidth(30);
	scrollPane.setViewportView(table);
	table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
	sheetNumber+=1;
	
}
private void addSheet(String sheetName,int rows,int columns){
	JScrollPane scrollPane = new JScrollPane();
	tabbedPane.addTab(sheetName, null, scrollPane, null);
	JTable table=new JTable(rows,columns);
	
	table.getColumnModel().getColumn(0).setResizable(false);
	//table.getColumnModel().getColumn(0).setPreferredWidth(30);
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
	
	JButton btnDeleteSpreadsheet = new JButton("Delete spreadsheet");
	btnDeleteSpreadsheet.setBackground(UIManager.getColor("Button.light"));
	btnDeleteSpreadsheet.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int option;
			int tabIndex=tabbedPane.getSelectedIndex();
			option=JOptionPane.showConfirmDialog(tabbedPane,"Do you want to delete the choosen spreadsheet?");
			if(option==0){
				tabbedPane.remove(tabIndex);
				sheetNumber-=1;
			}
		}
	});
	JButton addButton = new JButton("+");
	addButton.setBackground(UIManager.getColor("Button.light"));
	addButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			sheetName=JOptionPane.showInputDialog(null,"Enter new spreadSheetName");
			if(sheetName.length()==0){
				sheetName="sheet" + sheetNumber;
			}
			addSheet(sheetName);
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
	
	//New button
	JButton btnNew = new JButton("New");//"New"
	btnNew.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			JOptionPane.showInputDialog("Enter new workBook name");
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
	
	//Function and charts button
	JComboBox funcBox = new JComboBox();
	funcBox.setModel(new DefaultComboBoxModel(new String[] {"Function", "abs", "cos", "sin", "tan", "pow", "sum", "mult", "log", "log10", "and", "or", "not", "xor", "max", "min", "Mean", "Median", "Stddev", "Concat", "includes", "Trim", "Remove"}));
	menuBar.add(funcBox);
	
	JComboBox chartBox = new JComboBox();
	chartBox.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
		}
	});
	chartBox.setModel(new DefaultComboBoxModel(new String[] {"Charts", "Line chart", "Bar chart"}));
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

public void setSheetName(String name){
	this.sheetName=name;
}
public String getSheetName(){
	return sheetName;
}

public String getWorkBookName() {
	return workBookName;
}

public void setWorkBookName(String workBookName) {
	this.workBookName = workBookName;
}

}
