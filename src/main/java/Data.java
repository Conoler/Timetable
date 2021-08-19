import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;

import java.io.*;
import java.util.Arrays;

public class Data {


    static String tCode = "김성수:6197657536 전숙희:8950355660 기경민:9165284214 오윤진:2572269294 최성혁:8950279003 " +
                          "최선규:4580158712 전성찬:3295966160 박주현:4728703994 박재호:4336762484 홍석원:7807811223 " +
                          "박지영:2999114619 이태진:4271291695 손아람:5869966034 주상훈:4836458559 홍성희:3844758331 " +
                          "김상규:4777782507 이자현:6865735321 송성준:7612376707 이석화:4663248947 박보라:3569293392 " +
                          "이혜연:6451259993 윤수범:3099612774 김지민:8533791081 홍주표:4656127663 이효진:7142975348 " +
                          "최반석:4178565935 임지선:5935931358 김대진:7451766082 이윤아:9414696984 이지현:8579577853 " +
                          "서혜선:3389453066 ";
    public static String[/*반*/][/*요일*/][/*교시*/] Timetable = new String[8][5][7];
    static int datenum;
    public static void setDatenum(String date){
        switch(date) {
            case "월":
                datenum = 0;
                break;
            case "화":
                datenum = 1;
                break;
            case "수":
                datenum = 2;
                break;
            case "목":
                datenum = 3;
                break;
            case "금":
                datenum = 4;
                break;
            default:
                break;
        }
    }
    public static String getData(int cl, int date, int time){
        int cln = cl-1;
        int tin = time-1;
        return Timetable[cln][date][tin];

    }

    public static void changeData(TextChannel tc, User user, String c, String date, String t, String[] data){
        setDatenum(date);
        int toc = Integer.parseInt(c)-1;
        int tot = Integer.parseInt(t)-1;
        String td = Arrays.toString(data);
        String std = td.substring(1, td.length()-1);
        String mData = Timetable[toc][datenum][tot];
        if(mData == null){
            tc.sendMessage(user.getAsMention()+", 해당 시간대에 선생님 정보가 없습니다\n '!시간표 설정 <반> <요일> <교시> <교사>'로 설정할 수 있습니다.").queue();
            System.out.println("change");
        }else{
            System.out.println("chage error");
            if(Data.tCode.contains(std)){
                String[] st = std.split(", ");
                for(int i=0; i<st.length; i++){
                    if(Data.tCode.contains(st[i])){
                        tc.sendMessage(c+"반 "+date+"요일 "+t+"교시가 "+td+"선생님으로 수정되었습니다").queue();
                    }
                }
            }
            Timetable[toc][datenum][tot] = std;

            try {
                Data.saveData();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void setData(TextChannel tc, User user, String c, String date, String t, String[] data){
        setDatenum(date);
        int toc = Integer.parseInt(c)-1;
        int tot = Integer.parseInt(t)-1;
        String td = Arrays.toString(data);
        String std = td.substring(1, td.length()-1);
        String mData = Timetable[toc][datenum][tot];
        if(mData == null){
            System.out.println("set");
            Timetable[toc][datenum][tot] = std;
            tc.sendMessage(c+"반 "+date+"요일 "+t+"교시가 "+td+"선생님으로 설정되었습니다").queue();
            try {
                Data.saveData();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }else{
            System.out.println("set error");
            tc.sendMessage(user.getAsMention()+", 이미 해당 시간대에 ["+Timetable[toc][datenum][tot]+"]선생님 정보가 있습니다\n '!시간표 수정 <반> <요일> <교시> <교사>'로 수정할 수 있습니다.").queue();
        }
    }
    public static void saveData() throws IOException {
        BufferedWriter out = null;
        out = new BufferedWriter(new FileWriter("D://개발/Discord_Java/Timetable/Timetableinfo.txt"));
        clearData();
        for(int i = 0; i<8; i++){
            for(int j=0;j<5; j++){
                for(int k=0;k<7;k++){
                    if(Timetable[i][j][k] != null){
                        try {
                            out.write(i + " " + j + " " + k + ":" + Timetable[i][j][k]);
                            out.newLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        out.close();
    }
    public static void clearData(){
        File file = new File("D://개발/Discord_Java/Timetable/Timetableinfo.txt");
        file.delete();
        FileMake.FileMake();
    }

    public static void getFile(){
        String[] timetableData;
        for(int i = 0; i<FileMake.FIleRead().size(); i++){
            int n = FileMake.FIleRead().get(i).indexOf(":");
            timetableData = ListenerManager.subText(FileMake.FIleRead().get(i).substring(0, n));
            Timetable[Integer.parseInt(timetableData[0])][Integer.parseInt(timetableData[1])][Integer.parseInt(timetableData[2])] = FileMake.FIleRead().get(i).substring(n+1, FileMake.FIleRead().get(i).length());
        }
    }
}