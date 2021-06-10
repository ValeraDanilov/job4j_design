package ru.job4j.cache;
import java.io.File;
import java.io.IOException;

public class Emulator {

    public static void main(String[] args) throws IOException {
        DirFileCache dirFileCache = new DirFileCache("D:/Новая папка/");
        File folder = new File(dirFileCache.getCachingDir());
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                String res = dirFileCache.load(file.getAbsolutePath());
                dirFileCache.put(file.getName(), res);
            }
        }
        System.out.println(dirFileCache.get("test — копия (3).txt"));
    }
}
