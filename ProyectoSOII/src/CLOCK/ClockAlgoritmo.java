/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CLOCK;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Map;


public class ClockAlgoritmo {

    /**
     * @param args the command line arguments
     */
    public void Clock(String Documento, int Cache) throws IOException{
        final int cacheSize=Cache;
        float total;
        int warm_cache1;
        float warm_cache,miss_rate;
      
        DecimalFormat df = new DecimalFormat("0.00"); 
        ClockCache lr=new ClockCache(cacheSize);
	String file;
        file=Documento;
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        int miss=0;
        while((line = br.readLine()) != null) {
            miss++;
            lr.set(line);
            //i=i%cacheSize;
            
        }
        br.close();
        total=lr.hit+lr.miss;
        miss_rate= (float)(lr.miss/total)*100;
        warm_cache=(float)((lr.miss-Cache)/(total-Cache))*100;
       
        
        System.out.println("Miss rate:             "+df.format(miss_rate)+"%  ("+lr.miss+" misses out of "+total+" references)");
        System.out.println("Miss rate(warm cache):  "+df.format(warm_cache)+"%  ("+lr.warm+" misses out of "+total+"-"+Cache+" references)");
    
    }

}
