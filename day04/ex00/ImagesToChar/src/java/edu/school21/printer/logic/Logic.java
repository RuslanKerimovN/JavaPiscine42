package edu.school21.printer.logic;

import java.awt.image.BufferedImage;

public class Logic {
    private char black;
    private char white;
    private BufferedImage image;

    public Logic(char white, char black, BufferedImage image) {
        this.white = white;
        this.black = black;
        this.image = image;
    }

    public void fromImageToPrint() {
        int pixel = 0;

        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                pixel = image.getRGB(j,i);
                if ((pixel & 0x00FFFFFF) == 0x00FFFFFF) {
                    System.out.print(white);
                }
                else {
                    System.out.print(black);
                }
            }
            System.out.println();
        }
    }
}
