package ru.job4j.tracker;

/**
 * Task Tracker.
 */
public class StartUI {
    /**
     * Class StartUI. Perform logic app.
     */

    /**
     *  Create object Input.
     */
    private final Input input = new ConsoleInput();
    /**
     *  Create object Tracker.
     */
    private Tracker tracker = new Tracker();
    /**
     * Array for display menu.
     */
    private String[] menuDisplay = {
            "0. Add new Item",
            "1. Show all items",
            "2. Edit item",
            "3. Delete item",
            "4. Find  by Id",
            "5. Find items by name",
            "6. Exit Program",
    };

    /**
     * Method that processes user requests.
     */
    public void init() {
        boolean execute = true;
        while (execute) {
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
                String name = input.ask("Enter new name");
                String desc = input.ask("Enter new description");
                tracker.upddate(new Item(id, name, desc));
            } else if (choise == 3) {
                String id = input.ask("Enter id task for delete");
                tracker.delete(new Item(id, " ", " "));
            } else if (choise == 4) {
                String id = input.ask("Enter id");
                Item item = tracker.findById(id);
                System.out.println(String.format("name - %s. description - %s. id - %s",
                        item.getName(), item.getDesc(), item.getId()));
            } else if (choise == 5) {
                String name = input.ask("Enter the name");
                Item[] item = tracker.findByName(name);
                for (Item x : item) {
                    if (x != null) {
                        System.out.println(String.format("name - %s. description - %s. id - %s",
                                x.getName(), x.getDesc(), x.getId()));
                    }
                }
            } else if (choise == 6) {
                execute = false;
            }
        }
    }

    /**
     * Entry point.
     * @param args args.
     */
    public static void main(String[] args) {
        StartUI start = new StartUI();
        start.init();
    }
}
