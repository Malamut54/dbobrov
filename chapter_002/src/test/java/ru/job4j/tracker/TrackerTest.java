package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by kvazimoda on 24.04.2017.
 */
public class TrackerTest {
    @Test
    public void TestGetAllItemFromArray() {
        Item[] result = new Item[2];
        Item item = new Item("tra-ta-ta", "withoutName", 123L);
        Item item1 = new Item("Obladi-oblada", "withoutSecondName", 1234L);
        Tracker tracker = new Tracker();
        result[0] = item;
        result[1] = item1;
        tracker.add(item);
        tracker.add(item1);
        assertThat(tracker.findAll(), is(result));
    }
    @Test
    public void TestAddItemToArray() {
        Tracker tracker = new Tracker();
        Item item = new Item("tra-ta-ta", "withoutName", 123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }
    @Test
    public void TestFindItemByStringID() {
        Tracker tracker = new Tracker();
        Item item = new Item("tra-ta-ta", "withoutName", 123L);
        Item item1 = new Item("Obladi-oblada", "withoutSecondName", 1234L);
        tracker.add(item);
        tracker.add(item1);
        Item result = tracker.findById(item1.getId());
        assertThat(result, is(item1));
    }
    @Test
    public void TestFindItemByStringName() {
        Tracker tracker = new Tracker();
        Item item = new Item("tra-ta-ta", "withoutName", 123L);
        Item item1 = new Item("da-da-di", "withoutName", 123L);
        Item item2 = new Item("Obladi-oblada", "withoutSecondName", 1234L);
        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);
        Item[] result = {item, item1};
        Item[] expected = tracker.findByName("withoutName");
        assertThat(result, is(expected));
    }
    @Test
    public void TestDeleteItemFromArray() {
        Tracker tracker = new Tracker();
        Item item = new Item("tra-ta-ta", "withoutName", 123L);
        Item item1 = new Item("Obladi-oblada", "withoutSecondName", 1234L);
        tracker.add(item);
        tracker.add(item1);
        Item[] result = {item, null};
        tracker.delete(item1);
        assertThat(result, is(tracker.findAll()));
    }
    @Test
    public void TestUpdateItemFromArray() {
        Tracker tracker = new Tracker();
        Item item = new Item("tra-ta-ta", "withoutName", 123L);
        tracker.add(item);
        String id = tracker.findAll()[0].getId();
        Item item1 = new Item(id, "withoutSecondName", 1234L);
        tracker.upddate(item1);
        assertThat(tracker.findAll()[0].getName(), is(item1.getName()));
    }
}
