package staff;

import animals.*;
import food.*;

public class Worker {
    private int HP;

    public Worker() {
        this.HP = 100;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int hp) {
        this.HP = hp;
    }

    public void CheckHP()
    {
        if (this.HP == 100)
            System.out.println("Рабочий абсолютно здоров");
        else if (this.HP > 70)
            System.out.println("Рабочий здоров");
        else if (this.HP > 30)
            System.out.println("Рабочий нездоров");
        else
            System.out.println("Рабочий в критическом состоянии");
    }


    public void feed(Animal animal, Food food) {
        boolean fed = animal.eat(food);
        if (fed)
            System.out.println("Покормил животное " + animal.getName() + " едой " + food.getName());
    }

    public <T extends Voice> String getVoice(T animal) {
        return animal.voice();
    }

}
