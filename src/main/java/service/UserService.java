package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import pojo.User;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

//@Service
public class UserService implements IUserService {
    private TestingService service;
    private MessageSource messageSource;

    public UserService(TestingService service, MessageSource messageSource) {
        this.service = service;
        this.messageSource = messageSource;
    }

    public void startTest() {
        service.prepareQuestionsFromCSV();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите имя");
            printMessage("test.enterName",null);
            String name = reader.readLine();
            printMessage("test.enterLastName", null);
            String lastName = reader.readLine();
            User user = new User(name, lastName);

            for (int i = 0; i < service.getQuestions().size(); i++) {
                String[] transit = service.getQuestions().get(i);
                service.showQuestionsFromRow(transit);
                printMessage("test.selectAnswer", null);
                String answer = reader.readLine();
                user.getUserAnswers().add(answer);
            }

            int rightAnswersCount = 0;
            for (int i = 0; i < user.getUserAnswers().size(); i++) {
                if (service.getAnswers().get(i).equals(user.getUserAnswers().get(i))) rightAnswersCount++;
            }
            double rightAnswersPercent = (double) rightAnswersCount / (double) user.getUserAnswers().size() * 100;
            boolean isDone = false;
            if (service.getAnswers().equals(user.getUserAnswers())) isDone = true;
            System.out.println(user.toString() + (isDone ? ", тест сдан успешно" : ", тест не сдан, попробуйте еще раз")
                    + "\nверных ответов: "
                    + rightAnswersCount + "\nпроцент выполнения теста составил:"
                    + Math.round(rightAnswersPercent) + "%");
            printMessage("test.ended", new Integer[]{rightAnswersCount});

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void printMessage(String messageCode,Object[] parameters){
        System.out.println(messageSource.getMessage(messageCode,parameters, Locale.ENGLISH));
    }

}
