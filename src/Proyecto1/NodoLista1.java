package Proyecto1;

import java.io.Serializable;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Loscordonhdez
 */
public class NodoLista1 implements Serializable{
    // miembros de acceso del paquete; Lista puede acceder a ellos directamente  
    Object datos;  // los datos para este nodo  
    NodoLista1 siguienteNodo;  // referencia al siguiente nodo en la lista  
    NodoLista1 anteriorNodo;
    Object tipo;
    ListaSimple lista;
    byte[] array;
    // el constructor crea un objeto NodoLista que hace referencia al objeto  
    /*NodoLista(Object objeto) {
        this(objeto, null,null);
    } // ﬁn del constructor de NodoLista con un argumento */  

    public NodoLista1(Object datos, byte[] array) {
        this.datos = datos;
        this.array = array;
    }
    
    public NodoLista1(NodoLista1 siguienteNodo, ListaSimple lista) {
        this.siguienteNodo = siguienteNodo;
        this.lista = lista;
    }
    
    // el constructor crea un objeto NodoLista que hace referencia a   
    // un objeto Object y al siguiente objeto NodoLista  
    NodoLista1(Object objeto, NodoLista1 nodo,NodoLista1 nodo1) {
        datos = objeto;
        siguienteNodo = nodo;
        anteriorNodo= nodo1;
    }  // ﬁn del constructor de NodoLista con dos argumentos  
    NodoLista1(Object objeto, NodoLista1 nodo) {
        datos = objeto;
        siguienteNodo = nodo;
    }  // ﬁn del constructor de NodoLista con dos argumentos  
    NodoLista1(Object objeto, NodoLista1 nodo,NodoLista1 nodo1,Object tip,String name) {
        datos = objeto;
        siguienteNodo = nodo;
        anteriorNodo= nodo1;
        tipo=tip;
        lista= new ListaSimple(name);
    }  // ﬁn del constructor de NodoLista con dos argumentos  
    // devuelve la referencia a datos en el nodo  
    Object obtenerObject() {
        return datos;  // devuelve el objeto Object en este nodo  
    } // ﬁn del método obtenerObject  

    // devuelve la referencia al siguiente nodo en la lista  
    NodoLista1 obtenerSiguiente() {
        return siguienteNodo;  // obtiene el siguiente nodo
    }
}
