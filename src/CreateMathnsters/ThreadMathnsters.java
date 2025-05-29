package CreateMathnsters;

import Data.Data;
import Mathnsters.Mathnsters;
import javafx.application.Platform;
import javafx.scene.layout.AnchorPane;

import java.util.Random;

public class ThreadMathnsters extends Thread{

    public boolean b = true;
    int time,n1,n2,res,y,level,cont = 0;
    String type = "";
    Random random = new Random();
    AnchorPane pane;

    public ThreadMathnsters (int value, AnchorPane anchorPane){
        this.time = value;
        pane = anchorPane;
    }//value

    @Override public void run() {

        while(b) {
            try {

                Platform.runLater(()->{
                    n1 = random.nextInt(11);
                    n2 = random.nextInt(11);

                    switch (random.nextInt(2)){
                        case 0:
                            res = n1 + n2;
                            type = " + ";
                            break;
                        case 1:
                            res = n1 - n2;
                            type = " - ";
                            break;
                    }//switch

                    switch (random.nextInt(5)){
                        case 0:
                            y = 20;
                            level = 1;
                            break;
                        case 1:
                            y = 140;
                            level = 2;
                            break;
                        case 2:
                            y = 260;
                            level = 3;
                            break;
                        case 3:
                            y = 380;
                            level = 4;
                            break;
                        case 4:
                            y = 500;
                            level = 5;
                            break;
                    }//switch

                    cont++;

                    Data.mathnsters.add(new Mathnsters("" + n1 + type + n2,res,y,level));
                    pane.getChildren().add(Data.mathnsters.getLast());

                    pane.getChildren().get(pane.getChildren().size()-1).toBack();

                    System.out.println(cont + " -> " + pane.getChildren().size() + "\n");

                });

                Thread.sleep(time * 500L);

            }//try
            catch (Exception e) {
                System.out.println("Failed in the Thread: CreateMathnsters.ThreadMathnsters");
                e.printStackTrace();
            }//catch
        }//while

    }//run

}//class
