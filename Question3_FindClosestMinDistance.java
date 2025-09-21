import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Question3_FindClosestMinDistance {
    public static void main(String[] args) {
        // Test 1: Example from the question
        // Expected: 3
        int[] arr1 = {1, 2, 3, 1, 4, 5, 2};
        System.out.println("Test 1 -> " +findClosestMinDistance(arr1));
        test(arr1, 3);

        // Test 2: Minimum appears next to each other
        // Expected: 1
        int[] arr2 = {5, 1, 1, 3, 4};
        System.out.println("Test 2 -> " +findClosestMinDistance(arr2));
        test(arr2, 1);

        // Test 3: Minimum at start and end
        // Expected: 4
        int[] arr3 = {2, 3, 4, 5, 2};
        System.out.println("Test 3 -> " +findClosestMinDistance(arr3));
        test(arr3, 4);

        // Test 4: All numbers are the same (so all are minimums)
        // Expected: 1
        int[] arr4 = {7, 7, 7, 7};
        System.out.println("Test 4 -> " +findClosestMinDistance(arr4));
        test(arr4, 1);

        // Test 5: Multiple minimums scattered
        // Expected: 3
        int[] arr5 = {10, 2, 5, 6, 2, 8, 9, 2};
        System.out.println("Test 5 -> " +findClosestMinDistance(arr5));
        test(arr5, 3);

        // Test 6: Minimum in the middle
        // Expected: 2
        int[] arr6 = {9, 8, 1, 5, 1, 7};
        System.out.println("Test 6 -> " +findClosestMinDistance(arr6));
        test(arr6, 2);
    }

    // test function
    public static void test(int[] input, int expected) {
        int result = findClosestMinDistance(input);
        if (Objects.equals(result, expected)) {
            System.out.println("Passed for input: " + Arrays.toString(input)+ "\n") ;
        } else {
            System.out.println("Failed for input: " + input +
                    " | Expected: " + expected + " but got: " + result);
        }
    }

    // First loop: Determine the minimum value in the array.
    // Loop the array again and check the positions of elements equal to the minimum value.
    // Keep track of the last index where the minimum was found.
    // For each new occurrence, calculate the distance to the last occurrence.
    // Update the answer if this distance is smaller than the current answer.
    // Return the smallest distance found between the minimum value.
    public static int findClosestMinDistance(int[] numbers) {
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }

        int lastIndex = -1;
        int answer = numbers.length;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == min) {
                if (lastIndex != -1) {
                    int distance = i - lastIndex;
                    if (distance < answer) {
                        answer = distance;
                    }
                }
                lastIndex = i;
            }
        }
        return answer;
    }


}
