package minusXl_charts_managment;

import java.util.ArrayList;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import minusxl_data_management.Cell;

public class BarChart extends JFrame {

	private static final long serialVersionUID = 1L;
	//sented lists,passed as arguments to constructor
	private ArrayList<Cell> list;
	private ArrayList<Cell> dataList;
	
	private ArrayList<Cell> columKeys;
	private ArrayList<Cell> values;

	public BarChart(String windowTitle, String chartTitle,String horizontalKeysTitle
	,String verticalTitle,ArrayList<Cell> list,ArrayList<Cell> dataList) {
		super(windowTitle);
		
		
		this.list=list;
		this.dataList=dataList;
		
		//second arg stands for horizontal Keys Title and 3rd arg stands for vertical title
		JFreeChart pieChart = ChartFactory.createBarChart(chartTitle,horizontalKeysTitle,
		verticalTitle, 
		createDataSet(), 
		PlotOrientation.VERTICAL, true, true, false);

		ChartPanel chartPanel = new ChartPanel(pieChart);

		// settind default size
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));

		// add to contentPane
		setContentPane(chartPanel);

	}

	private CategoryDataset createDataSet() {
		
		double chartColumnValue = 0;
		
		Comparable columnKey = null;
		
		ArrayList<Cell> columnKeysList=new ArrayList<Cell>();
		ArrayList<Cell> valuesList=new ArrayList<Cell>();
		
		for(int i=0;i<dataList.size();i++){
			if(dataList.get(i).getCellType().equals("String")){
				columnKeysList.add(dataList.get(i));
			}
			else{
				valuesList.add(dataList.get(i));
			}
		}
		
		for(int i=0;i<columnKeysList.size();i++){
			System.out.println(columnKeysList.get(i).getCell());
		}
		
		// create the dataset...
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		//initialize and add values to the bar categories
		
		//this variable is used to keep the values displayed from the valuesList
		//it is used so every color key takes the correct value
		int valuesIterator=0;
		for(int i=0;i<list.size();i++){
			
			for(int j=0,k=valuesIterator;j<columnKeysList.size()&& k<valuesList.size();j++,k++){
				//create the color key
				final Comparable key =(Comparable) list.get(i).getCell();
				
				//create the column key,located in the x-axis
				//above the color keys
				columnKey =(Comparable) columnKeysList.get(j).getCell();
				
				//create the value displayed in the y-axis,cast to number
				//because only number types are acceptable
				chartColumnValue=(double) valuesList.get(k).getCell();
				valuesIterator+=1;
				//add the data to the chart
				dataset.addValue(chartColumnValue,key,columnKey);
			}

		}

		
		/*
		dataset.addValue(1.0, firefox, speed);
		dataset.addValue(4.0, firefox, popular);
		dataset.addValue(3.0, firefox, response);
		dataset.addValue(5.0, firefox, osindependent);
		dataset.addValue(5.0, firefox, features);

		dataset.addValue(5.0, chrome, speed);
		dataset.addValue(7.0, chrome, popular);
		dataset.addValue(6.0, chrome, response);
		dataset.addValue(8.0, chrome, osindependent);
		dataset.addValue(4.0, chrome, features);

		dataset.addValue(4.0, iexplorer, speed);
		dataset.addValue(3.0, iexplorer, popular);
		dataset.addValue(2.0, iexplorer, response);
		dataset.addValue(3.0, iexplorer, osindependent);
		dataset.addValue(6.0, iexplorer, features);
		 */
		return dataset;

	}

}
