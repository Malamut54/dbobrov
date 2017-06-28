package ru.job4j.finaltasktcolllite;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Task sort department.
 */
public class Department {

    /**
     * Fill list.
     *
     * @param dep input list.
     * @return output list.
     */
    public List<String> fillDeprt(List<String> dep) {
        List<String> result = new ArrayList<>(dep);
        String temp;
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).contains("\\")) {
                temp = result.get(i).substring(0, result.get(i).lastIndexOf("\\"));
                if (!result.contains(temp)) {
                    result.add(temp);
                }
            }
        }
        return result;
    }

    /**
     * Sort by ascending.
     * @param srcDep source list.
     * @return sorted by ascending.
     */
    public List<String> sortByAscending(List<String> srcDep) {
        List<String> resultAsc = new ArrayList<>(this.fillDeprt(srcDep));
        resultAsc.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        return resultAsc;
    }

    /**
     * Sort by descending.
     * @param srcDep source list.
     * @return sorted by descending.
     */
    public List<String> sortByDescending(List<String> srcDep) {
        List<String> resultAsc = new ArrayList<>(this.fillDeprt(srcDep));
        resultAsc.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int result = 0;

                int left = o1.length();
                int right = o2.length();
                int size = left > right ? left : right;

                for (int index = 0; index != size; index++) {
                    if (left > index && right > index) {
                        Character char1 = o1.charAt(index);
                        Character char2 = o2.charAt(index);

                        result = -char1.compareTo(char2);
                        if (result != 0) {
                            break;
                        }
                    } else if (left > index) {
                        result = 1;
                        break;
                    } else {
                        result = -1;
                        break;
                    }
                }
                return result;
            }
        });
        return resultAsc;
    }
}

