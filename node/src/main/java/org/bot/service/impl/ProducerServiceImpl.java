package org.bot.service.impl;

import org.bot.service.ProducerService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import static org.bot.model.RabbitQueue.ANSWER_MESSAGE;

/**
 * @author Artur Tomeyan
 * @date 26/10/2022
 */
@Service
public class ProducerServiceImpl implements ProducerService {

    private final RabbitTemplate rabbitTemplate;

    public ProducerServiceImpl(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void produceAnswer(SendMessage sendMessage) {

        rabbitTemplate.convertAndSend(ANSWER_MESSAGE, sendMessage);
    }
}