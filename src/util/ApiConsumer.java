package util;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class ApiConsumer {
    
    
    private URI uri;
    private HttpClient client;
    private HttpRequest request;

    Config c = new Config();
    Properties p = c.loadProperties("C:\\dados\\java\\Cachoeiro\\src\\configuration.properties");
    

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

    public String translateText(String text){
        
        String lang = "pt-br";
        String urlTranslate = "https://translated-mymemory---translation-memory.p.rapidapi.com/api/get?langpair="+lang+"%7Cit&q="+text+"&mt=1&onlyprivate=0&de=a%40b.c";
    
        String apiRapidKey = p.getProperty("rapidapi.api.key");
    
        this.uri = URI.create(urlTranslate);
        this.client = HttpClient.newHttpClient();
        this.request = HttpRequest.newBuilder(uri)
        .header("X-RapidAPI-Key", apiRapidKey)
        .header("X-RapidAPI-Host", "translated-mymemory---translation-memory.p.rapidapi.com")
		.method("GET", HttpRequest.BodyPublishers.noBody()).build();

        String response=null;
        
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return response;
    }

    public String translateCreate(String text){
        String apiRapidKey = p.getProperty("rapidapi.api.key");
        String urlCreateKey = "https://translated-mymemory---translation-memory.p.rapidapi.com/createkey";
        
        this.uri = URI.create(urlCreateKey);
        this.client = HttpClient.newHttpClient();
        this.request = HttpRequest.newBuilder(uri)
        .header("X-RapidAPI-Key", apiRapidKey)
        .header("X-RapidAPI-Host", "translated-mymemory---translation-memory.p.rapidapi.com")
		.method("GET", HttpRequest.BodyPublishers.noBody()).build();

        String response=null;
        
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return response;
    }

    
}
