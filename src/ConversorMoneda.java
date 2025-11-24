package conversor;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorMoneda {

    private final String apiKey = "eb4d71a77f53179f637ff9c6";  //la real
    private final HttpClient client;
    private final Gson gson;

    public ConversorMoneda() {
        this.client = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public double convertir(String origen, String destino, double monto)
            throws IOException, InterruptedException {

        String url = "https://v6.exchangerate-api.com/v6/" + apiKey +
                "/pair/" + origen + "/" + destino + "/" + monto;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());


        RespuestaAPI datos = gson.fromJson(response.body(), RespuestaAPI.class);

        return datos.conversion_result;
    }

    private static class RespuestaAPI {
        String result;
        double conversion_rate;
        double conversion_result;
    }
}
