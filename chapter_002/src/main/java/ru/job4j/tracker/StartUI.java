package ru.job4j.tracker;

import java.util.Arrays;

/**
 * Task Tracker.
 */
public class StartUI {

    private final Input input = new ConsoleInput();
    private Tracker tracker = new Tracker();

    private String[] menuDisplay = {
            "0. Add new Item",
            "1. Show all items",
            "2. Edit item",
            "3. Delete item",
            "4. Find item by Id",
            "5. Find items by name",
            "6. Exit Program",
    };

    public void init() {
        while (true) {
            for (int i = 0; i < menuDisplay.length; i++) {
                System.out.println(menuDisplay[i]);
            }
            int choise = Integer.parseInt(input.ask("Select item number"));

            if (choise == 0) {
                String id = "0";
                String name = input.ask("Enter your name");
                String descritpion = input.ask("Enter Description");
                tracker.add(new Item(id, name, descritpion));
            } else if (choise == 1) {
                Item[] item = tracker.findAll();
                for (Item x : item) {
                    System.out.println(String.format("name - %s. description - %s. id - %s",
                            x.getName(), x.getDesc(), x.getId()));
                }
            } else if (choise == 2) {
                String id = input.ask("Enter id task for edit");
            }
        }
    }


    public static void main(String[] args) {
        StartUI start = new StartUI();
        start.init();

    }
}
