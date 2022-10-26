package org.bot.service;

import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * @author Artur Tomeyan
 * @date 26/10/2022
 */
public interface ConsumerService {

    void consumeTextMessageUpdates(Update update);

    void consumeDocMessageUpdates(Update update);

    void consumePhotoMessageUpdates(Update update);
}