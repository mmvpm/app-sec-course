package org.example.itextpdf;

import com.itextpdf.text.io.TempFileCache;
import com.itextpdf.text.pdf.PdfBoolean;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TempFileCache_1 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("exposed/temp-file.txt");
        if (!Files.exists(path)) {
            Files.createFile(path);
        }

        var cache = new TempFileCache(path.toString());
        cache.put(PdfBoolean.PDFTRUE);

        var content = new FileInputStream(path.toFile()).readAllBytes();
        System.out.println(new String(content));
    }
}
