package com.example.batapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText txtUsuario;
    private EditText txtContrasenia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtUsuario = findViewById(R.id.txtUsuario);
        txtContrasenia = findViewById(R.id.txtContrasenia);

    }

    public void oyente_btnLogIn(View view) {
        Log.d("Debug_MainActivity", "El usuario quiere iniciar sesión en la app.");
        if(txtUsuario.getText().toString().equals("Bruce Wayne") && txtContrasenia.getText().toString().equals("Gotham123")){
            Intent i = new Intent(this, principal.class);
            i.putExtra("Usuario", "Bruce Wayne");
            startActivity(i);
        }else{
            Toast.makeText( this, "Usuario o Contrasenña incorrectos", Toast.LENGTH_SHORT).show();
        }

    }

    public void oyente_ivHelp(View view) {
        Toast.makeText( this, " Usuario: Bruce Wayne \n Contraseña: Gotham123", Toast.LENGTH_LONG).show();

    }
}
