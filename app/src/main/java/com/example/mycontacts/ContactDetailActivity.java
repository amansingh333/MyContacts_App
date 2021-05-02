package com.example.mycontacts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ContactDetailActivity extends AppCompatActivity {

    private static final String TAG = "ContactDetailActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);

        Log.d(TAG,"onCreate: started.");

        TextView contactName = findViewById(R.id.contact_name);
        String name = "";

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            name = extras.getString("name");
        }

        contactName.setText(name);
    }
}