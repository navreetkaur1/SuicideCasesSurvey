
    /**
     * Sample Skeleton for 'suicideCasesSurveyView.fxml' Controller Class
     */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

    public class SuicideCasesSurveyController implements Initializable {

        @FXML // ResourceBundle that was given to the FXMLLoader
        private ResourceBundle resources;

        @FXML // URL location of the FXML file that was given to the FXMLLoader
        private URL location;

        @FXML // fx:id="SexComboBox"
        private ComboBox<String> SexComboBox; // Value injected by FXMLLoader

        @FXML // fx:id="generationDropDown"
        private ComboBox<String> generationDropDown; // Value injected by FXMLLoader

        @FXML // fx:id="yearPicker"
        private DatePicker yearPicker; // Value injected by FXMLLoader

        @FXML // fx:id="CountryTextField"
        private TextField CountryTextField; // Value injected by FXMLLoader

        @FXML // fx:id="AgeTextArea"
        private TextField AgeTextArea; // Value injected by FXMLLoader

        @FXML // fx:id="Suicide"
        private TextField Suicide; // Value injected by FXMLLoader

        @FXML
        private Label messageId;

        @FXML
        private HBox Hbox;

        @FXML // This method is called by the FXMLLoader when initialization is complete
        void initialize() {

            assert SexComboBox != null : "fx:id=\"SexComboBox\" was not injected: check your FXML file 'suicideCasesSurveyView.fxml'.";
            assert generationDropDown != null : "fx:id=\"generationDropDown\" was not injected: check your FXML file 'suicideCasesSurveyView.fxml'.";
            assert yearPicker != null : "fx:id=\"yearPicker\" was not injected: check your FXML file 'suicideCasesSurveyView.fxml'.";
            assert CountryTextField != null : "fx:id=\"CountryTextField\" was not injected: check your FXML file 'suicideCasesSurveyView.fxml'.";
            assert AgeTextArea != null : "fx:id=\"AgeTextArea\" was not injected: check your FXML file 'suicideCasesSurveyView.fxml'.";
            assert Suicide != null : "fx:id=\"Suicide\" was not injected: check your FXML file 'suicideCasesSurveyView.fxml'.";

        }
        @FXML
        private void Submit(){
            if(!Hbox.getChildren().contains(messageId)) {
                Hbox.getChildren().add(1, messageId);
            }

            try{

                SuicideRateOverview newSuicide = new SuicideRateOverview(CountryTextField.getText(),
                        yearPicker.getValue().getYear(), SexComboBox.getValue(), AgeTextArea.getAnchor(), Suicide.getAnchor(),generationDropDown.getValue());

                messageId.setTextFill(Color.BLACK);
                messageId.setText(newSuicide.toString());

            }
            catch(Exception e){
                Hbox.getChildren().add(1,messageId);
                messageId.setTextFill(Color.RED);
                messageId.setText(e.getMessage());

            }
        }

        @Override
        public void initialize(URL location, ResourceBundle resources) {
            Hbox.getChildren().remove(messageId);
            messageId.setText("");
            SexComboBox.getItems().addAll(SuicideRateOverview.getsex());
            generationDropDown.getItems().addAll(SuicideRateOverview.getGenerationValue());

        }
    }


