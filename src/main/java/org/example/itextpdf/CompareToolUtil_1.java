package org.example.itextpdf;

import com.itextpdf.testutils.CompareToolUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CompareToolUtil_1 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("exposed/temp-file.txt");
        if (!Files.exists(path)) {
            Files.createFile(path);
        }

        CompareToolUtil.removeFiles(new String[]{path.toString()});
    }
}
