package com.example.servertst;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class database_collection extends AppCompatActivity {

    private RecyclerView recyclerView;
    private sample_adapter adapter;
    private DatabaseReference databaseReference;
    private ProgressBar progressBar;

    private List<upload_data> uploads;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_collection);

        progressBar = findViewById(R.id.progress_database);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        uploads = new ArrayList<>();

        databaseReference = FirebaseDatabase.getInstance().getReference("samples");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot postsnapshoit: snapshot.getChildren()){
                    upload_data upload_data_item = postsnapshoit.getValue(upload_data.class);
                    uploads.add(upload_data_item);
                }

                adapter = new sample_adapter(database_collection.this,uploads);
                recyclerView.setAdapter(adapter);
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                progressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(database_collection.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
