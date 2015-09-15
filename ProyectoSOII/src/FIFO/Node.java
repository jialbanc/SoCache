/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package FIFO;

import LRU.*;


public class Node {
    public String key;
    Node pre;
    Node next;
 
    public Node(String key){
        this.key = key;
    }
}
