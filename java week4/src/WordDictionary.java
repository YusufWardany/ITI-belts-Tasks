import java.util.*;

public class WordDictionary {
    private Map<Character, TreeSet<String>> wordsMap;

    public WordDictionary() {
        wordsMap = new TreeMap<>();
        // Initialize map with all alphabets
        for (char c = 'a'; c <= 'z'; c++) {
            wordsMap.put(c, new TreeSet<>());
        }
    }

    // Add words from array to the dictionary
    public void addWords(String[] words) {
        for (String word : words) {
            if (word != null && !word.trim().isEmpty()) {
                char firstChar = Character.toLowerCase(word.charAt(0));
                if (wordsMap.containsKey(firstChar)) {
                    wordsMap.get(firstChar).add(word);
                }
            }
        }
    }

    // Print all letters and corresponding words
    public void printAllWords() {
        System.out.println("=== All Words in Dictionary ===");
        for (Map.Entry<Character, TreeSet<String>> entry : wordsMap.entrySet()) {
            if (!entry.getValue().isEmpty()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    // Print words of a given letter
    public void printWordsByLetter(char letter) {
        char lowerLetter = Character.toLowerCase(letter);
        if (wordsMap.containsKey(lowerLetter)) {
            TreeSet<String> words = wordsMap.get(lowerLetter);
            if (words.isEmpty()) {
                System.out.println("No words found for letter '" + letter + "'");
            } else {
                System.out.println("Words for letter '" + letter + "': " + words);
            }
        } else {
            System.out.println("Invalid letter: '" + letter + "'");
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        WordDictionary dictionary = new WordDictionary();

        String[] words = {
                "apple", "banana", "cherry", "date", "elderberry",
                "fig", "grape", "honeydew", "ice cream", "jackfruit",
                "kiwi", "lemon", "mango", "nectarine", "orange",
                "pear", "quince", "raspberry", "strawberry", "tangerine",
                "ugli", "vanilla", "watermelon", "xigua", "yam", "zucchini"
        };

        dictionary.addWords(words);
        dictionary.printAllWords();
        System.out.println();
        dictionary.printWordsByLetter('a');
        dictionary.printWordsByLetter('z');
        dictionary.printWordsByLetter('x');
    }
}