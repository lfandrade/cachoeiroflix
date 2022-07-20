package util;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RapidAPI {
    
    
    private URI uri;
    private HttpClient client;
    private HttpRequest request;


    public String request(String url){

        this.uri = URI.create(url);
        this.client = HttpClient.newHttpClient();
        this.request = HttpRequest.newBuilder(uri)
        .header("X-RapidAPI-Key", "6094868363mshc00e29070dd17e2p108269jsn537e7c1b461e")
        .header("X-RapidAPI-Host", "translated-mymemory---translation-memory.p.rapidapi.com")
		.method("GET", HttpRequest.BodyPublishers.noBody()).build();
        
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
        
        String lang = "pt";
        String urlTranslate = "https://translated-mymemory---translation-memory.p.rapidapi.com/api/get?langpair=en%7C"+lang+"%7Cit&q="+text+"&mt=1&onlyprivate=0&de=a%40b.c";
        
        this.request(urlTranslate);
        
        return this.request(urlTranslate);
    }

    public String translateCreate(String text){
        
        String urlCreateKey = "https://translated-mymemory---translation-memory.p.rapidapi.com/createkey";
    
        return this.request(urlCreateKey);
    }

    
}
