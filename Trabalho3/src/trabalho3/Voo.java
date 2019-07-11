/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho3;

/**
 *
 * @author caio
 */
public class Voo {
  
    private int codigo;
    private int IDAero;
    private int codAeroOri;
    private int codAeroDst;

    public Voo(int codigo, int IDAero, int codAeroOri, int codAeroDst) {
        this.codigo = codigo;
        this.IDAero = IDAero;
        this.codAeroOri = codAeroOri;
        this.codAeroDst = codAeroDst;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getIDAero() {
        return IDAero;
    }

    public void setIDAero(int IDAero) {
        this.IDAero = IDAero;
    }

    public int getCodAeroOri() {
        return codAeroOri;
    }

    public void setCodAeroOri(int codAeroOri) {
        this.codAeroOri = codAeroOri;
    }

    public int getCodAeroDst() {
        return codAeroDst;
    }

    public void setCodAeroDst(int codAeroDst) {
        this.codAeroDst = codAeroDst;
    }
    
    
   
}
