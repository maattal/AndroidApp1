package com.example.projet.Entities;

import android.util.Log;

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
    // TODO (3): Firebase ne peux pas parser un objet Location en retour et commme de toute les facons
    //  nous sommes interesser que dans la lattitude et longitude alors autant ne prendre que eux.
    //  J'ai donc changer l'objet Location en deux objet double appeler longitude et lattitude
    Double parcel_latitude;
    Double parcel_longitude;

    String DeliveryName = "NO";
    Recipient recipient;
    Date sendParcelDate;
    long id=0;

    //constructor qui recoit un objet de type parcelfromfirebase qui fait la amara on sait pas comment mais il a recu
    public Parcel(ParcelFromFirebase parceldb) {
        this.type_havila = Enums.Type_Parcel.valueOf(parceldb.getType_havila());
        this.weight = Enums.Weight_Parcel.valueOf(parceldb.getWeight());
        this.parcelStatus = Enums.Status_Parcel.valueOf(parceldb.getParcelStatus());
        this.is_Fragile=parceldb.is_Fragile;
//        parcel_Localisation = new Location("");
//        parcel_Localisation.setLatitude(parceldb.latitude);
//        parcel_Localisation.setLongitude(parceldb.longitude);
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

    public Parcel() {
    }

    @Override
    public String toString() {
        return "Parcel{" +
                "type_havila=" + type_havila +
                ", weight=" + weight +
                ", parcelStatus=" + parcelStatus +
                ", is_Fragile=" + is_Fragile +
                ", parcel_Localisation=" + parcel_longitude + ' ' + parcel_latitude +
                ", DeliveryName='" + DeliveryName + '\'' +
                ", recipient=" + recipient +
                ", sendParcelDate=" + sendParcelDate +
                ", id=" + id +
                '}';
    }


// TODO (4):J'ai changer le constructeur pour accepter deux objet double (longitude, lattitude)
//  à la place de Location
 public Parcel(Type_Parcel type_havila, Weight_Parcel weight, Status_Parcel parcelStatus, boolean is_Fragile, Double parcel_longitude,Double parcel_latitude, String senderName, Recipient recipient, Date sendParcelDate) {
            this.type_havila = type_havila;
            this.weight = weight;
            this.parcelStatus = parcelStatus;
            this.is_Fragile = is_Fragile;
            this.parcel_longitude = parcel_longitude;
            this.parcel_latitude = parcel_latitude;
            this.DeliveryName = senderName;
            this.recipient = recipient;
            this.sendParcelDate = sendParcelDate;
        }

    public void setId(long id) {
        this.id = id;
    }

    public Double getParcel_latitude() {
        return parcel_latitude;
    }

    public void setParcel_latitude(Double parcel_latitude) {
        this.parcel_latitude = parcel_latitude;
    }

    public Double getParcel_longitude() {
        return parcel_longitude;
    }

    public void setParcel_longitude(Double parcel_longitude) {
        this.parcel_longitude = parcel_longitude;
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
        if (sendParcelDate != null) {
            Log.d("Date:",sendParcelDate.toString());
            return sendParcelDate;
        }
        return new Date();
    }

    public void setSendParcelDate(Date sendParcelDate) {
        this.sendParcelDate = sendParcelDate;
    }

    public long getId() {
        return id;
    }

}


