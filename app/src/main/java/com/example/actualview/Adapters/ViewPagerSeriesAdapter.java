package com.example.actualview.Adapters;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.actualview.Fragments.SeriesEstrenosFragment;
import com.example.actualview.Fragments.SeriesPopularesFragment;
import com.example.actualview.Fragments.SeriesProximamenteFragment;

import static com.example.actualview.activities.SeriesActivity.ESTRENOS;
import static com.example.actualview.activities.SeriesActivity.POPULARES;
import static com.example.actualview.activities.SeriesActivity.PROXIMAMENTE;

public class ViewPagerSeriesAdapter extends FragmentPagerAdapter {

    private int numberOfTabs;


    public ViewPagerSeriesAdapter(FragmentManager fm, Context context, int numberOfTabs) {
        super(fm);
        this.numberOfTabs = numberOfTabs;
    }


    @Override
    public Fragment getItem(int position) {
        //Aqui encontramos la funcionalidad de las pestañas
        switch (position) {
            case POPULARES:
                return new SeriesPopularesFragment();
            case ESTRENOS:
                return new SeriesEstrenosFragment();
            case PROXIMAMENTE:
                return new SeriesProximamenteFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }

}
