/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hextris;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Minh Nguyen
 */
public class Director {
    private static Director instance = null;
    Stage stage;
    Scene scene;
    public Director() {
    }
    
    public static Director getInstance()  {
        if(instance == null) {
            instance = new Director();
        }
        return instance;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
        this.stage.show();
    }

    public void setScene(Scene scene) {
        this.scene = scene;
        stage.setScene(scene);
    }
}
