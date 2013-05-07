package org.restlesscode.rabbit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RabbitExampleApp {

    public static void main(String[] args) {
        if (args.length == 0) return;
        if (args[0].equals("-p")) {
            ApplicationContext context = new ClassPathXmlApplicationContext("spring-producer-config.xml");
            Producer producer = (Producer) context.getBean("producer");
            producer.run();
        } else if (args[0].equals("-c")) {
            ApplicationContext context = new ClassPathXmlApplicationContext("spring-consumer-config.xml");
        }
    }

}
