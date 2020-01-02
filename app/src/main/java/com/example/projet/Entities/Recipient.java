package com.example.projet.Entities;
import android.location.Location;

public class Recipient
{
    String name;
    Double adress_destinataire_lattitude;//ca on sen occupe dans la deuxieme appliacation
    Double adress_destinataire_longitude;
    String phone;
    String mail;

    public Recipient() {
    }

    public Recipient(String name, Double adress_destinataire_lattitude,Double adress_destinataire_longitude, String phone, String mail) {
        this.name = name;
        this.adress_destinataire_lattitude = adress_destinataire_lattitude;
        this.adress_destinataire_longitude = adress_destinataire_longitude;
        this.phone = phone;
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAdress_destinataire_lattitude() {
        return adress_destinataire_lattitude;
    }

    public void setAdress_destinataire_lattitude(Double adress_destinataire_lattitude) {
        this.adress_destinataire_lattitude = adress_destinataire_lattitude;
    }

    public Double getAdress_destinataire_longitude() {
        return adress_destinataire_longitude;
    }

    public void setAdress_destinataire_longitude(Double adress_destinataire_longitude) {
        this.adress_destinataire_longitude = adress_destinataire_longitude;
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
