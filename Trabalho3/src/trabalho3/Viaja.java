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
public class Viaja {
 
    private String cpf;
    private int codigoVoo;
    private String assento;
    private String IDbagagem;

    public Viaja(String cpf, int codigoVoo, String assento, String IDbagagem) {
        this.cpf = cpf;
        this.codigoVoo = codigoVoo;
        this.assento = assento;
        this.IDbagagem = IDbagagem;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getCodigoVoo() {
        return codigoVoo;
    }

    public void setCodigoVoo(int codigoVoo) {
        this.codigoVoo = codigoVoo;
    }

    public String getAssento() {
        return assento;
    }

    public void setAssento(String assento) {
        this.assento = assento;
    }

    public String getIDbagagem() {
        return IDbagagem;
    }

    public void setIDbagagem(String IDbagagem) {
        this.IDbagagem = IDbagagem;
    }
    
    
}
