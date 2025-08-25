public class WordCountStringMethods {
    public static void main(String[] args) {
        String sentence = "This is a test sentence. This sentence is for testing word count.";
        String word = "sentence";

        // Method 1: Using split and loop
        int count1 = 0;
        String[] words = sentence.split(" ");
        for (String w : words) {
            if (w.equalsIgnoreCase(word)) {
                count1++;
            }
        }
        System.out.println("Count using split method: " + count1);

        // Method 2: Using indexOf
        int count2 = 0;
        int index = 0;
        while (index != -1) {
            index = sentence.toLowerCase().indexOf(word.toLowerCase(), index);
            if (index != -1) {
                count2++;
                index += word.length();
            }
        }
        System.out.println("Count using indexOf method: " + count2);
    }
}