package ru.job4j.nonblock;

import org.junit.Test;

import static junit.framework.TestCase.assertNull;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Task non blocking cache.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 10.11.2017
 */

public class CacheTest {
    /**
     * Add model.
     */
    @Test
    public void addModel() {
        Cache cache = new Cache();
        Model model = new Model("Test");
        cache.add(1, model);
        assertThat(cache.get(1), is(model));
    }

    /**
     * Delete model.
     */
    @Test
    public void deleteMessage() {
        Cache cache = new Cache();
        Model model = new Model("Test");
        cache.add(1, model);
        cache.delete(1);
        assertNull(cache.get(1));
    }

    /**
     * Update model.
     */
    @Test
    public void updateModel() {
        Cache cache = new Cache();
        Model model = new Model("Test");
        cache.add(1, model);
        Model updateModel = new Model("TestNew");
        try {
            cache.update(1, updateModel);
        } catch (OptimisticException e) {
            e.printStackTrace();
        }
        assertThat(cache.get(1), is(updateModel));
    }

}
