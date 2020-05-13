import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Person;
import service.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {

    //TODO: убрать всю бизнес логику из класса main!
    public static void main(String[] args) throws IOException {
        //TODO: для класса Person убрать все абстракции, это просто объект который не нуждается на данный момент в обертках, т.к.
        //        ОНИ НЕ СОДЕРЖАТ НИКАКОЙ ЛОГИКИ!!!
        // вместо этого реализовать сервисы и их вызовы из класса main
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");


        //TODO: вынести в отдельный сервис\метод логику создания класса Person
        Person person = null;
        try {
            person = Person.createPerson();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Test.testing(person);
        //TODO: файл для приложения хранить в ресурсах приложения
        // https://mkyong.com/spring/spring-read-file-from-resources-folder/
        // ПОДГОТОВИТЬ НОРМАЛЬНЫЙ CSV ФАЙЛ!!! в конце


        //TODO: вынести в отдельный сервис\метод для проведения теста с пользователем
//


    }
}
