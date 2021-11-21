package app.spacecat.imagetoasciifinal;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;

class Main{

    /*
    todo:
    - add javafx
        - slider that changes the scale
        - input -> output
        - copy button
     */

    public static void main(String[] args) throws IOException {
        File file  = new File("C:\\Users\\yotam\\Desktop\\banana.jpg");
        BufferedImage image = ImageIO.read(file);

        ASCII ascii = new ASCII(false);
        String asciiArt = ascii.convert(image ,6);

        System.out.println(asciiArt);
    }


}
