package Ship;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.util.Objects;

public class Ship extends AnchorPane {

    public Ship(double x, double y){

        this.setLayoutX(x);
        this.setLayoutY(y);

        try {
            this.getChildren().add(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("FormShip.fxml"))));
        }//try
        catch (IOException e) {
            System.out.println("Failed in the Ship.Ship: Create");
        }//catch

    }//public

}//Ship
