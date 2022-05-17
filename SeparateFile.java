import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class SeparateFile extends CreateDirs{

    public static void separateFile(FileDataSet[] fileData, long[] timeDiff, File folder) {
        String sourcePathFirst = fileData[0].path;
        String destDirFirst = makeNewDirsName(fileData[0], folder);
        Path destDirPathFirst = CreateDirs(destDirFirst);
        String destNameFirst = makeNewFileName(destDirPathFirst, sourcePathFirst);
        copyFile(sourcePathFirst, destNameFirst);
        for (int head = 0 ,near = 0; head < timeDiff.length; head++) {
            if (timeDiff[head] < 180) {
                String destDir;
                if (head == 0) {
                    destDir = destNameFirst;
                } else {
                    destDir = makeNewDirsName(fileData[head + 1], folder);
                }
                Path destDirPath = CreateDirs(destDir);
                for (near = 0; (head + near) < timeDiff.length && timeDiff[head + near] < 180; near++) {
                        String sourcePath = fileData[head + near + 1].path;
                        String destName = makeNewFileName(destDirPath, sourcePath);
                        copyFile(sourcePath, destName);
                }
                head = head + near -1;
            } else {
                String sourcePath = fileData[head + 1].path;
                String destDir = makeNewDirsName(fileData[head + 1], folder);
                Path destDirPath = CreateDirs(destDir);
                String destName = makeNewFileName(destDirPath, sourcePath);
                copyFile(sourcePath, destName);
            }
        }
    }

    public static void copyFile(String source, String dest) {
        Path sourcePath = Paths.get(source);
        Path destPath = Paths.get(dest);
        try {
            Files.copy(sourcePath, destPath);
            System.out.println("Copied " + sourcePath + " to " + destPath);
        } catch (IOException e) {
            System.out.println(e);
        }
    } 

    public static String makeNewDirsName(FileDataSet fileData, File folder) {
        String folderPath = folder.toPath().toString();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
        String timeStemp = dateFormat.format(fileData.date);
        String newDirsName = folderPath + "/" +timeStemp;
        return newDirsName;
    }

    public static String makeNewFileName(Path destDir, String sourcePath) {
        File sourceFile = new File(sourcePath);
        String sourceName = sourceFile.getName();

        String destPath = destDir.toString();
        destPath = destPath + "/" + sourceName;
        return destPath;
    }
    
    public static void main(String args[]) {
        String sourcePath = "C:/Users/user/Desktop/WebApp/LastWork/img/IMG_20131210_175636.jpg";
        Path destDir = Paths.get("C:/Users/user/Desktop/WebApp/LastWork/img/test");
        String destName = makeNewFileName(destDir, sourcePath);

        System.out.println(destName);

        copyFile(sourcePath, destName);
    }
}
