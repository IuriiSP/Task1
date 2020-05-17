import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.IUserService;
import service.UserService;

public class Main {

    public static void main(String[] args) {
        UserService service = new UserService();
        service.startTest();
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
//        IUserService iUserService = context.getBean(IUserService.class);
//        iUserService.startTest();
    }
}
