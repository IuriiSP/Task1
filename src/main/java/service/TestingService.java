package service;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.springframework.core.io.ClassPathResource;
import pojo.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class TestingService {
    private int questionsCount = 0;
    private List<String> answers = Arrays.asList("a", "b", "c");

    public void startTesting(User user) {
        if (user == null)
            throw new IllegalArgumentException("Не удалось начать тест, т.к. поользователь какая-то хуита");

        prepareQuestionsFromCSV();
        // вот этот блок кода не пашет и пишет, что стрим закрыт
        // если ранее Stream открывался и потом закрылся
        // UserService.createUser()
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            for (int i = 0; i < questionsCount; i++){
                user.getUserAnswers().add(bufferedReader.readLine());

            }
//            String answer = bufferedReader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        int rightAnswersCount = 0;
        for (int i = 0; i < answers.size(); i++){
            if (answers.get(i).equals(user.getUserAnswers().get(i))) rightAnswersCount++;
        }
        double rightAnswersPercent = (double)rightAnswersCount / (double)answers.size() * 100;
        boolean isDone = false;
        if (answers.equals(user.getUserAnswers())) isDone = true;
        System.out.println(user.toString() + " Тест сдан? " + isDone + "; верных ответов: "
                + rightAnswersCount + " , процент выполнения теста составил:" + Math.round(rightAnswersPercent) + "%");

    }

    public void prepareQuestionsFromCSV() {
        try {
            ClassPathResource classPathResource = new ClassPathResource("/CSVTest.csv");
            InputStream inputStream = classPathResource.getInputStream();
            CSVParser parser = (new CSVParserBuilder()).withSeparator(';').build();
            CSVReader reader = (new CSVReaderBuilder(new InputStreamReader(inputStream))).withSkipLines(1).withCSVParser(parser).build();
            //reader.readAll().forEach(this::createAndAddQuestionToList);
            List<String[]> strings = reader.readAll();
            questionsCount = strings.size();
            for (String[] row: strings) {
                showQuestionsFromRow(row);
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }

    private void showQuestionsFromRow(String[] row) {
        if (row == null || row.length < 4)
            throw new IllegalArgumentException("Array length < 4 or null");

        System.out.println(row[0]);
        System.out.println(row[1]);
        System.out.println(row[2]);
        System.out.println(row[3]);
        System.out.println("---------------------------------------------");
    }
}
