/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hextris;

import java.util.ArrayList;
import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.transform.Rotate;

/**
 *
 * @author Minh Nguyen
 */
public class GameScene {
    private Scene scene;
    private Group root ;
   
    ArrayList<Polygon> hextris ;
    private Group lbScore;
    private UFOPool UFO;
    Text lbText;
    private static int score = 0;
    private AnimationTimer timer;
    double speed = 3;
    int timeNext = 2000;
    public Scene CreateGameScene() {
        this.root = new Group(); // Lưu button , ảnh ... 
        // Tạo ngữ cảnh game
        this.scene = new Scene(root, Setting.SCENE_WIDTH, Setting.SCENE_HEIGHT);
        this.scene.setFill(Color.GRAY);
       
        score = 0;     
        
        CreateHextris();
        
        lbScore = CreateLabelScore();
        lbScore.setLayoutX(Setting.SCENE_WIDTH/2);
        lbScore.setLayoutY(Setting.SCENE_HEIGHT/2);
        root.getChildren().add(lbScore);
        
        
        UFO = new UFOPool();
        UFO.setScene(scene);
        
       
        SetupEventHandling();
        timer = new AnimationTimer() {
            private long lastTime = (long) System.currentTimeMillis();
          
            @Override
            public void handle(long now) {
                update();
                if(System.currentTimeMillis()- lastTime > timeNext) {
                    lastTime = System.currentTimeMillis();                    
                    addUFO();
                }
                UFO.move();
            }
        };
        timer.start();
        return scene;
    }
    private void update() {
        speed = 3 + score / 10 ;
        timeNext = 2000 - score * 3;
        int c = check();
        if(c == 1) {
            ++score;
            lbText.setText(String.valueOf(score));
        }
        else if(c == -1 ) {
            timer.stop();
            Director.getInstance().setScene(new GameOverScene().createScene());
            System.out.println("Game Over");
        }
    }
    public int check() {
        int result = 0;
        for(UFO ufo : UFO.getUfo()) {
          if(ufo.distance(Setting.SCENE_WIDTH/2,Setting.SCENE_HEIGHT/2) < 86 + ufo.size/2) {
            if(hextris.get(ufo.getPos()).getFill().equals(ufo.getColor())) {
                System.out.println("pass.");
                result = 1;
            }
            else {
                System.out.println("fail.");
                result = -1;
            }
            UFO.remove(ufo);
            break;
        }
          
        }

        return result;
    }
    private void SetupEventHandling() {
        this.SetHextrisRotate();
    }
    private void CreateHextris() {
        // Tạo hexagon ở giữa màn hình
        hextris = new ArrayList<>();
        
        // Tạo hexagon từ 6 hình tam giác
        for (int i = 0; i < 6; ++i) {
            Polygon triagle = new Polygon(new PolygonPoints.Triagle().GetPoints(100));
            // Set góc quay
            double angle = 60 * i;
            triagle.getTransforms().add(new Rotate(angle, 0, 0));
            // Set màu
            triagle.setLayoutX(Setting.SCENE_WIDTH/2);
            triagle.setLayoutY(Setting.SCENE_HEIGHT/2);
            triagle.setFill(Setting.listColors[i]);
            hextris.add(triagle);
            root.getChildren().add(triagle);
        }
       
        
    }
    private Group CreateLabelScore() {
        // Tạo 1 hexagon ở giữa 
        Group labelScore = new Group();
 
        Polygon hexa = new Polygon(new PolygonPoints.Hexagon().GetPoints(80)); 
        hexa.setFill(Color.GRAY);
        
        lbText = new Text();
        lbText.setText(String.valueOf(score));
        lbText.setFont(new Font(Setting.FONT_SIZE));
        lbText.setWrappingWidth(100);
        lbText.setLayoutX(-50);
        lbText.setLayoutY(20);
        lbText.setTextAlignment(TextAlignment.CENTER);

        lbText.autosize();
        labelScore.getChildren().add(hexa);
        labelScore.getChildren().add(lbText);
       
        return labelScore;
    }
    
    private void SetHextrisRotate() {
        
        scene.setOnKeyPressed((KeyEvent event) -> {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            if(KeyCode.RIGHT == event.getCode()) {
             //   hextris.getTransforms().add(new Rotate(Setting.ANGLE_ROTATE, 0, 0));
                rotateRight();
            }
            else if(KeyCode.LEFT == event.getCode()) {            
                //hextris.getTransforms().add(new Rotate(-Setting.ANGLE_ROTATE, 0, 0));
                rotateLeft();
            }
        });
    }
    private void rotateLeft() {
        Color t = (Color)hextris.get(0).getFill();
        for(int i = 1; i < 6; ++i) {
            hextris.get(i-1).setFill(hextris.get(i).getFill());
        }
        hextris.get(5).setFill(t);
        
    }
    private void rotateRight() {
        Color t = (Color)hextris.get(5).getFill();
        for(int i = 5; i > 0; --i) {
            hextris.get(i).setFill(hextris.get(i-1).getFill());
        }
        hextris.get(0).setFill(t);
    }
    private void addUFO() {
        Random r = new Random();
        int size = 15 + r.nextInt(6);
        UFO.addUFO(size,speed);
    }
}
