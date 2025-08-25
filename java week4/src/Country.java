import java.util.ArrayList;
import java.util.List;

public class Country {
    private String code;
    private String name;
    private String continent;
    private double surfaceArea;
    private int population;
    private double gnp;
    private int capital;
    private List<City> cities;

    public Country(String code, String name, String continent, double surfaceArea,
                   int population, double gnp, int capital) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.surfaceArea = surfaceArea;
        this.population = population;
        this.gnp = gnp;
        this.capital = capital;
        this.cities = new ArrayList<>();
    }

    // Getters and setters
    public String getCode() { return code; }
    public String getName() { return name; }
    public String getContinent() { return continent; }
    public double getSurfaceArea() { return surfaceArea; }
    public int getPopulation() { return population; }
    public double getGnp() { return gnp; }
    public int getCapital() { return capital; }
    public List<City> getCities() { return cities; }

    public void addCity(City city) {
        cities.add(city);
    }

    public City getHighestPopulatedCity() {
        return cities.stream()
                .max((c1, c2) -> Integer.compare(c1.getPopulation(), c2.getPopulation()))
                .orElse(null);
    }

    @Override
    public String toString() {
        return name + " (" + code + ")";
    }
}