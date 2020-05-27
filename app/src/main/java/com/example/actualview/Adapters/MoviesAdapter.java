package com.example.actualview.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.actualview.Models.Peliculas;
import com.example.actualview.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MoviesAdapter extends BaseAdapter {
    //Aqui encontramos todos los datos relacionados con las peliculas
    private Context context;
    private int layout;
    private List<Peliculas> peliculasList;

    public MoviesAdapter(Context context, int layout, List<Peliculas> peliculasList) {
        this.context = context;
        this.layout = layout;
        this.peliculasList = peliculasList;
    }

    @Override
    public int getCount() {
        return peliculasList.size();
    }

    @Override
    public Peliculas getItem(int position) { return peliculasList.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertMovies, ViewGroup viewGroup) {
        ViewHolder holder;
        if (convertMovies == null) {
            convertMovies = LayoutInflater.from(context).inflate(layout, null);
            holder = new ViewHolder();
           holder.name = (TextView) convertMovies.findViewById(R.id.nombreEstrenoMovies);
            holder.Descripcion = (TextView) convertMovies.findViewById(R.id.descripcionEstrenoMovies);
            holder.image = (ImageView) convertMovies.findViewById(R.id.imageEstrenoMovies);
            convertMovies.setTag(holder);
        } else {
            holder = (ViewHolder) convertMovies.getTag();
        }

        Peliculas currentPeliculas = peliculasList.get(position);
        holder.name.setText(currentPeliculas.getNombre());
        holder.Descripcion.setText(currentPeliculas.getDescripcion());
        String url = currentPeliculas.getImg();
        Picasso.with(context).load(url).into(holder.image);
        return convertMovies;
    }

    static class ViewHolder {
        private TextView name;
        private TextView Descripcion;
        private ImageView image;
    }


}
