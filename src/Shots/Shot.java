package Shots;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Objects;

public class Shot extends HBox {

    public static int value;
    Timeline timeline;
    ThreadShot threadShot;

    public Shot (int value, double x, double y,int level){

        Shot.value = value;
        this.setLayoutX(x);
        this.setLayoutY(y);

        try {
            this.getChildren().add(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("FormShot.fxml"))));
        }//try
        catch (IOException e) {
            System.out.println("Failed in the Shot: Shot.Shot create");
        }//catch

        timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(5),
                event -> ((AnchorPane)this.getParent()).getChildren().remove(this),
                new KeyValue(this.layoutXProperty(),1300)));
        timeline.play();

        threadShot = new ThreadShot(value,this,(Shot)this, level);
        threadShot.start();

        this.toBack();

    }//public

    public void remove(){
        timeline.stop();
        threadShot.b = false;
    }//remove

}//Shot
