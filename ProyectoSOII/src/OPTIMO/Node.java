/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OPTIMO;


public class Node {
    int key;
    int value; // value -1 si ya fue analizado, sino por default 0
 
    public Node(int key){
        this.key = key;
        this.value = 0;
    }

    public void setAnalized(){
        this.value = -1;
    }
    
    public void reset(){
        this.value=0;
    }
    
}
