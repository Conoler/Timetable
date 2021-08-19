import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.Arrays;

public class TListener extends ListenerAdapter {
    String[] Message;
    String msg;
    EmbedBuilder embedBuilder = new EmbedBuilder();
    User user;
    TextChannel textChannel;

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        embedBuilder.setColor(Color.CYAN);

        user = e.getAuthor();
        textChannel = e.getTextChannel();
        msg = e.getMessage().getContentRaw();

        Message = ListenerManager.subText(msg);
        int length = Message.length;

        if(user.isBot()) return;
        if(msg.startsWith("!시발")){
            textChannel.sendMessage(user.getAsMention() + ", 뭐 시발!").queue();
        }
        switch (msg){
            case "!1반" :
                ListenerManager.setClassLink(textChannel, 1, user);
                break;
            case "!2반" :
                ListenerManager.setClassLink(textChannel, 2, user);
                break;
            case "!3반" :
                ListenerManager.setClassLink(textChannel, 3, user);
                break;
            case "!4반" :
                ListenerManager.setClassLink(textChannel, 4, user);
                break;
            case "!5반" :
                ListenerManager.setClassLink(textChannel, 5, user);
                break;
            case "!6반" :
                ListenerManager.setClassLink(textChannel, 6, user);
                break;
            case "!7반" :
                ListenerManager.setClassLink(textChannel, 7, user);
                break;
            case "!8반" :
                ListenerManager.setClassLink(textChannel, 8, user);
                break;
        }

        if(msg.startsWith("!명령어")){

        }

        if(msg.startsWith("!시간표")){
            switch (length){
                case 1:
                    textChannel.sendMessage("'!시간표 도우미'로 설명을 볼 수 있습니다").queue();
                    break;
                case 2:
                    if ("도우미".equals(Message[1])) {
                        textChannel.sendMessage("!<n반> 을 이용해 수업 링크 보기\n" +
                                "!시간표 링크 <교사이름>\n" +
                                "!시간표 보기 <n반>\n" +
                                "!시간표 설정 <n반> <n요일> <n교시> <교사1> (<교사2> <교사3>..)\n" +
                                "!시간표 수정 <n반> <n요일> <n교시> <교사1> (<교사2> <교사3>..)\n" +
                                "!시간표").queue();
                    } else {
                        textChannel.sendMessage("?").queue();
                    }
                    break;
                case 3:
                    switch(Message[1]){
                        case "보기":
                            switch(Message[2]){
                                case "1반":
                                case "2반":
                                case "3반":
                                case "4반":
                                    ListenerManager.setTimetable(textChannel ,Message[2], "https://ifh.cc/g/aJcnlU.jpg");
                                    break;
                                case "5반":
                                case "6반":
                                    ListenerManager.setTimetable(textChannel ,Message[2], "https://ifh.cc/g/QJFOsg.png");
                                    break;
                                case "7반":
                                    ListenerManager.setTimetable(textChannel, Message[2], "https://ifh.cc/g/msuwdV.jpg");
                                    break;
                                case "8반":
                                    ListenerManager.setTimetable(textChannel, Message[2], "https://ifh.cc/g/pVtcT4.jpg");
                                    break;
                                default:
                                    textChannel.sendMessage("해당 시간표가 존재하지 않습니다.").queue();
                                    break;
                            }
                            break;
                        case "링크":
                            ListenerManager.settLink(textChannel, user, Message[2]);
                            break;
                        default:
                            textChannel.sendMessage("?").queue();
                            break;
                    }
                    break;
                default:
                   switch(Message[1]){
                        case "설정":
                            String[] mesg = Arrays.copyOfRange(Message, 5, Message.length);
                            Data.setData(textChannel, user, Message[2].substring(0, 1), Message[3].substring(0,1), Message[4].substring(0,1), mesg);

                            break;
                       case "수정":
                           String[] messg = Arrays.copyOfRange(Message, 5, Message.length);
                           Data.changeData(textChannel, user, Message[2].substring(0, 1), Message[3].substring(0,1), Message[4].substring(0,1), messg);

                           break;
                       default:
                           textChannel.sendMessage("?").queue();
                   }

                    break;
            }
        }
    }
}
