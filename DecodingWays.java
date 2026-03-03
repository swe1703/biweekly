package third;
import java.util.*;

public class DecodingWays {
    private static int decode(int start, int length, String string, int[] memoForWays) {
        if(start == length) return 1; //reached end; one valid way found
        if(string.charAt(start) == '0') return 0; //cant start with 0;
        if(memoForWays[start] != -1) return memoForWays[start]; //weve already calculated that

        //take one char and move to next index
        int count = decode(start+1, length, string, memoForWays);

        //take two chars and move
        if(start+1 < length) { //is choosing one more char possible?
            int value = ((string.charAt(start)-'0') * 10) + (string.charAt(start+1)-'0'); //taking 2 consecutive digits
            if(value <= 26) { //is it within a to z
                count = count + decode(start+2, length, string, memoForWays);
            }
        }

        memoForWays[start] = count; //store it for future use
        return count;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String string = s.nextLine();
        int length = string.length();

        int[] memoForWays = new int[length+1];
        Arrays.fill(memoForWays, -1);

        int start = 0;
        int ways = decode(start, length, string, memoForWays);
        System.out.println(ways);
    }
}
