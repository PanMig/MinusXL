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
   private ArrayList<Cell> dataList;
   
   public LineChart(String applicationTitle, String chartTitle,ArrayList<Cell> list,ArrayList<Cell> dataList) {
        super(applicationTitle);

        this.list=list;
		this.dataList=dataList;
        
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
	   
	   ArrayList<Cell> valuesList=new ArrayList<Cell>();
	

		for(int i=0;i<dataList.size();i++){
			if(dataList.get(i).getCellType().equals("String")){
				continue;
			}
			else{
				valuesList.add(dataList.get(i));
			}
		}
		
		/*for(int i=0;i<valuesList.size();i++){
			System.out.println(valuesList.get(i).getCell());
		}*/
     
		
	

     double value=0.0;
     //used to keep the index in the dataList
     //used for adding correct values to the keys
     int dataIterator=0;
     
      final XYSeriesCollection dataset = new XYSeriesCollection();
      
      for(int i=0;i<list.size();i++){
    	  System.out.println(i);
    	  //TODO values are not inserted correctly
  	    XYSeries key = new XYSeries((String)list.get(i).getCell());
  		for(int j=0;j<(valuesList.size()-list.size())-1;j++){
  			value=(double) valuesList.get(dataIterator).getCell();
  			key.add(value,value);
  			dataIterator++;
  			System.out.println(j+""+dataIterator);
  			
  		}
  		dataset.addSeries(key);
  	}
      
      //dataset.addSeries(chrome);
     
      return dataset;
     
  }
   
}
