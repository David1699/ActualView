package com.example.actualview.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.actualview.Adapters.ViewPagerMisSeriesAdapter;
import com.example.actualview.Adapters.ViewPagerSeriesAdapter;
import com.example.actualview.Fragments.MisSeriesPendientesFragment;
import com.example.actualview.Fragments.SeriesEstrenosFragment;
import com.example.actualview.R;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;


public class MisSeriesActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, CompoundButton.OnCheckedChangeListener {


    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private String email;
    private TextView temail;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerMisSeriesAdapter adapter;
    // Índice de posición de los fragments
    public static final int PENDIENTES = 0;
    public static final int FAVORITAS = 1;
    public static final int VISTAS = 2;

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
        setContentView(R.layout.misseries_main);

       setToolbar();

        setTabLayout();
        setViewPager();
        setListenerTabLayout(viewPager);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layoutmisSeries);
        navigationView = (NavigationView) findViewById(R.id.navviewmisSeries);

        setFragmentByDefault();

        navigationView.setNavigationItemSelectedListener(this);





    }

    private void setToolbar() {
        Toolbar toolbar2 = (Toolbar) findViewById(R.id.toolbarmisSeries);
        setSupportActionBar(toolbar2);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }





    private void setTabLayout() {
        //Se crean las diferentes pestañas para MisSeries
        tabLayout = (TabLayout) findViewById(R.id.tabLayoutmisSeries);
        tabLayout.addTab(tabLayout.newTab().setText("Pendientes"));
        tabLayout.addTab(tabLayout.newTab().setText("Favoritas"));
        tabLayout.addTab(tabLayout.newTab().setText("Vistas"));

    }

    private void setViewPager() {
        viewPager = (ViewPager) findViewById(R.id.viewPagermisSeries);
        adapter = new ViewPagerMisSeriesAdapter(getSupportFragmentManager(), this, 3);
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
        changeFragment(new MisSeriesPendientesFragment(), navigationView.getMenu().getItem(0));
    }

    private void changeFragment(Fragment fragment, MenuItem item) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_framemisSeries, fragment)
                .commit();
        item.setChecked(true);
        //   getSupportActionBar().setTitle(item.getTitle());
        getSupportActionBar().setTitle("Mis Series");
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
            //Se crea el caso para lo que hace menu_series
            case R.id.menu_series:
                Intent intent = new Intent(MisSeriesActivity.this, MisSeriesActivity.class);
                startActivity(intent);
                finish();
                break;
            //Se crea el caso para lo que hace menu_peliculas
            case R.id.menu_peliculas:
                intent = new Intent(MisSeriesActivity.this, PeliculasActivity.class);
                startActivity(intent);
                break;
            //Se crea el caso para lo que hace menu_mis_series
            case R.id.menu_mis_series:
                intent = new Intent(MisSeriesActivity.this, MisSeriesActivity.class);
                startActivity(intent);
                break;
            //Se crea el caso para lo que hace menu_mis_peliculas
            case R.id.menu_mis_peliculas:
                intent = new Intent(MisSeriesActivity.this, MisPeliculasActivity.class);
                startActivity(intent);
                break;
        }

        item.setChecked(true);

        return true;

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
        if (checked) {
            Toast.makeText(MisSeriesActivity.this, "La opción es seleccionada", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MisSeriesActivity.this, "La opción es desseleccionada", Toast.LENGTH_SHORT).show();
        }
    }
}