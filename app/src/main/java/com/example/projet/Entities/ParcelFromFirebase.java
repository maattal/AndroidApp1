package com.example.projet.Entities;

import android.location.Location;

import androidx.annotation.NonNull;

import java.util.Date;

// TODO (2): Toute cette class sert à rien et peux etre enlever
public class ParcelFromFirebase
{


    public  String type_havila;
    public String  weight;
    public String parcelStatus;
    public Boolean is_Fragile;
   //public Location parcel_Location;
    public Double latitude;
    public Double longitude;
    public String deliveryName;
   public Recipient recipient;
    public String sendParcelDate;

    public ParcelFromFirebase() {
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public String getType_havila() {
        return type_havila;
    }

    public void setType_havila(String type_havila) {
        this.type_havila = type_havila;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getParcelStatus() {
        return parcelStatus;
    }

    public void setParcelStatus(String parcelStatus) {
        this.parcelStatus = parcelStatus;
    }

    public Boolean getIs_Fragile() {
        return is_Fragile;
    }

    public void setIs_Fragile(Boolean is_Fragile) {
        this.is_Fragile = is_Fragile;
    }

    //public Location getParcel_Location(Location parcel_Location) {
     //   return parcel_Location ;
    //}

    //public void setParcel_Location(Location parcel_Location) {
      //  this.parcel_Location = parcel_Location;
    //}
public  double getLatitude(Double latitude){return latitude;}
public double getLongitude (Double longitude){return  longitude;}

    public String getDeliveryName() {
        return deliveryName;
    }

    public void setDeliveryName(String deliveryName) {
        this.deliveryName = deliveryName;
    }



    public String getSendParcelDate() {
        return sendParcelDate;
    }

    public void setSendParcelDate(String sendParcelDate) {
        this.sendParcelDate = sendParcelDate;
    }




    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }


}
