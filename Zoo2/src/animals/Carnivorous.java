package animals;

import enclosure.EnclosureSize;
import food.*;
import staff.Worker;
import zooExceptions.WrongFoodException;

public abstract class Carnivorous extends Animal {

    public Carnivorous(String name, int happiness, EnclosureSize size) {
        super(name, happiness, size);
    }

    public boolean tryAttack(Worker worker) {
        if (!this.isHappy()) {
            worker.setHP(worker.getHP() - 10);
            System.out.println(this.name + " атаковал рабочего!");
            return true;
        }
        System.out.println(this.name + " не атаковал рабочего");
        return false;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean eat(Food food) throws WrongFoodException {
        if (food instanceof Grass) {
            throw new WrongFoodException(this.name + " не может есть траву");
        }
        fullness += food.getFoodPoints();
        if (fullness > this.MAX_FULLNESS)
            fullness = this.MAX_FULLNESS;
        happiness += food.getHappinessBonus() * 2;
        if (happiness > this.MAX_HAPPINESS)
            happiness = this.MAX_HAPPINESS;
        return true;
    }

    @Override
    public boolean isHappy() {
        return this.happiness > 50;
    }
}
