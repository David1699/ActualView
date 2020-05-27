package com.example.actualview.Models;

public class Series {
    //Aquí te muestra todos los datos relacionados con las series
    private String Nombre;
    private String Descripcion;
    private String img;
    private Boolean proximamente;
    private Boolean estreno;
    private Boolean popular;
    private Boolean vista;
    private Boolean favorita;
    private Boolean pendiente;

    public Series(String nombre, String descripcion, String img, Boolean proximamente, Boolean estreno, Boolean popular, Boolean vista, Boolean favorita, Boolean pendiente) {
        Nombre = nombre;
        Descripcion = descripcion;
        this.img = img;
        this.proximamente = proximamente;
        this.estreno = estreno;
        this.popular = popular;
        this.vista = vista;
        this.favorita = favorita;
        this.pendiente = pendiente;
    }

    public Series() {
    }

    public String getNombre() {
        return Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public String getImg() {
        return img;
    }

    public Boolean getProximamente() {
        return proximamente;
    }

    public Boolean getEstreno() {
        return estreno;
    }

    public Boolean getPopular() {
        return popular;
    }

    public Boolean getVista() {
        return vista;
    }

    public Boolean getFavorita() {
        return favorita;
    }

    public Boolean getPendiente() {
        return pendiente;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setProximamente(Boolean proximamente) {
        this.proximamente = proximamente;
    }

    public void setEstreno(Boolean estreno) {
        this.estreno = estreno;
    }

    public void setPopular(Boolean popular) {
        this.popular = popular;
    }

    public void setVista(Boolean vista) {
        this.vista = vista;
    }

    public void setFavorita(Boolean favorita) {
        this.favorita = favorita;
    }

    public void setPendiente(Boolean pendiente) {
        this.pendiente = pendiente;
    }
}
