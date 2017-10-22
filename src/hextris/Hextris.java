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
    
    @Override
    public void start(Stage primaryStage) {
       
        
        scene = new StartScene().CreateStartScene();
        primaryStage.setTitle("HexTris Game");
        primaryStage.setScene(scene);// Set Scene
        primaryStage.show(); // Print to Scene       
    }
    
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
