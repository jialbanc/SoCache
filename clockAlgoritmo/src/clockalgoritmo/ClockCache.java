/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clockalgoritmo;

import java.util.HashMap;

/**
 *
 * @author Jimmy
 */
public class ClockCache {
    int capacity;
    HashMap<String, Node> map = new HashMap<String, Node>();
    Node head=null;
    Node end=null;
    int hit;
 
    public ClockCache(int capacity) {
        this.capacity = capacity;
        this.hit=0;
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
            Node old = map.get(key);
            if(old.bit==0){
                old.bit=1;
            }
            remove(old);
            setHead(old);
            hit++;
        }else{
            Node created = new Node(key);
            if(map.size()>=capacity){
                if(end.bit==0){
                    map.remove(end.key);
                    remove(end);
                    setHead(created);
                    map.put(key, created);
                }else{
                    Node old = map.get(end.key);
                    old.bit=0;
                    remove(old);
                    setHead(old);
                    set(key);
                }
            }else{
                setHead(created);
                map.put(key, created);
            }    
            
            
        }
    }
}
