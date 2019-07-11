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
public class Passageiro {
 
    private String cpf;
    private String nome;
    private String passaporte;

    public Passageiro(String cpf, String nome, String passaporte) {
        this.cpf = cpf;
        this.nome = nome;
        this.passaporte = passaporte;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassaporte() {
        return passaporte;
    }

    public void setPassaporte(String passaporte) {
        this.passaporte = passaporte;
    }
    
    
}
