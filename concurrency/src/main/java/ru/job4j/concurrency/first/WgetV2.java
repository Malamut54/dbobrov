package ru.job4j.concurrency.first;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import org.apache.commons.io.FilenameUtils;

public class WgetV2 implements Runnable{
    private final String url;
    private final int speed;

    public WgetV2(String url, int speed) {
        this.url = url;
        this.speed = speed;
    }

    @Override
    public void run() {
        String fileName = getFileName(url);
        try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
            FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {

            byte[] dataBuffer = new byte[speed];
            int bytesRead;

            while (true) {
                Date start = new Date();
                bytesRead = in.read(dataBuffer, 0, speed);
                if (bytesRead == -1) {
                    break;
                }
                fileOutputStream.write(dataBuffer, 0, bytesRead);
                Date finish = new Date();

                long executionTime = finish.getTime() - start.getTime();

                if (executionTime < 1000) {
                    System.out.println("Inside sleep");
                    Thread.sleep(1000 - executionTime);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getFileName(String url) {
        try {
            return FilenameUtils.getName(new URL(url).getPath());
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid URL " + url);
        }
    }

    /*
    * Input args
    * URL
    * Speed limit in byte/sec
    * */
    public static void main(String[] args) {
        String url = args[0];
        int speed = Integer.parseInt(args[1]);
        Thread thread = new Thread(new WgetV2(url, speed));
        thread.start();
    }
}
