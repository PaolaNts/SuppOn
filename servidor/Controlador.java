import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Controlador extends Thread{
    
    private Socket conexao;

    public Controlador(Socket conexao) throws Exception {
        if (conexao == null) throw new Exception("Socket vazio!");
        this.conexao = conexao;
    }

    public void handleRequest() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
             OutputStream outputStream = conexao.getOutputStream()) {

            // Configurar CORS para aceitar conexões de qualquer lugar
            String responseHeaders = "HTTP/1.1 200 OK\r\n" +
                    "Access-Control-Allow-Origin: *\r\n" +
                    "Access-Control-Allow-Methods: POST\r\n" +
                    "Content-Type: application/json\r\n" +
                    "\r\n";

            // Ler o JSON da solicitação
            StringBuilder requestBody = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isEmpty()) {
                    break;
                }
                requestBody.append(line);
            }

            // Tratar o JSON (retornar true para qualquer JSON enviado)
            String jsonResponse = "{ \"success\": true }";
            String response = responseHeaders + jsonResponse;
            outputStream.write(response.getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
        boolean teste = handleRequest();
    }
}
