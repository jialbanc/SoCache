/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lrualgoritmo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class LruAlgoritmo {

    /**
     * @param args the command line arguments
     */
    public void LRU() throws IOException{
        final int cacheSize=600000;
        
        LRUCache lr=new LRUCache(cacheSize);
	String file;
        file="C:/workload1.txt";
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while((line = br.readLine()) != null) {
            lr.set(line);
            //for (Map.Entry<String,Node> entry : lr.map.entrySet()) {
                //String key = entry.getKey();
                //Node value = entry.getValue();
                //System.out.println(value.value+"-");
            //}
            //System.out.println(" ");
        }
        br.close();
        System.out.println(lr.hit);
    
    }
    public static void main(String[] args) throws IOException {
        LruAlgoritmo a= new LruAlgoritmo();
        a.LRU();
    }
    
}
