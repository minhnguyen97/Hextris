/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hextris;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Rotate;

/**
 *
 * @author Minh Nguyen
 */
public class GameScene {
    private Scene scene;
    private Group root ;
    private Group hextris;
    
    public Scene CreateGameScene() {
        this.root = new Group(); // Lưu button , ảnh ... 
        // Tạo ngữ cảnh game
        this.scene = new Scene(root, Setting.SCENE_WIDTH, Setting.SCENE_HEIGHT);
        this.scene.setFill(Color.GRAY);
        
        this.hextris = CreateHextris();
        this.hextris.setLayoutX(scene.getWidth()/2);
        this.hextris.setLayoutY(scene.getHeight()/2);
        
        root.getChildren().add(hextris);
        
        this.SetupEventHandling();
        
        return scene;
    }
    private void SetupEventHandling() {
        this.SetHextrisRotate();
    }
    private Group CreateHextris() {
        // Tạo hexagon ở giữa màn hình
        Group hexagon = new Group();
       
        // Tạo hexagon từ 6 hình tam giác
        for (int i = 0; i < 6; ++i) {
            Polygon triagle = new Polygon(new PolygonPoints.Triagle().GetPoints(100));
            // Set góc quay
            double angle = 60 * i;
            triagle.getTransforms().add(new Rotate(angle, 0, 0));
            // Set màu
            triagle.setFill(Setting.listColors[i]);
 
            hexagon.getChildren().add(triagle);
        }
        // Tạo 1 hexagon ở giữa 
        Polygon hexa = new Polygon(new PolygonPoints.Hexagon().GetPoints(80));       

        hexagon.getChildren().add(hexa);
        return hexagon;
        
    }
    
    private void SetHextrisRotate() {
        
        scene.setOnKeyPressed((KeyEvent event) -> {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            if(KeyCode.RIGHT == event.getCode()) {
                hextris.getTransforms().add(new Rotate(Setting.ANGLE_ROTATE, 0, 0));
            }
            else if(KeyCode.LEFT == event.getCode()) {            
                hextris.getTransforms().add(new Rotate(-Setting.ANGLE_ROTATE, 0, 0));
            }
        });
    }
}
