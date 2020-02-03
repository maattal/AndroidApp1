package com.example.projet.UI;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.projet.Entities.Parcel;
//import com.example.projet.Entities.ParcelFromFirebase;
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
        recyclerView = (RecyclerView) findViewById(R.id.parcels_recycleView);
        recyclerView.setHasFixedSize(true);

        //le layout manager cest pour savoir a quoi va ressembler chaque ligne d ela view
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //l'adapter cest ce qui fait le lien entre la view et les donness
        mAdapter = new ParcelAdapter(HistoryParcelsActivities.this, parcelsList);
        recyclerView.setAdapter(mAdapter);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Parcels");//sa tu lenvoie dans ton addparceltofirebase
        myRef.addListenerForSingleValueEvent(valueEventListener);
    }


    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            parcelsList.clear();
            if (dataSnapshot.exists()) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Parcel parcel_db = snapshot.getValue(Parcel.class);
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

