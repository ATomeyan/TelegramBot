package org.bot.service;

import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * @author Artur Tomeyan
 * @date 25/10/2022
 */
public interface UpdateProducer {
    void produce(String rabbitQueue, Update update);
}