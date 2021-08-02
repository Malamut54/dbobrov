package ru.job4j.concurrency.fifth;

import static org.assertj.core.api.Assertions.*;


import org.junit.Test;

public class CASCountTest {

    @Test
    public void checkCount() throws InterruptedException {
        CASCount casCount = new CASCount();

        Thread threadOne = new Thread(casCount::increment);
        Thread threadTwo = new Thread(casCount::increment);
        Thread threadThree = new Thread(casCount::increment);

        threadOne.start();
        threadTwo.start();
        threadThree.start();

        threadOne.join();
        threadTwo.join();
        threadThree.join();

        assertThat(casCount.get()).isEqualTo(3);
    }
}