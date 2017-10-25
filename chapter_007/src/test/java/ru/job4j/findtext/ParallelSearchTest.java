package ru.job4j.findtext;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * Task parallel search.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 24.10.2017
 */

public class ParallelSearchTest {
    /**
     * Demo.
     */
    @Test
    public void searchText() {
        List<String> ext = new ArrayList<>();
        ext.add(".conf");
        ext.add(".sh");
        ext.add(".schema");
        ParallelSearch parallelSearch = new ParallelSearch();
        System.out.println(parallelSearch.searchText("H:\\job4j", "backup", ext));
    }

}