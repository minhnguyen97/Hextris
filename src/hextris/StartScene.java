/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hextris;


import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


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
        
        this.start = new Button("Play");
        start.setLayoutX(Setting.SCENE_WIDTH * 0.47 );
        start.setLayoutY(Setting.SCENE_HEIGHT * 0.425);
        start.setScaleX(2.5);
        start.setScaleY(3.2);
        start.setOnAction(e -> Director.getInstance().setScene(new GameScene().CreateGameScene()));
        root.getChildren().add(start);
        

       
        

        
        return scene;
    }
    
}
 
