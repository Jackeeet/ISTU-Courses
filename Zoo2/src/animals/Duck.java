package animals;

import enclosure.EnclosureSize;

public final class Duck extends Herbivore implements Swim, Fly, Run, Voice {
    public Duck(String name, int happiness, EnclosureSize size) {
        super(name, happiness, size);
    }

    @Override
    public void fly() {
        System.out.println("Утка летит");
    }

    @Override
    public void run() {
        System.out.println("Утка бежит");
    }

    @Override
    public void swim() {
        System.out.println("Утка плывет");
    }

    @Override
    public String voice() {
        return "Кря";
    }
}
