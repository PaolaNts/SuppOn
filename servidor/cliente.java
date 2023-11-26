import java.io.*;
import java.net.*;

public class cliente {
    public static void main(String[] args) throws Exception {
        try (Socket conexao = new Socket("localhost", 8080)) {
            Controlador controlador = new Controlador(conexao);
            controlador.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
