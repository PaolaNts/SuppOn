import java.io.*;
import java.net.*;

public class Cliente{
    public static void main(String[] args){
        Socket conexao = new Socket("localhost", 8080);

        Controlador controlador = new Controlador(conexao);
        controlador.start();
    }
}