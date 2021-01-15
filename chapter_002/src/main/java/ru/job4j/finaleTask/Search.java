package ru.job4j.finaleTask;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Search {

    public void packFiles(List<Path> sources, Path file) {
        try (PrintWriter writer = new PrintWriter(new BufferedOutputStream(new FileOutputStream(file.toFile())))) {
            for (Path path : sources) {
                writer.println(path);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Path> search(Path root, String ext, String marker) throws IOException {
        FileSearch searcher = new FileSearch(ext, marker);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    public static void main(String[] args) throws IOException {
        BaseSearchCriteria argJar = new BaseSearchCriteria(args);
        if (argJar.valid()) {
            List<Path> result = search(Paths.get(argJar.directory()), argJar.nameFile(), argJar.nameMarker());
            new Search().packFiles(result, Paths.get(argJar.output()));
        }
    }
}
