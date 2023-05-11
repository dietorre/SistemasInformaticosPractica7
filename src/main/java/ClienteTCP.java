import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ClienteTCP {
    public static void main(String[] args){
        //pruebaCliente("zoltar.redes.upv.es",21);
        //pruebaCliente("test.rebex.net",21);
        //getPaginaWeb("www.upv.es",80);
        //pruebaCliente("djxmmx.net",17);
        mandarMensaje("10.11.69.1",55555,"Diego de la Torre Gutiérrez");
    }

    public static void pruebaCliente(String nombre, int puerto){
        try {
            Socket s = new Socket(nombre,puerto);
            Scanner entrada = new Scanner(s.getInputStream());
            System.out.println(entrada.nextLine());
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getPaginaWeb(String nombre, int puerto){
        try {
            Socket s = new Socket(nombre,puerto);
            Scanner entrada = new Scanner(s.getInputStream());
            PrintWriter salida = new PrintWriter(s.getOutputStream());
            salida.print("GET /es/ HTTP/1.0" + "\r\n");
            salida.print("\r\n");
            salida.flush();
            while(entrada.hasNext()){
                System.out.println(entrada.nextLine());
            }
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void mandarMensaje(String nombre, int puerto, String mensaje){
        try {
            Socket s = new Socket(nombre,puerto);
            Scanner entrada = new Scanner(s.getInputStream());
            PrintWriter salida = new PrintWriter(s.getOutputStream());
            salida.print(mensaje + "\r\n");
            salida.flush();
            System.out.println(entrada.nextLine());
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
