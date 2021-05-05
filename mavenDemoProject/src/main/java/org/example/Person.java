package org.example;
/**
 * Hello world!
 */


public class Person {

    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {

        Person fred = new Person("Tosin","Adeoyo", 200000);
        Person craig = new Person("Tosin","Adeoyo", 200000);
        Person wilma = new Person("Kale","Adeoyo", 200000);

        fred.getFirstName();

        System.out.println(fred.getFirstName());;
        System.out.println("Hello World!");

        System.out.println("Are they equal " + fred.equals(craig));
        System.out.println("Are they equal " + craig.equals(wilma));
        System.out.println(fred);
    }
}
