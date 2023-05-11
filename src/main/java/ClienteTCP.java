import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ClienteTCP {
    public static void main(String[] args){
        //pruebaCliente("zoltar.redes.upv.es",21);
        //pruebaCliente("test.rebex.net",21);
        getPaginaWeb("www.upv.es",80);
    }

    public static void pruebaCliente(String nombre, int puerto){
        try {
            Socket s = new Socket(nombre,puerto);
            Scanner entrada = new Scanner(s.getInputStream());
            System.out.println(entrada.nextLine());
            s.close();
        } catch (IOException e) {
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
            for(int i=0; i < 20; i++){
                System.out.println(entrada.nextLine());
            }
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
