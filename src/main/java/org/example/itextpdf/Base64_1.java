package org.example.itextpdf;

import com.itextpdf.text.pdf.codec.Base64;

import java.io.IOException;

public class Base64_1 {
    public static void main(String[] args) throws IOException {
        var result = Base64.decodeFromFile("exposed/base64-example.txt");
        System.out.println(new String(result));
    }
}
