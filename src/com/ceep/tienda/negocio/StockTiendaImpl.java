
package com.ceep.tienda.negocio;

import com.ceep.tienda.datos.AccesoDatosImpl;
import com.ceep.tienda.datos.IAccesoDatos;
import com.ceep.tienda.dominio.Sneaker;
import com.ceep.tienda.excepciones.AccesoDatosEx;
import com.ceep.tienda.excepciones.EscrituraDatosEx;
import com.ceep.tienda.excepciones.LecturaDatosEx;
import java.util.ArrayList;
import java.util.List;


public class StockTiendaImpl implements IStockTienda{

    private final IAccesoDatos datos;
    
    public StockTiendaImpl() {
        this.datos = new AccesoDatosImpl();
    }
    
    
    @Override
    public void agregarSneaker(String nombreSneaker, String nombreCatalogo) {

        
        try {
            if (this.datos.existe(nombreCatalogo)) {
                this.datos.escribir(new Sneaker(nombreSneaker), nombreCatalogo, true);
            } else {
                System.out.println("Catálogo no inicalizado");
            }
        } catch (EscrituraDatosEx ex) {
            System.out.println("Error al agregar sneaker en el catálogo");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void listarSneaker(String nombreCatalogo) {
        List<Sneaker> sneakers = new ArrayList<>();
        
        try {
            sneakers = this.datos.listar(nombreCatalogo);
            sneakers.forEach(sneaker -> {
                System.out.println(sneaker.getNombre());
            });
        } catch (LecturaDatosEx ex) {
            System.out.println("Error leyendo el catálogo");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarSneaker(String nombreCatalogo, String buscar) {
        
        try {
            System.out.println(this.datos.buscar(nombreCatalogo, buscar));
        } catch (LecturaDatosEx ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void iniciarCatalogo(String nombreCatalogo) {
        
        try {
        if (this.datos.existe(nombreCatalogo)){
            this.datos.borrar(nombreCatalogo);
            this.datos.crear(nombreCatalogo);
        } else{
            this.datos.crear(nombreCatalogo);
        }
        } catch (AccesoDatosEx ex){
            ex.printStackTrace(System.out);
            System.out.println("Error al inicializar el catálogo de Sneakers");
        }

    }

    @Override
    public void comprarProducto(String nombreArchivo, String Buscar) {
        
        try {
            this.datos.comprarProducto(nombreArchivo, Buscar);
            System.out.println("Se han vendido las: ");
        } catch (LecturaDatosEx ex) {
            ex.printStackTrace();
            System.out.println("Error en la venta.");
        }
    }

    @Override
    public void borrar(String nombreArchivo) {
        
        try {
            this.datos.borrar(nombreArchivo);
        } catch (AccesoDatosEx ex) {
            ex.printStackTrace();
            System.out.println("Error al borrar los archivos");
        }
    }
    
    
}
