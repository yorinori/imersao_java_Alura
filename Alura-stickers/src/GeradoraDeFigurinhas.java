import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
    

    public void cria() throws Exception {
    
        // leitura da imagem
        BufferedImage imagemOriginal = ImageIO.read(new File("entrada/filme.jpg"));

        // cria nova imagem em memória com transparência e com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar a imagem original pra novo imagem (com memória)
        
        // escrever uma frase na nova imagem

        // escrever a nova imagem em um arquivo
    }

}
