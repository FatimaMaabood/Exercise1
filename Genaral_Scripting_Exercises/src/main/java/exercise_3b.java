import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class exercise_3b {
    public static void main(String[] args) throws Exception {
        String filePath="resource\\Dictionary.txt";
        dictionaryMeaning(filePath);
    }

    public static boolean dictionaryMeaning(String path){
        File file = new File(path);
        HashMap<String,List<String>> data=new HashMap<String, List<String>>();
        boolean isFound = true;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null)
            {
                String[] newString = st.split("-");
                for(String al:newString) {
                    String[] n=al.split(",");
                    data.put(newString[0], Arrays.asList(n));
                }
            }

            for(Map.Entry<String, List<String>> mapEntries: data.entrySet()){
                System.out.println(mapEntries.getKey());
                for(String elem: mapEntries.getValue()){
                    System.out.println(elem);
                }
            }

        }catch (FileNotFoundException ex) {
            isFound = false;
            System.out.println(ex);
        }finally {
            return isFound;
        }
    }

}
