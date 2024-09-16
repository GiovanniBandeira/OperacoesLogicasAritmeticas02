import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        String img1 = "src/ImgPadrao/img1.png";
        String img2 = "src/ImgPadrao/img2.png";
        String img3 = "src/ImgPadrao/img3.png";
        String img4 = "src/ImgPadrao/img4.png";
        String img5 = "src/ImgPadrao/img5.png";
        String img6 = "src/ImgPadrao/img6.png";
        String img7 = "src/ImgPadrao/img7.png";
        String img8 = "src/ImgPadrao/img8.png";
        String img9 = "src/ImgPadrao/img9.png";
        String img10 = "src/ImgPadrao/img10.png";

        BufferedImage imagem1 = ImageIO.read(new File(img1));
        BufferedImage imagem2 = ImageIO.read(new File(img2));
        BufferedImage imagem3 = ImageIO.read(new File(img3));
        BufferedImage imagem4 = ImageIO.read(new File(img4));
        BufferedImage imagem5 = ImageIO.read(new File(img5));
        BufferedImage imagem6 = ImageIO.read(new File(img6));
        BufferedImage imagem7 = ImageIO.read(new File(img7));
        BufferedImage imagem8 = ImageIO.read(new File(img8));
        BufferedImage imagem9 = ImageIO.read(new File(img9));
        BufferedImage imagem10 = ImageIO.read(new File(img10));

        int h = imagem2.getHeight();
        int w = imagem2.getWidth();

        BufferedImage imagemNova1 = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        BufferedImage imagemNova2 = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        BufferedImage resultImageAnd = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        BufferedImage resultImageOr = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        BufferedImage resultImageXor = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

        int fmax1 = 0; int fmin1 = 255; int fmax2 = 0; int fmin2 = 255;

