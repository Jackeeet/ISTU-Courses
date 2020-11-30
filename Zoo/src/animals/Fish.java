package animals;

public final class Fish extends Carnivorous implements Swim {
    public Fish(String name, int happiness) {
        super(name, happiness);
    }

    @Override
    public void swim() {
        System.out.println("Рыба плывет");
    }
}
