import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import util.ApiConsumer;



public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Olá Cachoeiro");

       
        ApiConsumer apiConsumer = new ApiConsumer();
        String url = "https://imdb-api.com/en/API/Top250Movies/k_le3hl6wp";
        
        String json = apiConsumer.request(url);

        System.out.println(json);

        List<FilmeTO> listagemFilmes = new ArrayList();
        
        Filmes filmes = new Filmes() {
            
        };

        FilmeTO f1 = new FilmeTO("Filme 1","Ação","10");
        FilmeTO f2 = new FilmeTO("Filme 2","Comédia","9");
        FilmeTO f3 = new FilmeTO("Filme 3","Ação","8");

        //listagemFilmes = filmes.listar();
        listagemFilmes.add(f1);
        listagemFilmes.add(f2);
        listagemFilmes.add(f3);


        System.out.println(listagemFilmes.size());
    }

    
}

