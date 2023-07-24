package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.IOException;

public class MyTelegramBot extends TelegramLongPollingBot {

    private static final String BOT_USERNAME = "Andry77NassaBot";
    private static final String BOT_TOKEN = "6345077356:AAF7kZBHIBPbpNSmi_LP9F_uWmC2qsfQGqM";

    private static final String URL =
            "https://api.nasa.gov/planetary/apod?api_key=CZO7VsNR7m5yah930wurJT4IuRUB1F5WaGGzYu5b";

    public static long chat_id;

    public MyTelegramBot() throws TelegramApiException {
        //Создать API для ботов Telegram также просто, просто создайте новый экземпляр.
        // Помните, что один экземпляр может обрабатывать разных ботов,
        // но каждый бот может запускаться только один раз
        // (Telegram не поддерживает одновременные вызовы GetUpdates):
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        // если (ТИПЫ TelegramBotsApi) горят красным, наводим и импортируем, так же исключения если пишет
        // Теперь нам нужно зарегистрировать новый экземпляр нашего ранее созданного класса bot в api

        botsApi.registerBot(this); //  this это ссылка на объект этогоНашего класса
    }

    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        // мы проверяем содержит ли обновление смс
        if (update.hasMessage()) {
            chat_id = update.getMessage().getChatId();
            switch (update.getMessage().getText()) {
                //case "/help":
                case "привет":
                    sendMessage("Привет, я Андрея-бот! Высылаю картинки космоса.  " +
                            " Они сделаны на сайте NASA и обновляются раз в сутки. " +
                            "  пиши - старт");
                    break;
                case "старт":
                    try {
                        sendMessage(Utils.getUrl(URL));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                default:
                    sendMessage("Не пиши ХЕРНЮ ))))) пиши - привет");
            }
        }
    }


    private void sendMessage(String messageText) {
        SendMessage message = new SendMessage(); //  сообщение ответ пользователю
        message.setChatId(chat_id);
        message.setText(messageText);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}