package model;

public class Kotik {
    private static int createdCount = 0;
    private int prettiness;
    private int weight;
    private String name;
    private String meow;
    private int fullness;

    public Kotik() {
        createdCount++;
    }

    public Kotik(int weight, String name) {
        this(5, weight, name, "Мяу!");
        createdCount++;
    }

    public Kotik(int prettiness, int weight, String name, String meow) {
        this.prettiness = prettiness;
        this.weight = weight;
        this.name = name;
        this.meow = meow;
        createdCount++;
    }

    public void setKotik(int prettiness, String name, int weight, String meow) {
        this.prettiness = prettiness;
        this.weight = weight;
        this.name = name;
        this.meow = meow;
    }

    public int getPrettiness() {
        return this.prettiness;
    }

    public int getWeight() {
        return this.weight;
    }

    public String getName() {
        return this.name;
    }

    public String getMeow() {
        return this.meow;
    }

    public int getFullness() {
        return this.fullness;
    }

    public static int getCreatedCount() {
        return createdCount;
    }

    public void liveAnotherDay() {
        for (int i = 0; i < 24; i++) {
            int rnd = (int) (Math.random() * 5 + 1);
            boolean completed;
            switch (rnd) {
                case 1:
                    completed = this.play();
                    break;
                case 2:
                    completed = this.sleep();
                    break;
                case 3:
                    completed = this.chaseMouse();
                    break;
                case 4:
                    completed = this.sniff();
                    break;
                case 5:
                    completed = this.scratchSofa();
                    break;
                default:
                    completed = false;
                    break;
            }
            if (!completed)
                this.eat();
        }
    }

    public boolean eat() {
        eat(10, "Вискас");
        return true;
    }

    public boolean eat(int foodPoints) {
        this.fullness += foodPoints;
        this.weight += foodPoints / 2;
        System.out.println("Съел " + foodPoints + "кусочков еды");
        return true;
    }

    public boolean eat(int foodPoints, String foodName) {
        this.fullness += foodPoints;
        this.weight += foodPoints / 2;
        System.out.println("Съел " + foodPoints + " кусочков " + foodName);
        return true;
    }

    public boolean play() {
        if (fullness <= 0)
            return false;
        this.prettiness += 5;
        this.weight -= 2;
        this.fullness -= 3;
        System.out.println("Поиграл");
        return true;
    }

    public boolean sleep() {
        if (fullness <= 0)
            return false;
        this.prettiness += 10;
        this.fullness -= 1;
        System.out.println("Поспал");
        return true;
    }

    public boolean chaseMouse() {
        if (fullness <= 0)
            return false;
        this.weight -= 3;
        this.fullness -= 5;
        System.out.println("Попробовал поймать мышь");
        return true;
    }

    public boolean sniff() {
        if (fullness <= 0)
            return false;
        this.prettiness += 1;
        System.out.println("Что-то унюхал");
        return true;
    }

    public boolean scratchSofa() {
        if (fullness <= 0)
            return false;
        this.prettiness -= 10;
        this.fullness -= 1;
        System.out.println("Поцарапал диван >:3");
        return true;
    }
}
