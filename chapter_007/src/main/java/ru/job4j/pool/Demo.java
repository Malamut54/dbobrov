package ru.job4j.pool;

/**
 * TODO: comment
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 01.11.2017
 */

public class Demo {


    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("working");
            }
        });
        ThreadPool threadPool = new ThreadPool();
        for (int i = 0; i < 20; i++) {
            threadPool.execute(thread);
        }
    }
}
