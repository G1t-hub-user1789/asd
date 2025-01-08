import java.util.List;
import java.util.ArrayList;

class Animal {
    private String name;
    private String species;
    private int age;

    public Animal(String name, String species, int age) {
        this.name = name;
        this.species = species;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Animal{name='" + name + "', species='" + species + "', age=" + age + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Animal animal = (Animal) obj;
        return age == animal.age && name.equals(animal.name) && species.equals(animal.species);
    }

    @Override
    public int hashCode() {
        return name.hashCode() + species.hashCode() + age;
    }
}

class ZooKeeper {
    private String name;
    private int experience;

    public ZooKeeper(String name, int experience) {
        this.name = name;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return "ZooKeeper{name='" + name + "', experience=" + experience + "}";
    }
}

class Zoo {
    private String name;
    private String location;
    private List<Animal> animals = new ArrayList<>();

    public Zoo(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public List<Animal> filter(String species) {
        return animals.stream().filter(a -> a.getSpecies().equalsIgnoreCase(species)).toList();
    }

    @Override
    public String toString() {
        return "Zoo{name='" + name + "', location='" + location + "', animals=" + animals + "}";
    }
}

public class Main {
    public static void main(String[] args) {
        Animal tiger = new Animal("Tiger", "Panthera tigris", 5);
        Animal elephant = new Animal("Elephant", "Loxodonta africana", 10);
        Animal lion = new Animal("Lion", "Panthera leo", 6);

        ZooKeeper john = new ZooKeeper("John Doe", 7);

        Zoo zoo = new Zoo("City Zoo", "Downtown");
        zoo.addAnimal(tiger);
        zoo.addAnimal(elephant);
        zoo.addAnimal(lion);

        System.out.println("Initial Zoo State:");
        System.out.println(zoo);

        System.out.println("\nFiltering Animals by Species 'Panthera':");
        List<Animal> filtered = zoo.filter("Panthera tigris");
        filtered.forEach(System.out::println);
    }
}
