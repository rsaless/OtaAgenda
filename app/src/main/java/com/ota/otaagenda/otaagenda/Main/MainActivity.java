package com.ota.otaagenda.otaagenda.Main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.ota.otaagenda.otaagenda.AddContact.AddContactActivity;
import com.ota.otaagenda.otaagenda.Entitys.Contato;
import com.ota.otaagenda.otaagenda.R;
import com.ota.otaagenda.otaagenda.ShowContact.ShowContactActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView{

    @BindView(R.id.rv_contatos) RecyclerView rvContatos;
    private MainPresenter mainPresenter;
    private final int CODIGO = 123;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainPresenter = new MainPresenter(this);
    }
    @Override public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_contatos, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.action_add:
                Intent adicionarContato = new Intent(MainActivity.this, AddContactActivity.class);
                startActivityForResult(adicionarContato, CODIGO);

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CODIGO && resultCode == Activity.RESULT_OK){
            Contato contato = (Contato) data.getSerializableExtra("contato");
            if(contato != null){
                mainPresenter.addContact(contato);
            }
        }
        //mainPresenter.addContact(requestCode, resultCode, data);
    }
    @Override public void updateList(final List<Contato> contactList){
        Adapter adapter = new Adapter(contactList, this);
        adapter.setRecyclerInterface(new RecyclerInterface() {
            @Override public void onClick(View view, int position) {
                Intent exibirContato = new Intent(MainActivity.this, ShowContactActivity.class);
                exibirContato.putExtra("exibir_contato", contactList.get(position));
                startActivity(exibirContato);
            }
        });

        rvContatos.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvContatos.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, layoutManager.getOrientation());
        rvContatos.addItemDecoration(dividerItemDecoration);
    }

}
