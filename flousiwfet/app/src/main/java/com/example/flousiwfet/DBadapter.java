package com.example.flousiwfet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.flousiwfet.achat;

import java.util.ArrayList;

import static com.example.flousiwfet.modify.idnum;
import static com.example.flousiwfet.modify2.requetem;
import static com.example.flousiwfet.search.requete;

public class DBadapter extends SQLiteOpenHelper {

    public DBadapter(Context context)
    {
        super(context,"produits",null,1);
    }

    public void onCreate(SQLiteDatabase db) {
        String creatTable="create table produit(id integer primary key,nom text ,prix float, ref text, stock int)";
        db.execSQL(creatTable); }


    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String deleteTable=("drop table if exists produit ");
        db.execSQL(deleteTable);
        onCreate(db); }

    public void ajoutdepense(achat a){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put("nom",a.getNom());
        contentValues.put("prix",a.getPrix());
        contentValues.put("ref",a.getRef());
        db.insert("produit",null,contentValues);

    }

    public ArrayList<achat> afficher(){
        SQLiteDatabase db=getReadableDatabase();
        String selectall="SELECT * FROM produit";
        Cursor cursor= db.rawQuery(selectall,null);
        ArrayList<achat> achats=new ArrayList<>();
        if (cursor.moveToFirst()){
            do{
                achat a=new achat(cursor.getString(1),cursor.getFloat(2),cursor.getString(3));
                a.setId(cursor.getInt(0));
                a.setRef(cursor.getString(3));
                achats.add(a); }
            while(cursor.moveToNext()); }
        return achats;
    }

    public ArrayList<achat>search(){
        SQLiteDatabase db=getReadableDatabase();

        Cursor cursor= db.rawQuery(requete,null);
        ArrayList<achat> achats=new ArrayList<>();
        if (cursor.moveToFirst()){
            do{
                achat a=new achat(cursor.getString(1),cursor.getFloat(2),cursor.getString(3));
                a.setId(cursor.getInt(0));
                a.setRef(cursor.getString(3));
                achats.add(a); }
            while(cursor.moveToNext()); }
        return achats;
    }


    public void modify()
    {
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL(requetem);
    }

    public void supprimer(int id){
        SQLiteDatabase db=getWritableDatabase();
        db.delete("produit","id="+Integer.toString(id),null);}


    public achat searchmodify(){
        SQLiteDatabase db=getReadableDatabase();
        String select="SELECT * FROM produit WHERE id='"+idnum+"'";
        Cursor cursor= db.rawQuery(select,null);
           achat  a=new achat();
        if (cursor.moveToFirst()){
            do{
                 a=new achat(cursor.getString(1),cursor.getFloat(2),cursor.getString(3));
                a.setId(cursor.getInt(0));
                a.setRef(cursor.getString(3));
                 }
            while(cursor.moveToNext()); }
        return a;
    }

}