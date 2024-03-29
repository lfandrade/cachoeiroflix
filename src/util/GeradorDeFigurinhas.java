package util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;


public class GeradorDeFigurinhas {

    public void criar(InputStream inputStream, String novoArquivo, String tituloTrazuzido) throws Exception{


        //leitura da image
        //BufferedImage imagemOriginal = ImageIO.read(new File(imageUrl));
        //InputStream inputStream = new URL(arquivo).openStream();
        
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        //criar nova imagem (em memória) com transparência e novo tamanho
        int novoSegmento=200;
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + novoSegmento;

        //nova imagem transparente
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        //copiar imagem original para nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        //configurar fonte
        Font font = new Font(Font.SANS_SERIF,Font.BOLD,50);
        graphics.setFont(font);
        graphics.setColor(Color.BLUE);
        
        //escrever um texto na nova imagem
        graphics.drawString(tituloTrazuzido, 30, altura+(novoSegmento/2));

        //escrever a nova imagem/arquivo
        ImageIO.write(novaImagem, "png", new File("images/"+novoArquivo+".png"));

    }


}