// =============================================================================================

        for (int lin = 0; lin < w; lin++) {
            for (int col = 0; col < h; col++) {

                int rgb1 = imagem1.getRGB(lin, col);
                Color color1 = new Color(rgb1);

                int red1 = color1.getRed();

                if (red1 > fmax1){fmax1 = red1;}
                if ( red1 < fmin1){fmin1 = red1;}

                // ====================================

                int rgb2 = imagem2.getRGB(lin, col);
                Color color2 = new Color(rgb2);

                int red2 = color2.getRed();

                if (red2 > fmax2){fmax2 = red2;}
                if ( red2 < fmin2){fmin2 = red2;}
            }
        }

        for (int lin = 0; lin < w; lin++) {
            for (int col = 0; col < h; col++) {

                int rgb1 = imagem1.getRGB(lin, col);
                Color color1 = new Color(rgb1);

                int red1 = color1.getRed();
                int g1 = (255 / (fmax1 - fmin1)) * (red1 - fmin1);

                imagem1.setRGB(lin, col, new Color(g1, g1, g1).getRGB());
                // ====================================

                int rgb2 = imagem2.getRGB(lin, col);
                Color color2 = new Color(rgb2);

                int red2 = color2.getRed();

                int g2 = (255 / (fmax2 - fmin2)) * (red2 - fmin2);

                imagem2.setRGB(lin, col, new Color(g2, g2, g2).getRGB());

                imagemNova1.setRGB(lin, col, new Color(imagem1.getRGB(lin, col) + imagem2.getRGB(lin, col)).getRGB());
                imagemNova2.setRGB(lin, col, new Color(imagem1.getRGB(lin, col) - imagem2.getRGB(lin, col)).getRGB());
            }
        }

        ImageIO.write(imagemNova1, "png", new File("src/ImgNova/Adicao/imagem1.png"));
        ImageIO.write(imagemNova2, "png", new File("src/ImgNova/Subtracao/imagem1.png"));

        for (int lin = 0; lin < w; lin++) {
            for (int col = 0; col < h; col++) {

                int pixel1 = imagem1.getRGB(lin, col);
                int pixel2 = imagem2.getRGB(lin, col);

                int resultPixelAnd = pixel1 & pixel2; // and
                int resultPixelOr = pixel1 | pixel2; // or
                int resultPixelXor = pixel1 ^ pixel2; // xor

                resultImageAnd.setRGB(lin, col, resultPixelAnd);
                resultImageOr.setRGB(lin, col, resultPixelOr);
                resultImageXor.setRGB(lin, col, resultPixelXor);
            }
        }

        ImageIO.write(resultImageAnd, "png", new File("src/ImgNova/End/op-and1.png"));
        ImageIO.write(resultImageOr, "png", new File("src/ImgNova/Or/op-or1.png"));
        ImageIO.write(resultImageXor, "png", new File("src/ImgNova/Xor/op-xor1.png"));




        for (int lin = 0; lin < w; lin++) {
            for (int col = 0; col < h; col++) {

                int rgb1 = imagem3.getRGB(lin, col);
                Color color1 = new Color(rgb1);

                int red1 = color1.getRed();

                if (red1 > fmax1){fmax1 = red1;}
                if ( red1 < fmin1){fmin1 = red1;}

                // ====================================

                int rgb2 = imagem4.getRGB(lin, col);
                Color color2 = new Color(rgb2);

                int red2 = color2.getRed();

                if (red2 > fmax2){fmax2 = red2;}
                if ( red2 < fmin2){fmin2 = red2;}
            }
        }

        for (int lin = 0; lin < w; lin++) {
            for (int col = 0; col < h; col++) {

                int rgb1 = imagem3.getRGB(lin, col);
                Color color1 = new Color(rgb1);

                int red1 = color1.getRed();
                int g1 = (255 / (fmax1 - fmin1)) * (red1 - fmin1);

                imagem3.setRGB(lin, col, new Color(g1, g1, g1).getRGB());
                // ====================================

                int rgb2 = imagem4.getRGB(lin, col);
                Color color2 = new Color(rgb2);

                int red2 = color2.getRed();

                int g2 = (255 / (fmax2 - fmin2)) * (red2 - fmin2);

                imagem4.setRGB(lin, col, new Color(g2, g2, g2).getRGB());

                imagemNova1.setRGB(lin, col, new Color(imagem3.getRGB(lin, col) + imagem4.getRGB(lin, col)).getRGB());
                imagemNova2.setRGB(lin, col, new Color(imagem3.getRGB(lin, col) - imagem4.getRGB(lin, col)).getRGB());
            }
        }

        ImageIO.write(imagemNova1, "png", new File("src/ImgNova/Adicao/imagem2.png"));
        ImageIO.write(imagemNova2, "png", new File("src/ImgNova/Subtracao/imagem2.png"));

        for (int lin = 0; lin < w; lin++) {
            for (int col = 0; col < h; col++) {

                int pixel1 = imagem3.getRGB(lin, col);
                int pixel2 = imagem4.getRGB(lin, col);

                int resultPixelAnd = pixel1 & pixel2; // and
                int resultPixelOr = pixel1 | pixel2; // or
                int resultPixelXor = pixel1 ^ pixel2; // xor

                resultImageAnd.setRGB(lin, col, resultPixelAnd);
                resultImageOr.setRGB(lin, col, resultPixelOr);
                resultImageXor.setRGB(lin, col, resultPixelXor);
            }
        }

        ImageIO.write(resultImageAnd, "png", new File("src/ImgNova/End/op-and2.png"));
        ImageIO.write(resultImageOr, "png", new File("src/ImgNova/Or/op-or2.png"));
        ImageIO.write(resultImageXor, "png", new File("src/ImgNova/Xor/op-xor2.png"));




        for (int lin = 0; lin < w; lin++) {
            for (int col = 0; col < h; col++) {

                int rgb1 = imagem5.getRGB(lin, col);
                Color color1 = new Color(rgb1);

                int red1 = color1.getRed();

                if (red1 > fmax1){fmax1 = red1;}
                if ( red1 < fmin1){fmin1 = red1;}

                // ====================================

                int rgb2 = imagem6.getRGB(lin, col);
                Color color2 = new Color(rgb2);

                int red2 = color2.getRed();

                if (red2 > fmax2){fmax2 = red2;}
                if ( red2 < fmin2){fmin2 = red2;}
            }
        }

        for (int lin = 0; lin < w; lin++) {
            for (int col = 0; col < h; col++) {

                int rgb1 = imagem5.getRGB(lin, col);
                Color color1 = new Color(rgb1);

                int red1 = color1.getRed();
                int g1 = (255 / (fmax1 - fmin1)) * (red1 - fmin1);

                imagem5.setRGB(lin, col, new Color(g1, g1, g1).getRGB());
                // ====================================

                int rgb2 = imagem6.getRGB(lin, col);
                Color color2 = new Color(rgb2);

                int red2 = color2.getRed();

                int g2 = (255 / (fmax2 - fmin2)) * (red2 - fmin2);

                imagem6.setRGB(lin, col, new Color(g2, g2, g2).getRGB());

                imagemNova1.setRGB(lin, col, new Color(imagem5.getRGB(lin, col) + imagem6.getRGB(lin, col)).getRGB());
                imagemNova2.setRGB(lin, col, new Color(imagem5.getRGB(lin, col) - imagem6.getRGB(lin, col)).getRGB());
            }
        }

        ImageIO.write(imagemNova1, "png", new File("src/ImgNova/Adicao/imagem3.png"));
        ImageIO.write(imagemNova2, "png", new File("src/ImgNova/Subtracao/imagem3.png"));

        for (int lin = 0; lin < w; lin++) {
            for (int col = 0; col < h; col++) {

                int pixel1 = imagem5.getRGB(lin, col);
                int pixel2 = imagem6.getRGB(lin, col);

                int resultPixelAnd = pixel1 & pixel2; // and
                int resultPixelOr = pixel1 | pixel2; // or
                int resultPixelXor = pixel1 ^ pixel2; // xor

                resultImageAnd.setRGB(lin, col, resultPixelAnd);
                resultImageOr.setRGB(lin, col, resultPixelOr);
                resultImageXor.setRGB(lin, col, resultPixelXor);
            }
        }

        ImageIO.write(resultImageAnd, "png", new File("src/ImgNova/End/op-and3.png"));
        ImageIO.write(resultImageOr, "png", new File("src/ImgNova/Or/op-or3.png"));
        ImageIO.write(resultImageXor, "png", new File("src/ImgNova/Xor/op-xor3.png"));




        for (int lin = 0; lin < w; lin++) {
            for (int col = 0; col < h; col++) {

                int rgb1 = imagem7.getRGB(lin, col);
                Color color1 = new Color(rgb1);

                int red1 = color1.getRed();

                if (red1 > fmax1){fmax1 = red1;}
                if ( red1 < fmin1){fmin1 = red1;}

                // ====================================

                int rgb2 = imagem8.getRGB(lin, col);
                Color color2 = new Color(rgb2);

                int red2 = color2.getRed();

                if (red2 > fmax2){fmax2 = red2;}
                if ( red2 < fmin2){fmin2 = red2;}
            }
        }

        for (int lin = 0; lin < w; lin++) {
            for (int col = 0; col < h; col++) {

                int rgb1 = imagem7.getRGB(lin, col);
                Color color1 = new Color(rgb1);

                int red1 = color1.getRed();
                int g1 = (255 / (fmax1 - fmin1)) * (red1 - fmin1);

                imagem7.setRGB(lin, col, new Color(g1, g1, g1).getRGB());
                // ====================================

                int rgb2 = imagem8.getRGB(lin, col);
                Color color2 = new Color(rgb2);

                int red2 = color2.getRed();

                int g2 = (255 / (fmax2 - fmin2)) * (red2 - fmin2);

                imagem8.setRGB(lin, col, new Color(g2, g2, g2).getRGB());

                imagemNova1.setRGB(lin, col, new Color(imagem7.getRGB(lin, col) + imagem8.getRGB(lin, col)).getRGB());
                imagemNova2.setRGB(lin, col, new Color(imagem7.getRGB(lin, col) - imagem8.getRGB(lin, col)).getRGB());
            }
        }

        ImageIO.write(imagemNova1, "png", new File("src/ImgNova/Adicao/imagem4.png"));
        ImageIO.write(imagemNova2, "png", new File("src/ImgNova/Subtracao/imagem4.png"));

        for (int lin = 0; lin < w; lin++) {
            for (int col = 0; col < h; col++) {

                int pixel1 = imagem7.getRGB(lin, col);
                int pixel2 = imagem8.getRGB(lin, col);

                int resultPixelAnd = pixel1 & pixel2; // and
                int resultPixelOr = pixel1 | pixel2; // or
                int resultPixelXor = pixel1 ^ pixel2; // xor

                resultImageAnd.setRGB(lin, col, resultPixelAnd);
                resultImageOr.setRGB(lin, col, resultPixelOr);
                resultImageXor.setRGB(lin, col, resultPixelXor);
            }
        }

        ImageIO.write(resultImageAnd, "png", new File("src/ImgNova/End/op-and4.png"));
        ImageIO.write(resultImageOr, "png", new File("src/ImgNova/Or/op-or4.png"));
        ImageIO.write(resultImageXor, "png", new File("src/ImgNova/Xor/op-xor4.png"));




        for (int lin = 0; lin < w; lin++) {
            for (int col = 0; col < h; col++) {

                int rgb1 = imagem9.getRGB(lin, col);
                Color color1 = new Color(rgb1);

                int red1 = color1.getRed();

                if (red1 > fmax1){fmax1 = red1;}
                if ( red1 < fmin1){fmin1 = red1;}

                // ====================================

                int rgb2 = imagem10.getRGB(lin, col);
                Color color2 = new Color(rgb2);

                int red2 = color2.getRed();

                if (red2 > fmax2){fmax2 = red2;}
                if ( red2 < fmin2){fmin2 = red2;}
            }
        }

        for (int lin = 0; lin < w; lin++) {
            for (int col = 0; col < h; col++) {

                int rgb1 = imagem9.getRGB(lin, col);
                Color color1 = new Color(rgb1);

                int red1 = color1.getRed();
                int g1 = (255 / (fmax1 - fmin1)) * (red1 - fmin1);

                imagem9.setRGB(lin, col, new Color(g1, g1, g1).getRGB());
                // ====================================

                int rgb2 = imagem10.getRGB(lin, col);
                Color color2 = new Color(rgb2);

                int red2 = color2.getRed();

                int g2 = (255 / (fmax2 - fmin2)) * (red2 - fmin2);

                imagem10.setRGB(lin, col, new Color(g2, g2, g2).getRGB());

                imagemNova1.setRGB(lin, col, new Color(imagem9.getRGB(lin, col) + imagem10.getRGB(lin, col)).getRGB());
                imagemNova2.setRGB(lin, col, new Color(imagem9.getRGB(lin, col) - imagem10.getRGB(lin, col)).getRGB());
            }
        }

        ImageIO.write(imagemNova1, "png", new File("src/ImgNova/Adicao/imagem5.png"));
        ImageIO.write(imagemNova2, "png", new File("src/ImgNova/Subtracao/imagem5.png"));

        for (int lin = 0; lin < w; lin++) {
            for (int col = 0; col < h; col++) {

                int pixel1 = imagem9.getRGB(lin, col);
                int pixel2 = imagem10.getRGB(lin, col);

                int resultPixelAnd = pixel1 & pixel2; // and
                int resultPixelOr = pixel1 | pixel2; // or
                int resultPixelXor = pixel1 ^ pixel2; // xor

                resultImageAnd.setRGB(lin, col, resultPixelAnd);
                resultImageOr.setRGB(lin, col, resultPixelOr);
                resultImageXor.setRGB(lin, col, resultPixelXor);
            }
        }

        ImageIO.write(resultImageAnd, "png", new File("src/ImgNova/End/op-and5.png"));
        ImageIO.write(resultImageOr, "png", new File("src/ImgNova/Or/op-or5.png"));
        ImageIO.write(resultImageXor, "png", new File("src/ImgNova/Xor/op-xor5.png"));
    }
}
