package Ship;

import Shots.Shot;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class FormShip {

    @FXML private TextField textNum;

    @FXML private Text textNum2;

    @FXML private AnchorPane pane;

    @FXML private ImageView ship;

    AnchorPane father;
    int level;

    @FXML void keyPressed(KeyEvent event) {

        father = (AnchorPane) pane.getParent();

        if(event.getCode() == KeyCode.W){
            if((int) father.getLayoutY() != 20) father.setLayoutY(father.getLayoutY() - 120);
        }//if up
        else if(event.getCode() == KeyCode.S){
            if((int) father.getLayoutY() != 500) father.setLayoutY(father.getLayoutY() + 120);
        }//if down
        else if(event.getCode() == KeyCode.D ){
            if(!textNum2.getText().equals("") && !textNum2.getText().equals("-")) {
                calcLevel();
                Shot shot = new Shot(Integer.parseInt(textNum2.getText()),
                        father.getLayoutX() + 140,
                        father.getLayoutY() + 45,
                        level);
                ((AnchorPane)father.getParent()).getChildren().add(shot);
                shot.toBack();
                textNum2.setText("");
            }//if
        }//if shot
        else if(event.getCode() == KeyCode.Q){
                calcLevel();
                Shot shot = new Shot(0,
                        father.getLayoutX() + 100,
                        father.getLayoutY() + 45,
                        level);
                ((AnchorPane)father.getParent()).getChildren().add(shot);
                shot.toBack();
                textNum2.setText("");
        }//if shot
        else if(event.getCode() == KeyCode.BACK_SPACE) {
            if(textNum2.getText().length() > 0)
                back();
        }//else if
        else if(event.getCode().isDigitKey() || event.getCode().isKeypadKey()) {
            if(textNum2.getText().length() < 5)
            textNum2.setText(textNum2.getText() + event.getCode().getName().charAt(event.getCode().getName().length() - 1) + "");
        }//else if
        else if(event.getCode() == KeyCode.A) {
            if(textNum2.getText().length() > 0) {
                if (textNum2.getText().charAt(0) != '-') textNum2.setText("-" + textNum2.getText());
                else less();
            }//if
            else textNum2.setText("-");
        }//else if

    }//KeyPressed

    String word = "";

    void back(){

        word = "";
        for (int x = 0; x < textNum2.getText().length() - 1; x++) word = word + textNum2.getText().charAt(x);
        textNum2.setText(word);

    }//back

    void less(){

        word = "";
        for (int x = 1; x < textNum2.getText().length(); x++) word = word + textNum2.getText().charAt(x);
        textNum2.setText(word);

    }//back

    void calcLevel(){

        father = (AnchorPane) pane.getParent();

        switch ((int)father.getLayoutY()){

            case 20: level = 1; break;
            case 140: level = 2; break;
            case 260: level = 3; break;
            case 380: level = 4; break;
            case 500: level = 5; break;

        }//switch

    }//calcLevel

}//FormShip
