/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gisapp;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author 120149H
 */
public class TrackerC extends Tracker {
    TrackerA trackA;
    TrackerB trackB;
    
    public TrackerC(){
        trackA = new TrackerA();
        trackB = new TrackerB();
    }

    @Override
    public void update(Observable o, Object arg) {
        trackA.update(o, arg);
        trackB.update(o, arg);
        if(((WayPoint)arg).isDestination())
            isAtDest = true;
    }
    
    private String getCurrentPath(){
        TrackerA tempA = (TrackerA)trackA.getCopyOfPath();
        return tempA.getPath();
    }

    @Override
    public String getPath() {
        if(isAtDest){
            TrackerB tempB = (TrackerB)trackB.getCopyOfPath();
            return tempB.getPath();
        }
        else
            return getCurrentPath();
    }

    @Override
    public void setStartingPoint(WayPoint start) {
        trackA.setStartingPoint(start);
        trackB.setStartingPoint(start);
    }
}
