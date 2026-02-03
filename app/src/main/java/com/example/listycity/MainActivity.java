package com.example.listycity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import java.util.Arrays;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView cityList;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;

    EditText cityInput;
    Button addButton;
    Button deleteButton;
    int selectedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        cityList = findViewById(R.id.city_list);
        cityInput = findViewById(R.id.city_input);
        addButton = findViewById(R.id.add_button);
        deleteButton = findViewById(R.id.delete_button);

        String []cities = {"Edmonton", "Vancouver", "Moscow", "Sydney", "Berlin", "Vienna", "Tokyo", "Beijing", "Osaka", "New Delhi"};

        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));
        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);
        cityList.setAdapter(cityAdapter);

        cityList.setOnItemClickListener((parent, view, position, id) -> {
            selectedPosition = position;
        });

        addButton.setOnClickListener(v -> {
            String newCity = cityInput.getText().toString().trim();
            if(!newCity.isEmpty()){
                dataList.add(newCity);
                cityAdapter.notifyDataSetChanged();
                cityInput.setText("");
            }
        });

        deleteButton.setOnClickListener(v -> {
            if(selectedPosition != -1){
                dataList.remove(selectedPosition);
                cityAdapter.notifyDataSetChanged();
                selectedPosition = -1;
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}