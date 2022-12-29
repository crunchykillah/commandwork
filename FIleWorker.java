import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
public class FileWorker{
  public String fileReader(String fileName) {

        try {
            str = new String(Files.readString(Path.of(fileName)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return str;

    }
  public String readEdit(){
        if (fileReader("kniga1.txt") != null){
            String resultString;
            resultString = fileReader("kniga1.txt").replaceAll("\\n\\r|\\r|\\n|\\s| ", "_");
            resultString = resultString.replaceAll("[^(A-Za-zА-Яа-я|_) ]", "");
            resultString = resultString.replaceAll("", "_");
            resultString = resultString.replaceAll("", "_");
            resultString = resultString.toUpperCase();
            return resultString;
        }
        return "строки не существует";
    }
