package util;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiConsumer {
    
    
    private URI uri;
    private HttpClient client;
    private HttpRequest request;

    /*url = "https://imdb-api.com/en/API/Top250Movies/k_le3hl6wp";
        uri = URI.create(url);
        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder(uri).build(); */

    public String request(String url){

        this.uri = URI.create(url);
        this.client = HttpClient.newHttpClient();
        this.request = HttpRequest.newBuilder(uri).build();
        
        String json = null;
        try {
             json = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return json;
    }

    
}
