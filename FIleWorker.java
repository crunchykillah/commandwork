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
    public String[] readSplit() {

        splitted = readEdit().split("_");
        Arrays.sort(splitted);
        return splitted;

    }
    public int lengthCounter() {
        int counter;
        counter = readSplit().length;
        return counter;
    }
    public String[] removeDuplicates(){
        HashSet<String> set;
        set = new HashSet<>();
        final int len = readSplit().length;

        for(int i = 0; i < len; i++){
            set.add(splitted[i]);
        }

        String[] whitelist = new String[set.size()];
        int i = 0;
        for (Iterator<String> it = set.iterator(); it.hasNext();) {
            whitelist[i++] = it.next();
        }
        return whitelist;

    } 
    public int lengthCounterAfterRemove() {
        int counter;
        counter = removeDuplicates().length;
        return counter;
    }

  
  
  
