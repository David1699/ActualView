package com.example.actualview.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.actualview.Adapters.SeriesAdapter;
import com.example.actualview.Models.Series;
import com.example.actualview.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class MisSeriesPendientesFragment extends Fragment implements View.OnClickListener{

    private FloatingActionButton fab;

    private List<Series> series;

    private ListView listView;
    private SeriesAdapter adapterSeries;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    public MisSeriesPendientesFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Aquí se muestran todas las series pendientes
        View view = inflater.inflate(R.layout.fragment_misseries_favoritas, container, false);
        inicializarFirebase();
        series = new ArrayList<Series>();
        listView = (ListView) view.findViewById(R.id.listViewSeries);
        databaseReference.child("Series").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                series.clear();
                for (DataSnapshot objSnaptshot : dataSnapshot.getChildren()){
                    Series s = objSnaptshot.getValue(Series.class);
                        if(s.getPendiente()!=null) {
                            if (s.getPendiente()) {

                                series.add(s);
                            }
                        }



                }
                adapterSeries = new SeriesAdapter(getContext(), R.layout.list_view_series, series);
                listView.setAdapter(adapterSeries);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        return view;
    }

    @Override
    public void onClick(View view) {
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(getContext());
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
}