package fourth;

import java.util.HashSet;

public class MaxProductOfWordLengths {
    static int product(String[] words) {
        int len = words.length;
        int product = 0, maxProduct = 0;

        for(int first = 0; first < len; first++) {
            HashSet<Character> word1Letters = new HashSet<>();
            String word1 = words[first];
            for(char c : word1.toCharArray()) {
                word1Letters.add(c);
            }

            for(int second = first+1; second < len; second++) {
                String word2 = words[second];
                int word2Length = word2.length();

                int i;
                for(i = 0; i < word2Length; i++) {
                    if(word1Letters.contains(word2.charAt(i))) break;
                }

                if(i == word2Length) product = word1.length() * word2Length;
                if(product > maxProduct) maxProduct = product;
            }
        }

        return maxProduct;
    }

    public static void main(String[] args) {
        String[] words = {"abcw","baz","foo","bar","xtfn","abcdef"};
        System.out.println(product(words));
    }
}
