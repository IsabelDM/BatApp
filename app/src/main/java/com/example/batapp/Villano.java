package com.example.batapp;

public class Villano {
    private String alias;
    private String nombre;
    private String apellido;

    public Villano(String alias, String nombre, String apellido){
        this.alias = alias;
        this.nombre  = nombre;
        this.apellido = apellido;
    }

    public String getAlias(){
        return alias;
    }

    public void setAlias(String alias){
        this.alias = alias;
    }

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre= nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }
}
