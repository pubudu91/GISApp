/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gisapp;

import java.util.Observable;
import java.util.Scanner;

/**
 *
 * @author Pubudu
 */
public class Traveller extends Observable {
    private String name;
    private Scanner in;
    private WayPoint currentLocation;
    private WayPoint destination;
    
    public Traveller(String name, WayPoint start){
        this.name = name;
        in = new Scanner(System.in);
        this.currentLocation = start;
    }
    
    public Traveller(String name, String start){
        this.name = name;
        in = new Scanner(System.in);
        this.currentLocation = new WayPoint(start);
    }
    
    public void goTo(WayPoint current){
        currentLocation = current;
        setChanged();
        notifyObservers(currentLocation);
    }
    
    public void setDestination(WayPoint destination){
        this.destination = destination;
    }
    
    public WayPoint getDestination(){
        return destination;
    }
    
    /*public void setCurrentLocation(String current){
        currentLocation = new WayPoint(current);
    }*/
    
    public WayPoint getCurrentLocation(){
        return currentLocation;
    }
}
