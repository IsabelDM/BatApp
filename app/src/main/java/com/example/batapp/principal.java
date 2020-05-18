package com.example.batapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.media.Image;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import android.widget.BaseAdapter;

public class principal extends AppCompatActivity {

private RecyclerView lstVillanos;
private ArrayList<Villano> villanos = new ArrayList<>();
private AdaptadorListaVillanos adaptadorLista;
private ConectorBD conectorBD;
private Button btnListarVillanos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        lstVillanos = findViewById(R.id.lstVillanos);
        RecyclerView.LayoutManager mLayoutManager = new
                LinearLayoutManager(getApplicationContext());
        lstVillanos.setLayoutManager(mLayoutManager);
        adaptadorLista = new AdaptadorListaVillanos(villanos);
        lstVillanos.setAdapter(adaptadorLista);
        conectorBD = new ConectorBD(this);
        btnListarVillanos = findViewById(R.id.btnListarVillanos);

        btnListarVillanos.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                villanos.removeAll(villanos);
                conectorBD.abrir();
                Cursor c = conectorBD.listarVillanos();
                if(c.moveToFirst()){
                    do{
                        Villano villano = new Villano(null,null,null);
                        villano.setAlias(c.getString(0));
                        villano.setNombre(c.getString(1));
                        villano.setApellido(c.getString(2));

                        villanos.add(villano);

                    } while (c.moveToNext());
                }
                c.close();
                conectorBD.cerrar();
                lstVillanos.getAdapter().notifyDataSetChanged();

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //Alternativa 1
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_pp, menu);
        return true;
    }


    public void oyente_MnuOpc1(MenuItem item) {
        Intent i = new Intent(this, perfil_page.class);
        startActivity(i);
    }

    public void oyente_MnuOpc2(MenuItem item) {
        Toast.makeText( this, "Creadora: Isabel Diezma Molero \n c 2020", Toast.LENGTH_LONG).show();
    }

    public void oyente_MnuOpc3(MenuItem item) {
        finish();
}


}
