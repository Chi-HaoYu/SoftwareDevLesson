import java.util.concurrent.TimeUnit;
import java.util.Arrays;





public class CloseDate {

    public static long[] closeDate(FileDataSet[] fileData) {
        long[] timeDiff = new long[1009];
        Arrays.fill(timeDiff, -1); 
        TimeUnit time = TimeUnit.MINUTES;

        for (int i = 0; i < fileData.length-1; i++) {
            timeDiff[i] = time.convert(
                            fileData[i+1].date.getTime() - fileData[i].date.getTime()
                            , TimeUnit.MILLISECONDS);
        }
/*
        for (int i = 0; i < timeDiff.length; i++) { 
            System.out.println(timeDiff[i]);
        }
*/
        return timeDiff;
    } 
}