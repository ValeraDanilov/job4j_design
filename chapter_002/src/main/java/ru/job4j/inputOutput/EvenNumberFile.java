package ru.job4j.inputOutput;

import java.io.FileInputStream;

public class EvenNumberFile {
//    public static void main(String[] args) {
//        try (FileInputStream in = new FileInputStream("C:/projects/job4j_design/chapter_002/src/main/resources/even.txt")) {
//            StringBuilder b = new StringBuilder();
//            int res;
//            while ((res = in.read()) != -1) {
//                b.append((char) res);
//            }
//            for (String value : b.toString().split(System.lineSeparator())) {
//                if (Integer.parseInt(value) % 2 == 0) {
//                    System.out.println(value);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
    @Override
    public String toString() {
        return "EvenNumberFile{}";
    }
}
