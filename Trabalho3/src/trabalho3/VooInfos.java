/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho3;

import java.util.Date;

/**
 *
 * @author caio
 */
public class VooInfos {
    
    private int codVoo;
    private Date dDecolagem;
    private Date dAterrissagem;
    private int qtdPass;

    public VooInfos(int codVoo, Date dDecolagem, Date dAterrissagem, int qtdPass) {
        this.codVoo = codVoo;
        this.dDecolagem = dDecolagem;
        this.dAterrissagem = dAterrissagem;
        this.qtdPass = qtdPass;
    }

    public int getCodVoo() {
        return codVoo;
    }

    public void setCodVoo(int codVoo) {
        this.codVoo = codVoo;
    }

    public Date getdDecolagem() {
        return dDecolagem;
    }

    public void setdDecolagem(Date dDecolagem) {
        this.dDecolagem = dDecolagem;
    }

    public Date getdAterrissagem() {
        return dAterrissagem;
    }

    public void setdAterrissagem(Date dAterrissagem) {
        this.dAterrissagem = dAterrissagem;
    }

    public int getQtdPass() {
        return qtdPass;
    }

    public void setQtdPass(int qtdPass) {
        this.qtdPass = qtdPass;
    }
    
 

    
}
