package Shots;

import AnimationCircle.AC;
import Data.Data;
import javafx.application.Platform;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class ThreadShot extends Thread{

    public boolean b = true;
    HBox shot;
    int value,level;
    Shot shotE;

    public ThreadShot (int value, HBox hBox, Shot shot, int level){
        this.value = value;
        this.shot = hBox;
        this.level = level;
        this.shotE = shot;
    }//value

    @Override public void run() {

        while(b){
            try{
                Platform.runLater(()->{
                    for(int x = 0; x < Data.mathnsters.size(); x++){
                        if(Data.mathnsters.get(x).level == this.level){
                            if((Data.mathnsters.get(x).getLayoutX()+60)-(shot.getLayoutX()+50) < 80 && (Data.mathnsters.get(x).getLayoutX()+60)-(shot.getLayoutX()+50) > 0){
                                if(Data.mathnsters.get(x).value == this.value){
                                    try {
                                        ((AnchorPane) shot.getParent()).getChildren().add(new AC(Data.mathnsters.get(x).getLayoutX() + 50,Data.mathnsters.get(x).getLayoutY() + 50));
                                        ((AnchorPane) shot.getParent()).getChildren().remove(Data.mathnsters.get(x));
                                        Data.mathnsters.get(x).remove();
                                        Data.mathnsters.remove(x);
                                        shotE.remove();
                                        ((AnchorPane)shot.getParent()).getChildren().remove(shot);
                                    }//try
                                    catch (Exception ignored){
                                        System.out.println("Failed in the shot: Shots.ThreadShot");
                                    }//catch
                                    break;
                                }//if
                            }//if
                        }//if
                    }//for
                });
                Thread.sleep(250);
            }//try
            catch (Exception ignored){
                System.out.println("Failed in the Thread: Shot.ThreadShot");
            }//catch
        }//while

    }//run

}//class
