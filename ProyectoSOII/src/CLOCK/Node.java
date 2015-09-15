/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CLOCK;

/**
 *
 * @author Jimmy
 */
public class Node {
    public String key;
    Node pre;
    Node next;
    int bit;
 
    public Node(String key){
        this.key = key;
        this.bit=0;
    }
}
