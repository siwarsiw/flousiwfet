 package com.example.flousiwfet;



 import android.widget.Toast;

 import java.text.DateFormat;
 import java.text.SimpleDateFormat;
 import java.util.Calendar;
 import java.util.Date;

 public class achat{
    int id ;
    int stock ;
     private String nom ;
     private Float prix ;
     String ref ;

     public achat()
     {}

     public achat(String nom, Float prix, String ref) {
         this.nom = nom;
         this.prix = prix;
         this.ref= ref;

     }



     public String getNom() {
         return nom;
     }

     public Float getPrix() {
         return prix;
     }

     public void setNom(String nom) {
         this.nom = nom;
     }

     public void setPrix(Float prix) {
         this.prix = prix;
     }

     public String getRef() {
         return ref;
     }
     public void setRef(String date) {
         this.ref = date;
     }

     public int getId() {
         return id;
     }

     public void setId(int id) {
         this.id = id;
     }

     public void setStock(int stock) {
         this.stock = stock;
     }

     public int getStock() {
         return stock;
     }
 }
