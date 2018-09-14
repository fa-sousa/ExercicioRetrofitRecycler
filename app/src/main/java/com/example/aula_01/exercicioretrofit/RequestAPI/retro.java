package com.example.aula_01.exercicioretrofit.RequestAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


//este trecho de código também é receita de bolo, só vai mudar a base url de acordo com o projeto
public class retro {
    private static Retrofit retrofit;
    private static final String BASE_URL = "http://navjacinth9.000webhostapp.com/json/";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
