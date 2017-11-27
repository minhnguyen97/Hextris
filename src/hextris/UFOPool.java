/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hextris;

import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.Scene;


/**
 *
 * @author Minh Nguyen
 */
public class UFOPool {
    Scene scene;

   
    ArrayList<UFO> ufo;
    
    public UFOPool(){
        System.out.println("UFO Pool created.");
        ufo = new ArrayList<>();
        // Gen UFOPool
    }
     public ArrayList<UFO> getUfo() {
        return ufo;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
    public void remove(UFO ufo) {
        Group root = (Group) scene.getRoot();
        root.getChildren().remove(ufo.getUfo());
        this.ufo.remove(ufo);
    }
    public void addUFO(int size, double speed) {
        System.out.println("UFO attack...");
        UFO u = new UFO(size,speed);
        
        Group root = (Group) scene.getRoot();
        root.getChildren().add(u.getUfo());
        ufo.add(u);
    }
    public void move() {
        ufo.stream().forEach((u) -> {
            u.moveToCenter();
        });
    }
}
