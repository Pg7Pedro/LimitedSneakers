
package com.ceep.tienda.principal;

import com.ceep.tienda.negocio.IStockTienda;
import com.ceep.tienda.negocio.StockTiendaImpl;
import java.util.Scanner;


public class LimitedSneakers {
    
    
    public static void main(String[] args) {
        
        var opcion = -1;
        var nombreSneaker = "";
        var lectura = new Scanner(System.in);
        var nombreCatalogo = "LimitedSneakers.txt";
        IStockTienda catalogo = new StockTiendaImpl();
        
        while (opcion != 0) {
            System.out.println("Elije una de las opciones: \n"
                    + "1.- Iniciar LimitedSneakers. \n"
                    + "2.- Agregar zapatilla. \n"
                    + "3.- Listar zapatillas. \n"
                    + "4.- Buscar zapatillas. \n"
                    + "5.- Vender zapatillas. \n"
                    + "0.- Salir \n");
            
            opcion = Integer.parseInt(lectura.nextLine());
            
            
            switch (opcion){
                case 1:
                    catalogo.iniciarCatalogo(nombreCatalogo);
                    System.out.println("LimitedSneakers iniciado...");
                    break;
                    
                case 2:
                    System.out.println("Introduce el nombre de las zapatillas que deseas agregar: ");
                    nombreSneaker = lectura.nextLine();
                    catalogo.agregarSneaker(nombreSneaker, nombreCatalogo);
                    System.out.println("Se han agregado las " + nombreSneaker + " al catálogo "
                    + nombreCatalogo);
                    break;
                    
                case 3:
                    catalogo.listarSneaker(nombreCatalogo);
                    break;
                
                case 4:
                    System.out.println("Introduce el nombre de las zapatillas que deseas buscar: ");
                    nombreSneaker = lectura.nextLine();
                    catalogo.buscarSneaker(nombreCatalogo, nombreSneaker);
                    break;
                    
                case 5:
                    System.out.println("Introduzca las zapatillas que va a comprar: ");
                    nombreSneaker = lectura.nextLine();
                    catalogo.comprarProducto(nombreCatalogo, nombreSneaker);
                    System.out.println(nombreSneaker);
                    break; 
                            
                    
                case 6:
                    System.out.println("");
                    catalogo.borrar(nombreCatalogo);
                    System.out.println("Se ha borrado el archivo correctamente.");
                    break;
                case 0:
                    System.out.println("Gracias por visitar LimitedSneakers.com");
                    break;
                    
                default:
                    System.out.println("Opción no valida.");
            }
        }
    }
 
}
