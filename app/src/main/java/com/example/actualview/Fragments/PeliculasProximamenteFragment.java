package com.example.actualview.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.actualview.Adapters.MoviesAdapter;
import com.example.actualview.Models.Peliculas;
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


public class PeliculasProximamenteFragment extends Fragment implements View.OnClickListener{

    private FloatingActionButton fab;

    private List<Peliculas> movies;
    private ListView listView;


    private MoviesAdapter adapterMovies;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    public PeliculasProximamenteFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Aquí se muestran todas las peliculas proximamente
        View view = inflater.inflate(R.layout.fragment_peliculas_proximamente, container, false);
        inicializarFirebase();
        listView = (ListView) view.findViewById(R.id.listViewMoviesProximamente);

        movies = new ArrayList<Peliculas>();
        databaseReference.child("Peliculas").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                movies.clear();
                for (DataSnapshot objSnaptshot : dataSnapshot.getChildren()){
                    Peliculas m = objSnaptshot.getValue(Peliculas.class);
                    if(m.getProximamente()!=null) {
                        if (m.getProximamente()) {

                            movies.add(m);
                        }
                    }



                }
                adapterMovies = new MoviesAdapter(getContext(), R.layout.list_view_movies, movies);
                listView.setAdapter(adapterMovies);
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