import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SuicideCasesSurveyController implements Initializable {

    @FXML
    private BarChart<?, ?> barChart;

    @FXML
    private CategoryAxis age;

    @FXML
    private NumberAxis suicideCases;

    @FXML
    private Label suicideLabel;

    private XYChart.Series  SuicideCases;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SuicideCases = new XYChart.Series();

        SuicideCases.getData().add(new XYChart.Data("12-15",34));
        SuicideCases.getData().add(new XYChart.Data("16-20",57));
        SuicideCases.getData().add(new XYChart.Data("21-25",67));
        SuicideCases.getData().add(new XYChart.Data("26-30",68));
        SuicideCases.getData().add(new XYChart.Data("31-35",86));
        SuicideCases.getData().add(new XYChart.Data("36-40",89));
        SuicideCases.getData().add(new XYChart.Data("41-46",57));
        SuicideCases.getData().add(new XYChart.Data("47-50",78));
        SuicideCases.getData().add(new XYChart.Data("50-60",69));

        barChart.getData().addAll(SuicideCases);


    }


    public void viewMyPieChart(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("pieChart.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Suicide Cases");
        stage.show();
    }
}
