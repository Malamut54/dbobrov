package ru.job4j.proffesions;

/**
 *Task Professional.
 *@author Dmitriy Bobrov (mailto:bobrov.dmitriy@gmail.com)
 *@since 0.1
 */
public class Teacher extends Proffesions {
/**
 *Class Engeneer. Describes Engeneer.
 */

    /**
     *Engeneer constructor.
     *@param name name
     *@param age age
     *@param gender gender
     */
    public Teacher(String name, int age, boolean gender) {
        super(name, age, gender);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    /**
     *Method teach.
     *@param engeneer - Describe student.
     *@return String - returns text.
     */
    public String teach(Engeneer engeneer) {
        return "The teacher " + getName() + " teach " + engeneer.getName();
    }
}
