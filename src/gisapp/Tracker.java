/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gisapp;

import java.util.Observer;

/**
 *
 * @author 120149H
 */
abstract class Tracker implements Observer, Cloneable {
    protected boolean isAtDest; // flag for checking whether the traveller is at his destination
    
    public Object getCopyOfPath() {
        Object obj = null;
        try{
            obj = clone();
        }
        catch(Exception e){}
        
        return obj;
    }
    
    abstract public void printPath();
    
    abstract public void setStartingPoint(WayPoint start);
}
