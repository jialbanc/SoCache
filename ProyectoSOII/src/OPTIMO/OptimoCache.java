/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OPTIMO;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class OptimoCache {
    int capacity;
    HashMap<String, Node> map = new HashMap<String, Node>();
    HashMap<Integer, String> mapFuturo = new HashMap<Integer, String>();
    int hit;
    int miss;
    int warm;
    
 
    public OptimoCache(int capacity, HashMap<Integer, String> mapFuturo) {
        this.capacity = capacity;
        this.hit=0;
        this.mapFuturo = mapFuturo;
        this.miss=0;
        this.warm=0;
    }
 
    public void findLast(int pos){
        boolean keepGoing = true;
        int cursor = pos+1;
        int numNodosAnalizados = 0;
        while(keepGoing){
            if(!mapFuturo.containsKey(cursor)){
                break;
            }
            for (Map.Entry<String,Node> entry : map.entrySet()) {
                
                if(entry.getKey().equals(mapFuturo.get(cursor))){
                    if(entry.getValue().value!=-1){
                        Node nuevo = new Node(cursor);
                        nuevo.setAnalized();
                        entry.setValue(nuevo);
                        numNodosAnalizados++;
                    }
                    if(numNodosAnalizados == capacity-1)
                        break;
                }
            }
            cursor++;
        }
    }
    
    public void removeLast(){
        String removed="";
        for (Map.Entry<String,Node> entry : map.entrySet()) {
            if(entry.getValue().value==0)
                removed=entry.getKey();
            else
                entry.getValue().reset();
        }
        map.remove(removed);
    }
    
    public void set(String key, int pos) {
    
        if(map.containsKey(key)){
            hit++;
        }else{
            miss++;
            Node current = new Node(pos);
            if(map.size()>=capacity){
                warm++;
                findLast(pos);
                removeLast();
                map.put(key, current);
            }else{
                map.put(key, current);
            }
        }
    }
}
