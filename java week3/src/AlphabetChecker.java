class AlphabetChecker {
    public static boolean isAlphabetic(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        for (char c : str.toCharArray()) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String test1 = "HelloWorld";
        String test2 = "Hello123";

        System.out.println(test1 + " contains only alphabets: " + isAlphabetic(test1));
        System.out.println(test2 + " contains only alphabets: " + isAlphabetic(test2));
    }
}