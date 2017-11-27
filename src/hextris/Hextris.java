/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hextris;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author dell
 */
public class Hextris extends Application {


    private Scene scene;
    enum GameState {
        START,
        PLAYING,
        GAMEOVER
    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("HexTris Game");
        scene = new StartScene().CreateStartScene();
        Director.getInstance().setStage(primaryStage);
        Director.getInstance().setScene(scene);
    }
    
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
   
}
