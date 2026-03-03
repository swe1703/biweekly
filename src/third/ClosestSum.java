package third;
import java.util.*;

public class ClosestSum {
    private static int find(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;

        int closest = nums[0] + nums[1] + nums[2];

        for(int index = 0; index < len-2; index++) { //from the current index, we need 2 more elements
            int left = index+1, right = len-1;

            while(left < right) {
                int possibleClosest = nums[index] + nums[left] + nums[right];

                int targetToClosest = Math.abs(target - closest);
                int targetToPossibleClosest = Math.abs(target - possibleClosest);

                if(targetToPossibleClosest <  targetToClosest) {
                    closest = possibleClosest;
                }

                if(possibleClosest < target) left++; //try a larger num to increase the sum
                else if(possibleClosest > target) right--; //try to decrease the sum
                else return possibleClosest; //target == possibleClosest
            }
        }

        return closest;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = s.nextInt();
        }

        int target = s.nextInt();

        int closestSum = find(nums, target);
        System.out.println(closestSum);
    }
}
