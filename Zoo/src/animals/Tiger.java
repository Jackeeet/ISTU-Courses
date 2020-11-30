package animals;

public final class Tiger extends Carnivorous implements Run, Voice {
    public Tiger(String name, int happiness) {
        super(name, happiness);
    }

    @Override
    public void run() {
        System.out.println("Тигр бежит");
    }

    @Override
    public String voice() {
        return "Рррр";
    }
}

