package com.example.flousiwfet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.flousiwfet.MainActivity.db;

public class result extends AppCompatActivity {

    public  adapter arrayAdapter ;
    public ArrayList<achat> MyLists ;
    ListView liste ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        liste=findViewById(R.id.listes);
        db = new DBadapter(this);
        MyLists= db.search();



        arrayAdapter=new adapter(this, R.layout.item,MyLists);

        liste.setAdapter(arrayAdapter);


    }
}
