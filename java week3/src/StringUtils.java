class StringUtils {
    public static String betterString(String s1, String s2, TwoStringPredicate checker) {
        return checker.isBetter(s1, s2) ? s1 : s2;
    }
}

@FunctionalInterface
interface TwoStringPredicate {
    boolean isBetter(String s1, String s2);
}

class BetterStringTest {
    public static void main(String[] args) {
        String string1 = "Hello";
        String string2 = "World!";

        String longer = StringUtils.betterString(string1, string2,
                (s1, s2) -> s1.length() > s2.length());
        System.out.println("Longer string: " + longer);

        String first = StringUtils.betterString(string1, string2,
                (s1, s2) -> true);
        System.out.println("First string: " + first);
    }
}