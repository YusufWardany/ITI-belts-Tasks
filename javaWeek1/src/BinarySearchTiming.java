import java.util.Arrays;

public class BinarySearchTiming {
    public static void main(String[] args) {
        // Create and sort array of 1000 random elements
        int[] array = new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 10000);
        }
        Arrays.sort(array);

        int target = array[(int)(Math.random() * array.length)]; // Random element from array

        long startTime = System.nanoTime();

        int result = binarySearch(array, target);

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        if (result == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index: " + result);
        }
        System.out.println("Binary search time: " + duration + " nanoseconds");
    }

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid;
            }

            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}