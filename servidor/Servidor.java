import java.net.*;
import java.io.*;

public class Servidor extends Thread {
    private Socket conexao;

    public Servidor(Socket conexao) {
        this.conexao = conexao;
    }

    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
             PrintWriter out = new PrintWriter(conexao.getOutputStream(), true)) {

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                if (inputLine.isEmpty()) {
                    break; // Fim do cabeçalho da solicitação
                }
                System.out.println(inputLine);
            }

         
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            new Servidor(serverSocket.accept()).start();
        }
    }
}
