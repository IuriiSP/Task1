import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.Iperson;
import service.Person;
import service.PersonSimple;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        Iperson iperson = context.getBean(Iperson.class);
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите имя");
        String name = consoleReader.readLine();
        System.out.println("введите фамилию");
        String lastName = consoleReader.readLine();
        Person ivan = iperson.getPerson(name, lastName);
        System.out.println(ivan.getName() + " " + ivan.getLastName());
        BufferedReader reader = new BufferedReader(new FileReader("D:\\Java\\CSVTest.csv"));
        String s = null;
        List<String> answers = Arrays.asList("a", "b", "c");

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
