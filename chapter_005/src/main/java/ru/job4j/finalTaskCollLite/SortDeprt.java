package ru.job4j.finalTaskCollLite;

import java.util.ArrayList;
import java.util.List;

/**
 * Task sort department
 */
public class SortDeprt implements Comparable<String>{
    private List<String> inputDeartment;

    public List<String> fillDeprt (List<String> dep) {
        List<String> result = new ArrayList<>(dep);
        String temp;
        for(int i = 0; i < result.size(); i++) {
            if (result.get(i).contains("\\")) {
                temp = result.get(i).substring(0, result.get(i).lastIndexOf("\\"));
                if (!result.contains(temp)) {
                    result.add(temp);
                }
            }
        }
        return result;
    }

    public List<String> ascendingSort(List<String> dep) {
        List<String> ascResult = new ArrayList<>();
        List<String> temp  = this.fillDeprt(dep);

    }

}
