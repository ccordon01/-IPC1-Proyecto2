/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto1;

/**
 *
 * @author Loscordonhdez
 */
public class reporte2 {
    String celda;
    String contenido;
    String tipo;

    public reporte2(String celda, String contenido, String tipo) {
        this.celda = celda;
        this.contenido = contenido;
        this.tipo = tipo;
    }

    public String getCelda() {
        return celda;
    }

    public void setCelda(String celda) {
        this.celda = celda;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
