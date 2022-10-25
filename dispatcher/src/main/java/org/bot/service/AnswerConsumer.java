package org.bot.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

/**
 * @author Artur Tomeyan
 * @date 25/10/2022
 */
public interface AnswerConsumer {
    void consume(SendMessage sendMessage);
}
