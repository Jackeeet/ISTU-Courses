package animals;

public final class Crocodile extends Carnivorous implements Swim {

    public Crocodile(String name, int happiness) {
        super(name, happiness);
    }

    @Override
    public void swim() {
        System.out.println("Крокодил плывет");
    }
}
