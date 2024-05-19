import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class MonedasApi {
    public Moneda buscaMoneda(String moneda1, String moneda2) {

        URI linkApi = URI.create("https://v6.exchangerate-api.com/v6/6aa07823b2a48ee67602727c/pair/" +
                moneda1 + "/" + moneda2);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(linkApi)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("Error!!!");
        }
    }
}
