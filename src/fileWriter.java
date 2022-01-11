import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class fileWriter {

private static Path path;

    public fileWriter() {
        path = Paths.get("logging/");
    }
    //write text to file

    public void writeFile(String webName, String text) {

        String pattern = "[^a-z^A-Z^0-9]";
        String fileName = webName.replaceAll(pattern, "_");
        path = Paths.get("logging/BBC_" + fileName + ".html");
        //path = Paths.get("logging/test.txt");

        try {
            Files.writeString(path, text);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
