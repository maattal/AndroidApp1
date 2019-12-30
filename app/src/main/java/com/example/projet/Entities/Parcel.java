package com.example.projet.Entities;

import android.location.Location;
import android.location.LocationManager;


import com.example.projet.Entities.Enums.Status_Parcel;
import com.example.projet.Entities.Enums.Type_Parcel;
import com.example.projet.Entities.Enums.Weight_Parcel;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Parcel
{
    Enums.Type_Parcel type_havila;
    Enums.Weight_Parcel weight;
    Enums.Status_Parcel parcelStatus;
    boolean is_Fragile;
    Location parcel_Localisation;
    String DeliveryName = "NO";
    Recipient recipient;
    Date sendParcelDate;
    long id=0;

    //constructor qui recoit un objet de type parcelfromfirebase qui fait la amara on sait pas comment mais il a recu
    public Parcel(ParcelFromFirebase parceldb)
    {
        this.type_havila = Enums.Type_Parcel.valueOf(parceldb.getType_havila());
        this.weight = Enums.Weight_Parcel.valueOf(parceldb.getWeight());
        this.parcelStatus = Enums.Status_Parcel.valueOf(parceldb.getParcelStatus());
        this.is_Fragile=parceldb.is_Fragile;
        parcel_Localisation = new Location("");
        parcel_Localisation.setLatitude(parceldb.latitude);
        parcel_Localisation.setLongitude(parceldb.longitude);
        this.setDeliveryName(parceldb.deliveryName);
        this.recipient= recipient;
        this.id  = id;
        this.sendParcelDate = new Date();
        try {
            this.sendParcelDate = new SimpleDateFormat("dd/MM/yyyy").parse(parceldb.getSendParcelDate());
        }
        catch (Exception e){
            this.sendParcelDate = new Date();
        }





    }

    public Parcel()
    {
    }

    @Override
    public String toString() {
        return "Parcel{" +
                "type_havila=" + type_havila +
                ", weight=" + weight +
                ", parcelStatus=" + parcelStatus +
                ", is_Fragile=" + is_Fragile +
                ", parcel_Localisation=" + parcel_Localisation +
                ", DeliveryName='" + DeliveryName + '\'' +
                ", recipient=" + recipient +
                ", sendParcelDate=" + sendParcelDate +
                ", id=" + id +
                '}';
    }



 public Parcel(Type_Parcel type_havila, Weight_Parcel weight, Status_Parcel parcelStatus, boolean is_Fragile, Location parcel_Localisation, String senderName, Recipient recipient, Date sendParcelDate) {
            this.type_havila = type_havila;
            this.weight = weight;
            this.parcelStatus = parcelStatus;
            this.is_Fragile = is_Fragile;
            this.parcel_Localisation = parcel_Localisation;
            this.DeliveryName = senderName;
            this.recipient = recipient;
            this.sendParcelDate = sendParcelDate;
        }

    public Type_Parcel getType_havila() {
        return type_havila;
    }

    public void setType_havila(Type_Parcel type_havila) {
        this.type_havila = type_havila;
    }

    public Weight_Parcel getWeight() {
        return weight;
    }

    public void setWeight(Weight_Parcel weight) {
        this.weight = weight;
    }

    public Status_Parcel getParcelStatus() {
        return parcelStatus;
    }

    public void setParcelStatus(Status_Parcel parcelStatus) {
        this.parcelStatus = parcelStatus;
    }

    public boolean isIs_Fragile() {
        return is_Fragile;
    }

    public void setIs_Fragile(boolean is_Fragile) {
        this.is_Fragile = is_Fragile;
    }

    public Location getParcel_Localisation() {
        return parcel_Localisation;
    }

    public void setParcel_Localisation(Location parcel_Localisation) {
        this.parcel_Localisation = parcel_Localisation;
    }

    public String getDeliveryName() {
        return DeliveryName;
    }

    public void setDeliveryName(String deliveryName) {
        DeliveryName = deliveryName;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public Date getSendParcelDate() {
        return sendParcelDate;
    }

    public void setSendParcelDate(Date sendParcelDate) {
        this.sendParcelDate = sendParcelDate;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}


