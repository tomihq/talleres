package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {
    private int longitud;
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
        if(this.longitud == 0){
            this.primero = nuevoNodo; 
        }else{
          Nodo primeroAnterior = this.primero; 
          nuevoNodo.sig = primeroAnterior;
          primeroAnterior.prev = nuevoNodo; 
          this.primero = nuevoNodo; 
        }
        this.longitud += 1; 
        
    }

    public void agregarAtras(T elem) {
        Nodo nuevo = new Nodo(elem);
        if (this.longitud == 0) {
           this.primero = nuevo;
        } else {
           Nodo actual = this.primero;
           while (actual.sig != null) {
                actual = actual.sig;
           }
        actual.sig = nuevo;
        nuevo.prev = actual; 
        }
        this.longitud += 1;
    }

    public T obtener(int i) {
        T nodoEncontrado = null; 
        for(int j = 0; j<this.longitud; j++){
            Nodo nodoActual = this.primero; 
            if(j == i){
                nodoEncontrado = nodoActual.valor;
                break;
            }else{
                nodoActual = nodoActual.sig; 
            }
        }
        return nodoEncontrado; 
    }

    public void eliminar(int i) {
        Nodo actual = this.primero; 
        
    }

    public void modificarPosicion(int indice, T elem) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public ListaEnlazada<T> copiar() {
        return new ListaEnlazada(this); 
    }
 /*    public ListaEnlazada(ListaEnlazada<T> lista) {
        this.primero = lista.primero;
        this.longitud = lista.longitud;
    } */
    
    @Override
    public String toString() {
        StringBuffer string = new StringBuffer(); 
        string.append("[");
        for(int j = 0; j<this.longitud; j++){
            string.append(this.primero.valor);
            this.primero = this.primero.sig; 
        }
        string.append("]");
        return string.toString(); 
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
