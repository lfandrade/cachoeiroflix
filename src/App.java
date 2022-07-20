import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.ApiConsumer;
import util.JsonParser;



public class App {
    public static void main(String[] args) throws Exception {
        
        System.out.println("Olá Cachoeiro");

       
        ApiConsumer apiConsumer = new ApiConsumer();
        String url = "https://imdb-api.com/en/API/Top250Movies/k_le3hl6wp";
        url ="https://api.mocki.io/v2/549a5d8b";
        
        String json = apiConsumer.request(url);

        //System.out.println(json);

        //extração dos itens/parser
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(json);


        //seleção/exibição dos intens
        
        for (Map<String, String> filme : listaDeFilmes) {
            System.out.println("Filme: " + filme.get("title"));
            System.out.println("Image: " + filme.get("image"));
            System.out.println("Nota: "  + filme.get("imDbRating"));
            System.out.println("");
        }


        //System.out.println(listaDeFilmes);
        //System.out.println(listaDeFilmes.size());
        //System.out.println(listaDeFilmes.get(1));
        //System.out.println(listaDeFilmes.get(1).get("title"));

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

