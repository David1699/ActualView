package com.example.actualview.Adapters;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.actualview.Fragments.MisPeliculasFavoritasFragment;
import com.example.actualview.Fragments.MisPeliculasPendientesFragment;
import com.example.actualview.Fragments.MisPeliculasVistasFragment;

import static com.example.actualview.activities.MisSeriesActivity.FAVORITAS;
import static com.example.actualview.activities.MisSeriesActivity.PENDIENTES;
import static com.example.actualview.activities.MisSeriesActivity.VISTAS;

public class ViewPagerMisPeliculasAdapter extends FragmentPagerAdapter {

    private int numberOfTabs;


    public ViewPagerMisPeliculasAdapter(FragmentManager fm, Context context, int numberOfTabs) {
        super(fm);
        this.numberOfTabs = numberOfTabs;
    }


    @Override
    public Fragment getItem(int position) {
        //Aqui encontramos la funcionalidad de las pestañas
        switch (position) {
            case PENDIENTES:
                return new MisPeliculasPendientesFragment();
            case FAVORITAS:
                return new MisPeliculasFavoritasFragment();
            case VISTAS:
                return new MisPeliculasVistasFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }

}
