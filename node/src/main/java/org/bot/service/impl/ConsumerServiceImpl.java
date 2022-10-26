package org.bot.service.impl;

import lombok.extern.log4j.Log4j;
import org.bot.service.ConsumerService;
import org.bot.service.ProducerService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import static org.bot.model.RabbitQueue.*;

/**
 * @author Artur Tomeyan
 * @date 26/10/2022
 */
@Service
@Log4j
public class ConsumerServiceImpl implements ConsumerService {

    private final ProducerService producerService;

    public ConsumerServiceImpl(ProducerService producerService) {
        this.producerService = producerService;
    }

    @Override
    @RabbitListener(queues = TEXT_MESSAGE_UPDATE)
    public void consumeTextMessageUpdates(Update update) {
        log.debug("Node: text message");

        Message message = update.getMessage();
        SendMessage sendMessage = new SendMessage();

        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText("Hello from node");
        producerService.produceAnswer(sendMessage);
    }

    @Override
    @RabbitListener(queues = DOC_MESSAGE_UPDATE)
    public void consumeDocMessageUpdates(Update update) {
        log.debug("Node: doc message");
    }

    @Override
    @RabbitListener(queues = PHOTO_MESSAGE_UPDATE)
    public void consumePhotoMessageUpdates(Update update) {
        log.debug("Node: photo message");
    }
}
