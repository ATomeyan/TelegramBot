package org.bot.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

/**
 * @author Artur Tomeyan
 * @date 26/10/2022
 */
public interface ProducerService {

    void produceAnswer(SendMessage sendMessage);
}