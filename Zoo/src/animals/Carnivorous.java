package animals;

import food.*;
import staff.Worker;

public class Carnivorous extends Animal {

    public Carnivorous(String name, int happiness) {
        super(name, happiness);
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
    public boolean eat(Food food) {
        if (food instanceof Grass) {
            System.out.println(this.name + " не может есть траву");
            return false;
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
