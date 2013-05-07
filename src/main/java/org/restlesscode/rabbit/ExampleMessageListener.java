package org.restlesscode.rabbit;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class ExampleMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        System.out.println("Got message: " + new String(message.getBody()));
    }

}
