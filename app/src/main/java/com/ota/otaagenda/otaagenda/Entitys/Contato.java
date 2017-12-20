package com.ota.otaagenda.otaagenda.Entitys;

import java.io.Serializable;

public class Contato implements Serializable{

    private String nome;
    private String endereco;
    private String email;
    private String telefone;
    private String caminhoFoto;

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public void setCaminhoFoto(String caminhoFoto){ this.caminhoFoto = caminhoFoto;}

    public String getEndereco() {
        return endereco;
    }
    public String getNome() {
        return nome;
    }
    public String getTelefone() {
        return telefone;
    }
    public String getEmail() {
        return email;
    }
    public String getCaminhoFoto(){ return caminhoFoto;}

    public Contato() {
    }
}
