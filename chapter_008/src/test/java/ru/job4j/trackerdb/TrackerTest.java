package ru.job4j.trackerdb;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Dmitriy Bobrov (mailto:bobrov.dmitriy@gmail.com)
 * @version $id$
 * @since 0.1
 */
public class TrackerTest {
    /**
     * Drop table.
     */
    @Before
    public void cleanDB() {
        StartUITest startUITest = new StartUITest();
        startUITest.cleanDatabase();
    }

    /**
     * Test. Get all Item from array.
     */
    @Test
    public void testFindAllItemFromArray() {
        List<Item> result = new ArrayList<Item>();
        Item item = new Item(1, "tra-ta-ta", "withoutName");
        Item item1 = new Item(2, "Obladi-oblada", "withoutSecondName");
        Tracker tracker = new Tracker();
        result.add(item);
        result.add(item1);
        tracker.add(item);
        tracker.add(item1);
        assertThat(tracker.findAll(), is(result));
    }

    /**
     * Test. Add one item to array.
     */
    @Test
    public void testAddItemToArray() {
        Tracker tracker = new Tracker();
        Item item = new Item(1, "tra-ta-ta", "withoutName");
        tracker.add(item);
        assertThat(tracker.findAll().get(0), is(item));
    }

    /**
     * Test. Find item by id.
     */
    @Test
    public void testFindItemByStringID() {
        Tracker tracker = new Tracker();
        Item item = new Item(1, "tra-ta-ta", "withoutName");
        Item item1 = new Item(2, "Obladi-obla-da", "withoutSecondName");
        tracker.add(item);
        tracker.add(item1);
        Item result = tracker.findById(item1.getId());
        assertThat(result, is(item1));
    }

    /**
     * Test. Find item by name.
     */
    @Test
    public void testFindItemByStringName() {
        Tracker tracker = new Tracker();
        Item item = new Item(1, "tra-ta-ta", "withoutName");
        Item item1 = new Item(2, "tra-ta-ta", "withoutName");
        Item item2 = new Item(3, "Obladi-oblada", "withoutSecondName");
        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);
        ArrayList<Item> result = new ArrayList<Item>();
        result.add(item);
        result.add(item1);
        ArrayList<Item> expected = tracker.findByName("tra-ta-ta");
        assertThat(result, is(expected));
    }

    /**
     * Test. Delete item from array.
     */
    @Test
    public void testDeleteItemFromArray() {
        Tracker tracker = new Tracker();
        Item item = new Item(1, "tra-ta-ta", "withoutName");
        Item item1 = new Item(2, "Obladi-oblada", "withoutSecondName");
        Item item2 = new Item(3, "Obladi-oblada", "withoutSecondName");
        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);
        ArrayList<Item> result = new ArrayList<Item>();
        result.add(item);
        result.add(item2);
        tracker.delete(item1);
        assertThat(result, is(tracker.findAll()));
    }

    /**
     * Test. Update item from array.
     */
    @Test
    public void testUpdateItemFromArray() {
        Tracker tracker = new Tracker();
        Item item = new Item(1, "tra-ta-ta", "withoutName");
        tracker.add(item);
        Integer id = tracker.findAll().get(0).getId();
        Item item1 = new Item(id, "bla-bla-bla", "obladi-oblada");
        tracker.upddate(item1);
        assertThat(tracker.findAll().get(0).getName(), is(item1.getName()));
    }
}