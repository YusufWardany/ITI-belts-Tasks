import java.util.StringTokenizer;

public class WordCountStringTokenizer {
    public static void main(String[] args) {
        String sentence = "This is a test sentence. This sentence is for testing word count.";
        String word = "sentence";

        int count = 0;
        StringTokenizer tokenizer = new StringTokenizer(sentence, " ,.!?");

        while (tokenizer.hasMoreTokens()) {
            if (tokenizer.nextToken().equalsIgnoreCase(word)) {
                count++;
            }
        }

        System.out.println("Count using StringTokenizer: " + count);
    }
}

/*
Original sentence breaks into these tokens:
["This", "is", "a", "test", "sentence", "This", "sentence", "is", "for", "testing", "word", "count"]*/