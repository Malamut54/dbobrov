package ru.job4j.pamperingwithdb;

/**
 * TODO: comment
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 24.11.2017
 */

public class Main {
    public static void main(String[] args) {
        Init init = new Init();

        init.setNumberOfValues(1000);
        init.setConnectToDB("jdbc:sqlite:H:\\projects\\sqlLiteDB\\base.db");
        FillDB fill = new FillDB();
        fill.fillDataBase(init);

    }
}
