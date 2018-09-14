package com.example.aula_01.exercicioretrofit.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aula_01.exercicioretrofit.Model.PojoDemo;
import com.example.aula_01.exercicioretrofit.R;

import java.util.ArrayList;

//eu escrevo a linha abaixo, que é de onde está classe está extendendo e em seguida vou seguindo as instruções do próprio Android

public class AdapterPojo extends RecyclerView.Adapter<AdapterPojo.ViewHolder>{

    private ArrayList<PojoDemo> dataList;

    public AdapterPojo(ArrayList<PojoDemo> dataList) {
        this.dataList = dataList;
    }

    @Override
    public AdapterPojo.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_employee, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterPojo.ViewHolder holder, int position) {
        holder.txtEmpName.setText(dataList.get(position).getName());
        holder.txtEmpEmail.setText(dataList.get(position).getEmail());
        holder.txtEmpPhone.setText(dataList.get(position).getPhone());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtEmpName, txtEmpEmail, txtEmpPhone;

        public ViewHolder(View itemView) {
            super(itemView);

            txtEmpName = (TextView) itemView.findViewById(R.id.txt_employee_name);
            txtEmpEmail = (TextView) itemView.findViewById(R.id.txt_employee_email);
            txtEmpPhone = (TextView) itemView.findViewById(R.id.txt_employee_phone);

        }
    }
}
