
package com.ceep.tienda.dominio;

public class Sneaker {
    
    private String nombre;
    
    public Sneaker(){
    }
    
    public Sneaker(String nombre){
        this();
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Sneaker{" + "nombre=" + nombre + '}';
    }

    
}
