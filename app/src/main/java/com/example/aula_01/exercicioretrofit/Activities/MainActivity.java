package com.example.aula_01.exercicioretrofit.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.aula_01.exercicioretrofit.Adapter.AdapterPojo;
import com.example.aula_01.exercicioretrofit.Model.PojoDemo;
import com.example.aula_01.exercicioretrofit.Model.PojoList;
import com.example.aula_01.exercicioretrofit.R;
import com.example.aula_01.exercicioretrofit.RequestAPI.DataService;
import com.example.aula_01.exercicioretrofit.RequestAPI.retro;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private AdapterPojo adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataService service = retro.getRetrofitInstance().create(DataService.class);

        Call<PojoList> call = service.getEmployeeData(100);
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<PojoList>() {
            @Override
            public void onResponse(Call<PojoList> call, Response<PojoList> response) {
            generateEmployeeList(response.body().getPojoDemo());
            }

            @Override
            public void onFailure(Call<PojoList> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });

    }
    /*Method to generate List of employees using RecyclerView with custom adapter*/
    private void generateEmployeeList(ArrayList<PojoDemo> empDataList) {

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_employee_list);

        adapter = new AdapterPojo(empDataList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
    }
}

