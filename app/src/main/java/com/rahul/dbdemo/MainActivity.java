package com.rahul.dbdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.rahul.dbdemo.adapter.RecyclerViewAdapter;
import com.rahul.dbdemo.data.MyDbHandler;
import com.rahul.dbdemo.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    //
    private RecyclerViewAdapter recyclerViewAdapter;
    private ArrayList<Contact> contactArrayList;
    private ArrayAdapter<String> arrayAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //RecyclerView Initialization
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        MyDbHandler db = new MyDbHandler(MainActivity.this);

        // Creating a contact object for the db
        Contact harry = new Contact();
        harry.setPhoneNumber("9090909090");
        harry.setName("Harry");

        // Adding a contact to the db
        db.addContact(harry);
        db.addContact(harry);
        db.addContact(harry);
        db.addContact(harry);
        db.addContact(harry);
        db.addContact(harry);
        db.addContact(harry);
        db.addContact(harry);
        db.addContact(harry);
        db.addContact(harry);
        db.addContact(harry);


        contactArrayList = new ArrayList<>();




        // Get all contacts
        List<Contact> contactList = db.getAllContacts();
        for(Contact contact: contactList){

            Log.d("dbharry", "\nId: " + contact.getId() + "\n" +
                    "Name: " + contact.getName() + "\n"+
                    "Phone Number: " + contact.getPhoneNumber() + "\n" );

            //Adding contact to String Array list named contacts
            contactArrayList.add(contact);

        }

        // Use your recyclerView
        recyclerViewAdapter = new RecyclerViewAdapter(this,contactArrayList);
        recyclerView.setAdapter(recyclerViewAdapter);


        Log.d("dbharry", "Bro you have "+ db.getCount()+ " contacts in your database");


    }
}