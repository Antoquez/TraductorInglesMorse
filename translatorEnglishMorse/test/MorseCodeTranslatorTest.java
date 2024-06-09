import logic.MorseCodeTranslator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MorseCodeTranslatorTest {

    MorseCodeTranslator translator = new MorseCodeTranslator();

    @Test
    void testEnglishToMorse_basic() {
        assertEquals(".-", translator.englishWordToMorseWord("A").trim());
        assertEquals("-...", translator.englishWordToMorseWord("B").trim());
        assertEquals(".-.-.-", translator.englishWordToMorseWord(".").trim());
    }

    @Test
    void testEnglishToMorse_words() {
        assertEquals(".- .-.. .--. .... .- /", translator.englishWordToMorseWord("ALPHA").trim());
        assertEquals(".-.. --- .-. . -- / .. .--. ... ..- -- /", translator.englishWordToMorseWord("LOREM IPSUM").trim());
    }

    @Test
    void testEnglishToMorse_phrases() {
        assertEquals(".-.. --- .-. . -- / .. .--. ... ..- -- / -.. --- .-.. --- .-. /", translator.englishWordToMorseWord("LOREM IPSUM DOLOR").trim());
    }

    @Test
    void testEnglishToMorse_unknownCharacters() {
        assertEquals("?? ", translator.englishWordToMorseWord("$").trim());
    }

    @Test
    void testEnglishToMorse_emptyAndNull() {
        assertEquals("", translator.englishWordToMorseWord(""));
        assertEquals("", translator.englishWordToMorseWord(null));
    }

    @Test
    void testEnglishToMorse_caseSensitivity() {
        assertEquals(".-", translator.englishWordToMorseWord("a").trim());
        assertEquals(".-", translator.englishWordToMorseWord("A").trim());
    }

    @Test
    void testMorseToEnglish_basic() {
        assertEquals("a", translator.morseWordToEnglishWord(".-").trim());
        assertEquals("b", translator.morseWordToEnglishWord("-...").trim());
        assertEquals(".", translator.morseWordToEnglishWord(".-.-.-").trim());
    }

    @Test
    void testMorseToEnglish_words() {
        assertEquals("alpha", translator.morseWordToEnglishWord(".- .-.. .--. .... .- /").trim());
        assertEquals("lorem ipsum", translator.morseWordToEnglishWord(".-.. --- .-. . -- / .. .--. ... ..- -- /").trim());
    }

    @Test
    void testMorseToEnglish_phrases() {
        assertEquals("lorem ipsum dolor", translator.morseWordToEnglishWord(".-.. --- .-. . -- / .. .--. ... ..- -- / -.. --- .-.. --- .-. /").trim());
    }

    @Test
    void testMorseToEnglish_unknownSequences() {
        assertEquals("??", translator.morseWordToEnglishWord("...---...").trim());
    }

    @Test
    void testMorseToEnglish_emptyAndNull() {
        assertEquals("", translator.morseWordToEnglishWord(""));
        assertEquals("", translator.morseWordToEnglishWord(null));
    }

    @Test
    void testMorseToEnglish_separators() {
        assertEquals("lorem ipsum", translator.morseWordToEnglishWord(".-.. --- .-. . -- / .. .--. ... ..- -- /").trim());
        assertEquals("lorem ipsum", translator.morseWordToEnglishWord(".-.. --- .-. . -- | .. .--. ... ..- -- |").trim());
    }
}
