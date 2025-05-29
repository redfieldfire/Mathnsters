import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

public class MainClass extends Application {

    @Override public void start(Stage primaryStage) throws Exception {

        primaryStage.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Game/Game.fxml")))));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();

    }//start

    public static void main(String[] args) {
        launch(args);
    }//public

}//MainClass
