import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Iperson;
import pojo.Person;

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
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        Iperson iperson = context.getBean(Iperson.class);

        //TODO: вынести в отдельный сервис\метод логику создания класса Person
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите имя");
        String name = consoleReader.readLine();
        System.out.println("введите фамилию");
        String lastName = consoleReader.readLine();
        Person ivan = iperson.getPerson(name, lastName);
        System.out.println(ivan.getName() + " " + ivan.getLastName());
        //TODO: файл для приложения хранить в ресурсах приложения
        // https://mkyong.com/spring/spring-read-file-from-resources-folder/
        // ПОДГОТОВИТЬ НОРМАЛЬНЫЙ CSV ФАЙЛ!!! в конце
        BufferedReader reader = new BufferedReader(new FileReader("D:\\Java\\CSVTest.csv"));
        String s = null;
        List<String> answers = Arrays.asList("a", "b", "c");


        //TODO: вынести в отдельный сервис\метод для проведения теста с пользователем
        while (reader.ready()){
            s = reader.readLine().replace(';',' ');
            if (!s.isEmpty()){
                System.out.println(s);
            }
            else{
                System.out.println("Please, give me an answer");
                ivan.userAnswers.add(consoleReader.readLine());
            }
        }
        // всегда ли сработает? помни об этом когда будешь переписывать!
        reader.close();

        System.out.println("Please, give me an answer");
        ivan.userAnswers.add(consoleReader.readLine());
        consoleReader.close();

        if (answers.equals(ivan.userAnswers)){
            System.out.println(ivan.getName() + " " + ivan.getLastName() + " " + ", тест пройден");
        }
        else System.out.println(ivan.getName() + " " + ivan.getLastName() + " " + ", попробуйте еще раз");
    }

}
