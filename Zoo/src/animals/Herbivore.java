package animals;

import food.*;

public class Herbivore extends Animal {
    public Herbivore(String name, int happiness) {
        super(name, happiness);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean eat(Food food) {
        if (food instanceof Meat) {
            System.out.println(this.name + " не может есть мясо");
            return false;
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
