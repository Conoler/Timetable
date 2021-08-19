
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileMake {
    public static void FileMake() {
        try {
            File file = new File("D://개발/Discord_Java/Timetable/Timetableinfo.txt");
            boolean success = file.createNewFile();
            if (!success) {
                System.out.println("Failed to create a file : D://개발/Discord_Java/Timetable/Timetableinfo.txt");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> FIleRead(){
        List<String> aLines = new ArrayList<String>();
        String aLine = "";

        try {
            File aText = new File("D://개발/Discord_Java/Timetable/Timetableinfo.txt");
            FileReader aReader = new FileReader(aText);
            BufferedReader aBufReader = new BufferedReader(aReader);
            while((aLine = aBufReader.readLine()) != null) {
                aLines.add(aLine);
            }
            aBufReader.close();
        } catch(Exception e) {
            //TODO
        }
        return aLines;
    }
}
