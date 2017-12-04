package ru.job4j.trackerdb;

/**
 * Task Tracker.
 */

import java.util.ArrayList;

/**
 * Class Menutracker. Provides menu operation.
 */
public class MenuTracker {

    /**
     * Private fields.
     */
    private Input input;
    /**
     * Private fields.
     */
    private Tracker tracker;
    /**
     * Private fields.
     */
    private ArrayList<UserAction> actions = new ArrayList<UserAction>();

    /**
     * Constructor Menutracker.
     *
     * @param input   Input.
     * @param tracker Tracker.
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Method fills the array.
     */
    public void fillActions() {
        this.actions.add(new AddItem("Add New Item", 0));
        this.actions.add(new ShowItems("Show all items", 1));
        this.actions.add(new EditItem("Edit item", 2));
        this.actions.add(new DeleteItem("Delete item", 3));
        this.actions.add(new FindItemByID("Find item by Id", 4));
        this.actions.add(new FindItemByName("Find item by name", 5));
        this.actions.add(new ExitProgram("Exit program", 6));
    }

    /**
     * Range of valid values.
     *
     * @return arr.
     */
    public ArrayList<Integer> rangekey() {
        ArrayList<Integer> range = new ArrayList<Integer>();
        for (int i = 0; i < this.actions.size(); i++) {
            range.add(i);
        }
        return range;
    }

    /**
     * Method select key from array.
     *
     * @param key item.
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Method display menu.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * class AddItem. Add item.
     */
    private class AddItem extends BaseAction {
        /**
         * Constructor.
         *
         * @param name Name of the menu item.
         * @param key  Number of the menu item.
         */
        AddItem(String name, int key) {
            super(name, key);
        }

        /**
         * Perform actions.
         *
         * @param input   ask.
         * @param tracker Object Tracker.
         */
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Enter your name");
            String descritpion = input.ask("Enter Description");
            tracker.add(new Item(name, descritpion));
        }

    }

    /**
     * class ShowItems. Display all items.
     */
    private static class ShowItems extends BaseAction {
        /**
         * Constructor.
         *
         * @param name Name of the menu item.
         * @param key  Number of the menu item.
         */
        ShowItems(String name, int key) {
            super(name, key);
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

    }

    /**
     * class EditItem. Edit item.
     */
    private class EditItem extends BaseAction {
        /**
         * Constructor.
         *
         * @param name Name of the menu item.
         * @param key  Number of the menu item.
         */
        EditItem(String name, int key) {
            super(name, key);
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
            tracker.upddate(new Item(Integer.parseInt(id), name, desc));

        }

    }

    /**
     * class DeleteItem. Delete item.
     */
    private class DeleteItem extends BaseAction {
        /**
         * Constructor.
         *
         * @param name Name of the menu item.
         * @param key  Number of the menu item.
         */
        DeleteItem(String name, int key) {
            super(name, key);
        }

        /**
         * Perform actions.
         *
         * @param input   ask.
         * @param tracker Object Tracker.
         */
        public void execute(Input input, Tracker tracker) {
            Integer id = Integer.parseInt(input.ask("Enetr Id items for delete"));
            tracker.delete(tracker.findById(id));
        }

    }
//

    /**
     * class FindItemByID. Find item by ID.
     */
    private class FindItemByID extends BaseAction {
        /**
         * Constructor.
         *
         * @param name Name of the menu item.
         * @param key  Number of the menu item.
         */
        FindItemByID(String name, int key) {
            super(name, key);
        }

        /**
         * Perform actions.
         *
         * @param input   ask.
         * @param tracker Object Tracker.
         */
        public void execute(Input input, Tracker tracker) {
            int id = Integer.parseInt(input.ask("Enter id"));
        }

    }

    /**
     * class FindItemByName. Find item by Name.
     */
    private class FindItemByName extends BaseAction {
        /**
         * Constructor.
         *
         * @param name Name of the menu item.
         * @param key  Number of the menu item.
         */
        FindItemByName(String name, int key) {
            super(name, key);
        }

        /**
         * Perform actions.
         *
         * @param input   ask.
         * @param tracker Object Tracker.
         */
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Enter name");
            ArrayList<Item> item = tracker.findByName(name);
            for (Item x : item) {
                if (x != null) {
                    System.out.println(String.format("name - %s. description - %s. id - %s",
                            x.getName(), x.getDesc(), x.getId()));
                }
            }
        }

    }

    }

    /**
     * class ExitProgram. Exit program.
     */
    class ExitProgram extends BaseAction {
        /**
         * Constructor.
         *
         * @param name Name of the menu item.
         * @param key  Number of the menu item.
         */
        ExitProgram(String name, int key) {
            super(name, key);
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

    }


