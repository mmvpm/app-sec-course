package org.example.itextpdf;

import com.itextpdf.testutils.CompareToolUtil;

import java.io.FileInputStream;
import java.io.IOException;

public class CompareToolUtil_2 {
    public static void main(String[] args) throws IOException {
        CompareToolUtil.copy("exposed/example.txt", "exposed/temp-file.txt");

        var content = new FileInputStream("exposed/temp-file.txt").readAllBytes();
        System.out.println(new String(content));
    }
}
