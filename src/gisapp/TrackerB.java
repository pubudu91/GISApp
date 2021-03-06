/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gisapp;

import java.util.Observable;
import java.util.Observer;
import java.util.Stack;

/**
 *
 * @author Pubudu
 */
public class TrackerB extends Tracker implements Cloneable {
    Stack<WayPoint> path;
    
    public TrackerB(){
        path = new Stack<WayPoint>();
    }
    
    public void update(Observable o, Object arg) {
        WayPoint pt = (WayPoint) arg;
        //System.out.println(arg+" "+pt.wasVisited());
        if(!path.contains(pt))
            path.push(pt);
        else{
            while(!path.peek().equals(pt))
                path.pop();
        }
    }
    
    public String getPath(){
        Stack<WayPoint> temp = new Stack<WayPoint>();
        
        //System.out.printf("\nThe path : ");
        StringBuilder txt = new StringBuilder();
        
        while(!path.isEmpty())
            temp.push(path.pop());
        
        while(!temp.isEmpty()){
            //System.out.print(temp.pop());
            txt.append(temp.pop());
                        
            if(temp.isEmpty())
                break;
            //System.out.print(" -> ");
            txt.append(" -> ");
        }
        
        //System.out.println();
        return txt.toString();
    }
    
    public void setStartingPoint(WayPoint start){
        if(path.size()==0)
            path.push(start);
    }
}
