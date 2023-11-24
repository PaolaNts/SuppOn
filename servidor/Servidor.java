import java.net.*;
import java.io.*;

public classe Servidor
{

    public static void main (String[] args)
    {
        ServerSocket host = new ServerSocket(8080);
        while(true){
            Socket conexao = host.accept();
            System.out.println("Conexao estabelecida!");
        }
    }
}