package animals;

import enclosure.EnclosureSize;

public final class Crocodile extends Carnivorous implements Swim {

    public Crocodile(String name, int happiness, EnclosureSize size) {
        super(name, happiness, size);
    }

    @Override
    public void swim() {
        System.out.println("Крокодил плывет");
    }
}
