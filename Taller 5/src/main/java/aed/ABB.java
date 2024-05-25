package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    private Nodo raiz; 
    private int cardinal; 
    private int altura; 

    private class Nodo {
        Nodo izq;
        Nodo der;
        Nodo arriba;  
        T val; 

        public Nodo(T val){
            this.val = val; 
        }
    }

    public ABB() {
        this.raiz = null; 
    }

    public int cardinal() {
        return this.cardinal; 
    }

    public T minimo(){
       Nodo nodo = this.raiz;  
       while(nodo != null){
        nodo = this.raiz.izq;
       }
       return nodo.val; 
    }

    public T maximo(){
       Nodo nodo = this.raiz;  
       while(nodo != null){
        nodo = this.raiz.der;
       }
       return nodo.val; 
    }

    public void insertar(T elem){
       Nodo nodo = this.raiz;
       Nodo nuevoNodo = new Nodo(elem);
       boolean insertado = false; 
       if(this.pertenece(elem)) return; 
       
       if(nodo == null){
            this.raiz = nuevoNodo; 
            this.cardinal += 1;
            return; 
       }
    
       while(nodo != null && !insertado){
            if(nuevoNodo.val.compareTo(nodo.val) > 0){
                if(nodo.der == null){
                    nodo.der = nuevoNodo;
                    nuevoNodo.arriba = nodo;
                    insertado = true; 
                    this.cardinal += 1;
                }else {
                    nodo = nodo.der;
                }
            }else{
                if(nodo.izq == null){
                     nodo.izq = nuevoNodo;
                     nuevoNodo.arriba = nodo;
                     insertado = true; 
                     this.cardinal +=1;
                }else{
                    nodo = nodo.izq;
                }
            }
           }
       

      
    }

    public boolean pertenece(T elem){
        Nodo nodo = this.raiz; 
        boolean encontrado = false; 
        while(nodo != null && !encontrado){
            if(elem.compareTo(nodo.val)==0){
                encontrado = true; 
            }else if(elem.compareTo(nodo.val)<0){
                nodo = nodo.izq;
            }else {
                nodo = nodo.der;
            }
        }
        return encontrado; 
    }

    public void eliminar(T elem){
        throw new UnsupportedOperationException("No implementada aun");
    }

    public String toString(){
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo _actual;

        public boolean haySiguiente() {            
            throw new UnsupportedOperationException("No implementada aun");
        }
    
        public T siguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
