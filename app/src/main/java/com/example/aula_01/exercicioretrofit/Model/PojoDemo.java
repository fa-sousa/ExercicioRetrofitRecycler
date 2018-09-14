package com.example.aula_01.exercicioretrofit.Model;

import com.google.gson.annotations.SerializedName;

//esta classe está pegando as informações do Json tal qual está escrito lá. Criamos os getters e setters e os construtores
public class PojoDemo {


    private String name;

    private String email;

    private String phone;

    public PojoDemo(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
