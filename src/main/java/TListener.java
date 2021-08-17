import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;

public class TListener extends ListenerAdapter {
    String[] Message;

    public boolean isExist(String[] strings, String string){
        return Arrays.asList(strings).contains(string);
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        User user = e.getAuthor();
        TextChannel tc = e.getTextChannel();
        String msg = e.getMessage().getContentRaw();

        Message = subText(msg);
        int length = Message.length;

        if(user.isBot()) return;
        Date today = new Date ();
        String[] date = subText(today.toString());
        LocalTime currentTime = LocalTime.now();
        LocalTime t1 = LocalTime.of(8, 00,00);
        LocalTime t2 = LocalTime.of(9, 00, 00);
        LocalTime t3 = LocalTime.of(10, 00, 00);
        LocalTime t4 = LocalTime.of(11, 00, 00);
        LocalTime t5 = LocalTime.of(12, 30, 00);
        LocalTime t6 = LocalTime.of(14,00,00);
        LocalTime t7 = LocalTime.of(15, 00, 00);
        LocalTime tend = LocalTime.of(16, 30, 00);
        int timeCode;
        if(currentTime.isAfter(t1)&&currentTime.isBefore(t2)){
            timeCode = 0;
        }else if(currentTime.isAfter(t2)&&currentTime.isBefore(t3)){
            timeCode = 1;
        }else if(currentTime.isAfter(t3)&&currentTime.isBefore(t4)){
            timeCode = 2;
        }else if(currentTime.isAfter(t4)&&currentTime.isBefore(t5)){
            timeCode = 3;
        }else if(currentTime.isAfter(t5)&&currentTime.isBefore(t6)){
            timeCode = 4;
        }else if(currentTime.isAfter(t6)&&currentTime.isBefore(t7)){
            timeCode = 5;
        }else if(currentTime.isAfter(t7)&&currentTime.isBefore(tend)){
            timeCode = 6;
        }else{
            timeCode = 9;
        }

        int DatenumN;
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
        switch (msg){
            case "!1반" :
                if(timeCode != 9){
                    System.out.println("1반 get timeCode");
                    String TimeData = Data.Timetable[0][DatenumN][timeCode];
                    System.out.println("1반 get TimeData");
                    String[] t = TimeData.split(", ");
                    System.out.println("Data split");
                    System.out.println(t[0]);
                    System.out.println((t[1]));
                    for(int i=0; i<t.length-1; i++){
                        tc.sendMessage(user.getAsMention() + ", " + Data.gettCode(t[i+1])).queue();
                        System.out.println(i + ", try : for");
                    }
                }else{
                    System.out.println("1반 error");
                    tc.sendMessage(user.getAsMention()+", 수업시간이 아닙니다.\n!시간표 링크 <선생님>을 이용해 주세요").queue();
                }
                break;
            case "!2반" :
                if(timeCode != 9){
                    System.out.println("2반 get timeCode");
                    String TimeData = Data.Timetable[1][DatenumN][timeCode];
                    System.out.println("2반 get TimeData");
                    String[] t = TimeData.split(", ");
                    System.out.println("Data split");
                    System.out.println(t[0]);
                    System.out.println((t[1]));
                    for(int i=0; i<t.length-1; i++){
                        tc.sendMessage(user.getAsMention() + ", " + Data.gettCode(t[i+1])).queue();
                        System.out.println(i + ", try : for");
                    }
                }else{
                    System.out.println("2반 error");
                    tc.sendMessage(user.getAsMention()+", 수업시간이 아닙니다.\n!시간표 링크 <선생님>을 이용해 주세요").queue();
                }
                break;
            case "!3반" :
                if(timeCode != 9){
                    System.out.println("3반 get timeCode");
                    String TimeData = Data.Timetable[2][DatenumN][timeCode];
                    System.out.println("3반 get TimeData");
                    String[] t = TimeData.split(", ");
                    System.out.println("Data split");
                    System.out.println(t[0]);
                    System.out.println((t[1]));
                    for(int i=0; i<t.length-1; i++){
                        tc.sendMessage(user.getAsMention() + ", " + Data.gettCode(t[i+1])).queue();
                        System.out.println(i + ", try : for");
                    }
                }else{
                    System.out.println("3반 error");
                    tc.sendMessage(user.getAsMention()+", 수업시간이 아닙니다.\n!시간표 링크 <선생님>을 이용해 주세요").queue();
                }
                break;
            case "!4반" :
                if(timeCode != 9){
                    System.out.println("4반 get timeCode");
                    String TimeData = Data.Timetable[3][DatenumN][timeCode];
                    System.out.println("4반 get TimeData");
                    String[] t = TimeData.split(", ");
                    System.out.println("Data split");
                    System.out.println(t[0]);
                    System.out.println((t[1]));
                    for(int i=0; i<t.length-1; i++){
                        tc.sendMessage(user.getAsMention() + ", " + Data.gettCode(t[i+1])).queue();
                        System.out.println(i + ", try : for");
                    }
                }else{
                    System.out.println("4반 error");
                    tc.sendMessage(user.getAsMention()+", 수업시간이 아닙니다.\n!시간표 링크 <선생님>을 이용해 주세요").queue();
                }
                break;
            case "!5반" :
                if(timeCode != 9){
                    System.out.println("5반 get timeCode");
                    String TimeData = Data.Timetable[4][DatenumN][timeCode];
                    System.out.println("5반 get TimeData");
                    String[] t = TimeData.split(", ");
                    System.out.println("Data split");
                    System.out.println(t[0]);
                    System.out.println((t[1]));
                    for(int i=0; i<t.length-1; i++){
                        tc.sendMessage(user.getAsMention() + ", " + Data.gettCode(t[i+1])).queue();
                        System.out.println(i + ", try : for");
                    }
                }else{
                    System.out.println("5반 error");
                    tc.sendMessage(user.getAsMention()+", 수업시간이 아닙니다.\n!시간표 링크 <선생님>을 이용해 주세요").queue();
                }
                break;
            case "!6반" :
                if(timeCode != 9){
                    System.out.println("6반 get timeCode");
                    String TimeData = Data.Timetable[5][DatenumN][timeCode];
                    System.out.println("6반 get TimeData");
                    String[] t = TimeData.split(", ");
                    System.out.println("Data split");
                    System.out.println(t[0]);
                    System.out.println((t[1]));
                    for(int i=0; i<t.length-1; i++){
                        tc.sendMessage(user.getAsMention() + ", " + Data.gettCode(t[i+1])).queue();
                        System.out.println(i + ", try : for");
                    }
                }else{
                    System.out.println("6반 error");
                    tc.sendMessage(user.getAsMention()+", 수업시간이 아닙니다.\n!시간표 링크 <선생님>을 이용해 주세요").queue();
                }
                break;
            case "!7반" :
                if(timeCode != 9){
                    System.out.println("7반 get timeCode");
                    String TimeData = Data.Timetable[6][DatenumN][timeCode];
                    System.out.println("7반 get TimeData");
                    String[] t = TimeData.split(", ");
                    System.out.println("Data split");
                    System.out.println(t[0]);
                    System.out.println((t[1]));
                    for(int i=0; i<t.length-1; i++){
                        tc.sendMessage(user.getAsMention() + ", " + Data.gettCode(t[i+1])).queue();
                        System.out.println(i + ", try : for");
                    }
                }else{
                    System.out.println("7반 error");
                    tc.sendMessage(user.getAsMention()+", 수업시간이 아닙니다.\n!시간표 링크 <선생님>을 이용해 주세요").queue();
                }
                break;
            case "!8반" :
                if(timeCode != 9){
                    System.out.println("8반 get timeCode");
                    String TimeData = Data.Timetable[7][DatenumN][timeCode];
                    System.out.println("8반 get TimeData");
                    String[] t = TimeData.split(", ");
                    System.out.println("Data split");
                    System.out.println(t[0]);
                    System.out.println((t[1]));
                    for(int i=0; i<t.length-1; i++){
                        tc.sendMessage(user.getAsMention() + ", " + Data.gettCode(t[i+1])).queue();
                        System.out.println(i + ", try : for");
                    }
                }else{
                    System.out.println("8반 error");
                    tc.sendMessage(user.getAsMention()+", 수업시간이 아닙니다.\n!시간표 링크 <선생님>을 이용해 주세요").queue();
                }
                break;
        }

        if(msg.startsWith("!시간표")){
            switch (length){
                case 1:
                    tc.sendMessage("'!시간표 도우미'로 설명을 볼 수 있습니다").queue();
                    break;
                case 2:
                    if ("도우미".equals(Message[1])) {
                        tc.sendMessage("!<반> 을 이용해 수업 링크 보기\n" +
                                "!시간표 링크 <교사이름>\n" +
                                "!시간표 보기 <반>\n" +
                                "!시간표 설정 <반> <요일> <교시> <과목> <교사1> (<교사2> <교사3>..)\n" +
                                "!시간표").queue();
                    } else {
                        tc.sendMessage("?").queue();
                    }
                    break;
                case 3:
                    switch(Message[1]){
                        case "보기":
                            switch(Message[2]){
                                case "1반":
                                    tc.sendMessage("1반 시간표").queue();
                                    break;
                                default:
                                    tc.sendMessage("!시간표 보기 <반>").queue();
                                    break;
                            }
                            break;
                        case "링크":
                            tc.sendMessage(user.getAsMention() + ", "+ Data.gettCode(Message[2])).queue();
                            break;
                        default:
                            tc.sendMessage("?").queue();
                            break;
                    }
                    break;
                default:
                   switch(Message[1]){
                        case "설정":
                            String[] mesg = Arrays.copyOfRange(Message, 5, Message.length);
                            System.out.println(Arrays.toString(mesg));
                            Data.setData(Message[2], Message[3], Message[4], mesg);
                            tc.sendMessage(Message[2] + "반 " + Message[3] + "요일 " + Message[4] + "교시로 해당 과목이 설정 되었습니다").queue();
                            break;
                       default:
                           tc.sendMessage("?").queue();
                   }

                    break;
            }
        }
    }

    public String[] subText(@NotNull String s){
        String[] strings;
        strings = s.split(" ");
        for(int i = 0; i<strings.length; i++){
            System.out.println(strings[i]);
        }
        return strings;
    }
}
