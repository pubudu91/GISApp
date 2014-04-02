/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gisapp;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Pubudu
 */
public class RoadNetwork {
    private ArrayList<String> keys;
    private HashMap<String, WayPoint> vertices;
    private boolean adjacent[][];
    
    public RoadNetwork(int maxNodes){
        keys = new ArrayList<String>();
        vertices = new HashMap<String, WayPoint>();
        adjacent = new boolean[maxNodes][maxNodes];
    }
    
    public void addPlace(String place){
        String temp = place.toLowerCase();
        keys.add(temp);
        vertices.put(temp, new WayPoint(place));
    }
    
    public boolean addPath(String place1, String place2){
        if(keys.contains(place1.toLowerCase()) && keys.contains(place2.toLowerCase())){
            int r = keys.indexOf(place1.toLowerCase());
            int c = keys.indexOf(place2.toLowerCase());
            
            adjacent[r][c] = adjacent[c][r] = true;
            
            return true;
        }
        else
            return false;
    } 
    
    public WayPoint getPlace(String name){
        return vertices.get(name.toLowerCase());
    }
    
    public WayPoint[] getAdjacentPlaces(WayPoint point){
        int index = keys.indexOf(point.toString().toLowerCase());
        int limit = keys.size();
        ArrayList<WayPoint> adj = new ArrayList<WayPoint>();
        
        if(index < 0)
            return null;
        else{
            for(int i=0; i<limit; i++){
                if(index == i)
                    continue;
                
                if(adjacent[index][i])
                    adj.add(vertices.get(keys.get(i)));
            }
        }
        
        if(adj.size() == 0)
            return null;
        else
            return adj.toArray(new WayPoint[1]);
    }
}
