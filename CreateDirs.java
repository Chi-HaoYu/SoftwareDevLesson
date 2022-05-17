import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;

public class CreateDirs {

    public static Path CreateDirs(String dirStr) {
        Path dirCreate = Paths.get(dirStr);

        try {
            Path dirsPath= Files.createDirectory(dirCreate);
            System.out.println("\nCreated " +dirsPath);
        } catch (IOException e) {
            System.out.println(e);
        }
        return dirCreate;
    }

    public static void main(String[] args) {
        CreateDirs createDirs = new CreateDirs();
        Path dirsCreated  = createDirs.CreateDirs("C:/Users/user/Desktop/Webapp/LastWork/img/img1");
        System.out.println(dirsCreated);
    }
}