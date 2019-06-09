/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author estudiantes
 */
public class ColaTerminados {
    private Nodo cabecera;
    private Nodo primero;
    private Nodo ultimo;
    int auxiliarcomienzo=0;
    int tam=0;
    int contador=0;
    public ColaTerminados() {
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
    public Nodo enqueue (int nombre,int tllegada,int trafaga,int tprioridad){
        Nodo aux = new Nodo(nombre,tllegada,trafaga,tprioridad,0,0,0,0, (int) (Math.random() * 1),cabecera);
        if (estaVacia()){
           primero=aux;
           cabecera.setSiguiente(primero);
        }
        else{
                ultimo.setSiguiente(aux);
                aux.setTcomienzo(auxiliarcomienzo);
        }
       if(contador==0){
               aux.setTcomienzo(aux.getTllegada());
           }
       else{
           if(auxiliarcomienzo<aux.getTllegada()){
               aux.setTcomienzo(aux.getTllegada());
           }
           else{
               
               aux.setTcomienzo(auxiliarcomienzo);
           }
           
       }
       
        contador++;
        tam++;
        ultimo=aux;
       return aux;
    } 
   public Nodo dequeue(){
        if (!estaVacia()){
            
            Nodo aux2=primero;
            aux2.setTfinal(aux2.getTcomienzo()+aux2.getTrafaga());
            aux2.setTretorno(aux2.getTfinal()-aux2.getTllegada());
            aux2.setTespera(aux2.getTretorno()-aux2.getTrafaga());
            Nodo aux=primero.getSiguiente();
            primero=aux;
            auxiliarcomienzo=aux2.getTfinal();
            tam--;
            return aux2;
        }
        else{
            return null;
        }
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
