package ru.job4j.tracker;

import org.junit.Test;

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
     * Test. Get all Item from array.
     */
    @Test
    public void testGetAllItemFromArray() {
        Item[] result = new Item[3];
        Item item = new Item("tra-ta-ta", "withoutName", 123L);
        Item item1 = new Item("Obladi-oblada", "withoutSecondName", 1234L);
        Item item2 = new Item("Da-da-di-da", "withoutSecondName", 1234L);
        Tracker tracker = new Tracker();
        result[0] = item;
        result[1] = item1;
        result[2] = item2;
        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);
        assertThat(tracker.findAll(), is(result));
    }

    /**
     * Test. Add one item to array.
     */
    @Test
    public void testAddItemToArray() {
        Tracker tracker = new Tracker();
        Item item = new Item("tra-ta-ta", "withoutName", 123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }

    /**
     * Test. Find item by id.
     */
    @Test
    public void testFindItemByStringID() {
        Tracker tracker = new Tracker();
        Item item = new Item("tra-ta-ta", "withoutName", 123L);
        Item item1 = new Item("Obladi-oblada", "withoutSecondName", 1234L);
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
        Item item = new Item("tra-ta-ta", "withoutName", 123L);
        Item item1 = new Item("da-da-di", "withoutName", 123L);
        Item item2 = new Item("Obladi-oblada", "withoutSecondName", 1234L);
        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);
        Item[] result = {item, item1, null};
        Item[] expected = tracker.findByName("withoutName");
        assertThat(result, is(expected));
    }

    /**
     * Test. Delete item from array.
     */
    @Test
    public void testDeleteItemFromArray() {
        Tracker tracker = new Tracker();
        Item item = new Item("tra-ta-ta", "withoutName", 123L);
        Item item1 = new Item("Obladi-oblada", "withoutSecondName", 1234L);
        Item item2 = new Item("Da-da-di-da", "withoutSecondName", 1234L);
        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);
        tracker.delete(item1);
        Item[] expected = {item, item2, null};
        Item[] result = tracker.findAll();
        assertThat(result, is(expected));
    }

    /**
     * Test. Update item from array.
     */
    @Test
    public void testUpdateItemFromArray() {
        Tracker tracker = new Tracker();
        Item item = new Item("tra-ta-ta", "withoutName", 123L);
        tracker.add(item);
        String id = tracker.findAll()[0].getId();
        Item item1 = new Item(id, "withoutSecondName", 1234L);
        tracker.upddate(item1);
        assertThat(tracker.findAll()[0].getName(), is(item1.getName()));
    }
}
