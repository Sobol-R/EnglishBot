import java.util.ArrayList;

public class Words {
    static Bot bot = new Bot();

    public void vegetablesFruits(String text, long chatid) {
        bot.sendText("Повторяй и запоминай эти слова:", chatid);
        bot.sendText("banana - банан \n apple - яблоко \n апельсин - orange", chatid);
    }

    public void thingsFurniture(String text, long chatid) {
        bot.sendText("Повторяй и запоминай эти слова:", chatid);
        bot.sendText("furniture - мебель \n sofa - диван \n armchair - кресло", chatid);
    }
    public void ownWords(String text, long chatid) {
        ArrayList<String> ownWords = new ArrayList<>();
        bot.sendText("Напиши мне слова, которые тебе необходимо запомнить, я буду напоминать о них через заданное тобою время", chatid);
    }
}
