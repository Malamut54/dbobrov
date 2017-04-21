package ru.job4j.proffesions;

/**
 *Task Professional.
 *@author Dmitriy Bobrov (mailto:bobrov.dmitriy@gmail.com)
 *@since 0.1
 */
public class Engeneer extends Proffesions {
/**
 *Class Engeneer. Describes Engeneer.
 */

    /**
     *Engeneer constructor.
     *@param name name
     *@param age age
     *@param gender gender
     */
    public Engeneer(String name, int age, boolean gender) {
        super(name, age, gender);
    }
    @Override
    public String getName() {
        return super.getName();
    }
    /**
     *Method teach.
     *@param people - Describe student.
     *@return String - returns text.
     */
    public String teach(Proffesions people) {
        return String.format("The engeneer %s teach %s", getName(), people.getName());
    }

    /**
     *Method twistNuts.
     */
    public void twistNuts() {

    }
    /**
     *Method dig.
     */
    public void dig() {

    }

}
