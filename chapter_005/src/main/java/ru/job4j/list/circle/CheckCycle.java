package ru.job4j.list.circle;

/**
 * Task Cycle.
 *
 * @param <T>
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 24.07.2017
 */

public class CheckCycle<T> {
    /**
     * Method check Cycle in LinkedList.
     *
     * @param first input node.
     * @return boolean, if true cycle is exist.
     */
    boolean hasCycle(Node<T> first) {
        /**
         * Slow pointer.
         */
        Node<T> tortoise = first;
        /**
         * Fast pointer.
         */
        Node<T> hare = first;

        while (hare != null) {
            hare = hare.next;
            if (hare.next == hare || hare.next == null) {
                return false;
            }
            hare = hare.next;
            tortoise = tortoise.next;
            if (hare == tortoise) {
                return true;
            }
        }
        return false;
    }
}
