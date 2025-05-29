package Shots;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class FormShot {

    @FXML private Text textVal;

    @FXML private AnchorPane pane;

    @FXML void initialize(){

        textVal.setText("" + Shot.value);

    }//initialize

}//FormShot
