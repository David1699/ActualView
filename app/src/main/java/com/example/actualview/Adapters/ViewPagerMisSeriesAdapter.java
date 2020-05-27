package com.example.actualview.Adapters;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.actualview.Fragments.MisSeriesFavoritasFragment;
import com.example.actualview.Fragments.MisSeriesPendientesFragment;
import com.example.actualview.Fragments.MisSeriesVistasFragment;
import com.example.actualview.Fragments.SeriesEstrenosFragment;
import com.example.actualview.Fragments.SeriesPopularesFragment;
import com.example.actualview.Fragments.SeriesProximamenteFragment;

import static com.example.actualview.activities.MisSeriesActivity.FAVORITAS;
import static com.example.actualview.activities.MisSeriesActivity.PENDIENTES;
import static com.example.actualview.activities.MisSeriesActivity.VISTAS;
import static com.example.actualview.activities.SeriesActivity.ESTRENOS;
import static com.example.actualview.activities.SeriesActivity.POPULARES;
import static com.example.actualview.activities.SeriesActivity.PROXIMAMENTE;

public class ViewPagerMisSeriesAdapter extends FragmentPagerAdapter {

    private int numberOfTabs;


    public ViewPagerMisSeriesAdapter(FragmentManager fm, Context context, int numberOfTabs) {
        super(fm);
        this.numberOfTabs = numberOfTabs;
    }


    @Override
    public Fragment getItem(int position) {
        //Aqui encontramos la funcionalidad de las pestañas
        switch (position) {
            case PENDIENTES:
                return new MisSeriesPendientesFragment();
            case FAVORITAS:
                return new MisSeriesFavoritasFragment();
            case VISTAS:
                return new MisSeriesVistasFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }

}
