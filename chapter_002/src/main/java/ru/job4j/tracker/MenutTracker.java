package ru.job4j.tracker;

/**
 * Created by kvazimoda on 02.05.2017.
 */
public class MenutTracker {

    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[5];

    public MenutTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.actions[0] = new AddItem(this.input, this.tracker);
    }
    
    public void show() {
        for (UserAction action : this.actions) {
            System.out.println(action.info());
        }
    }
    
    private class AddItem implements UserAction {
        public int key() {
            return 0;
        }
        public void execute(Input input, Tracker tracker) {
            String id = "0";
            String name = input.ask("Enter your name");
            String descritpion = input.ask("Enter Description");
            tracker.add(new Item(id, name, descritpion));
        }
        public String info() {
            return String.format("%s, %s", this.key(), "Add new Item");
        }
    }
}
