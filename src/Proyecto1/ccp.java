/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto1;

/**
 *
 * @author Loscordonhdez
 */
public class ccp {
    private int row;
    private int col;
    private String ccp;

    public ccp(int row, int col, String ccp) {
        this.row = row;
        this.col = col;
        this.ccp = ccp;
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

    public String getCcp() {
        return ccp;
    }

    public void setCcp(String ccp) {
        this.ccp = ccp;
    }
    
}
