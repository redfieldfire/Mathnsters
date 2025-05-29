package Mathnsters;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class FormMathnsters {

    @FXML private ImageView image;

    @FXML private Text text;

    @FXML void initialize(){

        text.setText(Mathnsters.text);

    }//initialize

}//FM
