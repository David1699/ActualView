package com.example.actualview.Utils;

import com.example.actualview.Models.Peliculas;
import com.example.actualview.Models.Series;

import java.util.ArrayList;
import java.util.List;

public class Util {
    //Esto son las listas predefinadas para series y películas

    public static List<Series> getSeries() {
        return new ArrayList<Series>() {{
            add(new Series("Affgfdhfdhfhfhfhfdhdfdhfdhfhfhfdh", "A","https://2.bp.blogspot.com/-wxyv9C6RyZQ/WHTdjHuRcNI/AAAAAAAAFos/jv_AN9rXdecO2stCij7dp4ETbDrg2e3qQCLcB/s1600/524c4636808aae44e8f6e1dfa3aea15c.jpg", true, true, true, true, true, true));
            add(new Series("B", "A","A", true, true, true, true, true, true));
            add(new Series("B", "A","A", true, true, true, true, true, true));
            add(new Series("C", "A","A", true, true, true, true, true, true));
            add(new Series("D", "A","A", true, true, true, true, true, true));
            add(new Series("F", "A","A", true, true, true, true, true, true));
            add(new Series("G", "A","A", true, true, true, true, true, true));

        }};
    }
    public static List<Peliculas> getMovies() {
        return new ArrayList<Peliculas>() {{
            add(new Peliculas("HHH", "A","A", true, true, true, true, true, true));
            add(new Peliculas("B", "A","A", true, true, true, true, true, true));
            add(new Peliculas("B", "A","A", true, true, true, true, true, true));
            add(new Peliculas("C", "A","A", true, true, true, true, true, true));
            add(new Peliculas("D", "A","A", true, true, true, true, true, true));
            add(new Peliculas("F", "A","A", true, true, true, true, true, true));
            add(new Peliculas("G", "A","A", true, true, true, true, true, true));

        }};
    }
}
