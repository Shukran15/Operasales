package com.example.operasales.model;

public class Primera {


    private long id;
    private String name;
    private String descripcion;
    private Kategory kt;
    private int freeplace;


    public Primera(long id, String name, String descripcion, Kategory kt, int freeplace) {
        this.id = id;
        this.name = name;
        this.descripcion = descripcion;
        this.kt = kt;
        this.freeplace = freeplace;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Kategory getKt() {
        return kt;
    }

    public void setKt(Kategory kt) {
        this.kt = kt;
    }

    public int getFreeplace() {
        return freeplace;
    }

    public void setFreeplace(int freeplace) {
        this.freeplace = freeplace;
    }

    @Override
    public String toString() {
        return "Primera{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", kt=" + kt +
                ", freeplace=" + freeplace +
                '}';
    }
}
