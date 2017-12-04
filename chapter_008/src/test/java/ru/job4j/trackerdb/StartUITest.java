package ru.job4j.trackerdb;

import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
     * Drop table.
     */
    @Before
    public void cleanDatabase() {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/tracker",
                    "trackeradmin", "12345678");
            statement = connection.createStatement();
            statement.execute("DROP TABLE item");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Test. Add new Item.
     */
    @Test
    public void addNewTask() {
        String[] add = {"0", "name", "desc", "y"};
        Tracker tracker = new Tracker();
        Input input = new StubInput(add);
        ConnectDB connectDB = new ConnectDB();
        new StartUI(tracker, input, connectDB).init();
        assertThat(tracker.findAll().get(0).getName(), is(add[1]));
    }


    /**
     * Test. Find all Items.
     */
    @Test
    public void finadAllItems() {
        String[] add = {"0", "name", "desc", "n", "0", "name2", "desc2", "y"};
        Tracker tracker = new Tracker();
        Input input = new StubInput(add);
        ConnectDB connectDB = new ConnectDB();
        new StartUI(tracker, input, connectDB).init();
        String[] result = {tracker.findAll().get(0).getName(), tracker.findAll().get(1).getName()};
        String[] expected = {"name", "name2"};
        assertThat(result, is(expected));
    }

    /**
     * Test. Find Item by ID.
     */
    @Test
    public void findItemById() {
        Item item = new Item("name", "descr");
        Tracker tracker = new Tracker();
        ConnectDB connectDB = new ConnectDB();
        tracker.add(item);
        String[] findById = {"4", "1", "y"};
        Input input = new StubInput(findById);
        new StartUI(tracker, input, connectDB).init();
        String result = tracker.findAll().get(0).getName();
        String expected = "name";
        assertThat(result, is(expected));
    }

    /**
     * Test. Delete Item by ID.
     */
    @Test
    public void deleteItemById() {
        Item item = new Item("name", "descr");
        Tracker tracker = new Tracker();
        ConnectDB connectDB = new ConnectDB();
        tracker.add(item);
        String[] del = {"3", "1", "y"};
        Input input = new StubInput(del);
        new StartUI(tracker, input, connectDB).init();
        Item result = tracker.findById(1);
        assertThat(result, is(nullValue()));
    }

    /**
     * Test. Find Item by name.
     */
    @Test
    public void findItemByName() {
        Item item0 = new Item("Fedor", "Descr");
        Item item1 = new Item("Dima", "Descr");
        ConnectDB connectDB = new ConnectDB();
        Tracker tracker = new Tracker();
        tracker.add(item0);
        tracker.add(item1);
        String[] find = {"5", "Fedor", "y"};
        Input input = new StubInput(find);
        new StartUI(tracker, input, connectDB).init();
        String result = tracker.findByName("Fedor").get(0).getName();
        ArrayList<Item> arrayList = new ArrayList();
        arrayList.add(item0);
        String expected = arrayList.get(0).getName();
        assertThat(result, is(expected));
    }

    /**
     * Test. Trows MenuOutException.
     *
     * @throws MenuOutException exception.
     */
    @Test(expected = MenuOutException.class)
    public void testMenuOutException() throws MenuOutException {
        Tracker tracker = new Tracker();
        ConnectDB connectDB = new ConnectDB();
        Input input = new StubInput(new String[]{"8"});
        new StartUI(tracker, input, connectDB).init();
    }
}
