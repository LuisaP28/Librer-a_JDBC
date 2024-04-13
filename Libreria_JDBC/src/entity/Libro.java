package entity;

import java.sql.Date;

public class Libro {
    private int id_libro;
    private String titulo;
    private Date año_publicacion;
    private double precio;
    private int id;

    public Libro() {
    }

    public Libro(int id_libro, String titulo, Date año_publicacion, double precio, int id) {
        this.id_libro = id_libro;
        this.titulo = titulo;
        this.año_publicacion = año_publicacion;
        this.precio = precio;
        this.id = id;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getAño_publicacion() {
        return año_publicacion;
    }

    public void setAño_publicacion(Date año_publicacion) {
        this.año_publicacion = año_publicacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id_libro=" + id_libro +
                ", titulo='" + titulo + '\'' +
                ", año_publicacion=" + año_publicacion +
                ", precio=" + precio +
                ", id=" + id +
                '}';
    }
}
