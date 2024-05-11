package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {
    int longitud;
    private Nodo primero; 


    private class Nodo {
        Nodo prev; 
        T valor;
        Nodo sig;
        public Nodo(T valor){
            this.valor = valor;
        }
    }

    public ListaEnlazada() {
        this.longitud = 0; 
    }

     public ListaEnlazada(ListaEnlazada l) {
        this.longitud = l.longitud;
        this.primero = l.primero;  
    }

    public int longitud() {
        return this.longitud; 
    }

    public void agregarAdelante(T elem) {
        Nodo nuevoNodo = new Nodo(elem);
        if(longitud == 0){
            this.primero = nuevoNodo; 
        }else{
          primeroAnterior = this.primero; 
          this.primero = nuevoNodo; 
          this.primero.sig = primeroAnterior;
          primeroAnterior.prev = this.primero;    
        }
        this.longitud += 1; 
        
    }

    public void agregarAtras(T elem) {
        Nodo nuevo = new Nodo(elem);
        if (primero == null) {
           this.primero = nuevo;
        } else {
           Nodo actual = primero;
           while (actual.sig != null) {
                actual = actual.sig;
           }
        actual.sig = nuevo;
        nuevo.prev = actual; 
    }

    public T obtener(int i) {
        Nodo nodoEncontrado; 
        boolean encontrado = false; 
        if(i == 0){
            return this.primero; 
        }
        for(int j = 0; j<this.longitud; j++){
            nodoActual = this.primero; 
            if(j == i && !encontrado){
                nodoEncontrado = nodoActual.valor;
                encontrado = true; 
            }else{
                nodoActual = nodoActual.sig; 
            }
        }
        return nodoEncontrado; 
    }

    public void eliminar(int i) {
        Nodo actual = this.primero; 
        for(int j = 0; j<this.longitud; j++){
            prev = actual;
            siguiente = actual.sig; 

            if(j == i){
                prev.siguiente = actual.sig;
                actual.sig.prev = prev.siguiente;  
            }
        }
        Nodo prev = actual; 
        Nodo siguiente = actual.sig; 
        
        this.longitud -= 1; 
    }

    public void modificarPosicion(int indice, T elem) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public ListaEnlazada<T> copiar() {
        return new ListaEnlazada(this); 
    }
    public ListaEnlazada(ListaEnlazada<T> lista) {
        this.primero = lista.primero;
        this.longitud = lista.longitud;
    }
    
    @Override
    public String toString() {
        StringBuffer string = new StringBuffer(); 
        string.append("[");
        for(int j = 0; j<this.longitud; i++){
            string.append(this.primero.valor);
            this.primero = this.primero.sig; 
        }
        string.append("]")
    }

    private class ListaIterador implements Iterador<T> {
    	// Completar atributos privados

        public boolean haySiguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
        
        public boolean hayAnterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }

        public T siguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
        

        public T anterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
	    throw new UnsupportedOperationException("No implementada aun");
    }

}
}
