package ir.mosi.rostam.productservice.messaging;

import ir.mosi.rostam.productservice.config.RabbitMQConfig;
import ir.mosi.rostam.productservice.messaging.message.CustomMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void listener(CustomMessage customMessage) {
        System.out.println(customMessage);
    }
}
