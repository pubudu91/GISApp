/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gisapp;

import java.util.Comparator;
import java.util.Observable;
import java.util.Observer;
import java.util.PriorityQueue;

/**
 *
 * @author 120149H
 */
public class TrackerA implements Observer{
    private final static int INITIAL = 10;
    CustomQueue<WayPoint> path;
    
    public TrackerA(){   
        path = new CustomQueue<WayPoint>();
    }
    
    public void update(Observable o, Object arg){
        WayPoint pt = (WayPoint) arg;
        path.offer(pt);
        //pt.setVisited(true);
    }
    
    public void printPath(){
        System.out.print("\nThe path from A-type Tracker: ");
        while(!path.isEmpty()){
            System.out.print(path.poll());
            
            if(path.isEmpty())
               break;
            
            System.out.print(" -> ");
        }
        System.out.println();
    }
    
    public void setStartingPoint(WayPoint start){
        if(path.size()==0){
            path.add(start);
            start.setVisited(true);
        }
    }
}
