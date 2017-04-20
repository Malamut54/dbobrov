package ru.job4j.proffesions;

/**
 * Create proffesions.
 */
public class Proffesions {
/**
 *Class Profeesions. Describes the profession.
 */

    /**
     * Private fileds.
     */
    private String name;
    /**
     * Private fileds.
     */
    private int age;
    /**
     * Private fileds gender.
     */
    private boolean gender;
    /**
     *Method work.
     */
    public void work() {

    }
    /**
     *proffesions constructor.
     *@param name name
     *@param age age
     *@param gender gender
     */
    public Proffesions(String name, int age, boolean gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    /**
     *Getter for name.
     *@return name.
     */
    public String getName() {
        return name;
    }
    /**
     *Getter for age.
     *@return age.
     */
    public int getAge() {
        return age;
    }
    /**
     *Getter for gender.
     *@return gender.
     */
    public boolean getGender() {
        return gender;
    }
}