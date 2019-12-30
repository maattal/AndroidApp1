package com.example.projet.UI;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.example.projet.R;

public class MainActivity extends AppCompatActivity {
    private static int timeout = 3000;

    //rajouter le intent vers nvlleactivity avec deux boutons + image du camion +dans chaque bouton rajouter un intent qui va a add et a history
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView im = findViewById(R.id.imageView);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent MyIntent = new Intent(MainActivity.this, MenuPrincipal.class);
                startActivity(MyIntent);
                finish();
            }
        }, timeout);
    }


}
