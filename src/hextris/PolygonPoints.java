/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hextris;

/**
 *
 * @author dell
 */

public class PolygonPoints {
    static double [] points;
    public static class Triagle{
        
        public double[] GetPoints(double side){
            points = new double[6];
            // X                       Y
            points[0] =  0  ;         points[1] = 0 ;
            points[2] =  side  ;         points[3] = 0 ;
            points[4] =  side/2  ;    points[5] = side*Math.sqrt(3)/2;
            return points;
        }
    }
    
}
