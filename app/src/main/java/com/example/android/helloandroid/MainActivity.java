package com.example.android.helloandroid;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /**
     * This app provide contact information for Udacity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This function can open up the contact and pre-fill all the info for you to save.
     */
    public void insertContact(View view) {
        Intent intent = new Intent(Intent.ACTION_INSERT);
        intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
        intent.putExtra(ContactsContract.Intents.Insert.NAME, getString(R.string.udacity));
        intent.putExtra(ContactsContract.Intents.Insert.PHONE, getString(R.string.telephone));
        intent.putExtra(ContactsContract.Intents.Insert.EMAIL, getString(R.string.email));
        intent.putExtra(ContactsContract.Intents.Insert.POSTAL, getString(R.string.address));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * This function can help you to open gmail app and fill out udacity email and receiver.
     */
    public void sentEmail(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{getString(R.string.email)});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Hello, Udacity!");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * This function can help you to open dialer to call udacity.
     */
    public void dialPhoneNumber(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + getString(R.string.telephone)));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * This function can help you to open google maps and locate where Udacity is at.
     */
    public void direction(View view) {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("https://www.google.com/maps/search/?api=1&query=" + getString(R.string.address)));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * This function can help you to open the browser and open up the udacity website.
     */
    public void openWebPage(View view) {
        Uri webpage = Uri.parse("https://www.udacity.com");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


}
