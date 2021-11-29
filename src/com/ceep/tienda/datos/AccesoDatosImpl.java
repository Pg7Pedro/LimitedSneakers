package com.ceep.tienda.datos;

import com.ceep.tienda.dominio.Sneaker;
import com.ceep.tienda.excepciones.AccesoDatosEx;
import com.ceep.tienda.excepciones.EscrituraDatosEx;
import com.ceep.tienda.excepciones.LecturaDatosEx;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class AccesoDatosImpl implements IAccesoDatos{

    @Override
    public boolean existe(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    @Override
    public List<Sneaker> listar(String nombreArchivo) throws LecturaDatosEx {
        
        var archivo = new File(nombreArchivo);
        List<Sneaker> sneakers = new ArrayList<>();
        
        try {
            // entrada es el descriptor de lectura
            var entrada = new BufferedReader(new FileReader(archivo));
            // nos devuelve una línea de nuestro archivo
            var lectura = entrada.readLine();
            while(lectura != null){ // hasta null
                // Creamos un objeto de Película con cada línea del archivo
                // Añado cada película a mi listado de películas
                sneakers.add(new Sneaker(lectura));
                // Avanzamos en la lectura
                lectura = entrada.readLine();
            }
            entrada.close();
        
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
            throw new LecturaDatosEx("Error de lectura listando las zapatillas");
        } catch (IOException e){
            e.printStackTrace(System.out);
            throw new LecturaDatosEx("Error de lectura listando las zapatillas");
        }
        return sneakers;
    }

    @Override
    public void escribir(Sneaker sneaker, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {

        File archivo = new File(nombreArchivo);

        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(sneaker.getNombre());
            salida.close();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new EscrituraDatosEx("Excepción al escribir en el archivo");
        }
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx {
        
         var archivo = new File(nombreArchivo);
        int cont = 1;
        String mensaje = "";
        try {
            // entrada es el descriptor de lectura
            var entrada = new BufferedReader(new FileReader(archivo));
            // nos devuelve una línea de nuestro archivo
            var lectura = entrada.readLine();
            while(lectura != null){ // 
                if (lectura.equalsIgnoreCase(buscar)){
                    mensaje = "La zapatilla " + buscar + " se encuentra en la "
                            + "línea " + cont + " del catálogo de zapatillas";
                    break;
                }
                lectura = entrada.readLine();
                cont++;
            }
            if (lectura == null) 
                mensaje = "La zapatilla " + buscar + " no está disponible "
                    + "en el catálogo de zapatillas.";
            
            entrada.close();
        
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
            throw new LecturaDatosEx("Error de lectura listando las películas");
        } catch (IOException e){
            e.printStackTrace(System.out);
            throw new LecturaDatosEx("Error de lectura listando las películas");
        }
        return mensaje;
    }
    

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
        
         var archivo = new File(nombreArchivo);
        try {
            var salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            throw new AccesoDatosEx("Error al crear el archivo");
        }
    }

    @Override
    public void borrar(String nombreArchivo) throws AccesoDatosEx{

        File archivo = new File(nombreArchivo);
        if (archivo.exists()){
            archivo.delete();
        }
        System.out.println("Se ha borrado el archivo");
    
    }
    
    public void comprarProducto(String nombreArchivo,String buscar) throws LecturaDatosEx {
        var tienda = new File(nombreArchivo);
        var Stock = new File("Stock.txt");
        String [] arrayProductos = new String[4];

        try {
            var entrada = new BufferedReader(new FileReader(tienda)); 
            var salida = new PrintWriter (new FileWriter(Stock));
            String lectura = null;
            while ((lectura = entrada.readLine()) !=null) {
                arrayProductos = lectura.split(";");
                if (arrayProductos[0] !=buscar) {
                    salida.println(arrayProductos);
                }
                
            }
    }catch(FileNotFoundException e){
        e.printStackTrace(System.out);
            throw new LecturaDatosEx ("Hay un error al buscar el producto");
    }catch(IOException e){
            e.printStackTrace(System.out);
            throw new LecturaDatosEx ("Hay un error al buscar el producto");
    } catch(NullPointerException e){
            e.printStackTrace(System.out);
            throw new LecturaDatosEx("Hay un error al buscar el nombre");
        } 

    
    
}
    
}
