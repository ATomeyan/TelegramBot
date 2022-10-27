package org.bot.service;

import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * @author Artur Tomeyan
 * @date 27/10/2022
 */
public interface MainService {

    void processTextMessage(Update update);
}