import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.IUserService;
import service.UserService;

public class Main {

    public static void main(String[] args) {
//        UserService service = new UserService();
//        service.startTest();
        ApplicationContext context = new AnnotationConfigApplicationContext("service");
        UserService userService = context.getBean(UserService.class);
        userService.startTest();
    }
}
