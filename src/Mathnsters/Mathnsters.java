package Mathnsters;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.util.Objects;

public class Mathnsters extends AnchorPane {

    public static String text;
    public int value,level;
    Timeline timeline;

    public Mathnsters(String text, int value, double y, int level){

        Mathnsters.text = text;
        this.value = value;
        this.setLayoutY(y);
        this.setLayoutX(1300);
        this.level = level;

        try {
            this.getChildren().add(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("FormMathnsters.fxml"))));
        }//try
        catch (Exception ignored){
            System.out.println("Failed in the Mathnsters: Mathnsters.Mathnsters");
        }//catch

        timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(15),
                event ->{((AnchorPane)this.getParent()).getChildren().remove(this);},
                new KeyValue(this.layoutXProperty(),-200)
        ));
        timeline.play();

        this.toBack();

    }//public

    public void remove(){
        timeline.stop();
    }//remove

}//Mathnsters
