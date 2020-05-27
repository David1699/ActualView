package com.example.actualview.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.actualview.Models.Series;
import com.example.actualview.R;

import com.squareup.picasso.Picasso;

import java.util.List;

public class SeriesAdapter extends BaseAdapter {
    //Aqui encontramos todos los datos relacionados con las peliculas
    private Context context;
    private int layout;
    private List<Series> seriesList;

    public SeriesAdapter(Context context, int layout, List<Series> seriesList) {
        this.context = context;
        this.layout = layout;
        this.seriesList = seriesList;
    }

    @Override
    public int getCount() {
        return seriesList.size();
    }

    @Override
    public Series getItem(int position) {
        return seriesList.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertSeries, ViewGroup viewGroup) {
        ViewHolder holder;
        if (convertSeries == null) {
            convertSeries = LayoutInflater.from(context).inflate(layout, null);
            holder = new ViewHolder();
            holder.name = (TextView) convertSeries.findViewById(R.id.nombreEstrenoSeries);
            holder.Descripcion = (TextView) convertSeries.findViewById(R.id.descripcionEstrenoSeries);
            holder.image = (ImageView) convertSeries.findViewById(R.id.imageEstrenoSeries);
            convertSeries.setTag(holder);
        } else {
            holder = (ViewHolder) convertSeries.getTag();
        }

        Series currentSeries = seriesList.get(position);
        holder.name.setText(currentSeries.getNombre());
        holder.Descripcion.setText(currentSeries.getDescripcion());
        String url = currentSeries.getImg();
        Picasso.with(context).load(url).into(holder.image);
        return convertSeries;
    }

    static class ViewHolder {
        private TextView name;
        private TextView Descripcion;
        private ImageView image;
    }


}
