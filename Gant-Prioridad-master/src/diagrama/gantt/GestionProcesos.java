/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagrama.gantt;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import logica.ColaBloqueados;
import logica.ColaListos;
import logica.ColaTerminados;
import logica.Nodo;

/**
 *
 * @author Victoria
 */
public class GestionProcesos {
    private int i=3;
    public  void insertar(ColaListos listos,Date comienzo) {
	TimerTask insertar = new TimerTask() {
	    public void run() {
               i++;
	        listos.enqueue(i,diferenciasegundos(comienzo,new Date()));
	     }
	    };
	    Timer timer = new Timer("Timer"); //timer que programa la tarea para cada 5 segundos
	    long delay  = 2000L; //retraso del hilo
	    long period = 2000L; //período de retraso
	    timer.scheduleAtFixedRate(insertar, delay, period);
            
	}
    public  void atenderlistos(ColaListos listos) {
        
	TimerTask atender = new TimerTask() {
	    public void run() {
                Nodo aux=listos.dequeue();
                String cadena="";
                cadena+= aux.getNombre() +"\t\t"+aux.getTllegada()+"\t\t"+aux.getTrafaga()+"\t\t"+aux.getPrioridad()+"\t\t"+aux.getTcomienzo()+"\t\t"+aux.getTfinal()+"\t\t"+aux.getTretorno()+"\t\t"+aux.getTespera();
                System.out.println(cadena);
            }
	    };
	    Timer timer = new Timer("Timer"); //timer que programa la tarea para cada 5 segundos
	    long delay  = 4000L; //retraso del hilo
	    long period = 4000L; //período de retraso
	    timer.scheduleAtFixedRate(atender, delay, period);
	}
    public  void atenderbloqueados(ColaBloqueados bloqueados) {
        
	TimerTask atender = new TimerTask() {
	    public void run() {
                Nodo aux=bloqueados.dequeue();
            }
	    };
	    Timer timer = new Timer("Timer"); //timer que programa la tarea para cada 5 segundos
	    long delay  = 3000L; //retraso del hilo
	    long period = 3000L; //período de retraso
	    timer.scheduleAtFixedRate(atender, delay, period);
	}
    public  void atenderTerminados(ColaTerminados terminados) {
        
	TimerTask atender = new TimerTask() {
	    public void run() {
                Nodo aux=terminados.dequeue();
            }
	    };
	    Timer timer = new Timer("Timer"); //timer que programa la tarea para cada 5 segundos
	    long delay  = 3000L; //retraso del hilo
	    long period = 3000L; //período de retraso
	    timer.scheduleAtFixedRate(atender, delay, period);
	}
    
    public int diferenciasegundos (Date fechacomienzo,Date fechaactual ){
        int diferencia= (int)((fechaactual.getTime()-fechacomienzo.getTime())/1000);
        return diferencia;
    }
}
