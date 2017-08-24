package Proyecto1;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Julio
 */
public class ListaCircular implements Serializable{
    NodoLista primerNodo;
    NodoLista ultimoNodo;
    ListaSimple lista;

    public ListaCircular() {
    primerNodo=ultimoNodo=null;
    }
    
    public void insertarAlFinal(ListaSimple l){
        if(estaVacia()){
            primerNodo=ultimoNodo=new NodoLista(null,l);
        }else{
            System.out.println("insertando...");
            ultimoNodo=ultimoNodo.siguienteNodo= new NodoLista(primerNodo, l);
        }
    }
    public boolean estaVacia(){
    
    return primerNodo==null;
    }
    public void imprimir(){
        if(estaVacia()){
            System.out.printf("Esta vacia\n");
            return;
        }
        //System.out.printf("La %s es: ", nombre);
        NodoLista actual= primerNodo;
        int c=1;
        System.out.println(" ");
        do {            
            System.out.println("Lista: "+ c);
            System.out.println(actual.lista.nombre);
            actual.lista.imprimir();
            actual=actual.siguienteNodo;
            c++;
        } while (actual!=primerNodo);
        
    }
    
    public String[] imprimir2(){
        String[] lislista = new String[getsize()];
        if(estaVacia()){
            System.out.printf("Esta vacia\n");
            return lislista;
        }
        //System.out.printf("La %s es: ", nombre);
        else{
        NodoLista actual= primerNodo;
        int c=1;
        System.out.println(" ");
        do {            
            System.out.println("Lista: "+ c);
            System.out.println(actual.lista.nombre);
            //actual.lista.imprimir();
            lislista[c-1]=actual.lista.nombre;
            actual=actual.siguienteNodo;
            c++;
        } while (actual!=primerNodo);
        }
        return lislista;
    }
public ListaSimple[] imprimir3(){
        ListaSimple[] lislista = new ListaSimple[getsize()];
        if(estaVacia()){
            System.out.printf("Esta vacia\n");
            return lislista;
        }
        //System.out.printf("La %s es: ", nombre);
        else{
        NodoLista actual= primerNodo;
        int c=1;
        System.out.println(" ");
        do {            
            System.out.println("Lista: "+ c);
            System.out.println(actual.lista.nombre);
            //actual.lista.imprimir();
            lislista[c-1]=actual.lista;
            actual=actual.siguienteNodo;
            c++;
        } while (actual!=primerNodo);
        }
        return lislista;
    }
    private int getsize() {
        
        NodoLista actual= primerNodo;
    int c=1;
        //System.out.println(" ");
        do {            
            //7System.out.println("Lista: "+ c);
            //System.out.println(actual.lista.nombre);
            //actual.lista.imprimir();
            actual=actual.siguienteNodo;
            c++;
        } while (actual!=primerNodo);
        return c;
    }
    
    }

