import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ServidorTCP {
    public static void main(String[] args){
        crearServidor(55555,"Bienvenido al servidor de prueba de redes");
    }

    public static void crearServidor(int puerto, String mensaje){
        try {
            ServerSocket ss = new ServerSocket(puerto);
            Socket s = ss.accept();
            PrintWriter salida = new PrintWriter(s.getOutputStream());
            salida.println(mensaje);
            s.close();
            ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
