/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.translatorenglishmorse;

import userInterface.JFMorseCodeTranslator;

/**
 * This class is used to execute principal interface
 *
 * @version 1.0
 * @author My Company
 */
public class TranslatorEnglishMorse {

    /**
     *
     * The main method serves as the entry point to the application.
     *
     * @param args the command-line arguments. Currently not used.
     */
    public static void main(String[] args) {
        JFMorseCodeTranslator translator = new JFMorseCodeTranslator();
        translator.setVisible(true);
    }
}
