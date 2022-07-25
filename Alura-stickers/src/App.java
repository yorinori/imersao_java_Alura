import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        // fazer uma conexão HTTP e buscar os top 250 filmes
        // String url = "https://api.mocki.io/v2/549a5d8b";
        String url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // pegar só os dados que interessam (titulo, poster, classificação) [Parsear o json]
        var parser = new JsonParser();
        List<Map<String, String>> listaDeConteudos = parser.parse(body);

        // exibir e manipular os dados

        var geradora = new GeradoraDeFigurinhas();

        for (int i = 0; i < 10; i++) {
            Map<String, String> conteudo = listaDeConteudos.get(i);

            // String urlImagem = conteudo.get("image")
            String urlImagem = conteudo.get("url")
                .replaceAll("(@+)(.*).jpg$", "$1.jpg");

            String titulo = conteudo.get("title");

            InputStream inputStream = new URL(urlImagem).openStream();
            String nomeArquivo = "saida/" + titulo + ".png";
        
            geradora.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.get("title"));
            System.out.println(conteudo.get("image"));
            System.out.println(conteudo.get("imDbRating"));
            System.out.println();
        
        }
    }
}

