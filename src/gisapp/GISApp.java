/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gisapp;

import java.util.Scanner;

/**
 *
 * @author Pubudu
 */
public class GISApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RoadNetwork map = new RoadNetwork(10);
        Scanner in = new Scanner(System.in);
        TrackerB trackB = new TrackerB();
        TrackerA trackA = new TrackerA();
        TrackerC trackC = new TrackerC();
        
        map.addPlace("Uni");
        map.addPlace("Katubedda");
        map.addPlace("Piliyandala");
        map.addPlace("Colombo");
        map.addPlace("Moratumulla");
        
        map.addPath("Uni", "Katubedda");
        map.addPath("Katubedda", "Colombo");
        map.addPath("Uni", "Piliyandala");
        map.addPath("Uni", "Moratumulla");
        map.addPath("Piliyandala", "Colombo");
        
        Traveller t = new Traveller("Pubudu",map.getPlace("Uni"));
        trackB.setStartingPoint(t.getCurrentLocation());
        trackA.setStartingPoint(t.getCurrentLocation());
        trackC.setStartingPoint(t.getCurrentLocation());
        t.addObserver(trackB);
        t.addObserver(trackA);
        t.addObserver(trackC);
        
       /**/ System.out.println("Enter Destination: ");
        t.setDestination(map.getPlace(in.next()));
        
        int count = 0;

        while(!t.getCurrentLocation().equals(t.getDestination())){
            System.out.println("Enter Location to go from current place: ");
            t.goTo(map.getPlace(in.next()));
            if((count++) == 2)
                trackC.printPath();
                
        }
        
        //System.out.println(t.getDestination()==map.getPlace(in.next()));
            
        trackB.printPath();
        trackA.printPath();
        trackC.printPath();
       // System.out.println(new WayPoint("Colombo").equals(new WayPoint("clombo")));
    }
    
    private static String toCamelCase(String str){
        char temp[] = str.toCharArray();
        temp[0] = (char) ((temp[0] ^ 32) & temp[0]);
        
        for(int i=1; i<temp.length; i++){
            if(temp[i-1] == ' ' && !Character.isDigit(temp[i]))
                temp[i] = (char) ((temp[i] ^ 32) & temp[i]);
        }
        
        return new String(temp);
    }
}
