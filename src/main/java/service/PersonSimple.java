package service;

public class PersonSimple implements Iperson {

    public Person getPerson(String name, String lastName) {
        return new Person(name, lastName);
    }
}
