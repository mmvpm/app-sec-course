package org.example.itextpdf;

import com.itextpdf.text.Utilities;

import java.io.IOException;

public class Utilities_1 {
    public static void main(String[] args) throws IOException {
        var result = Utilities.readFileToString("exposed/example.txt");
        System.out.println(result);
    }
}
