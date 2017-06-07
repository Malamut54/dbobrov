package ru.job4j.PerfomanceColl;

import java.util.*;

/**
 * Task Measuring perfomance of collection.
 */
public class PerfomanceCollection {
    /**
     * Main class
     */

    /**
     * Private variable.
     */
    private long resultInMs;
    private long resultAdd;
    private long resultDel;

    /**
     * Add value to collection.
     *
     * @param collection Type of collection.
     * @param amount     Number of records.
     * @return
     */
    public long add(Collection<String> collection, int amount) {

        Date start = new Date();
        for (int i = 0; i < amount; i++) {
            collection.add(Integer.toString(i));
        }
        Date finish = new Date();
        return this.resultInMs = finish.getTime() - start.getTime();
    }

    /**
     * Delete value from collection.
     *
     * @param collection Type of collection.
     * @param amount     Number of records.
     * @return
     */
    public long delete(Collection<String> collection, int amount) {
        Iterator<String> iter = collection.iterator();
        Date start = new Date();
        for (int i = 0; i < amount; i++) {
            iter.hasNext();
            iter.next();
            iter.remove();
        }
        Date finish = new Date();
        return this.resultInMs = finish.getTime() - start.getTime();
    }

    public static void main(String[] args) {
        List<String> lnkL = new LinkedList<String>();
        List<String> arrL = new ArrayList<String>();
        Set<String> treS = new TreeSet<String>();

        PerfomanceCollection perf = new PerfomanceCollection();

        perf.resultAdd = perf.add(lnkL, 100000);
        perf.resultDel = perf.delete(lnkL, 30000);
        System.out.println(String.format("Time to Add 100000 records to LinkedList: %s ms and delete first 30000 records: %s ms",
                perf.resultAdd, perf.resultDel));

        perf.resultAdd = perf.add(arrL, 100000);
        perf.resultDel = perf.delete(arrL, 30000);
        System.out.println(String.format("Time to Add 100000 records to ArrayList: %s ms and delete first 30000 records: %s ms",
                perf.resultAdd, perf.resultDel));

        perf.resultAdd = perf.add(treS, 100000);
        perf.resultDel = perf.delete(treS, 30000);
        System.out.println(String.format("Time to Add 100000 records to TreeSet: %s ms and delete first 30000 records: %s ms",
                perf.resultAdd, perf.resultDel));


    }
}
