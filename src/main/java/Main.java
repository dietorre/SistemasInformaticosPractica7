import java.net.*;
import java.io.*;
import java.util.List;

public class Main {
    public static void main(String[] args){
        direccionesHost();
        System.out.println();
        direccionesPorNombre("www.unirioja.es");
        System.out.println();
        listaDireccionesPorNombre("www.elpais.es");
    }

    public static void direccionesHost(){
        InetAddress direccion;
        try{
            direccion = InetAddress.getLocalHost();
            System.out.println("dirección =" + InetAddress.getLocalHost());
            System.out.println("dirección =" + direccion);
            System.out.println("direccion.getHostName = " + direccion.getHostName());
            System.out.println("direccion.getHostAdress = " + direccion.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static void direccionesPorNombre(String s){
        InetAddress direccion;
        try{
            direccion = InetAddress.getByName(s);
            System.out.println("dirección =" + InetAddress.getLocalHost());
            System.out.println("dirección =" + direccion);
            System.out.println("direccion.getHostName = " + direccion.getHostName());
            System.out.println("direccion.getHostAdress = " + direccion.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }


    public static void listaDireccionesPorNombre(String s){
        InetAddress[] direcciones;
        try{
            direcciones = InetAddress.getAllByName(s);
            for(int i = 0; i<direcciones.length; i++){
                System.out.println("dirección =" + direcciones[i]);
                System.out.println("direccion.getHostName = " + direcciones[i].getHostName());
                System.out.println("direccion.getHostAdress = " + direcciones[i].getHostAddress());
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }



}


