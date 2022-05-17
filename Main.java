import java.io.File;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        
        File folder = new File("C:/Users/user/Desktop/Webapp/LastWork/Camera/");

        GetFilePath getPath = new GetFilePath();
        String[] filePath = getPath.GetFilePath(folder);
/*        for (String str : filePath) {
            System.out.println(str);
        }
*/
        GetFileDate getDate = new GetFileDate();
        Date[] fileDate = getDate.GetFileDate(folder);
/*        for (Date date : fileDate) {
            System.out.println(date);
        }
*/
        MergePathDate merge = new MergePathDate();
        FileDataSet[] fileDataSet = merge.MergePathDate(filePath, fileDate);
/*        for (int i = 0; i < fileDataSet.length; i++) {
            System.out.println(fileDataSet[i].path + ' ' + fileDataSet[i].date);
        }
*/
        DateSort Sort = new DateSort();
        FileDataSet[] fileSorted = Sort.DateSort(fileDataSet);
/*        for (int i = 0; i < fileSorted.length; i++) {
            System.out.println(i + " : " + fileDataSet[i].path + "   " + fileDataSet[i].date);
        }
*/
        CloseDate closeDate = new CloseDate();
        long[] timeDiff = closeDate.closeDate(fileSorted);

        SeparateFile separateFile = new SeparateFile();
        separateFile.separateFile(fileSorted, timeDiff, folder);

    }
}