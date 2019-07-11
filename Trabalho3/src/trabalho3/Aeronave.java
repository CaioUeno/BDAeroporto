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
public class Aeronave {
    
    private int IDAero;
    private String modelo;
    private int capacidade;
    private String tipo;

    public Aeronave(int IDAero, String modelo, int capacidade, String tipo) {
        this.IDAero = IDAero;
        this.modelo = modelo;
        this.capacidade = capacidade;
        this.tipo = tipo;
    }

    public int getIDAero() {
        return IDAero;
    }

    public void setIDAero(int IDAero) {
        this.IDAero = IDAero;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
}
