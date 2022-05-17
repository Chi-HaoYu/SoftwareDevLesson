import java.io.File;

public class GetFilePath {

    public static String[] GetFilePath(File folder) {
        String[] paths = new String[1010];
        int i = 0;
        for (File file : folder.listFiles()) {
            if (!file.isDirectory()) {
                paths[i] = file.getAbsolutePath();
                System.out.println("Get : " + paths[i++]);
            } else {
                GetFilePath(file);
            }
        }
        System.out.println("Get " + i + "files\n");

        return paths;
    }
}