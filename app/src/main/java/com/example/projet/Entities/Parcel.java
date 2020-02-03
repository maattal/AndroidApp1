package com.example.projet.Entities;

import android.location.Location;
import android.location.LocationManager;
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
    Double parcel_latitude;
    Double parcel_longitude;
    String DeliveryName = "NO";
    Recipient recipient;
    Date sendParcelDate;
    long id;
    Location location_parcel;
    String mail;
    public Location getLocation_parcel() {
        return location_parcel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Parcel()
    {
    }

    public void setLocation_parcel() {
        this.location_parcel.setLatitude(this.parcel_latitude);
        this.location_parcel.setLongitude(this.parcel_longitude);
    }
//                ", recipient=" + recipient +
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



 public Parcel(Type_Parcel type_havila, Weight_Parcel weight, Status_Parcel parcelStatus, boolean is_Fragile, Double parcel_longitude,Double parcel_latitude, String senderName, Recipient recipient, Date sendParcelDate,String mail) {
            this.type_havila = type_havila;
            this.weight = weight;
            this.parcelStatus = parcelStatus;
            this.is_Fragile = is_Fragile;
            this.parcel_longitude = parcel_longitude;
            this.parcel_latitude=parcel_latitude;
            this.DeliveryName = senderName;
            this.recipient = recipient;
            this.sendParcelDate = sendParcelDate;
            this.mail=mail;
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


