/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmos;

import CLOCK.ClockAlgoritmo;
import FIFO.FifoAlgoritmo;
import LRU.LruAlgoritmo;
import OPTIMO.OptimoAlgoritmo;
import java.io.IOException;


public class ProyectoSOII {

    /**
     * @param args the command line arguments
     */
    /*FORMATO DE CONSOLA java -jar ProyectoSOII.jar workload.txt lru 5000 */
    
    public static void main(String[] args) throws IOException {
        LRU.LruAlgoritmo algoritmo1= new LruAlgoritmo();
        CLOCK.ClockAlgoritmo algoritmo2= new ClockAlgoritmo();
        OPTIMO.OptimoAlgoritmo algoritmo3= new OptimoAlgoritmo();
        FIFO.FifoAlgoritmo algoritmo4= new FifoAlgoritmo();
        String Documento,Politica;
        int Cache;
        if(args.length<3){
            System.out.println("No hay suficientes argumentos recibidos");
            return;
        }
        Documento = args[0];
        Politica= args[1];
        Cache = Integer.parseInt(args[2]);
        switch(Politica.toUpperCase()){
           case "LRU":
               algoritmo1.LRU(Documento,Cache);
               break;
           case "OPTIMO":
               algoritmo3.Optimo(Documento,Cache);
               break;
           case "CLOCK":
               algoritmo2.Clock(Documento,Cache);
               break;
           case "FIFO":
               algoritmo4.FIFO(Documento, Cache);
               break;
            default:
                break;
             
       }
    }
    
}
