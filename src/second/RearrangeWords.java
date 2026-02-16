package second;
import java.util.*;
public class RearrangeWords {
    public static String rearrange(String sentence) {
        String[] words = sentence.split(" ");

        for(int i = 0; i < words.length-1; i++) {
            for(int j = 0; j < words.length-i-1; j++) {
                int len1 = words[j].length();
                int len2 = words[j+1].length();

                if(len1 > len2) {
                    String temp = words[j];
                    words[j] = words[j+1];
                    words[j+1] = temp;
                }
            }
        }

        //Arrays.sort(words, Comparator.comparingInt(String::length));

        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < words.length; i++) {
            if(i == 0) {
                String firstLetter = String.valueOf(words[i].charAt(0)).toUpperCase();
                String remaining = words[i].substring(1);
                ans.append(firstLetter).append(remaining).append(" ");
            }

            else {
                String string = words[i].toLowerCase();
                ans.append(string).append(" ");
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String sentence = s.nextLine();
        System.out.println(rearrange(sentence));
    }
}