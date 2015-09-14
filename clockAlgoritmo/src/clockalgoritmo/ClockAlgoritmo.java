/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clockalgoritmo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;


public class ClockAlgoritmo {

    /**
     * @param args the command line arguments
     */
    public void Clock() throws IOException{
        final int cacheSize=5000;
        
        ClockCache lr=new ClockCache(cacheSize);
	String file;
        file="C:/workload1.txt";
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while((line = br.readLine()) != null) {
            lr.set(line);
            //i=i%cacheSize;
            
        }
        br.close();
        System.out.println(lr.hit);
    
    }
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        ClockAlgoritmo a= new ClockAlgoritmo();
        a.Clock();
    }
    
}
