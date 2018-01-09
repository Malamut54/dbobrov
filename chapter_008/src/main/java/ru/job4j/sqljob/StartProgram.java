package ru.job4j.sqljob;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Final task. Parse sql.ru.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 11.12.2017
 */

public class StartProgram {
    private Init init = new Init();
    private Parser parser = new Parser();
    private Timer timer = new Timer();
    long periodicity = 1000 * 60 * 60 * 24 * init.getPeriodicity();

    public StartProgram() {
        Task t = new Task();
        timer.schedule(t, 100, periodicity);
    }

    private class Task extends TimerTask {
        public void run() {
            parser.grabLinkVacation();
        }
    }
    public static void main(String[] args) {
        new StartProgram();
    }
}
