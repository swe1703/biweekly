package second;

import java.util.*;

public class ShortestPalindrome {
    public static boolean palindromeCheck(String string, int endIndex) {
        int start = 0;
        int end = endIndex;

        while(start < end) {
            if (string.charAt(start) != string.charAt(end)) return false;
            start++;
            end--;
        }

        return true;
    }

    public static String palindrome(String word) {
        int length = word.length();
        int suffixStartsfrom = 0;
        for(int i = length-1; i >= 0; i--) {
            if(palindromeCheck(word, i)) {
                suffixStartsfrom = i + 1;
                break;
            }
        }

        String tempSuffix = word.substring(suffixStartsfrom);
        StringBuilder suffix = new StringBuilder(tempSuffix).reverse();
        return suffix.toString() + word;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String word = s.next();
        System.out.println(palindrome(word));
    }
}
