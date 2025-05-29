package Game;

import CreateMathnsters.ThreadMathnsters;
import Ship.Ship;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class Game {

    @FXML private AnchorPane pane;

    @FXML void initialize(){

        pane.getChildren().add(new Ship(20,20));
        ThreadMathnsters threadMathnsters = new ThreadMathnsters(5,pane);
        threadMathnsters.start();

    }//initialize

}//Game
