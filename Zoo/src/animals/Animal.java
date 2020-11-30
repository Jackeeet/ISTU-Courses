package animals;

import food.*;

abstract public class Animal {
    protected int fullness;
    protected int happiness;
    protected String name;

    protected final int MAX_FULLNESS = 50;
    protected final int MAX_HAPPINESS = 100;

    protected Animal(String name, int happiness) {
        this.name = name;
        this.fullness = 0;
        if (!(happiness > 0 && happiness <= this.MAX_HAPPINESS))
            throw new IllegalArgumentException();
        this.happiness = happiness;
    }

    public abstract String getName();

    public abstract boolean eat(Food food);

    public abstract boolean isHappy();
}
