import java.util.function.Function;

public class TemperatureConverter {
    public static void main(String[] args) {
        // Using Function interface to convert Celsius to Fahrenheit
        Function<Double, Double> celsiusToFahrenheit = celsius -> (celsius * 9/5) + 32;

        double celsius = 25.0;
        double fahrenheit = celsiusToFahrenheit.apply(celsius);

        System.out.println(celsius + "°C is " + fahrenheit + "°F");
    }
}