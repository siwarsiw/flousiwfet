package com.example.flousiwfet;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.flousiwfet.MainActivity.MyList;
import static com.example.flousiwfet.MainActivity.db;
import static com.example.flousiwfet.modify.idnum;

public class modify2 extends AppCompatActivity {
    Button b ;
    EditText nom ;
    EditText prix ;
    EditText ref ;
    EditText stock ;
    public static String requetem ;
    achat a ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify2);
        db= new DBadapter(this);
        b=findViewById(R.id.b);
        nom=findViewById(R.id.achat);
        prix=findViewById(R.id.prix);
        ref=findViewById(R.id.ref);
        stock = findViewById(R.id.stock);
        a= db.searchmodify();

        nom.setText(a.getNom());
        ref.setText(a.getRef());
        stock.setText(Integer.toString(a.getStock()));
        prix.setText(Float.toString(a.getPrix()));

        b.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v)
            {
               String  achats = nom.getText().toString();
               String  reff = ref.getText().toString();
               String stockk = stock.getText().toString();
               String prixx = prix.getText().toString();
               requetem="UPDATE produit SET nom='"+achats+"', prix ="+prixx.toString()+
                       " , stock="+stockk.toString()+" , ref='"+reff+"' WHERE id='"+idnum+"'";

                new AlertDialog.Builder(modify2.this)
                        .setTitle("Modification")
                        .setMessage("Voulez vous modifier cet produit?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {


                                Intent intent = new Intent(modify2.this, modify2.class); startActivity(intent);


                            }})
                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();

               db.modify();
               // Intent intent = new Intent(modify2.this, MainActivity.class); startActivity(intent);


            }

        });
    }
}
