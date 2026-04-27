package seventh;

public class CountingValleys {
    public static int countingValleys(int steps, String path) {
        int valleys = 0;

        int track = 0;
        boolean valleyStartCheck = false;

        for(char step : path.toCharArray()) {

            if(step == 'U') track++;
            else track--;

            if(track < 0) { //went below sea level; valley has started
                valleyStartCheck = true;
            }

            else if(track == 0 && valleyStartCheck == true) { //up to sea level; valley has ended
                valleys++;
                valleyStartCheck = false;
            }
        }

        return valleys;
    }

    public static void main(String[] args) {
        int valleys = countingValleys(8, "DDUUUUDD");
        System.out.println(valleys);
    }
}
