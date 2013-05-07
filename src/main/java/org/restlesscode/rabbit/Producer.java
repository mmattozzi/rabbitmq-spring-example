package org.restlesscode.rabbit;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Required;

import java.util.Date;

public class Producer implements Runnable {

    protected AmqpTemplate amqpTemplate;

    @Required
    public void setAmqpTemplate(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    @Override
    public void run() {
        while (true) {
            MessageProperties messageProperties = new MessageProperties();
            messageProperties.setContentType("text/plain");
            Message message = new Message(new Date().toString().getBytes(), messageProperties);
            amqpTemplate.send(message);
            System.out.println("Sent message.");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
