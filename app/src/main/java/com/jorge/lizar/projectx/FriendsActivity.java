package com.jorge.lizar.projectx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Arrays;
import java.util.List;


public class FriendsActivity extends AppCompatActivity
{
    ListView listContent;
    List<String> listInformation;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference friendsReference = database.getReference("users");

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        friendsReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                System.out.println(dataSnapshot.getValue());
            }

            @Override
            public void onCancelled(DatabaseError databaseError)
            {
                System.out.println(databaseError);
            }
        });

        listInformation = Arrays.asList("text", "more text");
        listContent = (ListView) findViewById(R.id.listContent);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listInformation);
        listContent.setAdapter(arrayAdapter);
    }
}
