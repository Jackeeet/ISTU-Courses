package animals;

import enclosure.EnclosureSize;

public final class Fish extends Carnivorous implements Swim {
    public Fish(String name, int happiness, EnclosureSize size) {
        super(name, happiness, size);
    }

    @Override
    public void swim() {
        System.out.println("Рыба плывет");
    }
}
