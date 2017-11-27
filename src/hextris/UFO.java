/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hextris;

import java.util.Random;
import javafx.geometry.Point2D;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;

/**
 *
 * @author Minh Nguyen
 */
public class UFO {
    double x,y;
    int pos;
    double speed;
    int size;
    Shape ufo;
    UFO(int size ,double speed) {
        this.size = size;
        this.speed = speed;
        int side = new Random().nextInt(4);
        pos = new Random().nextInt(6);
        double layoutX,layoutY;
        double radius = (30 + 60 * pos ) * Math.PI / 180;
         switch(side) {
           
            case 0:  {
                ufo = new Polygon(new PolygonPoints.Triagle().GetPoints(2 * size));
                ufo.getTransforms().add(new Rotate(pos* 60, 0, 0));
                break;
            }
            case 1: {
                Rectangle r = new Rectangle(size * 2, 2 * size);
                r.setX(-size);
                r.setY(-size);
                ufo = r;
                break;
            }
            case 2:{
                ufo = new Polygon(new PolygonPoints.Hexagon().GetPoints(size));
                break;
            }
            default : {
                ufo = new Circle(size);
            }
        }
       
        
        layoutX = Setting.SCENE_WIDTH /2 + Setting.DISTANCE * Math.cos(radius);
        layoutY = Setting.SCENE_HEIGHT /2 + Setting.DISTANCE * Math.sin(radius);
        setX(layoutX);
        setY(layoutY);
        ufo.setFill(Setting.listColors[new Random().nextInt(6)]);
    }
    public void moveToCenter() {
        double centerX = Setting.SCENE_WIDTH/2;
        double centerY = Setting.SCENE_HEIGHT/2;
        double d = distance(centerX,centerY);
        if(d <= speed) return;
        d -= speed;
        double radius = (30 + 60 * pos ) * Math.PI / 180;
        double layoutX = Setting.SCENE_WIDTH /2 + d* Math.cos(radius);
        double layoutY = Setting.SCENE_HEIGHT /2 + d * Math.sin(radius);
        setX(layoutX);
        setY(layoutY);
    }
    public double distance(double x,double y) {
        double d =  new Point2D(this.x,this.y).distance(x,y);
        return d;
    }
    public final void setX(double x) {
        this.x = x;
        ufo.setLayoutX(x);
    }

    public final void setY(double y) {
        this.y = y;
        ufo.setLayoutY(y);
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
    
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getPos() {
        return pos;
    }

    public double getSpeed() {
        return speed;
    }

    public int getSize() {
        return size;
    }

    public Shape getUfo() {
        return ufo;
    }
    public Paint getColor() {
        return ufo.getFill();
    }
    
}
