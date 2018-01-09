import java.util.Scanner;


public class exersice_1 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

       String ans= reverseEverything(scan.nextLine());
        System.out.println(ans);
    }
    public static String reverseEverything(String s){

        char chars[]=s.toLowerCase().toCharArray();
        int left=0;
        int right=s.length()-1;
        for (left=0;left<=right;left++,right--){
            char temp=chars[left];
            chars[left]=chars[right];
            chars[right]=temp;
        }
        return new String(chars);

    }

}
