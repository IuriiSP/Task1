package pojo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Person {
    private final String name;
    private final String lastName;
    private ArrayList<String> getUserAnswers = new ArrayList<String>();

    public ArrayList<String> getGetUserAnswers() {
        return getUserAnswers;
    }

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

    public static Person createPerson () throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите имя");
        String n = reader.readLine();
        System.out.println("введите фамилию");
        String ln = reader.readLine();
        Person person = new Person(n, ln);
        reader.close();
        return person;
    }

    @Override
    public String toString() {
        return "уважаемый " + name + " " + lastName;
    }
}
