package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  List view
        ListView listView = (ListView) findViewById(R.id.myListView);

        //  ArrayList for containing data
        name = new ArrayList<>(asList("Android" , "Java" , "C++" , "SQL"));
        name.add("Android");
        name.add("Java");
        name.add("C++");
        name.add("SQL");

        //  ArrayAdapter to hold the data
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this , android.R.layout.simple_list_item_1,name);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("Tapped" , "Name of the person: "+name.get(position));

                //  Toast to display the text tapped
                Toast.makeText(getApplicationContext(),name.get(position),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
