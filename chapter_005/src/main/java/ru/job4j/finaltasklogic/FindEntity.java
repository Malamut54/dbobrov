package ru.job4j.finaltasklogic;

import java.util.ArrayList;
import java.util.List;

/**
 * Task Find the dependence.
 *
 * @author Dmitriy Bobrov (bobrov.dmitriy@gmail.com)
 * @since 07.09.2017
 */

public class FindEntity {
    /**
     * Method finding dependency.
     *
     * @param input List.
     * @return List.
     */
    public List<String> parser(List<String> input) {
        List<String> output = new ArrayList<>();
        Integer entity = 0;
        Integer dependence = 0;
        for (int i = 0; i < input.size(); i++) {
            entity = Integer.parseInt(input.get(i).substring(0, 1));
            dependence = Integer.valueOf(input.get(i).substring(1));
            for (int j = 0; j < input.size(); j++) {
                if (entity == Integer.valueOf(input.get(j).substring(1)) && dependence == Integer.valueOf(input.get(j).substring(0, 1))) {
                    input.remove(i);
                    output.add(String.valueOf(entity + " " + dependence + " " + entity));
                    i = 0;
                    break;
                }
            }
        }
        return output;
    }
}
