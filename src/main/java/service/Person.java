package service;

import java.util.ArrayList;

public class Person {
    private final String name;
    private final String lastName;
    public ArrayList<String> userAnswers = new ArrayList<String>();

    public Person(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }
}
