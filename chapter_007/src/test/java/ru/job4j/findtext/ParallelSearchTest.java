package ru.job4j.findtext;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * TODO: comment
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 24.10.2017
 */

public class ParallelSearchTest {
    @Test
    public void searchText() throws IOException {
        List<String> ext = new ArrayList<>();
        ext.add(".conf");
        ext.add(".db");
        ParallelSearch parallelSearch = new ParallelSearch();


        parallelSearch.searchText("H:\\job4j", "some text", ext);
    }

}