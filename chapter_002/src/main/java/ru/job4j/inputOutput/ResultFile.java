package ru.job4j.inputOutput;

import java.io.FileOutputStream;

public class ResultFile {
//    public static void main(String[] args) {
//        try (FileOutputStream out = new FileOutputStream("C:\\projects\\job4j_design\\chapter_002\\src\\main\\resources\\result.txt")) {
//            out.write("  | ".getBytes());
//            for (int i = 1; i < 10; i++) {
//                String count = i + "  ";
//                out.write(count.getBytes());
//            }
//            out.write("\n--|-----------".getBytes());
//            out.write("----------------\n".getBytes());
//            for (int i = 1; i < 10; i++) {
//                String count = i + " | ";
//                out.write(count.getBytes());
//                for (int j = 1; j < 10; j++) {
//                    String check = i * j < 10 ? "  " : " ";
//                    String count1 = i * j + check;
//                    out.write(count1.getBytes());
//                }
//               out.write("\n".getBytes());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public String toString() {
        return "ResultFile{}";
    }
}
