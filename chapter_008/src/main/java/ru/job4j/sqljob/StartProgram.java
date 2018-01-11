package ru.job4j.sqljob;

/**
 * Final task. Parse sql.ru.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 11.12.2017
 */

public class StartProgram {
    /**
     * Start app.
     *
     * @param args args.
     */
    public static void main(String[] args) {
        Init init = new Init();
        final Parser parser = new Parser();
        final long periodicity = 1000 * 60 * 60 * 24 * init.getPeriodicity();

        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        parser.grabLinkVacation();
                        Thread.sleep(periodicity);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
