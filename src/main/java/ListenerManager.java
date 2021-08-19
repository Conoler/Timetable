import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.time.LocalTime;
import java.util.Date;

public class ListenerManager extends ListenerAdapter {

    public static EmbedBuilder embedBuilder = new EmbedBuilder();

    public static void settLink(TextChannel tc, User u, String teacher){
        int TargetNum = Data.tCode.indexOf(teacher);
        if(!Data.tCode.contains(teacher)){
            System.out.println("setLink.!contain");
            tc.sendMessage("해당 선생님의 코드가 존재하지 않습니다.").queue();
        }else{
            System.out.println("setLink.contain");
            tc.sendMessage(u.getAsMention() + ", " + teacher + "선생님의 줌링크 입니다\nhttps://zoom.us/j/" + Data.tCode.substring(TargetNum+4,(Data.tCode.substring(TargetNum).indexOf(" ")+TargetNum)) + "?from=join").queue();
            System.out.println("link have been made");
        }
    }


    public static void setClassLink(TextChannel tc, int cl, User u){
        Date today = new Date ();
        String[] date = ListenerManager.subText(today.toString());
        int timeCode;
        int DatenumN;
        LocalTime currentTime = LocalTime.now();
        LocalTime t1 = LocalTime.of(8, 00,00);
        LocalTime t2 = LocalTime.of(9, 00, 00);
        LocalTime t3 = LocalTime.of(10, 00, 00);
        LocalTime t4 = LocalTime.of(11, 00, 00);
        LocalTime t5 = LocalTime.of(12, 30, 00);
        LocalTime t6 = LocalTime.of(14,00,00);
        LocalTime t7 = LocalTime.of(15, 00, 00);
        LocalTime tend = LocalTime.of(16, 30, 00);
        switch(date[0]){
            case "Mon":
                DatenumN = 0;
                break;
            case "Tue":
                DatenumN = 1;
                break;
            case "Wed":
                DatenumN = 2;
                break;
            case "Thu":
                DatenumN = 3;
                break;
            case "Fri":
                DatenumN = 4;
                break;
            default:
                DatenumN = 9;
                break;
        }
        if(currentTime.isAfter(t1)&&currentTime.isBefore(t2)){
            timeCode = 1;
        }else if(currentTime.isAfter(t2)&&currentTime.isBefore(t3)){
            timeCode = 2;
        }else if(currentTime.isAfter(t3)&&currentTime.isBefore(t4)){
            timeCode = 3;
        }else if(currentTime.isAfter(t4)&&currentTime.isBefore(t5)){
            timeCode = 4;
        }else if(currentTime.isAfter(t5)&&currentTime.isBefore(t6)){
            timeCode = 5;
        }else if(currentTime.isAfter(t6)&&currentTime.isBefore(t7)){
            timeCode = 6;
        }else if(currentTime.isAfter(t7)&&currentTime.isBefore(tend)){
            timeCode = 7;
        }else{
            timeCode = 9;
        }
        if(timeCode != 9){
            String timeD = Data.getData(cl, DatenumN, timeCode);
            if(timeD!= null){
                String[] t = timeD.split(", ");
                for(int i=0; i<t.length; i++){
                    ListenerManager.settLink(tc, u, t[i]);
                }
            }else{
                tc.sendMessage("해당 시간의 시간표가 설정되지 않았습니다").queue();
            }

        }else{
            tc.sendMessage(u.getAsMention()+", 수업시간이 아닙니다.\n!시간표 링크 <선생님>을 이용해 주세요").queue();
        }
    }

    public static void setTimetable(TextChannel tc, String name, String url){
        embedBuilder.setColor(Color.CYAN);
        embedBuilder.setTitle(name + " 시간표 입니다.");
        embedBuilder.setImage(url);
        tc.sendMessage(embedBuilder.build()).queue();
    }

    public static String[] subText(String s){
        String[] strings;
        strings = s.split(" ");
        for(int i = 0; i<strings.length; i++){
            System.out.println(strings[i]);
        }
        return strings;
    }
}