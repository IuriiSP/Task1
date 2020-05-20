import config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.IUserService;
import service.UserService;

public class Main {

    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext("service");
//        IUserService userService = context.getBean(IUserService.class);
//        userService.startTest();
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();

        UserService service = ctx.getBean(UserService.class);
        service.startTest();
    }
}
