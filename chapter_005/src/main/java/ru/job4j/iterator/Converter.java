package ru.job4j.iterator;

import java.util.Iterator;

/**
 * Task Iterator Of Iterator.
 *
 * @author dbobrov
 * @since 05.07.2017
 */

public class Converter {
    /**
     * Private fields.
     */
    private Iterator<Integer> innerIterator;

    /**
     * Method converts Iterator Of Iterators to Iterator.
     *
     * @param it input Iterator of iterators.
     * @return Iterator.
     */
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        this.innerIterator = it.next();

        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return it.hasNext() || innerIterator.hasNext();
            }

            @Override
            public Integer next() {
                Integer result;
                if (innerIterator.hasNext()) {
                    result = innerIterator.next();
                } else {
                    innerIterator = it.next();
                    result = innerIterator.next();
                }
                return result;
            }
        };
    }
}




