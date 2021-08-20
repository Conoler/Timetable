import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import okhttp3.EventListener;

public class Bot extends EventListener {

    public static void main(String[] args)
            throws Exception
    {
        JDA jda = JDABuilder.createDefault("ODc1NzA4ODAxNzU4Njc0OTU1.YRZdYA.Ts7-5fEJPlLvlu5BGYYOq9pGI0g").addEventListeners(new TListener()).build();
        jda.addEventListener(new ListenerManager());
        FileMake.FileMake();
        Data.getFile();
    }
}