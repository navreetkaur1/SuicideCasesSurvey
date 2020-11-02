import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;

import java.net.URL;
import java.util.*;

public class PieChartController implements Initializable {

        @FXML
        private PieChart MyChart;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<PieChart.Data> pieChart = FXCollections.observableArrayList(
                new PieChart.Data("Generation x",13),
                new PieChart.Data("Generation Y",35),
                new PieChart.Data("Generation z",46),
                new PieChart.Data("Boomers",35)
        );
        // create pie chart and assign data
        PieChart chart = new PieChart(pieChart);
         chart.setData(pieChart);
        chart.setTitle("According to generation ");


    }
}

