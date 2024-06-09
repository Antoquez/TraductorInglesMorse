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
 *
 * @author MARQUEZ
 */
public class Export {

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
     * Exporta el contenido como archivo de texto.
     *
     * @param file El archivo de destino.
     * @param content El contenido a exportar.
     * @throws FileNotFoundException Si el archivo no puede ser creado o abierto.
     */
    
    private void exportAsTxt(File file, String content) throws FileNotFoundException {
        try (PrintWriter out = new PrintWriter(file)) {
            out.println(content);
        }
    }

    /**
     * Exporta el contenido como una imagen.
     *
     * @param file El archivo de destino.
     * @param content El contenido a exportar.
     * @param fontSize El tamaño de la fuente.
     * @param isBold Indica si el texto debe estar en negrita.
     * @param isItalic Indica si el texto debe estar en cursiva.
     * @param color El color del texto.
     * @param format El formato de la imagen (PNG).
     * @throws IOException Si ocurre un error durante la creación de la imagen.
     */
    private void exportAsImage(File file, String content, int fontSize, boolean isBold, boolean isItalic, java.awt.Color color, String format) throws IOException {
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
