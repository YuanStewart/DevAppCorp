/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

/**
 *
 * @author yuans
 */
public class TipoDeSaudacao {
    private String dia;
    private String tarde;
    private String noite;

    public TipoDeSaudacao(String dia, String tarde, String noite) {
        this.dia = dia;
        this.tarde = tarde;
        this.noite = noite;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getTarde() {
        return tarde;
    }

    public void setTarde(String tarde) {
        this.tarde = tarde;
    }

    public String getNoite() {
        return noite;
    }

    public void setNoite(String noite) {
        this.noite = noite;
    }
    
}
