package minusXl_charts_managment;
import java.util.ArrayList;

import minusxl_data_management.Cell;

public class ChartManager {

	public static void createBarChart(ArrayList<minusxl_data_management.Cell> keysList, ArrayList<Cell> dataList,String title) {
		BarChart chart = new BarChart("Bar chart window",
		title,"category","score", keysList,dataList);
		chart.pack();
		chart.setVisible(true);
	}

	public static void createLineChart(ArrayList<minusxl_data_management.Cell> keysList, ArrayList<Cell>listX, ArrayList<Cell>listY,String title) {
		LineChart chart = new LineChart("Line chart window",
		title,keysList,listX,listY);
		chart.pack();
		chart.setVisible(true);

	}

}
