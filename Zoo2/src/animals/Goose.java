package animals;

import enclosure.EnclosureSize;

public final class Goose extends Herbivore implements Swim, Fly, Run, Voice {
    public Goose(String name, int happiness, EnclosureSize size) {
        super(name, happiness, size);
    }

    @Override
    public void fly() {
        System.out.println("Гусь летит");
    }

    @Override
    public void run() {
        System.out.println("Гусь бежит");
    }

    @Override
    public void swim() {
        System.out.println("Гусь плывет");
    }

    @Override
    public String voice() {
        return "Га";
    }
}
