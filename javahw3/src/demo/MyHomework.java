package demo;
import java.util.Scanner;

public class MyHomework {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        
        System.out.println(count(s));
    }

    public static int count(String s) {
        int count = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            count += expand(s, i, i);  
            count += expand(s, i, i + 1); 
        }
        
        return count;
    }

    private static int expand(String s, int left, int right) {
        int count = 0;
        
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}
