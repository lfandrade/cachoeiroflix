import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.io.PrintStream;  
import static java.nio.charset.StandardCharsets.UTF_8;  
import util.ApiConsumer;
import util.Config;
import util.RapidAPI;
import util.JsonParser;



public class App {
    public static void main(String[] args) throws Exception {        
        
       
        searchImdb("Top250Movies");

    }
    

    public static void searchImdb(String endpoint){
        
        ApiConsumer apiConsumer = new ApiConsumer();
        
        String token = "549a5d8b";
        String url = "https://api.mocki.io/v2/"+token;
        
       
        String json = apiConsumer.request(url);

        //extração dos itens/parser
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(json);


        //seleção/exibição dos intens
        
        for (Map<String, String> filme : listaDeFilmes) {
            System.out.println("\u001B[40mFilme: " + filme.get("title"));
            System.out.println("\u001B[42mFilme (PT-BR): " + translateText(filme.get("title")));
            System.out.println("\u001B[40mImage: " + filme.get("image"));
            System.out.println("Nota: "  + filme.get("imDbRating"));
            System.out.println("");
        }

    }

    public static String translateText(String text){
        RapidAPI rapidAPI = new RapidAPI();
        String bodyTranslate = rapidAPI.translateText(text);
        JsonParser parser = new JsonParser();
        List<Map<String, String>> items = parser.parse(bodyTranslate);

        String translatedText = items.get(0).get("translation");
        return translatedText;
    }

    
}

