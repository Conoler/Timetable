import java.util.Arrays;

public class Data {
    static String tCode = "김성수:6197657536 전숙희:8950355660 기경민:9165284214 오윤진:2572269294 최성혁:8950279003 " +
                          "최선규:4580158712 전성찬:3295966160 박주현:4728703994 박재호:4336762484 홍석원:7807811223 " +
                          "박지영:2999114619 이태진:4271291695 손아람:5869966034 주상훈:4836458559 홍성희:3844758331 " +
                          "김상규:4777782507 이자현:6865735321 송성준:7612376707 이석화:4663248947 박보라:3569293392 " +
                          "이혜연:6451259993 윤수범:3099612774 김지민:8533791081 홍주표:4656127663 이효진:7142975348 " +
                          "최반석:4178565935 임지선:9714815077 김대진:7451766082 이윤아:4676665232 이지현:8579577853 " +
                          "서혜선:3389453066 ";
    public static String[/*반*/][/*요일*/][/*교시*/] Timetable = new String[7][4][6];
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
    public static void setData(String c, String date, String t, String[] data){
        setDatenum(date);
        int toc = Integer.parseInt(c)-1;
        int tot = Integer.parseInt(t)-1;
        String td = Arrays.toString(data);
        String std = td.substring(1, td.length()-1);
        Timetable[toc][datenum][tot] = std;
    }

    public static String gettCode(String s) {
        int TargetNum = tCode.indexOf(s);
        String result;
        if(!tCode.contains(s)){
            System.out.println("gettCode.!contain");
            result = "해당 선생님의 코드가 존재하지 않습니다.";
        }else{
            System.out.println("gettCode.contain");
            result = s + "선생님의 줌링크 입니다\nhttps://zoom.us/j/" + tCode.substring(TargetNum+4,(tCode.substring(TargetNum).indexOf(" ")+TargetNum)) + "?from=join";
            System.out.println("link have been made");
        }
        return result;
    }

}