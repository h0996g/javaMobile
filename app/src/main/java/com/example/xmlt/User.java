package com.example.xmlt;

import android.net.Uri;

import java.io.Serializable;

public class User implements Serializable {
    String nom;
    String prenom;
    String email;
    String phone;
    String uri;

    public User(String nom, String prenom, String email, String phone,String uri) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.phone = phone;
        this.uri = uri;


    }

    public User(){}
}
