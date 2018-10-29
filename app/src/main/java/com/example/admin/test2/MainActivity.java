package com.example.admin.test2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;
public class MainActivity extends AppCompatActivity {

    public DatabaseReference testapp;
    private TextView ntextview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ntextview = (TextView) findViewById(R.id.textview1);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        testapp = database.getReference();
        testapp.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map map = (Map) dataSnapshot.getValue();
                String username = String.valueOf(map.get("textview1"));
                ntextview.setText(username);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                ntextview.setText("Failed");
            }
        }
        );

    }



}
