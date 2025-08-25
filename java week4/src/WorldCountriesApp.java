import java.util.*;
import java.util.stream.Collectors;

public class WorldCountriesApp {
    private List<Country> countries;
    private List<City> cities;

    public WorldCountriesApp() {
        countries = new ArrayList<>();
        cities = new ArrayList<>();
    }

    public void addCountry(Country country) {
        countries.add(country);
    }

    public void addCity(City city) {
        cities.add(city);
        // Add city to corresponding country
        countries.stream()
                .filter(c -> c.getCode().equals(city.getCountryCode()))
                .findFirst()
                .ifPresent(country -> country.addCity(city));
    }

    // Find the highest populated city of each country
    public Map<Country, City> findHighestPopulatedCityPerCountry() {
        Map<Country, City> result = new HashMap<>();
        for (Country country : countries) {
            City highestCity = country.getHighestPopulatedCity();
            if (highestCity != null) {
                result.put(country, highestCity);
            }
        }
        return result;
    }

    // Find the most populated city of each continent
    public Map<String, City> findMostPopulatedCityPerContinent() {
        Map<String, City> result = new HashMap<>();

        // Group countries by continent
        Map<String, List<Country>> countriesByContinent = countries.stream()
                .collect(Collectors.groupingBy(Country::getContinent));

        for (Map.Entry<String, List<Country>> entry : countriesByContinent.entrySet()) {
            String continent = entry.getKey();
            List<Country> continentCountries = entry.getValue();

            // Get all cities from all countries in this continent
            List<City> continentCities = continentCountries.stream()
                    .flatMap(country -> country.getCities().stream())
                    .collect(Collectors.toList());

            // Find city with highest population
            City mostPopulated = continentCities.stream()
                    .max((c1, c2) -> Integer.compare(c1.getPopulation(), c2.getPopulation()))
                    .orElse(null);

            if (mostPopulated != null) {
                result.put(continent, mostPopulated);
            }
        }

        return result;
    }

    // Find the highest populated capital city
    public City findHighestPopulatedCapital() {
        return countries.stream()
                .map(country -> {
                    int capitalId = country.getCapital();
                    return country.getCities().stream()
                            .filter(city -> city.getId() == capitalId)
                            .findFirst()
                            .orElse(null);
                })
                .filter(Objects::nonNull)
                .max((c1, c2) -> Integer.compare(c1.getPopulation(), c2.getPopulation()))
                .orElse(null);
    }

    // Helper method to display results
    public void displayResults() {
        System.out.println("=== Highest Populated City per Country ===");
        Map<Country, City> countryCities = findHighestPopulatedCityPerCountry();
        countryCities.forEach((country, city) ->
                System.out.println(country.getName() + ": " + city));

        System.out.println("\n=== Most Populated City per Continent ===");
        Map<String, City> continentCities = findMostPopulatedCityPerContinent();
        continentCities.forEach((continent, city) ->
                System.out.println(continent + ": " + city));

        System.out.println("\n=== Highest Populated Capital City ===");
        City highestCapital = findHighestPopulatedCapital();
        if (highestCapital != null) {
            System.out.println(highestCapital);
        } else {
            System.out.println("No capital cities found");
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        WorldCountriesApp app = new WorldCountriesApp();

        // Create sample countries
        Country usa = new Country("USA", "United States", "North America", 9833517, 331000000, 21427700, 1);
        Country canada = new Country("CAN", "Canada", "North America", 9984670, 38000000, 1736425, 2);
        Country china = new Country("CHN", "China", "Asia", 9596961, 1402000000, 14342903, 3);
        Country india = new Country("IND", "India", "Asia", 3287263, 1380000000, 2875142, 4);

        app.addCountry(usa);
        app.addCountry(canada);
        app.addCountry(china);
        app.addCountry(india);

        // Create sample cities
        app.addCity(new City(1, "Washington D.C.", 705749, "USA"));
        app.addCity(new City(2, "New York", 8336817, "USA"));
        app.addCity(new City(3, "Los Angeles", 3979576, "USA"));

        app.addCity(new City(4, "Ottawa", 994837, "CAN"));
        app.addCity(new City(5, "Toronto", 2731571, "CAN"));
        app.addCity(new City(6, "Vancouver", 631486, "CAN"));

        app.addCity(new City(7, "Beijing", 21542000, "CHN"));
        app.addCity(new City(8, "Shanghai", 24256800, "CHN"));
        app.addCity(new City(9, "Guangzhou", 14043500, "CHN"));

        app.addCity(new City(10, "New Delhi", 16787949, "IND"));
        app.addCity(new City(11, "Mumbai", 12478447, "IND"));
        app.addCity(new City(12, "Bangalore", 8425970, "IND"));

        // Display results
        app.displayResults();
    }
}