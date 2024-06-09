import static org.junit.jupiter.api.Assertions.*;

import logic.Export;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;

class ExportTest {

    private static final String TEXT_CONTENT = "Hello, World!";
    private static final String IMAGE_CONTENT = "Morse Code";

    @TempDir
    Path tempDir;

    @Test
    void testExportAsTxt() throws Exception {
        File file = new File(tempDir.toFile(), "test.txt");
        Export exporter = new Export();
        exporter.exportBraille(file, "txt", TEXT_CONTENT, 12, false, false, Color.BLACK);

        // Verify the contents of the file
        FileInputStream fis = new FileInputStream(file);
        byte[] bytes = new byte[(int) file.length()];
        fis.read(bytes);
        fis.close();
        String fileContent = new String(bytes);
        assertEquals(TEXT_CONTENT, fileContent.trim());
    }

    @Test
    void testExportAsImage() throws Exception {
        File file = new File(tempDir.toFile(), "test.png");
        Export exporter = new Export();
        exporter.exportBraille(file, "png", IMAGE_CONTENT, 24, true, false, Color.BLUE);

        // Verify that the file was created
        assertTrue(file.exists());
    }

    @Test
    void testExportUnsupportedFormat() {
        File file = new File(tempDir.toFile(), "test.xyz");
        Export exporter = new Export();
        assertThrows(IllegalArgumentException.class, () -> {
            exporter.exportBraille(file, "xyz", TEXT_CONTENT, 12, false, false, Color.BLACK);
        });
    }
}