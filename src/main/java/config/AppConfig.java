package config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import service.TestingService;
import service.UserService;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {
    @Bean
    TestingService testingService(){
        return new TestingService();
    }

    @Bean
    UserService userService(TestingService testingService, MessageSource messageSource){
        return new UserService(testingService, messageSource);
    }
}
