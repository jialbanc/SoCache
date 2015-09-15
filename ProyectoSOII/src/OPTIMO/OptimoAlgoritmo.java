/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OPTIMO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class OptimoAlgoritmo {

    /**
     * @param args the command line arguments
     */
    public void Optimo(String Documento, int Cache) throws IOException{
        final int cacheSize=Cache;
        float total;
        int warm_cache1;
        float warm_cache,miss_rate;
      
        DecimalFormat df = new DecimalFormat("0.00"); 
        HashMap<Integer, String> mapFuturo = new HashMap<Integer, String>();
	String file;
        file="C:/"+Documento;
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        int i=0;
        while((line = br.readLine()) != null){
            mapFuturo.put(i,line);
            i++;
        }
        br.close();
        OptimoCache lr=new OptimoCache(cacheSize,mapFuturo);
        BufferedReader br2 = new BufferedReader(new FileReader(file));
        i=0;
        while((line = br2.readLine()) != null){
            lr.set(line,i);
            i++;
        }
        total=lr.hit+lr.miss;
        miss_rate= (float)(lr.miss/total)*100;
        warm_cache=(float)((lr.miss-Cache)/(total-Cache))*100;
       
        
        System.out.println("Miss rate:             "+df.format(miss_rate)+"%  ("+lr.miss+" misses out of "+total+" references)");
        System.out.println("Miss rate(warm cache):  "+df.format(warm_cache)+"%  ("+lr.warm+" misses out of "+total+"-"+Cache+" references)");
    
    }
   
    
}
