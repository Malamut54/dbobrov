package ru.job4j.proffesions;

/**
 *Task Professional.
 *@author Dmitriy Bobrov (mailto:bobrov.dmitriy@gmail.com)
 *@since 0.1
 */
public class Doctor extends Proffesions {
/**
 *Class Doctor. Describes Doctor.
 */

    /**
     *Doctor constructor.
     *@param name name
     *@param age age
     *@param gender gender
     */
    public Doctor(String name, int age, boolean gender) {
        super(name, age, gender);
    }
    @Override
    public String getName() {
        return super.getName();
    }

    /**
     *Method cure.
     *@param people - Describe student.
     *@return String - returns text.
     */
    public String cure(Proffesions people) {
        return String.format("The doctor %s treats %s", getName(), people.getName());
    }
}
