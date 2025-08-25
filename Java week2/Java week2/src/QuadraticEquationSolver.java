import java.util.function.BiFunction;
import java.util.function.Function;

public class QuadraticEquationSolver {
    public static void main(String[] args) {
        // BiFunction to calculate discriminant (b² - 4ac)
        BiFunction<Double, Double, Function<Double, Double>> discriminant =
                (a, b) -> c -> b * b - 4 * a * c;

        // Function to calculate roots
        Function<Double, Function<Double, Function<Double, String>>> rootsCalculator =
                a -> b -> c -> {
                    double disc = discriminant.apply(a, b).apply(c);
                    if (disc < 0) {
                        return "No real roots";
                    } else if (disc == 0) {
                        double root = (-b) / (2 * a);
                        return "One real root: " + root;
                    } else {
                        double root1 = (-b + Math.sqrt(disc)) / (2 * a);
                        double root2 = (-b - Math.sqrt(disc)) / (2 * a);
                        return "Two real roots: " + root1 + " and " + root2;
                    }
                };

        // Example usage
        double a = 1.0, b = -3.0, c = 2.0;
        String roots = rootsCalculator.apply(a).apply(b).apply(c);
        System.out.println("For equation " + a + "x² + " + b + "x + " + c + " = 0");
        System.out.println(roots);
    }
}