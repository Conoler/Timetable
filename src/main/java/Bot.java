import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import okhttp3.EventListener;

public class Bot extends EventListener {

    public static void main(String[] args)
            throws Exception
    {
        JDA jda = JDABuilder.createDefault(TOKEN).addEventListeners(new TListener()).build();
        jda.addEventListener(new ListenerManager());
        FileMake.FileMake();
        Data.getFile();
    }
}
