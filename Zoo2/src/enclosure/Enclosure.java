package enclosure;

import animals.Animal;

import java.util.HashMap;

public class Enclosure<AnimalType extends Animal> {
    private HashMap<String, AnimalType> enclosure;
    private EnclosureSize size;

    public Enclosure(EnclosureSize size) {
        this.enclosure = new HashMap<String, AnimalType>();
        this.size = size;
    }

    public void AddAnimal(AnimalType animal) {
        if (animal.getRequiredEnclosureSize().ordinal() <= this.size.ordinal()) {
            enclosure.put(animal.getName(), animal);
            System.out.println(animal.getName() + " добавлен в вольер");
        } else {
            System.out.println(animal.getName() + " не помещается в вольер");
        }
    }

    public void RemoveAnimal(AnimalType animal) {
        enclosure.remove(animal.getName(), animal);
    }

    public AnimalType GetAnimal(String name) {
        return enclosure.get(name);
    }
}
