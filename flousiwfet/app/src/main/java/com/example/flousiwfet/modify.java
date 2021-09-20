package com.example.flousiwfet;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.flousiwfet.MainActivity.MyList;
import static com.example.flousiwfet.MainActivity.db;

public class modify extends AppCompatActivity {




    public  adapter arrayAdapter ;

    ListView liste ;
    public static int idnum ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);

        liste=findViewById(R.id.listem);
        db= new DBadapter(this);
        MyList= db.afficher();

        arrayAdapter=new adapter(this, R.layout.item,MyList);

        liste.setAdapter(arrayAdapter);

        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, final View view, final int position, long id){


                                idnum=MyList.get(position).getId();
                                Intent intent = new Intent(modify.this, modify2.class); startActivity(intent);



            }

        }     );
    }

    public void onResume(){
        super.onResume();
        MyList= db.afficher();

        arrayAdapter=new adapter(this, R.layout.item,MyList);

        liste.setAdapter(arrayAdapter);


    }
}
