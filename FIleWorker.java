import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
public class FileWorker{
  private String str;
  private String[] splitted;
  public static Map<String, Integer> wordMap = new HashMap<>();
  public String fileReader(String fileName) {

        try {
            str = new String(Files.readString(Path.of(fileName)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return str;

  }
  public void answersPrint() throws IOException {
        removeDuplicates();
        System.out.println("кол-во всех слов в тексте = " + lengthCounter());
        System.out.println("кол-во уникальных слов = " + lengthCounterAfterRemove());
        wordCounter();
        PopularWordsSearcher(getWordMap());


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
   public int wordCounter() {

        for (String word : splitted) {
            if (wordMap.containsKey(word)) {
                wordMap.put(word, wordMap.get(word) + 1);
            }

            else wordMap.put(word, 1);
        }
        return wordMap.size();
   }

   public static Map<String, Integer> getWordMap() {
       return wordMap;
   }

   public static String PopularWordsSearcher(Map<String, Integer> wordMap) {

       for (int i = 0; i < 100; i++) {
           int maxim = (Collections.max(wordMap.values()));
           Iterator<Map.Entry<String, Integer>> iter = wordMap.entrySet().iterator();

           while (iter.hasNext()) {
                   Map.Entry<String, Integer> entry = iter.next();

               if (maxim == entry.getValue()) {
                   System.out.println(entry.getKey() + " " + maxim);
                   iter.remove();
               }
           }
       }
       return "наконец-то готово";
    }

}
  

  
  
  
