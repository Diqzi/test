package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.listview.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ListAdapter listAdapter;
    ArrayList<ListData> dataArrayList = new ArrayList<>();
    ListData listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageList = {R.drawable.pencil, R.drawable.pencil, R.drawable.pencil, R.drawable.pencil, R.drawable.pencil, R.drawable.pencil, R.drawable.pencil};
        String[] nameList = {"Tugas praktikum 1", "Tugas praktikum 2", "Tugas praktikum 3", "Tugas praktikum 4", "Tugas praktikum 5","Tugas praktikum 6", "Tugas praktikum 7"};
        String[] timeList = {"Due date : 07 June 2023", "Due date : 14 June 2023", "Due date : 21 June 2023","Due date : 27 June 2023", "Due date : 03 Juli 2023", "Due date : 08 Juli 2023", "Due date : 14 Juli 2023"};

        for (int i = 0; i < imageList.length; i++){
            listData = new ListData(nameList[i], timeList[i], imageList[i]);
            dataArrayList.add(listData);
        }
        listAdapter = new ListAdapter(MainActivity.this, dataArrayList);
        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);

        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetailedActivity.class);
                intent.putExtra("name", nameList[i]);
                intent.putExtra("time", timeList[i]);
                intent.putExtra("image", imageList[i]);
                startActivity(intent);
            }
        });
    }
}