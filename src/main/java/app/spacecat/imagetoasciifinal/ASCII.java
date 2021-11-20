package app.spacecat.imagetoasciifinal;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

class ASCII {
    boolean isNegative;

    public ASCII(boolean isNegative){
        this.isNegative = isNegative;
    }

    String convert(BufferedImage image, int scale) throws IOException {

        BufferedImage scaledImage = resizeImage(image, image.getWidth()/scale, image.getHeight()/scale);

        StringBuilder stringBuilder = new StringBuilder();

        for(int y = 0; y < scaledImage.getHeight(); y++){
            stringBuilder.append("\n");
            for(int x = 0; x < scaledImage.getWidth(); x++){
                Color color = new Color(scaledImage.getRGB(x, y));

                double grayScale = 0.299 * color.getRed() + 0.587 * color.getGreen() + 0.114 * color.getBlue();
//                System.out.println(grayScale);
                if(isNegative){
                    stringBuilder.append(grayScaleCharPos(grayScale));
                } else{
                    stringBuilder.append(grayScaleCharNeg(grayScale));
                }

            }
        }

        return stringBuilder.toString();
    }

    private char grayScaleCharPos(double grayScale){
        char character;

        if(grayScale <= 20){
            character = ' ';
        } else if(grayScale <= 50){
            character = '.';
        } else if(grayScale <= 80){
            character = ',';
        } else if(grayScale <= 110){
            character = ';';
        } else if(grayScale <= 140){
            character = '?';
        } else if(grayScale <= 170){
            character = 'o';
        } else if(grayScale <= 200){
            character = '&';
        } else if(grayScale <= 230){
            character = '#';
        } else{
            character = '@';
        }


        return character;

    }

    private char grayScaleCharNeg(double grayScale){
        char character;

        if(grayScale <= 20){
            character = '@';
        } else if(grayScale <= 50){
            character = '#';
        } else if(grayScale <= 80){
            character = '&';
        } else if(grayScale <= 110){
            character = 'o';
        } else if(grayScale <= 140){
            character = '?';
        } else if(grayScale <= 170){
            character = ';';
        } else if(grayScale <= 200){
            character = ',';
        } else if(grayScale <= 230){
            character = '.';
        } else{
            character = ' ';
        }


        return character;

    }

    private BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight){
        Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_DEFAULT);
        BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);

        return outputImage;
    }

}
