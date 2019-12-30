package com.example.projet.DataModel;

import com.example.projet.Entities.Parcel;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
//snapshot\ cest le anaf que tu as mis ton myref
//snapshot.getvalue(ParcelFromFireBase.class) ca te lit tahless le parcel que tu as mis dans le firebase
//tu cree une rechima de parcel et dans le ondatachange t le clear avant d'ajouter la havila e a la fin tu l'ajoute

public class Firebase_DBmanager {
    public interface Action<T> {
        void onSuccess(T obj);

        void onFailure(Exception exception);

        void onProgress(String status, double percent);
    }

    public interface NotifyDataChange<T> {
        void OnDataChanged(T obj);

        void onFailure(Exception exception);
    }

    static DatabaseReference ParcelsRef;
    static List<Parcel> parcelList;

    static {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        ParcelsRef = database.getReference("Parcels");//sa tu lenvoie dans ton addparceltofirebase
        parcelList = new ArrayList<>();

    }

//et une reference de la database ou tu ajoutes
    public static void addParcelToFirebase(final Parcel parcel)
    {
        ParcelsRef.push().setValue(parcel); //set value il va dan les get de la mahlaka et rajoute ca dans firebase
    }

    //chew lui cest pas onchild mais pas grave
    private static ChildEventListener parcelRefChildEventListener;
//ca cest le truc qui dit que si tu as changee qq chose dans ta database rajoute aussi dans la liste
    public static void notifyToParcelList(final NotifyDataChange<List<Parcel>> notifyDataChange) {
        if (notifyDataChange != null) {

            if (parcelRefChildEventListener != null) {
                notifyDataChange.onFailure(new Exception("first unNotify parcel list"));
                return;
            }
            parcelList.clear();

            parcelRefChildEventListener = new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    Parcel parcel = dataSnapshot.getValue(Parcel.class);
                    String id = dataSnapshot.getKey();
                   parcel.setId(Long.parseLong(id));
                    parcelList.add(parcel);



                    notifyDataChange.OnDataChanged(parcelList);
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                    Parcel parcel = dataSnapshot.getValue(Parcel.class);
                    Long id = Long.parseLong(dataSnapshot.getKey());
                    parcel.setId(id);


                    for (int i = 0; i < parcelList.size(); i++) {
                        if (parcelList.get(i).getId() == (id)) {
                            parcelList.set(i, parcel);
                            break;
                        }
                    }
                    notifyDataChange.OnDataChanged(parcelList);
                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {
                    Parcel parcel = dataSnapshot.getValue(Parcel.class);
                    Long id = Long.parseLong(dataSnapshot.getKey());
                    parcel.setId(id);

                    for (int i = 0; i < parcelList.size(); i++) {
                        if (parcelList.get(i).getId() == id) {
                            parcelList.remove(i);
                            break;
                        }
                    }
                    notifyDataChange.OnDataChanged(parcelList);
                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    notifyDataChange.onFailure(databaseError.toException());
                }
            };
            ParcelsRef.addChildEventListener(parcelRefChildEventListener);
        }
    }
            public static void stopNotifyToParcelList()
        {
                if (parcelRefChildEventListener != null) {
                    ParcelsRef.removeEventListener(parcelRefChildEventListener);
                    parcelRefChildEventListener = null;
                }
        }

        }

