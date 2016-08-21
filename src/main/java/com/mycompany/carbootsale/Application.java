package com.mycompany.carbootsale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main( String[] args ) {
        final ApplicationContext ctx = SpringApplication.run(Application.class, args);

        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                ((ConfigurableApplicationContext)ctx).close();
            }
        });
    }

}
