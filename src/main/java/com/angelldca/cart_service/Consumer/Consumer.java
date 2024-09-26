package com.angelldca.cart_service.Consumer;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

@Component
@Slf4j
public class Consumer {
    private CountDownLatch latch = new CountDownLatch(1);
    private Map<String, Object> lastMessage;
    @RabbitListener(queues = {"${angelldca.queue.name}"})
    public void receiver(@Payload Map<String, Object> productData ){
        log.info("Recived message: "+ productData);
        makeSlow();
        latch.countDown();
        this.saveMessage(productData);
    }


    private void makeSlow(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public CountDownLatch getLatch() {
        return latch;
    }

    public void saveMessage(Map<String, Object> message) {
        this.lastMessage = message;
    }

    public Map<String, Object> getLastMessage() {
        return lastMessage;
    }
}
