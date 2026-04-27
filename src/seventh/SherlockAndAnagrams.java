package seventh;

import java.util.Arrays;
import java.util.HashMap;

public class SherlockAndAnagrams {
    public static int sherlockAndAnagrams(String s) {
        int len = s.length();

        HashMap<String, Integer> frequency = new HashMap<>();
        int pairs = 0;

        for(int start = 0; start < len; start++) {
            for(int end = start+1; end <= len; end++) {
                String tempSubstring = s.substring(start, end);

                char[] charsOfSubstring = tempSubstring.toCharArray();
                Arrays.sort(charsOfSubstring);

                String substring = new String(charsOfSubstring);

                int previousCount = 0; //no of times it had occurred before
                if(frequency.containsKey(substring)) previousCount = frequency.get(substring);

                pairs = pairs + previousCount; //current substring can pair with all the same previous ones

                frequency.put(substring, previousCount+1); //updating the substring count
            }
        }

        return pairs;
    }

    public static void main(String[] args) {
        System.out.println(sherlockAndAnagrams("abba"));
        System.out.println(sherlockAndAnagrams("abcd"));
    }
}
