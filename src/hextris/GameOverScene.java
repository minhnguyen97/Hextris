/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hextris;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Minh Nguyen
 */
public class GameOverScene {
    Scene scene;
    public Scene createScene() {
        Label label = new Label("Game Over!");
        label.setTextAlignment(TextAlignment.CENTER);
        label.setLayoutX(360);
        label.setLayoutY(260);
        Button replay = new Button("Replay");
        replay.setLayoutX(0.4 * Setting.SCENE_WIDTH);
        replay.setLayoutY(Setting.SCENE_HEIGHT/2);
        replay.setOnAction(e -> Director.getInstance().setScene(new GameScene().CreateGameScene()));
        Button exit = new Button("Exit");
        exit.setLayoutX(0.6 * Setting.SCENE_WIDTH);
        exit.setLayoutY(Setting.SCENE_HEIGHT/2);
        exit.setOnAction(e -> System.exit(0));
        Group root = new Group();
        root.getChildren().addAll(replay,exit,label);
        scene = new Scene(root,Setting.SCENE_WIDTH,Setting.SCENE_HEIGHT);
        
        return scene;
    }
}
