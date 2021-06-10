package ru.job4j.concurrency.third.parser;

import java.io.*;
import java.util.function.Predicate;

public class ParseFile {

    private final File file;

    public ParseFile(File file) {
        if (file == null) {
            throw new IllegalArgumentException("File can not be null");
        }
        this.file = file;
    }

    private String getContent(Predicate<Character> predicate) throws IOException {
        synchronized (file) {
            StringBuilder output;
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                output = new StringBuilder();
                int data;
                while ((data = br.read()) > 0) {
                    if (predicate.test((char) data)) {
                        output.append(data);
                    }
                }
                return output.toString();
            }
        }
    }
}
