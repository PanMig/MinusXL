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
	private ArrayList<Cell> list;
	private ArrayList<Cell> dataList;

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
		//colors :given by the user
		//final Comparable firefox =(Comparable) list.get(0).getCell();
		//final String chrome = "Chrome";
		//final String iexplorer = "InternetExplorer";
		
		// column keys...
		
		final String popular = "Popular";
		final String response = "Response";
		final String osindependent = "OS Independent";
		final String features = "Features";
		
		// create the dataset...
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		//initialize and add values to the bar categories
		for(int i=0;i<list.size();i++){
			for(int j=0;j<dataList.size();j++){
				final Comparable key =(Comparable) list.get(i).getCell();
				if(dataList.get(j).getCellType().equals("String")){
					columnKey =(Comparable) dataList.get(j).getCell();
				}
				else{
					chartColumnValue=(double) dataList.get(j).getCell();
					System.out.println(chartColumnValue);
				}
				dataset.addValue(chartColumnValue,key,columnKey);
				
				/*
				dataset.addValue(4.0,key, popular);
				dataset.addValue(3.0,key, response);
				dataset.addValue(5.0, key, osindependent);
				dataset.addValue(5.0,key, features);*/
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
