package homeworks.homework10;

import java.util.Arrays;

public class Sequence {

    public static int[] filter(int[] array, ByCondition condition) {
        int[] result = new int[0];
        int counter = 0;

        for (int n : array) {
            if (condition.isOk(n)) {
                result = Arrays.copyOf(result, result.length + 1);
                result[counter] = n;
                counter++;
            }
        }

        return result;
    }
}
