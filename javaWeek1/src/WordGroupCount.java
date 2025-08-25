public class WordGroupCount {
    public static void main(String[] args) {
        String sentence = "This is a test sentence. This sentence is for testing word count.";
        String word = "sentence";

        // Method 1: Split and count
        int count = 0;
        String[] words = sentence.split("\\s+"); // Split by whitespace

        for (String w : words) {
            // Remove punctuation and compare (basic punctuation handling)
            String cleanWord = w.replaceAll("[^a-zA-Z]", "");
            if (cleanWord.equalsIgnoreCase(word)) {
                count++;
            }
        }

        System.out.println("Count (split method): " + count);


        // Method 2: indexOf with boundary checking
        int count1 = 0;
        int index = 0;
        String lowerSentence = sentence.toLowerCase();
        String lowerWord = word.toLowerCase();
        int wordLength = word.length();

        while ((index = lowerSentence.indexOf(lowerWord, index)) != -1) {
            // Check word boundaries
            boolean startBoundary = index == 0 ||
                    !Character.isLetter(lowerSentence.charAt(index - 1));
            boolean endBoundary = (index + wordLength) == lowerSentence.length() ||
                    !Character.isLetter(lowerSentence.charAt(index + wordLength));

            if (startBoundary && endBoundary) {
                count1++;
            }
            index += wordLength;
        }

        System.out.println("Count (indexOf method): " + count1);
    }
}

//Comment

/*Key Differences:
Split Method:

Splits sentence into words

Handles punctuation by removing non-letters

Simple but creates temporary array

Pros: Simple implementation, handles basic punctuation

Cons: Creates temporary array, less precise with complex word boundaries



Count: 2 (matches "sentence" twice)

indexOf Method:

Searches for word boundaries

More precise word matching

Better performance for large texts

Count: 2 (matches "sentence" twice)

Both methods:

Are case-insensitive

Use only String class methods

Handle basic word boundaries

Pros: More precise word matching, better performance for large texts

Cons: More complex implementation
*/