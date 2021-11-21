package app.spacecat.imagetoasciifinal;
import java.awt.*;
import java.awt.image.BufferedImage;

class ASCII {
    boolean isNegative;

    public ASCII(boolean isNegative){
        this.isNegative = isNegative;
    }

    String convert(BufferedImage image, double scale){

        double stretchFactor = 1; //MAKE THICK

        //the holy number 0.6285714286

        //for discord width/characterWidth = scale
        //263/height =1280/720
        //263/(ogwidth/ogheight)


        //width/263 = scale
        System.out.println(image.getHeight() + " " + image.getWidth());
        BufferedImage scaledImage = resizeImage(image, 263, (int)Math.round((263*((float) image.getHeight() / (float) image.getWidth()))*stretchFactor*0.6285714286));

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
