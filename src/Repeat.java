
import org.telegram.telegrambots.api.objects.Update;

import java.util.Timer;
import java.util.TimerTask;

public class Repeat {
    Timer timer = null;
    static Bot bot = new Bot();
    static Words words = new Words();
    int count = 0;
   public void repeatVegetablesFruits(String text, long chatid, Update update) {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
       timer = new Timer();
        count = 0;
       timer.schedule(new TimerTask() {
           @Override
           public void run() {
               words.vegetablesFruits(text, chatid);
               count++;
               if (count > 5) {
                   timer.cancel();
                   next(update);
               }
           }
       }, 5000, 5000);

    }
    public void repeatThingsFurniture(String text, long chatid, Update update) {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        timer = new Timer();
        count = 0;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                words.vegetablesFruits(text, chatid);
                count++;
                if (count > 5) {
                    timer.cancel();
                    next(update);
                }
            }
        }, 5000, 5000);

    }
    public void next(Update update) {
        bot.answerMode4 = false;
        bot.answerMode5 = true;
        bot.onUpdateReceived(update);

    }
}
