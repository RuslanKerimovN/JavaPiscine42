package edu.school21.printer.app;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import edu.school21.printer.logic.Logic;


public class Program {
    public static void main(String[] args) {
        if (args.length != 3 || args[0].length() != 1 || args[1].length() != 1) {
            System.err.println("Illegal arguments");
            System.exit(-1);
        }

        BufferedImage image = null;
        int pixel = 0;
        char white = args[0].charAt(0);
        char black = args[1].charAt(0);

        try {
            image = ImageIO.read(new File(args[2]));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Logic logic = new Logic(white, black, image);
        logic.fromImageToPrint();
    }
}
