/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package FIFO;

import LRU.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class FifoAlgoritmo {

    /**
     * @param args the command line arguments
     */
    public void FIFO(String Documento, int Cache) throws IOException{
        final int cacheSize=Cache;
        
        FIFOCache lr=new FIFOCache(cacheSize);
        DecimalFormat df = new DecimalFormat("0.00"); 
	String file;
        float total;
        int warm_cache1;
        float warm_cache,miss_rate;
        file="C:/"+Documento;
        
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while((line = br.readLine()) != null) {
            lr.set(line);
            }
        br.close();
        
        total=lr.hit+lr.miss;
        miss_rate= (float)(lr.miss/total)*100;
        warm_cache=(float)((lr.miss-Cache)/(total-Cache))*100;
       
        
        System.out.println("Miss rate:             "+df.format(miss_rate)+"%  ("+lr.miss+" misses out of "+total+" references)");
        System.out.println("Miss rate(warm cache):  "+df.format(warm_cache)+"%  ("+lr.warmCache+" misses out of "+total+"-"+Cache+" references)");
    }
  
   
}
