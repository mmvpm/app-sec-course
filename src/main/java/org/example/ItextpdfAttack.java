//package org.example;
//
//import com.itextpdf.text.pdf.hyphenation.Hyphenation;
//import com.itextpdf.text.pdf.hyphenation.HyphenationTree;
//import java.io.FileInputStream;
//import java.io.InputStream;
//
//public class ItextpdfAttack {
//    public static void main(String[] args) {
//        try {
//            String filePath = "/Users/mmvpm/Courses/app-sec-course/exposed/1.xml";
//            HyphenationTree hyphenationTree = new HyphenationTree();
//
//            try (InputStream inputStream = new FileInputStream(filePath)) {
//                System.out.println("Загружаем и парсим файл: " + filePath);
//                hyphenationTree.loadSimplePatterns(inputStream);
//                System.out.println("Файл успешно загружен.");
//            }
//
//            String word = "hyphenation";
//            int leftMin = 1;
//            int rightMin = 1;
//
//            Hyphenation hyphenation = hyphenationTree.hyphenate(word, leftMin, rightMin);
//
//            if (hyphenation != null) {
//                int[] hyphenationPoints = hyphenation.getHyphenationPoints();
//                System.out.println("Слово: " + word);
//                System.out.print("Позиции переносов: ");
//                for (int point : hyphenationPoints) {
//                    System.out.print(point + " ");
//                }
//                System.out.println();
//            } else {
//                System.out.println("Не удалось найти переносы для слова: " + word);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
