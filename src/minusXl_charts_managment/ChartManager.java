package minusXl_charts_managment;
import java.util.ArrayList;

import minusxl_data_management.Cell;

public class ChartManager {

	public static void createBarChart(ArrayList<minusxl_data_management.Cell> keysList, ArrayList<Cell> dataList) {
		BarChart chart = new BarChart("Browser Usage Statistics",
		"Which Browser are you using?","category","score", keysList,dataList);
		chart.pack();
		chart.setVisible(true);
	}

	public static void createLineChart() {

	}

}
