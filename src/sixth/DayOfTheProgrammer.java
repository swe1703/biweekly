package sixth;

import java.io.*;

public class DayOfTheProgrammer {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static String dayOfProgrammer(int year) {
        if(year == 1918) { //special case
            //daysInFeb = 15 (from 14 to 28)
            //daysTillAugust = 230
            //256-230 = 26
            return "26.09.1918";
        }

        else if(year < 1918) { //julian
            if(year % 4 == 0) return "12.09." + year; //leap
            else return "13.09." + year; //non leap
        }

        else { //gregorian (year > 1918)
            if((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) return "12.09." + year; //leap
            else return "13.09." + year; //non leap
        }
    }
}
