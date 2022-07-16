import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;



public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Olá Cachoeiro");

        var url = "https://imdb-api.com/en/API/Top250Movies/k_le3hl6wp";
        URI uri = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(uri).build();
        String json = client.send(request, HttpResponse.BodyHandlers.ofString()).body();


        System.out.println(json);

    }
}

