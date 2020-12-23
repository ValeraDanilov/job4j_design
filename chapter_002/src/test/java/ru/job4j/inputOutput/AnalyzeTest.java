package ru.job4j.inputOutput;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnalyzeTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void drop() throws IOException {
        File source = folder.newFile("server.log.txt");
        File target = folder.newFile("target.txt");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01\n" +
                    "\n" +
                    "500 10:57:01\n" +
                    "\n" +
                    "400 10:58:01\n" +
                    "\n" +
                    "200 10:59:01\n" +
                    "\n" +
                    "500 11:01:02\n" +
                    "\n" +
                    "200 11:02:02");
        }
        Analyze.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
        }
        assertThat(rsl.toString(), is("From: 10:57:01. To: 10:59:01From: 11:01:02. To: 11:02:02"));
    }
}
