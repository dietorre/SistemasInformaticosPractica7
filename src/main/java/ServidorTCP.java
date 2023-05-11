import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ServidorTCP {
    public static void main(String[] args){
        //crearServidor(55555,"Bienvenido al servidor de prueba de redes");
        servidorTablaMultiplicar(55555);
    }

    public static void crearServidor(int puerto, String mensaje){
        try {
            ServerSocket ss = new ServerSocket(puerto);
            Socket s = ss.accept();
            PrintWriter salida = new PrintWriter(s.getOutputStream());
            salida.println(mensaje);
            salida.flush();
            s.close();
            ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void servidorTablaMultiplicar(int puerto){
        try {
            ServerSocket ss = new ServerSocket(puerto);
            Socket s = ss.accept();
            PrintWriter salida = new PrintWriter(s.getOutputStream());
            Scanner entrada = new Scanner(s.getInputStream());
            int aux = entrada.nextInt();
            for(int i=0;i<10;i++){
                salida.println(aux + " x " + i + " = =" + aux*i);
            }
            salida.flush();
            s.close();
            ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
