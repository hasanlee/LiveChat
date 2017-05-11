package com.hasanli.livechat.livechat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;


public class MainActivity extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;
    Button golive;
    public EditText name,surname,phone;
    //shared preference
    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        golive = (Button) findViewById(R.id.button);
        name = (EditText) findViewById(R.id.editTextName);
        surname = (EditText) findViewById(R.id.editTextSurname);
        phone = (EditText) findViewById(R.id.editTextPhone);
        final Date vaxt = new Date();

        // Write a message to the database
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference();


        golive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = name.getText().toString().trim();
                String usurname = surname.getText().toString().trim();
                String uphone = phone.getText().toString().trim();

                if (uname.isEmpty()){
                    name.setError("Enter Name");
                } else {
                    if(usurname.isEmpty()){
                        surname.setError("Enter Surname");
                    } else {
                        if (uphone.isEmpty()) {
                            phone.setError("Enter Phone Number");
                        } else {
                            //save data to local sharedpreference
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putString("Name",uname);
                            editor.putString("Surname",usurname);
                            editor.putString("PhoneNumber",uphone);
                            editor.putString("LastSignInDate",vaxt.toString());
                            editor.apply();
                            //save data to firebase
                            final User customer= new User();
                            customer.setName(uname);
                            customer.setSurname(usurname);
                            customer.setPhone(uphone);
                            customer.setSigndate(vaxt.toString());
                            customer.setFullname(usurname+" "+uname);
                            myRef.child("Users").child(uname).setValue(customer);
                            //load chat page intent
                            Intent intent = new Intent(view.getContext(), ChatActivity.class);
                            intent.putExtra("name", uname);
                            startActivity(intent);
                        }
                    }
                }


            }

        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        name.setText(preferences.getString("Name", null));
        surname.setText(preferences.getString("Surname", null));
        phone.setText(preferences.getString("PhoneNumber", null));
    }

    @Override
    protected void onResume() {
        super.onResume();
        name.setText(preferences.getString("Name", null));
        surname.setText(preferences.getString("Surname", null));
        phone.setText(preferences.getString("PhoneNumber", null));
    }
}
