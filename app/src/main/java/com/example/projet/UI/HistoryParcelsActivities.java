package com.example.projet.UI;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projet.Entities.Parcel;
import com.example.projet.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HistoryParcelsActivities extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter mAdapter;

    List<Parcel> parcelsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        parcelsList = new ArrayList<Parcel>();
        buildTheView();

    }

    private void buildTheView() {
        setContentView(R.layout.activity_history_parcels_activities);
        recyclerView = (RecyclerView) findViewById(R.id.parcelsRecycleView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new ParcelAdapter(HistoryParcelsActivities.this, parcelsList);
        recyclerView.setAdapter(mAdapter);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Parcels");//sa tu lenvoie dans ton addparceltofirebase

        myRef.addListenerForSingleValueEvent(valueEventListener);
       // myRef.addValueEventListener(valueEventListener);
    }

    //la dedans tu fais une fonction qui remplit la list
    //dedans reference.AddListenerForSingleValueEvent(valueEventListener)
    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            parcelsList.clear();
            if (dataSnapshot.exists()) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    // TODO (1): Tu peux pas parcer un objet firebase a un autre objet qui est different
                    //  Tu parser un object Parcel à un objet ParcelFromFirebase
                    //  J'ai donc tous simplement changer ParcelFromFirebase a Parcel
                    //  Vous pouvez donc enelever toute la classe ParcelFromFirebase qui sert du coup a rien
                    Parcel parcel_db;
                    parcel_db = (Parcel) snapshot.getValue(Parcel.class);
                    parcelsList.add(parcel_db);
                }
                mAdapter.notifyDataSetChanged();
            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
        }


    };
}

