package animals;

import enclosure.EnclosureSize;

public final class Tiger extends Carnivorous implements Run, Voice {
    public Tiger(String name, int happiness, EnclosureSize size) {
        super(name, happiness, size);
    }

    @Override
    public void run() {
        System.out.println("Тигр бежит");
    }

    @Override
    public String voice() {
        return "Рррр";
    }
}

