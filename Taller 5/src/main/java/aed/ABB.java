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
       while(nodo.izq != null){
        nodo = nodo.izq;
       }
       return nodo.val; 
    }

    public T maximo(){
       Nodo nodo = this.raiz;  
       while(nodo.der != null){
        nodo = nodo.der;
       }
       return nodo.val; 
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
        boolean borrado = false;
        //Si es la raiz y no tiene hijos. 
        if (elem.compareTo(nodo.val) == 0 && nodo.der == null && nodo.izq == null) {
            this.raiz = null;
            this.cardinal -= 1;
            return;
        }

        while(nodo != null && !borrado){
            if(elem.compareTo(nodo.val)>0){
                padre = nodo; //guardo anterior
                nodo = nodo.der;
            }else if(elem.compareTo(nodo.val)<0){
                padre = nodo; //guardo el anterior
                nodo = nodo.izq;
            }else{ //aca ya tengo garantizado que encontre el nodo a eliminar
                //si es igual y tiene algun hijo, entonces reemplazo el hijo por el 
                if(nodo.der == null || nodo.izq == null){
                    //Guardo alguno de los hijos del nodo.
                    Nodo hijo = nodo.izq != null ? nodo.izq : nodo.der;

                   //Si tiene un hijo siendo raiz.
                    if (padre == null) {
                        this.raiz = hijo; // El nodo a eliminar es la raíz. Por lo tanto el unico hijo que tiene pasa a ser raiz.
                    } else if (padre.izq == nodo) { //Si el nodo a eliminar no es la raiz, entonces solo hago el swap
                        padre.izq = hijo;
                    } else {
                        padre.der = hijo;
                    }
                    this.cardinal-=1;
                    borrado = true; 
                }else{
                   Nodo nodoAct = nodo;
                   Nodo predecesorInmediato = nodoAct.izq;

                   //Busco el predecesor inmediato (el mas grande de los chiquitos)
                   while(predecesorInmediato.der != null){
                    nodoAct = predecesorInmediato;
                    predecesorInmediato = predecesorInmediato.der;
                   }

                   //nodoAct al final es el anterior al ultimo mas grande de los chiquitos.
                   nodo.val = predecesorInmediato.val;
                   
                   if(nodoAct != nodo){
                    nodoAct.der = predecesorInmediato.izq; 
                   }else{
                    nodoAct.izq = predecesorInmediato.izq;
                   }
                   
                    this.cardinal -= 1;
                    borrado = true;
                }
            }
        }
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
