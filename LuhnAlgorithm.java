import java.util.ArrayList;
import java.util.Random;

public class LuhnAlgorithm {
    public static void main(String[] args) {
        // First, 15 random digits. The format is xxxxxxxxxxxxxxxy, with y as the check digit
        Random random = new Random();
        boolean validCheck = false;
        int checkDigit = 0;
        ArrayList<Integer> nums = new ArrayList<Integer>();
        while(validCheck != true) {
            // Generate nums
            for (int i = 0; i < 15; i++) {
                nums.add(random.nextInt((9 - 1) + 1) + 1);
            }
            // This block doubles every other number
            for (int i = 0; i < nums.size(); i++) {
                nums.set(i,(nums.get(i) * 2));
                i++; // This way, it adds two to i
            }
            for (int i = 0; i < nums.size(); i++) {
                if (nums.get(i) >= 10) {
                    nums.set(i, ((nums.get(i) / 10) + (nums.get(i) % 10)));
                }
            }
            for (int i = 0; i < nums.size(); i++) {
                checkDigit += nums.get(i);
            }
            System.out.println(checkDigit);
            System.out.println(checkDigit % 10);
            // Check if the digit is valid
            if ((checkDigit % 10) != 0) {
                validCheck = false;
                nums.clear();
                checkDigit = 0;
            } else {
                nums.add((checkDigit * 9) % 10);
                validCheck = true;
            }
        }
        // We now have a full 16 digit credit card number!
        System.out.println(nums);
    }
}
