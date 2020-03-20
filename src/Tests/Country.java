package Tests;

class Country {
    String name;
    long population;
    double area;

    Country(String name, long population, double area) {
        this.name = name;
        this.population = population;
        this.area = area;
    }

    public String toString() {
        return "\nCountry name: " + name +
                "\nPopulation: " + population +
                "\nArea: " + area +
                "\nDensity: " + density() + "\n\n";
    }

    double density() {
        if (area > 0)
            return population / area;
        else return 0;
    }

    public static void main(String[] args) {
        Country[] countries = new Country[5];

        countries[0] = new Country("china", 90000, 900);
        countries[1] = new Country("India", 80000, 600);
        countries[2] = new Country("Russia", 60000, 950);
        countries[3] = new Country("pakistan", 20000, 100);
        countries[4] = new Country("srilanka", 10000, 150);

        System.out.println("Largest area:");
        Country largest = countries[0];
        for (Country c : countries) {
            if (c.area > largest.area) {
                largest = c;
            }
        }
        System.out.println(largest.toString());
        System.out.println("Largest population:");
        Country population = countries[0];
        for (Country c : countries) {
            if (c.population > population.population) {
                population = c;
            }
        }
        System.out.println(population.toString());

        System.out.println("Largest density:");
        Country density = countries[0];
        for (Country c : countries) {
            if (c.density() > density.density()) {
                density = c;
            }
        }
        System.out.println(density.toString());
    }
}
