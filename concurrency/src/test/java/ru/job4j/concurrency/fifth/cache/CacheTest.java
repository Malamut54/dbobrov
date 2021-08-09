package ru.job4j.concurrency.fifth.cache;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CacheTest {

    @Test
    void whenCacheEmptyFillOneBase() {
        Cache cache = new Cache();
        Base base = new Base(1, 1);
        base.setName("someName");
        assertThat(cache.add(base)).isTrue();

    }

    @Test
    void whenBaseExistSameBaseCantAddTwice() {
        Cache cache = new Cache();
        Base base = new Base(1, 1);
        base.setName("someName");

        assertThat(cache.add(base)).isTrue();
        assertThat(cache.add(base)).isFalse();
    }

    @Test
    void whenUpdateByDiffVersionNumberThrowOptimisticException() {
        Cache cache = new Cache();
        Base base = new Base(1, 1);
        base.setName("someName");

        cache.add(base);

        Base updBase = new Base(1, 0);
        base.setName("someName");
        assertThatThrownBy(() -> {
            cache.update(updBase);
        })
            .isInstanceOf(OptimisticException.class)
            .hasMessage("Error while update");
    }

    @Test
    void whenUpdateBySameVersionNumberThrowOptimisticException() {
        Cache cache = new Cache();
        Base base = new Base(1, 1);
        base.setName("someName");

        cache.add(base);

        Base updBase = new Base(1, 1);
        base.setName("someNewName");

        assertThat(cache.update(updBase)).isTrue();
    }

    @Test
    void deleteWhenBaseExist() {
        Cache cache = new Cache();
        Base base = new Base(1, 1);
        base.setName("someName");

        cache.add(base);
        assertThat(cache.delete(base)).isTrue();
    }

    @Test
    void deleteWhenBaseDoesNOtExist() {
        Cache cache = new Cache();
        assertThat(cache.delete(new Base(1, 1))).isFalse();
    }
}