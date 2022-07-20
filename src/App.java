import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.io.InputStream;
import java.io.PrintStream;  
import static java.nio.charset.StandardCharsets.UTF_8;  
import util.ApiConsumer;
import util.Config;
import util.GeradorDeFigurinhas;
import util.RapidAPI;
import util.JsonParser;



public class App {
    public static void main(String[] args) throws Exception {        
        
       //GeradorDeFigurinhas geradorDeFigurinhas = new GeradorDeFigurinhas();
       //geradorDeFigurinhas.criar("images/filme.jpg");
        searchImdb("Top250Movies",true);

    }
    

    public static void searchImdb(String endpoint, Boolean gerarFigurinha){
        
        ApiConsumer apiConsumer = new ApiConsumer();
        
        String token = "549a5d8b";
        String url = "https://api.mocki.io/v2/"+token;
        
       
        String json = apiConsumer.request(url);

        //extração dos itens/parser
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(json);

        GeradorDeFigurinhas geradorDeFigurinhas = new GeradorDeFigurinhas();

        //seleção/exibição dos intens
        
        for (Map<String, String> filme : listaDeFilmes) {
            System.out.println("\u001B[40mFilme: " + filme.get("title"));
            System.out.println("\u001B[42mFilme (PT-BR): " + translateText(filme.get("title")));
            System.out.println("\u001B[40mImage: " + filme.get("image"));
            System.out.println("Nota: "  + filme.get("imDbRating"));
            System.out.println("");

            try {
                if(gerarFigurinha){
                    //geradorDeFigurinhas.criar(filme.get("image"),filme.get("id"));
                    InputStream inputStream = new URL(filme.get("image")).openStream();
                    geradorDeFigurinhas.criar(inputStream,filme.get("id"));
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }     
       
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

