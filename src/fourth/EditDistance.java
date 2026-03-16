package fourth;

public class EditDistance {
    public static int distance(String word1, String word2) {
        int len2 = word2.length();
        int word1Index = 0, word2Index = 0;
        int total = 0;

        StringBuilder tempWord1 = new StringBuilder(word1);

        while(word1Index < tempWord1.length() && word2Index < len2) {
            if(tempWord1.charAt(word1Index) == word2.charAt(word2Index)) { //both chars are same
                word1Index++;
                word2Index++;
            }

            else { //chars are not same
                if(word1Index+1 < tempWord1.length() && tempWord1.charAt(word1Index+1) == word2.charAt(word2Index)) { //bc - c
                    tempWord1.deleteCharAt(word1Index);
                    total++;
                }

                else if(word2Index+1 < len2 && tempWord1.charAt(word1Index) == word2.charAt(word2Index+1)) { //b - cb
                    tempWord1.insert(word1Index, word2.charAt(word2Index));
                    total++;

                    word1Index++;
                    word2Index++;
                }

                else { //when both the above cases fail (bc - ad)
                    tempWord1.setCharAt(word1Index, word2.charAt(word2Index));
                    total++;

                    word1Index++;
                    word2Index++;
                }
            }
        }

        total = total + (tempWord1.length()-word1Index) + (len2-word2Index); //to handle the remaining chars in both the strings (cat - catch)
        return total;
    }

    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";

        System.out.println(distance(word1, word2));
    }
}