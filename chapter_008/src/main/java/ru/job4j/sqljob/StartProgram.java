package ru.job4j.sqljob;

/**
 * Final task. Parse sql.ru.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 11.12.2017
 */

public class StartProgram {
    public static void main(String[] args) {
//        Init init = new Init();
//        init.getCredentials();

        Parser parser = new Parser();
        parser.grab();
    }
}
