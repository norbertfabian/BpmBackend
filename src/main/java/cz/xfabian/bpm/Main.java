package cz.xfabian.bpm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by Norbert Fábián on 5/25/2017.
 */

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
         ConfigurableApplicationContext context =  SpringApplication.run(Main.class, args);
         context.getBean(DataFiller.class).fillData();
    }
}
