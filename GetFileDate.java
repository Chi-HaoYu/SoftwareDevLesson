import java.io.File;
import java.util.Calendar;
import java.util.Date;

public class GetFileDate extends GetFilePath {

    public static Date[] GetFileDate(File folder) {
        String[] filePath = GetFilePath(folder);
        Date[] date = new Date[1010];

        for (int i = 0; i < filePath.length; i++) {
            File file = new File(filePath[i]);
            Calendar c = Calendar.getInstance();
            c.setTimeInMillis(file.lastModified());
            date[i] = c.getTime();
        }

        return date;
    }

}