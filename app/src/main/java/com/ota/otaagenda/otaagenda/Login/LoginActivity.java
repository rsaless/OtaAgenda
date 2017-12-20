package com.ota.otaagenda.otaagenda.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;

import com.ota.otaagenda.otaagenda.Main.MainActivity;
import com.ota.otaagenda.otaagenda.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.text_input_layout_username) TextInputLayout usernameLayout;
    @BindView(R.id.text_input_layout_password) TextInputLayout passwordLayout;
    @BindView(R.id.edit_text_username) TextInputEditText usernameText;
    @BindView(R.id.edit_text_password) TextInputEditText passwordText;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
    }

    protected void setErroUsuario(){
        usernameLayout.setErrorEnabled(true);
        usernameLayout.setError("Usuário inválido");
    }

    protected void setErroSenha(){
        passwordLayout.setErrorEnabled(true);
        passwordLayout.setError("Senha inválida");
    }

    protected void differentInputs(){
        usernameLayout.setErrorEnabled(true);
        usernameLayout.setError("Usuário e senha diferentes");
        passwordLayout.setErrorEnabled(true);
        passwordLayout.setError("Usuário e senha diferentes");
    }

    protected void openMain(){
        Intent intentMain = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intentMain);
    }

    @OnTextChanged(R.id.edit_text_username) public void validaUsuario(){
        usernameLayout.setErrorEnabled(false);
        usernameLayout.setError("");
    }

    @OnTextChanged(R.id.edit_text_password) public void validaSenha(){
        passwordLayout.setErrorEnabled(false);
        passwordLayout.setError("");
    }

    @OnClick(R.id.buttonlogin) public void fazLogin(){
        if (usernameText.getText().toString().isEmpty()){
            setErroUsuario();
        } else if(passwordText.getText().toString().isEmpty()){
            setErroSenha();
        } else if(usernameText.getText().toString().equals(passwordText.getText().toString())){
            openMain();
        } else {
            differentInputs();
        }
    }

    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }

}
