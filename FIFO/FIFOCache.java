/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package FIFO;

import LRU.*;
import java.util.HashMap;


public class FIFOCache {
    int capacity;
    HashMap<String, Node> map = new HashMap<String, Node>();
    Node head=null;
    Node end=null;
    int hit;
    int warmCache;
    int miss;
 
    public FIFOCache(int capacity) {
        this.capacity = capacity;
        this.hit=0;
        this.warmCache=0;
        this.miss=0;
    }

    public void remove(Node n){
        if(n.pre!=null){
            n.pre.next = n.next;
        }else{
            head = n.next;
        }
 
        if(n.next!=null){
            n.next.pre = n.pre;
        }else{
            end = n.pre;
        }
 
    }
 
    public void setHead(Node n){
        n.next = head;
        n.pre = null;
 
        if(head!=null)
            head.pre = n;
 
        head = n;
 
        if(end ==null)
            end = head;
    }
    
    public void set(String key) {
    
        if(map.containsKey(key)){            
            hit++;
        }else{
            miss++;
            Node created = new Node(key);
            if(map.size()>=capacity){
                map.remove(end.key);
                remove(end);
                setHead(created);
                warmCache++;
            }else{
                setHead(created);
            }
            map.put(key, created);
        }
    }
}
