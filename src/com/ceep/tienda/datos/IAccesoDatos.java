
package com.ceep.tienda.datos;

import com.ceep.tienda.dominio.Sneaker;
import com.ceep.tienda.excepciones.AccesoDatosEx;
import com.ceep.tienda.excepciones.EscrituraDatosEx;
import com.ceep.tienda.excepciones.LecturaDatosEx;
import java.util.List;

public interface IAccesoDatos {
    
    
    boolean existe(String nombreArchivo);
    
    List<Sneaker> listar(String nombreArchivo) throws LecturaDatosEx;
    
    void escribir(Sneaker sneaker, String nombreArchivo, boolean anexar)
            throws EscrituraDatosEx;
    
    String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx;
    
    void crear(String nombreArchivo) throws AccesoDatosEx;
    
    void borrar(String nombreArchivo) throws AccesoDatosEx;
    
    void comprarProducto(String nombreArchivo, String buscar) throws LecturaDatosEx;
}
