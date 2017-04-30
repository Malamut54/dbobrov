package ru.job4j.tracker;

/**
 * Task Tracker.
 */
public class StartUI {
    /**
     * Class StartUI. Perform logic app.
     */

    /**
     *  Private fields.
     */
    private Input input;
    /**
     *  Private fields.
     */
    private Tracker tracker;

    /**
     * Constructor for StartUI.
     * @param tracker tracker.
     * @param input input.
     */
    public StartUI(Tracker tracker, Input input) {
        this.tracker = tracker;
        this.input = input;
    }

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
     *  Constant fields.
     */
    private static final int ADD = 0;
    /**
     *  Constant fields.
     */
    private static final int ALL = 1;
    /**
     *  Constant fields.
     */
    private static final int EDIT = 2;
    /**
     *  Constant fields.
     */
    private static final int DEL = 3;
    /**
     *  Constant fields.
     */
    private static final int FINDID = 4;
    /**
     *  Constant fields.
     */
    private static final int FINDNAME = 5;
    /**
     *  Constant fields.
     */
    private static final int EXIT = 6;

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

            if (choise == ADD) {
                String id = "0";
                String name = input.ask("Enter your name");
                String descritpion = input.ask("Enter Description");
                tracker.add(new Item(id, name, descritpion));
            } else if (choise == ALL) {
                Item[] item = tracker.findAll();
                for (Item x : item) {
                    System.out.println(String.format("name - %s. description - %s. id - %s",
                            x.getName(), x.getDesc(), x.getId()));
                }
            } else if (choise == EDIT) {
                String id = input.ask("Enter id task for edit");
                String name = input.ask("Enter new name");
                String desc = input.ask("Enter new description");
                tracker.upddate(new Item(id, name, desc));
            } else if (choise == DEL) {
                String id = input.ask("Enter id task for delete");
                tracker.delete(new Item(id, " ", " "));
            } else if (choise == FINDID) {
                String id = input.ask("Enter id");
                Item item = tracker.findById(id);
                System.out.println(String.format("name - %s. description - %s. id - %s",
                        item.getName(), item.getDesc(), item.getId()));
            } else if (choise == FINDNAME) {
                String name = input.ask("Enter the name");
                Item[] item = tracker.findByName(name);
                for (Item x : item) {
                    if (x != null) {
                        System.out.println(String.format("name - %s. description - %s. id - %s",
                                x.getName(), x.getDesc(), x.getId()));
                    }
                }
            } else if (choise == EXIT) {
                execute = false;
            }
        }
    }

    /**
     * Entry point.
     * @param args args.
     */
    public static void main(String[] args) {
        StartUI start = new StartUI(new Tracker(), new ConsoleInput());
        start.init();
    }
}
