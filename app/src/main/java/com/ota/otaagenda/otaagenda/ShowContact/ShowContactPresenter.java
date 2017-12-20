package com.ota.otaagenda.otaagenda.ShowContact;

import com.ota.otaagenda.otaagenda.Entitys.Contato;

public class ShowContactPresenter {
    ShowContactView showContactView;

    public ShowContactPresenter (ShowContactView showContactView){
        this.showContactView = showContactView;
    }

    public void showContact(Contato contato){
        if (contato != null){
            showContactView.showInfo(contato);
        }
    }
}
