package cz.tul;

import cz.tul.configuration.JpaConfiguration;
import cz.tul.configuration.MongoConfiguration;
import cz.tul.data.Bill;
import cz.tul.data.User;
import cz.tul.repositories.BaseBillRepository;
import cz.tul.repositories.BaseUserRepository;
import cz.tul.services.BillService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import java.util.UUID;

@SpringBootApplication(exclude = {
        MongoAutoConfiguration.class,
        MongoDataAutoConfiguration.class,
        MongoRepositoriesAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class,
        DataSourceAutoConfiguration.class,
        JpaRepositoriesAutoConfiguration.class})
@Import({JpaConfiguration.class, MongoConfiguration.class})
public class Main {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Main.class);
        ConfigurableApplicationContext context = application.run(args);
        BaseBillRepository billRepository = context.getBean(BaseBillRepository.class);
        BaseUserRepository userRepository = context.getBean(BaseUserRepository.class);

        User u = userRepository.save(new User(UUID.randomUUID(), "jarda", 28));
        Bill b = billRepository.save(new Bill(UUID.randomUUID(), 250, u));


        System.out.println(billRepository.findOne(b.getId()));
        context.getBean(BillService.class).listBills().forEach(System.out::println);
    }

}
