package com.example.projet.Entities;

/* class in charge of all the enums */
public class Enums {
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
