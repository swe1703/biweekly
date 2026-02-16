package second;

import java.util.Scanner;

public class CroakOfFrogs {
    public static int count(String string) {
        int frogs = -1;
        for(char ch : string.toCharArray()) {
            if("croak".indexOf(ch) == -1) {
                frogs = -1;
                break;
            }
        }

        return frogs;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String string = s.next();
        System.out.println(count(string));
    }
}
