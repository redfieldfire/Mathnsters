package AnimationCircle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class AC extends Circle {

    public AC(double x, double y) {

        this.setLayoutX(x);
        this.setLayoutY(y);
        //this.setFill(Color.web("D847DC"));
        this.setFill(Color.WHITE);
        Timeline t1 = new Timeline();
        t1.getKeyFrames().add(new KeyFrame(Duration.seconds(1.0D),
                (event) -> ((AnchorPane) this.getParent()).getChildren().remove(this),
                new KeyValue(this.opacityProperty(), 0),
                new KeyValue(this.radiusProperty(), 600)));
        t1.play();

    }//AC

}//AC
