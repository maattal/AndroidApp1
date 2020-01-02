package com.example.projet.UI;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projet.Entities.Enums;
import com.example.projet.Entities.Enums.Status_Parcel;
import com.example.projet.Entities.Enums.Type_Parcel;
import com.example.projet.Entities.Enums.Weight_Parcel;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.projet.DataModel.Firebase_DBmanager;

import com.example.projet.Entities.Parcel;
import com.example.projet.Entities.Recipient;
import com.example.projet.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.LocationListener;

import android.os.Build;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static java.lang.Boolean.TRUE;

public class AddParcelActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_parcel);

        //region FILLING OF THE ADRESS TEXT
        getAdress();
         Location_Packet.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setLocationManager();
        }
    });
//endregion

        //region FILLING OF THE SPINNER LIST
        Spinner mySpinnerType = (Spinner) findViewById(R.id.spinnerType);
        mySpinnerType.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Type_Parcel.values()));

        Spinner mySpinnerWeight = (Spinner) findViewById(R.id.spinnerWeight);
        mySpinnerWeight.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Weight_Parcel.values()));

        Spinner mySpinnerStatus = (Spinner) findViewById(R.id.spinnerStatus);
        mySpinnerStatus.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Status_Parcel.values()));
        //endregion

        //region ADD_button
        Button add_button = (Button) findViewById(R.id.add);
        //Button history_button = (Button) findViewById(R.id.History);
        final Firebase_DBmanager myManager = new Firebase_DBmanager();
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //FirebaseDatabase databaseexemple=FirebaseDatabase.getInstance();
                myManager.addParcelToFirebase( getParcel());//instance de la firebase);

            }
        });
//endregion
    }

    //region GET_ADRESS
static Location locationamettredansparcel;
        LocationManager locationManager;
        LocationListener locationListener;
        TextView Location_Packet;

    void getAdress()

    {
        Location_Packet = (TextView) findViewById(R.id.Location_Packet);
        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                Location_Packet.setText(getPlace(location));
                locationamettredansparcel=location;
                //getPlace(location).toString()
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };
    }
    private void setLocationManager() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 5);

        } else {

            // Android version is lesser than 6.0 or the permission is already granted.

            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);

        }

    }

    public String getPlace(Location location)
    {

        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        List<Address> addresses = null;
        try {
            addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            if (addresses.size() > 0) {

                String address = addresses.get(0).getAddressLine(0);
                Double latitude = addresses.get(0).getLatitude();
                Double longitude = addresses.get(0).getLongitude();
                return latitude + "\n" + longitude + "\n" + address;
            }
            return "no place: \n (" + location.getLongitude() + " , " + location.getLatitude() + ")";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "IOException...";
    }
    //endregion

    //region GET_PARCEL
    private Parcel getParcel() {
        Spinner mySpinnerType = (Spinner) findViewById(R.id.spinnerType);
        Spinner mySpinnerWeight = (Spinner) findViewById(R.id.spinnerWeight);
        Spinner mySpinnerStatus = (Spinner) findViewById(R.id.spinnerStatus);
        CheckBox is_Fragile = (CheckBox) findViewById(R.id.isFragile);

        boolean is_Fragileparcel = false;
        if (is_Fragile.isChecked()) {
            is_Fragileparcel = true;
        }

        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        Location location=new Location(locationamettredansparcel);

        Type_Parcel type_havila = (Type_Parcel) mySpinnerType.getSelectedItem();
        Weight_Parcel weight = (Weight_Parcel) mySpinnerWeight.getSelectedItem();
        Status_Parcel parcelStatus = (Status_Parcel) mySpinnerStatus.getSelectedItem();
        TextView postman = (TextView) findViewById(R.id.PostMan);

        Recipient rec=getRecipient();
        TextView date_sending = findViewById(R.id.Date);
        String help=date_sending.toString();
        // TODO (5): J'ai changer ici de façon à prendre que la longitude et la lattitude de la location
        return new Parcel(type_havila, weight,parcelStatus , is_Fragileparcel, location.getLongitude(), location.getLatitude(), postman.getText().toString(),getRecipient(),stringToDate(help));
    }
public Date stringToDate(String mystring)
{
    Date date=new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    try {

         date = formatter.parse(mystring);

    } catch (ParseException e) {
        e.printStackTrace();
    }
    return date;
}
    private Recipient getRecipient() {
        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        Location location=new Location(locationamettredansparcel);
        Location locationRecipient=new Location(location);

        TextView Destinataire = (TextView) findViewById(R.id.Destinataire);
        TextView phone = (TextView) findViewById(R.id.Telephone);
        TextView mail = (TextView) findViewById(R.id.Mail);
        TextView postman = (TextView) findViewById(R.id.PostMan);
        return new Recipient( Destinataire.getText().toString(), location.getLatitude(),location.getLongitude(), phone.getText().toString(),  mail.getText().toString());

    }
    //endregion
}
