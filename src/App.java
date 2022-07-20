import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.io.PrintStream;  
import static java.nio.charset.StandardCharsets.UTF_8;  
import util.ApiConsumer;
import util.RapidAPI;
import util.JsonParser;



public class App {
    public static void main(String[] args) throws Exception {        
        searchImdb("Top250Movies");
    }

    public static void searchImdb(String endpoint){
        
        ApiConsumer apiConsumer = new ApiConsumer();
        
        //IMDB
        String token ="k_le3hl6wp";
        String url = "https://imdb-api.com/en/API/"+endpoint+"/"+token;

        //Aquiles
        url ="https://api.mocki.io/v2/549a5d8b";
       
        String json = apiConsumer.request(url);

        //extração dos itens/parser
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(json);


        //seleção/exibição dos intens
        
        for (Map<String, String> filme : listaDeFilmes) {
            System.out.println("Filme: " + filme.get("title"));
            System.out.println("Filme (PT-BR): " + translateText(filme.get("title")));
            System.out.println("Image: " + filme.get("image"));
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

    public static void c(){
         //translateText("Lord of the rings");



        /*List<FilmeTO> listagemFilmes = new ArrayList();
        
        Filmes filmes = new Filmes() {
            
        };

        FilmeTO f1 = new FilmeTO("Filme 1","Ação","10");
        FilmeTO f2 = new FilmeTO("Filme 2","Comédia","9");
        FilmeTO f3 = new FilmeTO("Filme 3","Ação","8");

        //listagemFilmes = filmes.listar();
        listagemFilmes.add(f1);
        listagemFilmes.add(f2);
        listagemFilmes.add(f3);


        System.out.println(listagemFilmes.size());*/
    }
    
}

