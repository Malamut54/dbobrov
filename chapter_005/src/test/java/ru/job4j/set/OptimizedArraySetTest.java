package ru.job4j.set;

import org.junit.Test;

import java.util.Date;

/**
 * Task List.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 */

public class OptimizedArraySetTest {
    /**
     * Test perfomance.
     */
    @Test
    public void testPerfomanceSet() {
        ArraySet<String> slowSet = new ArraySet<>();
        OptimizedArraySet<String> fastSet = new OptimizedArraySet<>();


        Date startSlowSet = new Date();
        for (int i = 0; i < 10000; i++) {
            slowSet.add(String.valueOf(i));
        }
        slowSet.add("10001");
        Date finishSlowSet = new Date();
        long slowResult = finishSlowSet.getTime() - startSlowSet.getTime();
        System.out.println(String.format("Time on simple ArraySet = %s",
                slowResult));

        Date startFastSet = new Date();
        for (int i = 0; i < 10000; i++) {
            fastSet.add(String.valueOf(i));
        }
        fastSet.add("10001");
        Date finishFastSet = new Date();
        long fastResult = finishFastSet.getTime() - startFastSet.getTime();
        System.out.println(String.format("Time on OptimizedArraySet = %s",
                fastResult));
    }


}
