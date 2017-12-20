package com.ota.otaagenda.otaagenda.AddContact;

import com.ota.otaagenda.otaagenda.Entitys.Contato;

public class AddContactPresenter {
    AddContactView addContactView;

    public AddContactPresenter (AddContactView addContactView){
        this.addContactView = addContactView;
    }

    public Contato getContato(String nome, String telefone, String email, String endereco, String caminhoFoto){
        Contato contato = null;

        if(!nome.isEmpty() && !telefone.isEmpty()){
            contato = new Contato();
            contato.setNome(nome);
            contato.setTelefone(telefone);
            contato.setEmail(email);
            contato.setEndereco(endereco);
            contato.setCaminhoFoto(caminhoFoto);
        }

        return contato;
    }

    public void showContact(Contato contato){
        if (contato != null){
            addContactView.showInfo(contato);
        }
    }
}
