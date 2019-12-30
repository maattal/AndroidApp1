package com.example.projet.Entities;
import android.location.Location;

public class Recipient
{
    String name;
    Location adress_destinataire;//ca on sen occupe dans la deuxieme appliacation
    String phone;
    String mail;

    public Recipient() {
    }

    public Recipient(String name, Location adress_destinataire, String phone, String mail) {
        this.name = name;
        this.adress_destinataire = adress_destinataire;
        this.phone = phone;
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getAdress_destinataire() {
        return adress_destinataire;
    }

    public void setAdress_destinataire(Location adress_destinataire) {
        this.adress_destinataire = adress_destinataire;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }



}
