package com.example.actualview.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;


import com.example.actualview.Adapters.ViewPagerSeriesAdapter;
import com.example.actualview.Fragments.SeriesEstrenosFragment;
import com.example.actualview.R;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;


public class SeriesActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, CompoundButton.OnCheckedChangeListener {


    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private String email;
    private TextView temail;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerSeriesAdapter adapter;
    // Índice de posición de los fragments
    public static final int POPULARES = 0;
    public static final int ESTRENOS = 1;
    public static final int PROXIMAMENTE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.header_nav_drawer);
        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            email = bundle.getString("email");
            temail = (TextView) findViewById(R.id.textLogin);
            temail.setText("Usuario");
        }
        setContentView(R.layout.activity_main);

       setToolbar();

        setTabLayout();
        setViewPager();
        setListenerTabLayout(viewPager);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layoutSeries);
        navigationView = (NavigationView) findViewById(R.id.navviewSeries);

        setFragmentByDefault();

        navigationView.setNavigationItemSelectedListener(this);




    }

    private void setToolbar() {
        Toolbar toolbar2 = (Toolbar) findViewById(R.id.toolbarSeries);
        setSupportActionBar(toolbar2);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }





    private void setTabLayout() {
        //Se crean las pestañas de Series
        tabLayout = (TabLayout) findViewById(R.id.tabLayoutSeries);
        tabLayout.addTab(tabLayout.newTab().setText("Populares"));
        tabLayout.addTab(tabLayout.newTab().setText("Estrenos"));
        tabLayout.addTab(tabLayout.newTab().setText("Próximamente"));

    }

    private void setViewPager() {
        //Aqui se encuentra el viewpager para peliculas
        viewPager = (ViewPager) findViewById(R.id.viewPagerSeries);
        adapter = new ViewPagerSeriesAdapter(getSupportFragmentManager(), this, 3);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    private void setListenerTabLayout(final ViewPager viewPager) {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

    }
    private void setFragmentByDefault() {
        changeFragment(new SeriesEstrenosFragment(), navigationView.getMenu().getItem(0));
    }

    private void changeFragment(Fragment fragment, MenuItem item) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frameSeries, fragment)
                .commit();
        item.setChecked(true);
        //   getSupportActionBar().setTitle(item.getTitle());
        getSupportActionBar().setTitle("Series");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


        switch (item.getItemId()) {
            //Se crea el caso para lo que hace menu_mis_peliculas
            case R.id.menu_series:
                Intent intent = new Intent(SeriesActivity.this, SeriesActivity.class);
                startActivity(intent);
                finish();
                break;
            //Se crea el caso para lo que hace menu_mis_peliculas
            case R.id.menu_peliculas:
                intent = new Intent(SeriesActivity.this, PeliculasActivity.class);
                startActivity(intent);
                break;
            //Se crea el caso para lo que hace menu_mis_peliculas
            case R.id.menu_mis_series:
                intent = new Intent(SeriesActivity.this, MisSeriesActivity.class);
                startActivity(intent);
                break;
            //Se crea el caso para lo que hace menu_mis_peliculas
            case R.id.menu_mis_peliculas:
                intent = new Intent(SeriesActivity.this, MisPeliculasActivity.class);
                startActivity(intent);
                break;
        }


        return true;

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
        if (checked) {
            Toast.makeText(SeriesActivity.this, "La opción es seleccionada", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(SeriesActivity.this, "La opción es desseleccionada", Toast.LENGTH_SHORT).show();
        }
    }
}