package ru.job4j.tracker;

/**
 * Task Tracker.
 */


public class MenutTracker {
    /**
     * Class Menutracker.
     */
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[7];

    public MenutTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.actions[0] = new AddItem();
        this.actions[1] = new ShowItems();
        this.actions[2] = new EditItem();
        this.actions[3] = new DeleteItem();
        this.actions[4] = new FindItemByID();
        this.actions[5] = new FindItemByName();
        this.actions[6] = new ExitProgram();
    }

    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private class AddItem implements UserAction {
        /**
         * Method determines the uniqueness of the key.
         *
         * @return key
         */
        public int key() {
            return 0;
        }

        /**
         * Perform actions.
         *
         * @param input   ask.
         * @param tracker Object Tracker.
         */
        public void execute(Input input, Tracker tracker) {
            String id = "0";
            String name = input.ask("Enter your name");
            String descritpion = input.ask("Enter Description");
            tracker.add(new Item(id, name, descritpion));
        }

        /**
         * Display menu items.
         *
         * @return String menu item.
         */
        public String info() {
            return String.format("%s, %s", this.key(), "Add new Item");
        }
    }

    private static class ShowItems implements UserAction {

        /**
         * Method determines the uniqueness of the key.
         *
         * @return key
         */
        public int key() {
            return 1;
        }

        /**
         * Perform actions.
         *
         * @param input   ask.
         * @param tracker Object Tracker.
         */
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.findAll()) {
                System.out.println(String.format("%s  %s", item.getId(), item.getName()));
            }
        }

        /**
         * Display menu items.
         *
         * @return String menu item.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Show all items");
        }
    }
}

class EditItem implements UserAction {

    /**
     * Method determines the uniqueness of the key.
     *
     * @return key
     */
    public int key() {
        return 2;
    }

    /**
     * Perform actions.
     *
     * @param input   ask.
     * @param tracker Object Tracker.
     */
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Enter Id");
        String name = input.ask("Enter new name");
        String desc = input.ask("Enter new description");
        tracker.upddate(new Item(id, name, desc));

    }

    /**
     * Display menu items.
     *
     * @return String menu item.
     */
    public String info() {
        return String.format("%s. %s", this.key(), "Edit item");
    }
}

class DeleteItem implements UserAction {
    /**
     * Method determines the uniqueness of the key.
     *
     * @return key
     */
    public int key() {
        return 3;
    }

    /**
     * Perform actions.
     *
     * @param input   ask.
     * @param tracker Object Tracker.
     */
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Enetr Id items for delete");
        tracker.delete(tracker.findById(id));
    }

    /**
     * Display menu items.
     *
     * @return String menu item.
     */
    public String info() {
        return String.format("%s. %s", this.key(), "Delete item");
    }
}

class FindItemByID implements UserAction {
    /**
     * Method determines the uniqueness of the key.
     *
     * @return key
     */
    public int key() {
        return 4;
    }

    /**
     * Perform actions.
     *
     * @param input   ask.
     * @param tracker Object Tracker.
     */
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Enter id");
        System.out.println(String.format
                ("%s, %s", tracker.findById(id).getName(), tracker.findById(id).getName()));
    }

    /**
     * Display menu items.
     *
     * @return String menu item.
     */
    public String info() {
        return String.format("%s. %s", this.key(), "Find item by Id");
    }
}

class FindItemByName implements UserAction {
    /**
     * Method determines the uniqueness of the key.
     *
     * @return key
     */
    public int key() {
        return 5;
    }

    /**
     * Perform actions.
     *
     * @param input   ask.
     * @param tracker Object Tracker.
     */
    public void execute(Input input, Tracker tracker) {
        String name = input.ask("Enter name");
        Item[] item = tracker.findByName(name);
        for (Item x : item) {
            if (x != null) {
                System.out.println(String.format("name - %s. description - %s. id - %s",
                        x.getName(), x.getDesc(), x.getId()));
            }
        }
    }

        /**
         * Display menu items.
         *
         * @return String menu item.
         */
        public String info () {
            return String.format("%s. %s", this.key(), "Find item by name");
        }
    }
class ExitProgram implements UserAction {
    /**
     * Method determines the uniqueness of the key.
     *
     * @return key
     */
    public int key() {
        return 6;
    }

    /**
     * Perform actions.
     *
     * @param input   ask.
     * @param tracker Object Tracker.
     */
    public void execute(Input input, Tracker tracker) {
        System.exit(0);
    }

    /**
     * Display menu items.
     *
     * @return String menu item.
     */
    public String info() {
        return String.format("%s. %s", this.key(), "Exit program");
    }
}