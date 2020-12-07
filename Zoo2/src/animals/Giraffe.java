package animals;

import enclosure.EnclosureSize;

public final class Giraffe extends Herbivore implements Run, Voice{
    public Giraffe(String name, int happiness, EnclosureSize size) {
        super(name, happiness, size);
    }

    @Override
    public void run() {
        System.out.println("Жираф бежит");
    }

    @Override
    public String voice() {
        return "Звук жирафа";
    }
}
