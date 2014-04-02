/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gisapp;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author 120149H
 */
public class CustomQueue<E> extends AbstractQueue<E> {
    ArrayList<E> queue;
    
    public CustomQueue(){
        queue = new ArrayList<E>();
    }
    
    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean offer(E e) {
        if(e != null){
            queue.add(0,e);
            return true;
        }
        else
            return false;
    }

    @Override
    public E poll() {
        if(!isEmpty())
            return queue.remove(queue.size()-1);
        else 
            return null;
    }

    @Override
    public E peek() {
        if(!isEmpty())
            return queue.get(0);
        else
            return null;    
    }
    
    public boolean isEmpty(){
        return queue.size() == 0;
    }
}
