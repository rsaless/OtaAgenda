package com.ota.otaagenda.otaagenda.ShowContact;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ota.otaagenda.otaagenda.AddContact.AddContactActivity;
import com.ota.otaagenda.otaagenda.Entitys.Contato;
import com.ota.otaagenda.otaagenda.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowContactActivity extends AppCompatActivity implements ShowContactView {

    @BindView(R.id.contactNome) TextView nome;
    @BindView(R.id.contactEmail) TextView email;
    @BindView(R.id.contactTelefone) TextView telefone;
    @BindView(R.id.contactEndereco) TextView endereco;
    @BindView(R.id.contactFoto) ImageView foto;

    public String caminhoFoto;
    ShowContactPresenter showContactPresenter;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_contact);
        ButterKnife.bind(this);

        showContactPresenter= new ShowContactPresenter(this);
        showContactPresenter.showContact((Contato) getIntent().getSerializableExtra("exibir_contato"));
    }
    @Override public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_show_contato, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_send_sms:
                sendSMS();
                return true;

            case R.id.action_view_on_map:
                viewOnMap();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override public void showInfo(Contato contato) {
        nome.setText(contato.getNome());
        telefone.setText(contato.getTelefone());
        email.setText(contato.getEmail());
        endereco.setText(contato.getEndereco());
        caminhoFoto = contato.getCaminhoFoto();
        exibeFoto();
    }

    private void exibeFoto(){
        Picasso.with(this)
                .load("file://" + caminhoFoto)
                .fit()
                .centerCrop()
                .into(foto);
    }
    public void viewOnMap(){
        final String address = endereco.getText().toString();
        Intent intentMapa = new Intent(Intent.ACTION_VIEW);
        intentMapa.setData(Uri.parse("geo:0,0?q=" + address));

        if(intentMapa.resolveActivity(getPackageManager()) != null) {
            startActivity(intentMapa);
        }else {
            showToast();
        }
    }
    public void sendSMS(){
        final String cellphone = telefone.getText().toString();
        Intent intentSMS = new Intent(Intent.ACTION_VIEW);
        intentSMS.setData(Uri.parse("sms:" + cellphone));
        if(intentSMS.resolveActivity(getPackageManager()) != null) {
            startActivity(intentSMS);
        }else {
            showToast();
        }
    }
    public void showToast() {
        Toast toast = Toast.makeText(ShowContactActivity.this, "Impossível abrir o recurso", Toast.LENGTH_LONG);
        toast.show();
    }
}
