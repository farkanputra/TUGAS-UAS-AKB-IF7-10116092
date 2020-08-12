/**
 11/08/2020
 10116092
 Farkan Putra Ar-Rafii
 AKB -7
 **/
package com.example.pc_1.akb;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pc_1.akb.Adapter.TempatWisataAdapter;
import com.example.pc_1.akb.Model.Friends;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFriends extends Fragment {
    FloatingActionButton btnOpenDialog;
    TextView textInfo;
    String nama,nim,kelas,telp,email,socmed;

    private RecyclerView recyclerView;
    private TempatWisataAdapter adapter;
    private ArrayList<Friends> mahasiswaArrayList;
    View myView;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new TempatWisataAdapter(mahasiswaArrayList);

        addData();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myView =  inflater.inflate(R.layout.fragment_menu_friends, container, false);
        textInfo = myView.findViewById(R.id.tes);






        btnOpenDialog = myView.findViewById(R.id.btn_tambah);


        btnOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

        addData();

        recyclerView = (RecyclerView) myView.findViewById(R.id.recycler_view);

        adapter = new TempatWisataAdapter(mahasiswaArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
        return myView;
    }

    private void openDialog() {
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View subView = inflater.inflate(R.layout.alert_dialog, null);
        final EditText nama_dialog = subView.findViewById(R.id.txt_nama_dialog);
        final EditText nim_dialog = subView.findViewById(R.id.txt_nim_dialog);
        final EditText kelas_dialog = subView.findViewById(R.id.txt_kelas_dialog);
        final EditText telp_dialog = subView.findViewById(R.id.txt_telp_dialog);
        Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Tambah Tempat Wisata");
        builder.setMessage("Masukan Info Tempat Wisata");
        builder.setView(subView);
        AlertDialog alertDialog = builder.create();

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                nama=nama_dialog.getText().toString();
                nim=nim_dialog.getText().toString();
                kelas=kelas_dialog.getText().toString();
                telp=telp_dialog.getText().toString();
                textInfo.setText(nim);
                mahasiswaArrayList.add(new Friends(nim, nama, kelas));



            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "Cancel", Toast.LENGTH_LONG).show();
            }
        });

        builder.show();

    }






    void addData(){
        mahasiswaArrayList = new ArrayList<>();
        mahasiswaArrayList.add(new Friends("Alun-Alun Bandung", "Alamat : Jl. Asia Afrika, Balonggede,Regol,Bandung,Jawa Barat,Indonesia,40251", "Hiburan : Alun-Alun Bandung, Gedung Asia Afrika, Tempat makan dan Tempat Baju"));
        mahasiswaArrayList.add(new Friends("The Lodge Maribaya", "Alamat : Jalan Maribaya No. 149/252, RT. 03 / RW. 15, Babakan Gentong, Cibodas,Lembang,Bandung Barat,Jawa Barat,Indonesia,40391", "Hiburan : Balon udara, Gantole, Zip Bike, Ayunan, Sky tree"));
        mahasiswaArrayList.add(new Friends("Danau Situ Patenggang", "Alamat : Patengan,Rancabali,Bandung,Jawa Barat,Indonesia,40973", "Hiburan : Kebun Teh, Danau Situ Patenggang, Batu Cinta, Kapal Pinisi"));

    }
}
