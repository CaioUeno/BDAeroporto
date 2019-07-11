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
public class Aeroporto {
    
    private int codigoAero;
    private String cidade;
    private String estado;
    private String pais;
    private String nomeAero;

    public Aeroporto(int codigoAero, String cidade, String estado, String pais, String nomeAero) {
        this.codigoAero = codigoAero;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.nomeAero = nomeAero;
    }

    public int getCodigoAero() {
        return codigoAero;
    }

    public void setCodigoAero(int codigoAero) {
        this.codigoAero = codigoAero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getNomeAero() {
        return nomeAero;
    }

    public void setNomeAero(String nomeAero) {
        this.nomeAero = nomeAero;
    }
    
    
    
    
    
}
