
package archivos;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Archivos {
    
    public static void leerArchivo(String name){
        File archivo = null; // apunta a un archivo fisico del dd
        FileReader fr = null;// para leer el archivo
        BufferedReader bufer = null;
        try{ // Es la aparte buena 
            //Creamos un apuntador al archivo físico
            archivo= new File("C:\\Users\\leone\\Documents\\Archivos para leer\\" + name + ".txt");
            //Abrimos el archivo para lectura
            fr=new FileReader(archivo);
            //configurar bufer para hacer lectura
            bufer = new BufferedReader(fr);
            
            //lectura del contenido
            String linea;
            //mientras haya información en el archivo
            while((linea = bufer.readLine()) !=null ) //La entrada va a ser el archivo y no por teclado
                System.out.println("Linea del archivo: " + linea);
            
        }catch(Exception e){ // se ejecuta cuando hay un error
            System.out.println("Error: No se encuentra el archivo");
            e.printStackTrace();
        }finally{
            //Esta cláusula se ejecuta siempre 
            //Se cierra el archivo
            try{
                //si se logró abrir el archivo, debemos cerrarlo.
                if(null !=fr){
                    fr.close();
                }
            
            }catch(Exception e2){
                System.out.println("Error al cerrar el archivo");
                e2.printStackTrace();
            }
            
        }
        
        
    }
    
    public static void escribirArchivo(String name){
        FileWriter archivo = null;
        PrintWriter pw = null;
        BufferedReader bufer2 = new BufferedReader(new InputStreamReader(System.in));
        String entrada;
        char respuesta;
        
        try{
            archivo = new FileWriter("C:\\Users\\leone\\Documents\\Archivos para leer\\" + name + ".txt");
            pw = new PrintWriter(archivo);
           do{
               System.out.println("Escribe información a guardar en el archivo: ");
               entrada = bufer2.readLine();
               //Agrega lo leído en teclado al archivo en disco
               pw.println(entrada);
               
               System.out.println("Escribe s para continuar, n para parar ");
               entrada = bufer2.readLine();
               respuesta = entrada.charAt(0);
               
           } while( respuesta != 'n');
        }catch (Exception e){
            System.out.println("Error al escribir en archivo: " + name);
            e.printStackTrace();
            
        }finally{
            try{
                // Cerrar el archivo si es que se pudo abrir para escritura
                if(null != archivo){
                    archivo.close();
                    
                }
                
            }catch(Exception e2){
                System.out.println("Error al cerrar archivo " + name);
                e2.printStackTrace();
            }
        }
    }

    public static void eliminarArchivo(String name){
      
        
        File archivo = new File ("C:\\Users\\leone\\Documents\\Archivos para leer\\" + name + ".txt");
        if(archivo.delete()){
            System.out.println("Archivo eliminado " + archivo.getName());
        }else{
            System.out.println("Error al eliminar archivo ");
        }
    }

    

    public static void editarArchivo(String name) throws IOException {
         
        FileWriter archivo = null;
        PrintWriter pw = null;
        BufferedReader bufer3 = new BufferedReader(new InputStreamReader(System.in));
        String entrada;
        char respuesta;
        
        File file = new File("C:\\Users\\leone\\Documents\\Archivos para leer\\" + name + ".txt");
        
        try{
            archivo = new FileWriter("C:\\Users\\leone\\Documents\\Archivos para leer\\" + name + ".txt");
            pw = new PrintWriter(archivo);
           do{
               System.out.println("Escribe información a editar en el archivo: ");
               entrada = bufer3.readLine();
               //Agrega lo leído en teclado al archivo en disco
               pw.println(entrada);
               
               System.out.println("Escribe s para continuar, n para parar ");
               entrada = bufer3.readLine();
               respuesta = entrada.charAt(0);
               
           } while( respuesta != 'n');
        }catch (Exception e){
            System.out.println("Error al escribir en archivo: " + name);
            e.printStackTrace();
            
        }finally{
            try{
                // Cerrar el archivo si es que se pudo abrir para escritura
                if(null != archivo){
                    archivo.close();
                    
                }
                
            }catch(Exception e2){
                System.out.println("Error al cerrar archivo " + name);
                e2.printStackTrace();
            }
        }
    }














    public static void main(String[] args) throws IOException {
        BufferedReader buferTeclado = new BufferedReader(new InputStreamReader(System.in));
        String entrada;
        String fileName;
        int opcion;
        
        System.out.println("Programa que lee un archivo de texto de videojuegos");
        System.out.println("----------------------------------------");
        System.out.println("1 - Leer un archivo de texto existente");
        System.out.println("2 - Crear un archivo de texto");
        System.out.println("3 - Eliminar un archivo de texto");
        System.out.println("4 - Editar un archivo de texto");
        System.out.println(" ¿Que quieres hacer? ");
        entrada = buferTeclado.readLine();
        opcion = Integer.parseInt(entrada);
        System.out.println("Escribe el nombre del archivo: ");
        entrada = buferTeclado.readLine();
        fileName = entrada;
        
        
        switch( opcion ){
            case 1: {
                System.out.println("Lectura de un archivo existente");         
                  System.out.println("Contenido del archivo: ");
                  leerArchivo(entrada);
            }
            break;
            case 2: {
                System.out.println("Creacion de un archivo de texto");
                escribirArchivo(fileName);
                
            }
            break;
            case 3:{
                System.out.println("elimina un archivo:");
                eliminarArchivo(fileName);
            }
            break;
            case 4:{
                System.out.println("edita un archivo de texto: ");
                editarArchivo(fileName);
               
            }
            break;
            default: System.out.println("Opcion no valida");
        }
        
       
    }
    
}
