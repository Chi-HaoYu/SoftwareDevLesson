import java.io.File;
import java.util.Date;

public class MergePathDate {

    public static FileDataSet[]  MergePathDate(String[] filePath, Date[] fileDate) {
        FileDataSet[] fileDataSet = new FileDataSet[1010];

        for (int i = 0; i < fileDataSet.length; i++) {
            fileDataSet[i] = new FileDataSet();
            fileDataSet[i].path = filePath[i];
            fileDataSet[i].date = fileDate[i];
        }

        return fileDataSet;
    }
}