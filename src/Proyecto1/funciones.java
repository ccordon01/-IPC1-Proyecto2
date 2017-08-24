/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto1;

/**
 *
 * @author Loscordonhdez
 */
public class funciones {
    private int row;
    private int col;
    private String funcion;

    public funciones(int row, int col, String funcion) {
        this.row = row;
        this.col = col;
        this.funcion = funcion;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }
    
}
