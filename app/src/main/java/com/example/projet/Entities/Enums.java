package com.example.projet.Entities;

public class Enums {
    //mettre la les enums
    public enum Status_Parcel {
        SEND,
        PICKING,
        DELIVERING,
        RECEIVED
    }

    public enum Type_Parcel {
        ENVELOPPE,
        LITTLE_PACKET,
        BIG_PACKET
    }
    public enum Weight_Parcel {
        UPTO500g,
        UPTO1KG,
        UPTO5KG,
        UPTO20KG
    }


}
