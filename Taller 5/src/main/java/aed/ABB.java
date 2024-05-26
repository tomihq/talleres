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
        T res = minimoRecursivo(this.raiz);
        return res;
    }

    public T minimoRecursivo(Nodo arbol){
        if(arbol.izq == null) return arbol.val;
        return maximoRecursivo(arbol.izq);
    }

    public T maximo(){
       T res = maximoRecursivo(this.raiz);
       return res;
    }

    public T maximoRecursivo(Nodo arbol){
        if(arbol.der == null) return arbol.val;
        return maximoRecursivo(arbol.der);
    }

    public void insertar(T elem){
       Nodo nodo = this.raiz;
       Nodo nuevoNodo = new Nodo(elem);
       if(this.pertenece(elem)) return; 
       
       if(nodo == null){
            this.raiz = nuevoNodo; 
            this.cardinal += 1;
            return; 
       }
    
       this.insertarRecursivo(nuevoNodo, nodo);
      
    }

    public void insertarRecursivo(Nodo nuevoNodo, Nodo arbol){
        if(arbol == null) return; 
        if(nuevoNodo.val.compareTo(arbol.val) > 0){
            if(arbol.der == null) arbol.der = insertarNodo(nuevoNodo, arbol, arbol.der);
            else insertarRecursivo(nuevoNodo, arbol.der);
        }else{
            if(arbol.izq == null) arbol.izq = insertarNodo(nuevoNodo, arbol, arbol.izq);
            else insertarRecursivo(nuevoNodo, arbol.izq);
        }

    }

    public Nodo insertarNodo(Nodo nuevoNodo, Nodo arbol, Nodo arbolLado){
        arbolLado = nuevoNodo;
        nuevoNodo.arriba = arbol;
        this.cardinal += 1;
        return nuevoNodo;
    }

    public boolean pertenece(T elem){
        Nodo nodo = this.raiz;
        boolean encontrado = perteneceRecursivo(elem, nodo); 
        return encontrado; 
    }

    public boolean perteneceRecursivo(T elem, Nodo arbol){
        if(arbol == null) return false; 
        if(elem.compareTo(arbol.val)==0) return true; 
        else if(elem.compareTo(arbol.val)<0) return perteneceRecursivo(elem, arbol.izq);
        else return perteneceRecursivo(elem, arbol.der);
    }

    public void eliminar(T elem){
        Nodo nodo = this.raiz;
        Nodo padre = null;
        //Si es la raiz y no tiene hijos. 
        if (elem.compareTo(nodo.val) == 0 && nodo.der == null && nodo.izq == null) {
            this.raiz = null;
            this.cardinal -= 1;
            return;
        }

        eliminarRecursivo(elem, padre, nodo);
    }

    public void eliminarRecursivo(T elem, Nodo padre, Nodo arbol){
        if(arbol == null) return; 
        if(elem.compareTo(arbol.val) > 0) eliminarRecursivo(elem, arbol, arbol.der);
        else if(elem.compareTo(arbol.val)<0) eliminarRecursivo(elem, arbol, arbol.izq);
        else {
            if(arbol.der == null || arbol.izq == null){
                //Guardo alguno de los hijos del nodo.
                Nodo hijo = arbol.izq != null ? arbol.izq : arbol.der;

                //Si tiene un hijo siendo raiz.
                if (padre == null) {
                    this.raiz = hijo; // El nodo a eliminar es la raíz. Por lo tanto el unico hijo que tiene pasa a ser raiz.
                } else if (padre.izq == arbol) { //Si el nodo a eliminar no es la raiz, entonces solo hago el swap
                    padre.izq = hijo;
                } else {
                    padre.der = hijo;
                }
                this.cardinal--;
            }else{
                Nodo nodoAct = arbol;
                Nodo predecesorInmediato = nodoAct.izq;

                //Busco el predecesor inmediato (el mas grande de los chiquitos)
                while(predecesorInmediato.der != null){
                    nodoAct = predecesorInmediato;
                    predecesorInmediato = predecesorInmediato.der;
                }

                //nodoAct al final es el anterior al ultimo mas grande de los chiquitos.
                arbol.val = predecesorInmediato.val;
                
                if(nodoAct != arbol){
                    nodoAct.der = predecesorInmediato.izq; 
                }else{
                    nodoAct.izq = predecesorInmediato.izq;
                }
            
                this.cardinal--;
            }
        }
        return; 
        

    }

    public String toString(){
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo _actual;

        public ABB_Iterador(){
        }

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
