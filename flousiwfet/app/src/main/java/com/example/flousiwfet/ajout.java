package com.example.flousiwfet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import static com.example.flousiwfet.MainActivity.db;

public class ajout extends AppCompatActivity {

    Button b ;
    EditText nom ;
    EditText prix ;
    EditText ref ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);

        b=findViewById(R.id.b);
        nom=findViewById(R.id.achat);
        prix=findViewById(R.id.prix);
        ref=findViewById(R.id.ref);


        b.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v)
            {
                String achats = nom.getText().toString();
                String reff = ref.getText().toString();
                Float p =Float.valueOf(prix.getText().toString());
                achat a = new achat(achats, p, reff);
                db.ajoutdepense(a);
                Toast.makeText(ajout.this, " ajouté avec succès", Toast.LENGTH_SHORT).show();


            }

        });
    }


}
