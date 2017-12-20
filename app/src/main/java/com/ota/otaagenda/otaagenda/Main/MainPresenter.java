package com.ota.otaagenda.otaagenda.Main;

import com.ota.otaagenda.otaagenda.Entitys.Contato;

import java.util.ArrayList;
import java.util.List;


public class MainPresenter {

    MainView mainView;
    private List<Contato> contactList = new ArrayList<>();

    public MainPresenter(MainView mainView){
        this.mainView = mainView;
    }

    void addContact(Contato contato){
        contactList.add(contato);
        mainView.updateList(contactList);
    }

}