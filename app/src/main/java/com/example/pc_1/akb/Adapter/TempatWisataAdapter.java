package com.example.pc_1.akb.Adapter;
/**
 09/05/2020
 10116092
 Farkan Putra Ar-Rafii
 AKB -7
 **/
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pc_1.akb.Model.Friends;
import com.example.pc_1.akb.R;

import java.util.ArrayList;

public class TempatWisataAdapter extends RecyclerView.Adapter<TempatWisataAdapter.MahasiswaViewHolder> {


    private ArrayList<Friends> dataList;

    public TempatWisataAdapter(ArrayList<Friends> dataList) {
        this.dataList = dataList;
    }

    @Override
    public MahasiswaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_mahasiswa, parent, false);
        return new MahasiswaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MahasiswaViewHolder holder, int position) {
        holder.txtNama.setText(dataList.get(position).getNama());
        holder.txtNim.setText(dataList.get(position).getNim());
        holder.txtKelas.setText(dataList.get(position).getKelas());
        holder.txtTelp.setText(dataList.get(position).getTelp());
        holder.txtEmail.setText(dataList.get(position).getEmail());
        holder.txtSocmed.setText(dataList.get(position).getSocmed());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class MahasiswaViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNama, txtNim, txtKelas,txtTelp,txtEmail,txtSocmed;

        public MahasiswaViewHolder(View itemView) {
            super(itemView);
            txtNama = (TextView) itemView.findViewById(R.id.txt_nama);
            txtNim = (TextView) itemView.findViewById(R.id.txt_nim);
            txtKelas = (TextView) itemView.findViewById(R.id.txt_kelas);
            txtTelp = (TextView) itemView.findViewById(R.id.txt_telp);
            txtEmail = (TextView) itemView.findViewById(R.id.txt_email);
            txtSocmed = (TextView) itemView.findViewById(R.id.txt_socmed);
        }
    }
}