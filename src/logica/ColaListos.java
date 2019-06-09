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
public class ColaListos {
    private Nodo cabecera;
    private Nodo primero;
    private Nodo ultimo;
    private ColaTerminados terminados;
    private ColaBloqueados bloqueados;
    int tam=0;
    
    public ColaListos(ColaTerminados terminados) {
        bloqueados=new ColaBloqueados(this);
        cabecera=new Nodo (0,0,0,100000,0,0,0,0,0,cabecera);
        this.terminados=terminados;
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
        Nodo aux = new Nodo(nombre,tllegada,trafaga,tprioridad,0,0,0,0, (int) (Math.random() * 2+1),cabecera);
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
     public Nodo enqueue (int nombre,int tllegada){
        Nodo aux = new Nodo(nombre,tllegada,(int)(Math.random()*8+1),(int)(Math.random()*8+1),0,0,0,0,(int)(Math.random()*2+1),cabecera);
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
       if(!estaVacia()){
       Nodo anterior=cabecera;
       Nodo actual=primero;
       Nodo siguiente=actual.getSiguiente();
       int i;
       
       Nodo minimo=actual;
       Nodo anteriormin=anterior;
       Nodo sigminimo=siguiente;
       
       for (i=1;i<size();i++){
           anterior=actual;
           actual=siguiente;
           siguiente=actual.getSiguiente();
           if(minimo.getPrioridad()>actual.getPrioridad()){
               minimo=actual;
               anteriormin=anterior;
               sigminimo=siguiente;
           }
       }
       if (minimo.getEstado()==2){
           bloqueados.enqueue(minimo.getNombre(),minimo.getTllegada(),minimo.getTrafaga(),minimo.getPrioridad());
       }
       else{
         terminados.enqueue(minimo.getNombre(),minimo.getTllegada(),minimo.getTrafaga(),minimo.getPrioridad());
       }
       if(minimo==primero){
           primero=sigminimo;
       }
       if(minimo==ultimo){
           ultimo=anteriormin;
       }
       anteriormin.setSiguiente(sigminimo);
     if(minimo==cabecera){
         return null;
     }
     else{
         return minimo;
     }    
       }
       else{
           return null;
       }
     
     
       
       /**
        if (!estaVacia()){
            Nodo aux2=primero;
            if(tam==1){
               aux2.setTcomienzo(0);
            }
            aux2.setTfinal(aux2.getTcomienzo()+aux2.getTrafaga());
            aux2.setTretorno(aux2.getTfinal()-aux2.getTllegada());
            aux2.setTespera(aux2.getTretorno()-aux2.getTrafaga());
            Nodo aux=primero.getSiguiente();
            primero=aux;
            primero.setTcomienzo(aux2.getTfinal());
            return aux2;
        }
        else{
            return null;
        }
        **/
    }

    public ColaTerminados getTerminados() {
        return terminados;
    }

    public void setTerminados(ColaTerminados terminados) {
        this.terminados = terminados;
    }

    public ColaBloqueados getBloqueados() {
        return bloqueados;
    }

    public void setBloqueados(ColaBloqueados bloqueados) {
        this.bloqueados = bloqueados;
    }
   
   
    public String Mostrar() {
        if (estaVacia()){
            return "No hay procesos en cola";
        }
        else{
            String cadena = "Nombre \t T llegada \t T rafaga \t T comienzo \t T final \t T retorno \t T espera \n";
            Nodo aux = primero;
            
            while (aux!=cabecera){
                cadena+= aux.getNombre() +"\t"+aux.getTllegada()+"\t"+aux.getTrafaga()+"\t"+aux.getPrioridad()+"\n";
                aux =aux.getSiguiente();
            }        
            return cadena;
        }
    }
   
}
