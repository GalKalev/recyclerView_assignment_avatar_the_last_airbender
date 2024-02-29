package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private ArrayList<DataModel> dataSet;
    private CustomeAdapter adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SearchView searchView = (SearchView) findViewById(R.id.searchView);

        recyclerView = findViewById(R.id.res);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        dataSet = new ArrayList<>();


        recyclerView.setItemAnimator(new DefaultItemAnimator());

        for(int i = 0; i < MyData.drawableArray.length; i++){
            dataSet.add(new DataModel(
                    MyData.nameArray[i],
                    MyData.descriptionArray[i],
                    MyData.id_[i],
                    MyData.drawableArray[i],
                    MyData.drawableBgArray[i]
            ));
        }

        adapter = new CustomeAdapter(dataSet);
        recyclerView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<DataModel> filteredList = new ArrayList<>();
                for(DataModel item : dataSet){
                    if(item.getName().toLowerCase().contains(newText.toLowerCase())){
                        filteredList.add(item);
                    }
                }
                if(filteredList.isEmpty()){
                    Toast.makeText(MainActivity.this, "No Data Found...", Toast.LENGTH_SHORT).show();
                }
                else{
                    adapter.filterList(filteredList);
                }
                return false;
            }
        });


    }

}