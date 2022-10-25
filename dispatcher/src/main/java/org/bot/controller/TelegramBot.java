package org.bot.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * @author Artur Tomeyan
 * @date 20/10/2022
 */
@Component

public class TelegramBot extends TelegramLongPollingBot {

    private static final Logger logger = Logger.getLogger(TelegramBot.class);
    @Value("${bot.name}")
    private String botName;

    @Value("${bot.token}")
    private String botToken;

    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        logger.debug(message.getText());

        SendMessage response = new SendMessage();
        response.setChatId(message.getChatId().toString());
        response.setText("Hello from BOT");
        sendAnswerMessage(response);
    }

    private void sendAnswerMessage(SendMessage sendMessage){
        if (sendMessage != null){
            try {
                execute(sendMessage);
            } catch (TelegramApiException e){
                logger.error(e);
            }
        }
    }
}