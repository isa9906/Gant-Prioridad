/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;

/**
 *
 * @author Victoria
 */
public class ColaBloqueados {
    private Nodo cabecera;
    private Nodo primero;
    private Nodo ultimo;
    private ColaListos listos;
    int tam=0;
    
    public ColaBloqueados(ColaListos listos) {
        this.listos=listos;
        cabecera=new Nodo (0,0,0,0,0,0,0,0,0,cabecera);
        primero=cabecera;
        ultimo=cabecera;
        tam=0;
    }
    public boolean estaVacia (){
        return primero==cabecera;
    }
    public int size (){
        return tam;
    }
    public Nodo enqueue (int nombre,int tllegada,int trafaga,int prioridad){
        Nodo aux = new Nodo(nombre,tllegada,prioridad,(int)(Math.random()*8+1),0,0,0,0,0,cabecera);
        if (estaVacia()){
           primero=aux;
           cabecera.setSiguiente(primero);
        }
        else{
                ultimo.setSiguiente(aux);
        }
        tam++;
        ultimo=aux;
       return aux;
    } 
   public Nodo dequeue(){
        if (!estaVacia()){
             Nodo aux2=primero;
            listos.enqueue(aux2.getNombre(),aux2.getTllegada(),aux2.getTrafaga(),aux2.getPrioridad());
            
            Nodo aux=primero.getSiguiente();
            primero=aux;
            primero.setTcomienzo(aux2.getTfinal());
            tam--;
            return aux2;
        }
        else{
            return null;
        }
    }
   public Nodo getI(int i){
       Nodo aux=primero;
       int j;
       for (j=0;j<=i;j++){
           aux=aux.getSiguiente();
       }
       return aux;
   }
    public String Mostrar() {
        if (estaVacia()){
            return "No hay procesos en cola";
        }
        else{
            String cadena = "Nombre \t T llegada \t T rafaga \t T comienzo \t T final \t T retorno \t T espera \n";
            Nodo aux = primero;
            
            while (aux!=cabecera){
                cadena+= aux.getNombre() +"\t"+aux.getTllegada()+"\t"+aux.getTrafaga()+"\t"+aux.getTcomienzo()+"\t"+aux.getTfinal()+"\t"+aux.getTretorno()+"\t"+aux.getTespera()+"\n";
                aux =aux.getSiguiente();
            }        
            return cadena;
        }
    }
}
