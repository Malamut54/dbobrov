package ru.job4j.test;

import java.util.*;

/**
 * Created by kvazimoda on 20.06.2017.
 */

class Person {
    int age;

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }

    public Person(int age) {
        this.age = age;
    }
}

class ComparePerson implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.age - o2.age;
    }
}

public class Main {
    public static void main(String[] args) {
//        ComparePerson comparePerson = new ComparePerson();
//        Set<Person> set = new TreeSet<Person>(comparePerson);
//        set.add(new Person(4));
//        set.add(new Person(7));
//        set.add(new Person(1));
//        set.add(new Person(2));
//        for (Person o : set) {
//            System.out.println(o);
//        }


        ArrayList<String> states = new ArrayList<String>();
        states.add("Германия");
        states.add("Франция");
        states.add("Италия");
        states.add("Испания");

        ListIterator<String> listIter = states.listIterator();

        while (listIter.hasNext()) {

            System.out.println(listIter.next());
        }
        // сейчас текущий элемент - Испания
        // изменим значение этого элемента
        listIter.set("Португалия");
        // пройдемся по элементам в обратном порядке
        while (listIter.hasPrevious()) {

            System.out.println(listIter.previous());
        }
    }
}
