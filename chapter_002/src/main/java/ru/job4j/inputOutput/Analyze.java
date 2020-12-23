package ru.job4j.inputOutput;

import java.io.*;

public class Analyze {

    public static void unavailable(String source, String target) {
        String number = "", time = "";
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            for (String value = in.readLine(); value != null; value = in.readLine()) {
                if (value.length() != 0) {
                    String[] array = value.split(" ");
                    if (!(number.equals("")) && !(array[0].equals("400") || array[0].equals("500"))) {
                        out.println("From: " + time + ". To: " + array[1]);
                        time = "";
                    }
                    if ((time.equals("")) && (array[0].equals("400") || array[0].equals("500"))) {
                        number = array[0];
                        time = array[1];
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
