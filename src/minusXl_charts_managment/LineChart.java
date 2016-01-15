package minusXl_charts_managment;

import java.util.ArrayList;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import minusxl_data_management.Cell;

public class LineChart extends JFrame {

   private static final long serialVersionUID = 1L;
   private ArrayList<Cell> list;
   private ArrayList<Cell> listX;
   private ArrayList<Cell> listY;
   
   public LineChart(String applicationTitle, String chartTitle,ArrayList<Cell> list,
		   ArrayList<Cell> listX,ArrayList<Cell> listY) {
        super(applicationTitle);

        this.list=list;
		this.listX=listX;
		this.listY=listY;
        
        // based on the dataset we create the chart
        JFreeChart pieChart = ChartFactory.createXYLineChart(chartTitle, "Category", "Score",
        createDataset(),PlotOrientation.VERTICAL, true, true, false);

        // Adding chart into a chart panel
        ChartPanel chartPanel = new ChartPanel(pieChart);
      
        // settind default size
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
      
        // add to contentPane
        setContentPane(chartPanel);
    }
  
   private XYDataset createDataset() {

     double valueX=0.0;
     double valueY=0.0;
     //used to keep the index in the dataList
     //used for adding correct values to the keys
     int dataIterator=0;
     
      final XYSeriesCollection dataset = new XYSeriesCollection();
 
      
      for(int i=0;i<list.size();i++){
    	  
  	    XYSeries key = new XYSeries((String)list.get(i).getCell());
  	    
  	  for(int j=0,k=dataIterator;j<listX.size() && k<listY.size();j++,k++){
  			valueX=(double) listX.get(j).getCell();
  			valueY=(double) listY.get(dataIterator).getCell();
  			dataIterator++;
  			key.add(valueX,valueY);
  		}
  		dataset.addSeries(key);
  	}
     
      return dataset;
     
  }
   
}
