package com.example.projet.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projet.R;

public class MenuPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        Button Add_Button = findViewById(R.id.Add_Parcel);
        Add_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MenuPrincipal.this, AddParcelActivity.class);
                startActivity(intent);
            }
        });
        Button History_Button= findViewById(R.id.History_Parcel);
        History_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MenuPrincipal.this, HistoryParcelsActivities.class);
                startActivity(intent);
            }
        });
    }
}
