/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hextris;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

/**
 *
 * @author dell
 */
public class Hextris extends Application {
    final Color listColors[] = {
        Color.web("#FFCC99"),
        Color.web("#FF99FF"),
        Color.web("#FF66FF"),
        Color.web("#00AA00"),
        Color.web("#FF0033"),
        Color.web("#001100")
        
    };
        
    
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group(); // Lưu button , ảnh ... 

        Scene scene = new Scene(root, Setting.SCENE_WIDTH, Setting.SCENE_HEIGHT);
        // Tạo hình tam giác
        for (int i = 0; i < 6; ++i) {
            Polygon triagle = new Polygon(new PolygonPoints.Triagle().GetPoints(100));
            // Set vị trí
            triagle.setLayoutX(scene.getWidth()/2);
            triagle.setLayoutY(scene.getHeight()/2);
            
            // Set góc quay
            double angle = 60 * i;
            triagle.getTransforms().add(new Rotate(angle, 0, 0));
            
            // Set màu
            
            triagle.setFill(listColors[i]);
             
            root.getChildren().add(triagle);
        }

        primaryStage.setTitle("HexTris");
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
