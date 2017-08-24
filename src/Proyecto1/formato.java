/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto1;

/**
 *
 * @author FernandoJosue
 */
public class formato {
    private int row;
    private int col;
    private boolean negrita;
    private boolean curisva;
    private boolean subrayado;
    private boolean tachado;

    public formato(int row, int col, boolean negrita, boolean curisva, boolean subrayado, boolean tachado) {
        this.row = row;
        this.col = col;
        this.negrita = negrita;
        this.curisva = curisva;
        this.subrayado = subrayado;
        this.tachado = tachado;
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

    public boolean isNegrita() {
        return negrita;
    }

    public void setNegrita(boolean negrita) {
        this.negrita = negrita;
    }

    public boolean isCurisva() {
        return curisva;
    }

    public void setCurisva(boolean curisva) {
        this.curisva = curisva;
    }

    public boolean isSubrayado() {
        return subrayado;
    }

    public void setSubrayado(boolean subrayado) {
        this.subrayado = subrayado;
    }

    public boolean isTachado() {
        return tachado;
    }

    public void setTachado(boolean tachado) {
        this.tachado = tachado;
    }
    
}
