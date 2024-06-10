/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

/**
 * This class provides methods to translate English words to Morse code and vice
 * versa. It uses two HashMaps to store the translation libraries for both
 * directions.
 *
 * @version 1.0
 * @since 1.0
 * @author my company
 */
public class MorseCodeTranslator {

    private HashMap<String, String> englishToMorseLib = new HashMap<>(), morseToEnglishLib = new HashMap<>();

    {
        //fill up englishToMorseLib
        englishToMorseLib.put("A", ".-");
        englishToMorseLib.put("B", "-...");
        englishToMorseLib.put("C", "-.-.");
        englishToMorseLib.put("D", "-..");
        englishToMorseLib.put("E", ".");
        englishToMorseLib.put("F", "..-.");
        englishToMorseLib.put("G", "--.");
        englishToMorseLib.put("H", "....");
        englishToMorseLib.put("I", "..");
        englishToMorseLib.put("J", ".---");
        englishToMorseLib.put("K", "-.-");
        englishToMorseLib.put("L", ".-..");
        englishToMorseLib.put("M", "--");
        englishToMorseLib.put("N", "-.");
        englishToMorseLib.put("O", "---");
        englishToMorseLib.put("P", ".--.");
        englishToMorseLib.put("Q", "--.-");
        englishToMorseLib.put("R", ".-.");
        englishToMorseLib.put("S", "...");
        englishToMorseLib.put("T", "-");
        englishToMorseLib.put("U", "..-");
        englishToMorseLib.put("V", "...-");
        englishToMorseLib.put("W", ".--");
        englishToMorseLib.put("X", "-..-");
        englishToMorseLib.put("Y", "-.--");
        englishToMorseLib.put("Z", "--..");

        englishToMorseLib.put("0", "-----");
        englishToMorseLib.put("1", ".----");
        englishToMorseLib.put("2", "..---");
        englishToMorseLib.put("3", "...--");
        englishToMorseLib.put("4", "....-");
        englishToMorseLib.put("5", ".....");
        englishToMorseLib.put("6", "-....");
        englishToMorseLib.put("7", "--...");
        englishToMorseLib.put("8", "---..");
        englishToMorseLib.put("9", "----.");

        englishToMorseLib.put(".", ".-.-.-");
        englishToMorseLib.put(",", "--..--");
        englishToMorseLib.put("?", "..--..");
        englishToMorseLib.put(":", "---...");
        englishToMorseLib.put("-", "-....-");
        englishToMorseLib.put("@", ".--.-.");
        englishToMorseLib.put("error", "........");

        //fill the morseToEnglishLib
        List<Object> values = Arrays.asList(englishToMorseLib.values().toArray());
        List<Object> keys = Arrays.asList(englishToMorseLib.keySet().toArray());
        for (int i = 0; i < values.size(); i++) {
            morseToEnglishLib.put(values.get(i).toString(), keys.get(i).toString());
        }
    }

    /**
     * Converts an English word to its Morse code representation.
     *
     * @param englishWord the English word to be translated to Morse code
     * @return a String representing the Morse code of the input English word
     */
    public String englishWordToMorseWord(String englishWord) {
        StringBuffer buffer = new StringBuffer();
        Stream.of(englishWord.split("[ \n]"))
                .forEach(s -> {
                    for (char c : s.toCharArray()) {
                        buffer.append(englishToMorseLib.containsKey(String.valueOf(c).toUpperCase()) ? englishToMorseLib.get(String.valueOf(c).toUpperCase()) + " " : "?? ");
                    }
                    buffer.append(" / ");
                });
        return buffer.toString();
    }

    /**
     * Converts a Morse code word to its English representation.
     * 
     * @param morseWord the Morse code word to be translated to English
     * @return a String representing the English word of the input Morse code
     */
    public String morseWordToEnglishWord(String morseWord) {
        StringBuffer buffer = new StringBuffer();
        Stream.of(morseWord.split("[\\s\\n]"))
                .filter((s) -> s != null && !s.isEmpty())
                .forEach(s -> {
                    if (s.equalsIgnoreCase("/") || s.equalsIgnoreCase("|")) {
                        buffer.append(" ");
                    } else {
                        buffer.append((morseToEnglishLib.containsKey(s) ? morseToEnglishLib.get(s) : "?? ").toLowerCase());
                    }
                });
        return buffer.toString();
    }
}
