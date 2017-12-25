
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.api.objects.Location;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.security.URIParameter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Bot extends TelegramLongPollingBot {
    boolean normalMode = true;
    boolean answerMode = false;
    boolean answerMode1 = false;
    boolean answerMode2 = false;
    boolean answerMode3 = false;
    boolean answerMode4 = false;
    boolean answerMode5 = false;
    static Words words = new Words();
    static Repeat repeat = new Repeat();
    ArrayList<String> checkWords = new ArrayList<>();
    @Override
    public void onUpdateReceived(Update update) {
        String text = update.getMessage().getText();
        text = text.toLowerCase();
        long chatid = update.getMessage().getChatId();
        if (answerMode5 == true) {
            sendText("Выбери тематику новых слов", chatid);
            answerMode5 = false;
            answerMode4 = true;
        } else if (text.equals("/newords")) {
            sendText("Для начала необходимо определить твой уровень", chatid);
            sendText("Готов начать?", chatid);
            normalMode = false;
            answerMode = true;
        } else if (answerMode == true) {
            if (text.equals("да")) {
                sendText("Дай перевод словам", chatid);
                answerMode = false;
                sendText("car", chatid);
                answerMode1 = true;
            } else if (text.equals("нет")) {
                sendText("я подожду", chatid);
                answerMode = false;
            }
        } else if (answerMode1 == true) {

            if (text.equals("машина")) {
                checkWords.add("+");
            } else {
                checkWords.add("-");
            }
            answerMode1 = false;
            sendText("house", chatid);
            answerMode2 = true;
        } else if (answerMode2 == true) {

            if (text.equals("дом")) {
                checkWords.add("+");
            } else {
                checkWords.add("-");
            }
            answerMode2 = false;
            sendText("suit", chatid);
            answerMode3 = true;
        } else if (answerMode3 == true) {

            if (text.equals("костюм")) {
                checkWords.add("+");
            } else {
                checkWords.add("-");
            }
            answerMode3 = false;
            String collect = checkWords.toString();
            sendText("Ваши результаты: ", chatid);
            sendText(collect, chatid);
            checkWords.clear();
            sendText("Я определил твой уровень и готов начать обучение, тебе осталось выбрать тематику слов", chatid);
            answerMode4 = true;
        } else if (answerMode4 == true) {
            if (text.equals("овощи и фрукты")) {
                words.vegetablesFruits(text, chatid);
                repeat.repeatVegetablesFruits(text, chatid, update);
            } else if (text.equals("вещи и мебель")) {
                words.thingsFurniture(text, chatid);
                repeat.repeatThingsFurniture(text, chatid, update);
            } else if (text.equals("добавить свои слова")) {
                words.ownWords(text, chatid);
            }
        }
    }

    public void sendText(String text, long chatid) {
        SendMessage request =  new SendMessage();
        request.setText(text);
        request.setChatId(chatid);
        try {
            execute(request);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "SobEngBot";
        //возвращаем юзера
    }

    @Override
    public String getBotToken() {
        return "420131371:AAEKU-oO_oI7yAjspur5yZBJTFeufohDunk";
        //Токен бота
    }
}
