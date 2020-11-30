package animals;

public final class Giraffe extends Herbivore implements Run, Voice{
    public Giraffe(String name, int happiness) {
        super(name, happiness);
    }

    @Override
    public void run() {
        System.out.println("Жираф бежит");
    }

    @Override
    public String voice() {
        return "Звук жирафа";
    }
}
