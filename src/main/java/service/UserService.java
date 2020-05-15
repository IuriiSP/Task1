package service;

import pojo.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserService {

    public User createUser() {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите имя");
            String name = reader.readLine();
            System.out.println("введите фамилию");
            String lastName = reader.readLine();
//            reader.close();
            return new User(name, lastName);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }

//        return new User("1", "1");

    }
}
