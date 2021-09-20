package com.example.flousiwfet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.flousiwfet.MainActivity.MyList;
import static com.example.flousiwfet.MainActivity.db;

public class search extends AppCompatActivity {


    public  String achats ;
    public  String reff ;
    public  Float ps ;
    public Float pi ;
    public static String requete ;
    Button b ;
    EditText nom ;
    EditText prixi;
    EditText prixs;
    EditText ref ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        db= new DBadapter(this);


        b=findViewById(R.id.bs);
        nom=findViewById(R.id.achats);
        prixi=findViewById(R.id.prixi);
        prixs=findViewById(R.id.prixs);
        ref=findViewById(R.id.refs);


        b.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v)
            {
                achats = nom.getText().toString();
                reff = ref.getText().toString();
                if (!achats.isEmpty())
                {
                    requete= "SELECT * FROM produit WHERE nom='"+achats+"'";
                }
                else if  (!reff.isEmpty())
                {
                    requete= "SELECT * FROM produit WHERE ref='"+reff+"'";
                }else if (! prixs.getText().toString().isEmpty()&& ! prixs.getText().toString().isEmpty())
                {
                    requete= "SELECT * FROM produit WHERE prix <= "+prixs.getText().toString()+" AND prix >= "+prixi.getText().toString();
                }
                else
                    requete= "SELECT * FROM produit ";
                Toast.makeText(search.this, "recherche en cours", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(search.this, result.class); startActivity(intent);
            }

        });


    }
}
