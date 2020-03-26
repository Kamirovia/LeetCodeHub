import java.util.*;

public class Main12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = new int[10];
        int count = 0;
        while (in.hasNextInt() && count < 11) {
            int num = in.nextInt();
            if (num == 0)
                break;

            nums[count] = num;
            count++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                break;
            System.out.println(nums[i] / 2);
        }

        in.close();
    }
}