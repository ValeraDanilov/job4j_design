package ru.job4j.inputOutput;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConsoleChat {

    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private boolean result = true;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.path))) {
            for (String element : writeHistory()) {
                writer.write(element + System.lineSeparator());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<String> writeHistory() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String value = "";
        List<String> answer = readAnswers();
        List<String> result = new ArrayList<>();
        while (!value.equals(OUT)) {
            value = reader.readLine();
            result.add(String.format("User: %s", value));
            if (!check(value) || value.equals(OUT)) {
                this.result = value.equals(CONTINUE);
                continue;
            }
            int index = (int) (Math.random() * answer.size());
            result.add(String.format("Bot: %s", answer.get(index)));
            System.out.println(answer.get(index));
        }
        return result;
    }

    private List<String> readAnswers() {
        List<String> answers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(this.botAnswers))) {
            answers = reader.lines().filter(v -> !v.equals("")).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return answers;
    }

    private boolean check(String value) {
        if (value.equals(STOP)) {
            this.result = false;
        }
        return result;
    }

    public static void main(String[] args) {
        ConsoleChat chat = new ConsoleChat("./chat.history.txt", "./bot.answers.txt");
        chat.run();
    }
}
