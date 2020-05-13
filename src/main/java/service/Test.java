package service;

import pojo.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class Test {

//    BufferedReader reader = new BufferedReader(new FileReader("D:\\Java\\CSVTest.csv"));
//    String s = null;
//    List<String> answers = Arrays.asList("a", "b", "c");
//     while (reader.ready()){
//            s = reader.readLine().replace(';',' ');
//            if (!s.isEmpty()){
//                System.out.println(s);
//            }
//            else{
//                System.out.println("Please, give me an answer");
//                person.getGetUserAnswers().add(consoleReader.readLine());
//            }
//        }
//        // всегда ли сработает? помни об этом когда будешь переписывать!
//        reader.close();
//
//        System.out.println("Please, give me an answer");
//        person.getGetUserAnswers().add(consoleReader.readLine());
//        consoleReader.close();
//        if (answers.equals(person.getGetUserAnswers())){
//        System.out.println(person.getName() + " " + person.getLastName() + " " + ", тест пройден");
//    }
//        else System.out.println(person.getName() + " " + person.getLastName() + " " + ", попробуйте еще раз");
//}
    private List<String> answers = Arrays.asList("a", "b", "c");


    public static void testing (Person person) throws IOException {
//        String pathForTestQuestions = "C:\\Users\\Admin\\IdeaProjects\\Task1\\src\\main\\resources\\CSVTest.csv";
//
//        public void initQuestionsFromCSV() {
//            this.questions = new ArrayList();
//            try {
//                InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(pathForTestQuestions);
//                CSVParser parser = (new CSVParserBuilder()).withSeparator(';').build();
//                CSVReader reader = (new CSVReaderBuilder(new InputStreamReader(inputStream))).withSkipLines(1).withCSVParser(parser).build();
//                reader.readAll().forEach(row -> createAndAddQuestionToList(row));
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        }
        System.out.println("и чего-то тут крутится, тестируется");
        System.out.println("и вот тебе результат, " + person.toString());
    }
}
