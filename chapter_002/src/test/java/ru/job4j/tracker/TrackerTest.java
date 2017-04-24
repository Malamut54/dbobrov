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
        assertThat(tracker.getAll(), is(result));
    }
    @Test
    public void TestAddItemToArray() {
        Tracker tracker = new Tracker();
        Item item = new Item("tra-ta-ta", "withoutName", 123L);
        tracker.add(item);
        assertThat(tracker.getAll()[0], is(item));
    }
    @Test
    public void TestFindItemByStrinID() {
        Tracker tracker = new Tracker();
        Item item = new Item("tra-ta-ta", "withoutName", 123L);
        Item item1 = new Item("Obladi-oblada", "withoutSecondName", 1234L);
        tracker.add(item);
        tracker.add(item1);
        Item result = tracker.findById("Obladi-oblada");
        assertThat(result, is(item1));
    }
}
