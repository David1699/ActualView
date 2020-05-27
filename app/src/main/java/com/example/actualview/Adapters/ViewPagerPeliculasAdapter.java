package com.example.actualview.Adapters;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.actualview.Fragments.PeliculasEstrenosFragment;
import com.example.actualview.Fragments.PeliculasPopularesFragment;
import com.example.actualview.Fragments.PeliculasProximamenteFragment;

import static com.example.actualview.activities.SeriesActivity.ESTRENOS;
import static com.example.actualview.activities.SeriesActivity.POPULARES;
import static com.example.actualview.activities.SeriesActivity.PROXIMAMENTE;

public class ViewPagerPeliculasAdapter extends FragmentPagerAdapter {

    private int numberOfTabs;


    public ViewPagerPeliculasAdapter(FragmentManager fm, Context context, int numberOfTabs) {
        super(fm);
        this.numberOfTabs = numberOfTabs;
    }


    @Override
    public Fragment getItem(int position) {
        //Aqui encontramos la funcionalidad de las pestañas
        switch (position) {
            case POPULARES:
                return new PeliculasPopularesFragment();
            case ESTRENOS:
                return new PeliculasEstrenosFragment();
            case PROXIMAMENTE:
                return new PeliculasProximamenteFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }

}
