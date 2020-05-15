import pojo.User;
import service.TestingService;
import service.UserService;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        //User user = new UserService().createUser();

        new TestingService().startTesting(new UserService().createUser());
    }
}
