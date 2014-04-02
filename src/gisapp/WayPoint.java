/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gisapp;

/**
 *
 * @author Pubudu
 */
public class WayPoint {
    private String name;
    private boolean wasVisited;
    
    public WayPoint(String name){
        this.name = toCamelCase(name);
    }
    
    public String getName(){
        return name;
    }
    
    private String toCamelCase(String str){
        char temp[] = str.toCharArray();
        temp[0] = (char) ((temp[0] ^ 32) & temp[0]);
        
        for(int i=1; i<temp.length; i++){
            if(temp[i-1] == ' ' && !Character.isDigit(temp[i]))
                temp[i] = (char) ((temp[i] ^ 32) & temp[i]);
        }
        
        return new String(temp);
    }
    
    public void setVisited(boolean visited){
        this.wasVisited = visited;
    }
    
    public boolean wasVisited(){
        return wasVisited;
    }
    
    public String toString(){
        return this.name;
    }
    
    public boolean equals(WayPoint obj){
        return this.name.equals(obj.getName());
    }
}
