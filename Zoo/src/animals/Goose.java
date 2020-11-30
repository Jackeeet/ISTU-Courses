package animals;

public final class Goose extends Herbivore implements Swim, Fly, Run, Voice {
    public Goose(String name, int happiness) {
        super(name, happiness);
    }

    @Override
    public void fly() {
        System.out.println("Гусь летит");
    }

    @Override
    public void run() {
        System.out.println("Гусь бежит");
    }

    @Override
    public void swim() {
        System.out.println("Гусь плывет");
    }

    @Override
    public String voice() {
        return "Га";
    }
}
