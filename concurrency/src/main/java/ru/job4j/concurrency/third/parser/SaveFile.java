package ru.job4j.concurrency.third.parser;

import java.io.*;

public class SaveFile {

    private final File file;

    public SaveFile(File file) {
        if (file == null) {
            throw new IllegalArgumentException("File can not be null");
        }
        this.file = file;
    }

    public void saveContent(String content) throws IOException {
        synchronized (file) {
            try (OutputStream o = new BufferedOutputStream(new FileOutputStream(file))) {
                o.write(content.getBytes());
            }
        }
    }

}
