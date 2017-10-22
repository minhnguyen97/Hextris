/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hextris;

import com.sun.javaws.jnl.JavaFXAppDesc;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

/**
 *
 * @author Minh Nguyen
 */
public class StartScene {
    private Scene scene;
    private Group root;
    private ImageView title;
    private Button start;
    public Scene CreateStartScene(){
        this.root = new Group();
        this.scene = new Scene(root,Setting.SCENE_WIDTH,Setting.SCENE_HEIGHT);
        // Tile
        this.title = new ImageView();
        
        Image background = new Image("image/background.png");
        
        title.setImage(background);
        
        root.getChildren().add(title);
        // ButtonStart
        
        this.start = new Button();
        
        root.getChildren().add(start);
        
        //this.SetupEventHandling();
       
        

        
        return scene;
    }
    private void SetupEventHandling() {
        
    }
}
 
