package com.example.aula_01.exercicioretrofit.RequestAPI;

import com.example.aula_01.exercicioretrofit.Model.PojoList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DataService {

    //receita de bolo e só muda o endpoint de acordo com o projeto que está sendo desenvolvido
    @GET("retrofit-demo.php")
    Call<PojoList> getEmployeeData(@Query("company_no") int companyNo);

}
