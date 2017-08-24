package Proyecto1;

import java.io.Serializable;
import static sun.security.krb5.Confounder.bytes;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Loscordonhdez
 */
public class ListaDoble implements Serializable{
    NodoLista1 primerNodo;
    NodoLista1 ultimoNodo;
    String nombre;
    byte[] array;
    public ListaDoble(){
            this("lista");
                    }
    public ListaDoble(String n){
    nombre=n;
    primerNodo=ultimoNodo=null;
    }
    /*public void insertarAlFrente(Object ei){
    if(estaVacia())
    {
    primerNodo=ultimoNodo= new NodoLista1(ei);
    }
    else{
    primerNodo= new NodoLista1(ei,primerNodo,null);
    }
    }*/
    public void insertarAlFinal(Object ei,byte [] arr){
    if(estaVacia())
    {
    primerNodo=ultimoNodo= new NodoLista1(ei,arr);
    }
    else{
    ultimoNodo=ultimoNodo.siguienteNodo= new NodoLista1(ei,arr);
    }
    }
    public Object eliminarDelFrente(){
    if(estaVacia())
    {
        return "Lista Vacia";}
    else{
    Object ee=primerNodo.datos;
    if(primerNodo==ultimoNodo){
    primerNodo=ultimoNodo=null;
    }
    else{
    primerNodo= primerNodo.siguienteNodo;
    }
    return ee;
    }
    }
    public boolean estaVacia(){
    
    return primerNodo==null;
    }
    
    public void imprimir(){
        if(estaVacia()){
            System.out.printf("%s vacia\n", nombre);
            return;
        }
        System.out.printf("La %s es: ", nombre);
        NodoLista1 actual= primerNodo;
        
        System.out.println(" ");
        while(actual!=null){
            System.out.printf("%s", actual.datos);
            actual = actual.siguienteNodo;
        System.out.println("");
        }
        
    }
    public String[] imprimir2(){
        String[] arraydata=new String[getsize()];
        if(estaVacia()){
            System.out.printf("%s vacia\n", nombre);
            return arraydata;
        }
        //System.out.printf("La %s es: ", nombre);
        NodoLista1 actual= primerNodo;
        int c=0;
        System.out.println(" ");
        while(actual!=null){
            arraydata[c]=actual.datos.toString();
            //System.out.printf("%s", actual.datos);
            actual = actual.siguienteNodo;
        //System.out.println("");
            c++;
        }
        return arraydata;
    }
    public int getsize() {
        
        NodoLista1 actual= primerNodo;
    int c=0;
        //System.out.println(" ");
        try {
             do {            
            //7System.out.println("Lista: "+ c);
            //System.out.println(actual.lista.nombre);
            //actual.lista.imprimir();
            actual=actual.siguienteNodo;
            c++;
        } while (actual!=null);
        } catch (Exception e) {
        }
        return c;
    }
    public void pop(Object nt){
        
        NodoLista1 aux=null;
    if(estaVacia()){
        System.out.println("Esta Vacia");
        return;
    }
    else{
        //System.out.print("La lista es: ");
        NodoLista1 actual=primerNodo;
        boolean ver=false;
        int cont=0;
        while (actual !=null) {
        cont++;
             if(Integer.parseInt(nt.toString())==cont){
                 ver=true;
                aux=actual;
                 actual=null;
             }
             else{
             ver=false;
            actual=actual.siguienteNodo;
             }
            //System.out.print("Nombre: "+actual.datos+" Telefono: "+actual.telefono+" Correo: "+actual.correo);
        //System.out.println(" ");
        }
        if(ver==false){
            System.out.println("No existe");
        }
        else{
        if(aux==primerNodo){
        eliminarDelFrente();
        }
        /*else if(aux==ultimoNodo){
        eliminarDelFinal();
        }*/
        else{
            int contaux=0;
            NodoLista1 actual1=primerNodo;
        while (actual1 !=null) {
            contaux++;
            if(contaux==cont-1){
            actual1.siguienteNodo=aux.siguienteNodo;
            actual1=null;
            }
            else{
            actual1=actual1.siguienteNodo;
            }
        }
        }
        }
    }
    
    }
}