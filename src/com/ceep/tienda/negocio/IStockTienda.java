
package com.ceep.tienda.negocio;


public interface IStockTienda {
    
    void agregarSneaker(String nombreSneaker, String nombreCatalogo);
    
    void listarSneaker(String nombreCatalogo);
    
    void buscarSneaker(String nombreCatalago, String buscar);
    
    void iniciarCatalogo(String nombreCatalogo);
    
    void comprarProducto(String nombreArchivo, String Buscar);
    
    void borrar(String nombreArchivo);
}
