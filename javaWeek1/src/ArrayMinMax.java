public class ArrayMinMax {
    public static void main(String[] args) {
        // Create array of 1000 random elements
        int[] array = new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 10000);
        }

        long startTime = System.nanoTime();

        int min = array[0];
        int max = array[0];

        for (int num : array) {
            if (num < min) min = num;
            if (num > max) max = num;
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
        System.out.println("Search time: " + duration + " nanoseconds");
    }
}