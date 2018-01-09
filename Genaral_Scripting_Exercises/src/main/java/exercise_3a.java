import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class exercise_3a {
    public static void main(String[] args) throws Exception {
        String filePath="resource\\Dictionary.txt";
        boolean ans=(doesFileExist(filePath));
        if(ans==true){
            System.out.println("File exists in this path");
        }
        else if(ans==false)
        System.out.println("File does not exists in this path");

    }


    public static boolean doesFileExist(String path){
        File file = new File(path);

        boolean isFound = true;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
        }catch (FileNotFoundException ex) {
            isFound = false;
            System.out.println(ex);
        }finally {
            return isFound;
        }
    }

}