package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Dmitriy Bobrov (mailto:bobrov.dmitriy@gmail.com)
 * @version $id$
 * @since 0.1
 */
public class StartUITest {
    /**
     * Test. Add new Item.
     */
    @Test
    public void addNewTask() {
        String[] add = {"0", "name", "desc", "6"};
        Tracker tracker = new Tracker();
        Input input = new StubInput(add);
        new StartUI(tracker, input).init();
        assertThat(tracker.findAll()[0].getName(), is(add[1]));
    }
    /**
     * Test. Find all Items.
     */
    @Test
    public void finadAllItems() {
        String[] add = {"0", "name", "desc", "0", "name2", "desc2", "6"};
        Tracker tracker = new Tracker();
        Input input = new StubInput(add);
        new StartUI(tracker, input).init();
        String[] result = {tracker.findAll()[0].getName(), tracker.findAll()[1].getName()};
        String[] expected = {"name", "name2"};
        assertThat(result, is(expected));
    }

    /**
     * Test. Find Item by ID.
     */
    @Test
    public void findItemById() {
      Item item = new Item("123", "name", "descr");
      Tracker tracker = new Tracker();
      tracker.add(item);
      String id = item.getId();
      String[] edit = {"2", id, "newName", "descr", "6"};
      Input input = new StubInput(edit);
      new StartUI(tracker, input).init();
      String result = tracker.findAll()[0].getName();
      String expected = "newName";
      assertThat(result, is(expected));
    }

    /**
     * Test. Delete Item by ID.
     */
    @Test
    public void deleteItemById() {
        Item item = new Item("123", "name", "descr");
        Tracker tracker = new Tracker();
        tracker.add(item);
        String id = item.getId();
        String[] del = {"3", id, "6"};
        Input input = new StubInput(del);
        new StartUI(tracker, input).init();
        Item result = tracker.findById(id);
        assertThat(result, is(nullValue()));
    }

    /**
     * Test. Find Item by name.
     */
    @Test
    public void findItemByName() {
        Item item0 = new Item("123", "Fedor", "Descr");
        Item item1 = new Item("123", "Dima", "Descr");
        Tracker tracker  = new Tracker();
        tracker.add(item0);
        tracker.add(item1);
        String[] find = {"5", "Fedor", "6"};
        Input input = new StubInput(find);
        new StartUI(tracker, input).init();
        Item[] result = tracker.findByName("Fedor");
        Item[] expected = {item0, null};
        assertThat(result, is(expected));
    }
}
