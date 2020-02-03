package com.example.projet.DataModel;
import com.example.projet.Entities.Parcel;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

/* class in charge of the firebase */
public class Firebase_DBmanager {

    static DatabaseReference ParcelsRef;
    static List<Parcel> parcelList;

    static {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        ParcelsRef = database.getReference("Parcels");
        parcelList = new ArrayList<>();

    }

    public static void addParcelToFirebase(final Parcel parcel)
    {
        ParcelsRef.push().setValue(parcel);
    }


}

