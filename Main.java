import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedImage img1 = ImageIO.read(new File("src/pedra.jpg"));
        BufferedImage img2 = ImageIO.read(new File("src/parque.jpg"));
        //BufferedImage img1 = ImageIO.read(new File("src/bola.png"));
        //BufferedImage img2 = ImageIO.read(new File("src/campo.png"));

        BufferedImage resultImageAnd = new BufferedImage(img1.getWidth(), img1.getHeight(), BufferedImage.TYPE_INT_ARGB);
        BufferedImage resultImageOr = new BufferedImage(img1.getWidth(), img1.getHeight(), BufferedImage.TYPE_INT_ARGB);
        BufferedImage resultImageXor = new BufferedImage(img1.getWidth(), img1.getHeight(), BufferedImage.TYPE_INT_ARGB);

        for (int y = 0; y < img1.getHeight(); y++) {
            for (int x = 0; x < img1.getWidth(); x++) {

                int pixel1 = img1.getRGB(x, y);
                int pixel2 = img2.getRGB(x, y);

                int resultPixelAnd = pixel1 & pixel2; // and
                int resultPixelOr = pixel1 | pixel2; // or
                int resultPixelXor = pixel1 ^ pixel2; // xor

                resultImageAnd.setRGB(x, y, resultPixelAnd);
                resultImageOr.setRGB(x, y, resultPixelOr);
                resultImageXor.setRGB(x, y, resultPixelXor);
            }
        }

        ImageIO.write(resultImageAnd, "png", new File("src/op-and.png"));
        ImageIO.write(resultImageOr, "png", new File("src/op-or.png"));
        ImageIO.write(resultImageXor, "png", new File("src/op-xor.png"));

        System.out.println("Operação AND concluída com sucesso!");
    }
}
