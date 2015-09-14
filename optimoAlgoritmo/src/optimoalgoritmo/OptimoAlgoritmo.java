/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package optimoalgoritmo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Jimmy
 */
public class OptimoAlgoritmo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        final int cacheSize=600000;
        
        HashMap<Integer, String> mapFuturo = new HashMap<Integer, String>();
	String file;
        file="C:/ESPOL/workload.txt";
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
        System.out.println(lr.hit);
    }
    
}
