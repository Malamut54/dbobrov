package ru.job4j.finalTaskCollLite;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Task sort department
 */
public class Department {

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

    public List<String> sortByDescending(List<String> srcDep) {
        List<String> resultAsc = new ArrayList<>(this.fillDeprt(srcDep));
        resultAsc.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int result = 0;

                int left = o1.length();
                int right = o1.length();
                int size = left > right ? left : right;
                for (int i = 0; i != size; i++) {
                    if (left > i && right > i) {
                        result = -o2.substring(i, i).compareTo(o1.substring(i, i));
                        if (result != 0) {
                            break;
                        } else if (left > i) {
                            result = -1;
                            break;
                        } else {
                            result = 1;
                            break;
                        }
                    }
                }
                return result;
            }
        });
        return resultAsc;
    }
}

