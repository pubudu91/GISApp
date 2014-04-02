/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gisapp;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Pubudu
 */
public class GISApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        RoadNetwork map = new RoadNetwork(10);       
        TrackerB trackB = new TrackerB();
        TrackerA trackA = new TrackerA();
        TrackerC trackC = new TrackerC();
        Scanner kboard = new Scanner(System.in);
        
        /*map.addPlace("Uni");
        map.addPlace("Katubedda");
        map.addPlace("Piliyandala");
        map.addPlace("Colombo");
        map.addPlace("Moratumulla");
        
        map.addPath("Uni", "Katubedda");
        map.addPath("Katubedda", "Colombo");
        map.addPath("Uni", "Piliyandala");
        map.addPath("Uni", "Moratumulla");
        map.addPath("Piliyandala", "Colombo");*/
        
        getLocationDetails(map);
        
        Traveller t = new Traveller("Pubudu",map.getPlace("Uni"));
        
        trackB.setStartingPoint(t.getCurrentLocation());
        trackA.setStartingPoint(t.getCurrentLocation());
        trackC.setStartingPoint(t.getCurrentLocation());
        
        t.addObserver(trackB);
        t.addObserver(trackA);
        t.addObserver(trackC);

        System.out.println("Enter Destination: ");
        t.setDestination(map.getPlace(kboard.next()));
        
        int count = 0;

        while(!t.getCurrentLocation().equals(t.getDestination())){
            displayAdjPlaces(map,t.getCurrentLocation());
            System.out.println("Enter Location to go from current place: ");
            //t.goTo(map.getPlace(kboard.next()));
            WayPoint next = map.getPlace(kboard.next());
            if(next == null){
                System.out.println("Invalid location");
                continue;
            }
            t.goTo(next);
            if((count++) == 2)
                System.out.println("Path travelled so far as tracked by Type-C tracker: "+trackC.getPath());
                
        }
            
        System.out.println("The actual path: "+trackB.getPath());
        System.out.println("The complete path: "+trackA.getPath());
        System.out.println("The tracked path of Tracker C: "+trackC.getPath());
    }
    
    public static void displayAdjPlaces(RoadNetwork map, WayPoint current){
        WayPoint[] adj = map.getAdjacentPlaces(current);
        
        if(adj == null){
            System.out.println("No adjacent locations");
            return;
        }
        
        for(int i = 0; i < adj.length; i++) 
            System.out.print(adj[i]+" ");
        
        System.out.println();
    }
    
    public static void getLocationDetails(RoadNetwork map)throws IOException{
        Scanner in = new Scanner(new File("Input/input.txt"));
        
        int n = in.nextInt();
        
        for(int i=0; i<n; i++)
            map.addPlace(in.next());
        
        for(int i=0; i<n; i++)
            map.addPath(in.next(),in.next());
    }
}
