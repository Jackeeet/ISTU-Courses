package animals;

import enclosure.EnclosureSize;
import food.*;
import zooExceptions.WrongFoodException;

public abstract class Herbivore extends Animal {
    public Herbivore(String name, int happiness, EnclosureSize size) {
        super(name, happiness, size);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean eat(Food food) throws WrongFoodException {
        if (food instanceof Meat) {
            throw new WrongFoodException(this.name + " не может есть мясо");
        }
        fullness += food.getFoodPoints();
        if (fullness > this.MAX_FULLNESS)
            fullness = this.MAX_FULLNESS;

        happiness += food.getHappinessBonus();
        if (happiness > this.MAX_HAPPINESS)
            happiness = this.MAX_HAPPINESS;
        return true;
    }

    @Override
    public boolean isHappy() {
        return this.happiness > 15;
    }
}
