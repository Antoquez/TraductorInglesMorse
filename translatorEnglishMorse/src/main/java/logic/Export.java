/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package logic;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.imageio.ImageIO;

/**
 * This class provides methods to export Morse code as a text file or an image file.
 * 
 * @version 1.0
 * @since 1.0
 * @author my company
 */
public class Export {

    /**
     * Exports Morse code content to the specified file format.
     * 
     * @param file The destination file.
     * @param format The format to export the content ("TXT" or "PNG").
     * @param morseText The Morse code content to be exported.
     * @param fontSize The font size for the image export.
     * @param isBold Indicates if the text should be bold.
     * @param isItalic Indicates if the text should be italic.
     * @param color The color of the text in the image.
     * @throws Exception If an error occurs during export.
     */
    public void exportMorse(File file, String format, String morseText, int fontSize, boolean isBold, boolean isItalic, java.awt.Color color) throws Exception {
        switch (format.toUpperCase()) {
            case "TXT":
                exportAsTxt(file, morseText);
                break;
            case "PNG":
                exportAsImage(file, morseText, fontSize, isBold, isItalic, color, format);
                break;
            default:
                throw new IllegalArgumentException("Unsupported format: " + format);
        }
    }
    
    /**
     * Exports the content as a text file.
     * 
     * @param file The destination file.
     * @param content The content to be exported.
     * @throws FileNotFoundException If the file cannot be created or opened.
     */
    public void exportAsTxt(File file, String content) throws FileNotFoundException {
        try (PrintWriter out = new PrintWriter(file)) {
            out.println(content);
        }
    }

    /**
     * Exports the content as an image file.
     * 
     * @param file The destination file.
     * @param content The content to be exported.
     * @param fontSize The font size for the text in the image.
     * @param isBold Indicates if the text should be bold.
     * @param isItalic Indicates if the text should be italic.
     * @param color The color of the text.
     * @param format The image format ("PNG").
     * @throws IOException If an error occurs during image creation.
     */
    public void exportAsImage(File file, String content, int fontSize, boolean isBold, boolean isItalic, java.awt.Color color, String format) throws IOException {
        BufferedImage bufferedImage = new BufferedImage(500, 500, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bufferedImage.createGraphics();
        int fontStyle = Font.PLAIN;
        if (isBold && isItalic) {
            fontStyle = Font.BOLD | Font.ITALIC;
        } else if (isBold) {
            fontStyle = Font.BOLD;
        } else if (isItalic) {
            fontStyle = Font.ITALIC;
        }

        g2d.setFont(new Font("morse", fontStyle, fontSize));
        g2d.setColor(color);
        g2d.drawString(content, 20, 50);
        g2d.dispose();
        ImageIO.write(bufferedImage, format.toLowerCase(), file);
    }
    
}
