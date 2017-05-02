package ru.job4j.tracker;

/**
 * Created by kvazimoda on 02.05.2017.
 */
public interface UserAction {
    int key();
    void execute(Input input, Tracker tracker);
    String info();
}
