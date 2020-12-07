package animals;

import enclosure.EnclosureSize;
import food.*;
import zooExceptions.WrongFoodException;

import java.util.Objects;

abstract public class Animal {
    protected int fullness;
    protected int happiness;
    protected String name;
    protected EnclosureSize requiredEnclosureSize;

    protected final int MAX_FULLNESS = 50;
    protected final int MAX_HAPPINESS = 100;

    protected Animal(String name, int happiness, EnclosureSize size) {
        this.name = name;
        this.fullness = 0;
        if (!(happiness > 0 && happiness <= this.MAX_HAPPINESS))
            throw new IllegalArgumentException();
        this.happiness = happiness;
        this.requiredEnclosureSize = size;
    }

    public abstract String getName();

    public abstract boolean eat(Food food) throws WrongFoodException;

    public abstract boolean isHappy();

    public EnclosureSize getRequiredEnclosureSize(){
        return this.requiredEnclosureSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return fullness == animal.fullness &&
                happiness == animal.happiness &&
                name.equals(animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
