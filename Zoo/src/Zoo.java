import animals.*;
import food.*;
import staff.Worker;

public class Zoo {
    public static void main(String[] args) {

        Crocodile crocodile = new Crocodile("Гена", 35);
        Duck duck = new Duck("Вебер", 100);
        Fish fish = new Fish("Рыберт", 25);
        Giraffe giraffe = new Giraffe("Жираф", 40);
        Goose goose = new Goose("Гусь", 35);
        Tiger tiger = new Tiger("Тигр", 10);

        Swim[] pond = new Swim[10];
        FillPond(pond);
        for (Swim var : pond) {
            var.swim();
        }
        System.out.println();

        ChickenPiece chickenPiece = new ChickenPiece(10);
        Cricket cricket = new Cricket(1);
        Mouse mouse = new Mouse(0);

        Flower flower = new Flower(1);
        Fruit fruit = new Fruit(10);
        Vegetable vegetable = new Vegetable(5);

        Worker worker = new Worker();
        worker.feed(crocodile, chickenPiece);
        worker.feed(tiger, vegetable);
        worker.feed(duck, cricket);
        worker.feed(goose, flower);
        worker.feed(giraffe, mouse);
        worker.feed(fish, fruit);
        System.out.println();

        System.out.println("Голос утки : " + worker.getVoice(duck));
        System.out.println("Голос жирафа : " + worker.getVoice(giraffe));
        System.out.println("Голос гуся : " + worker.getVoice(goose));
        System.out.println("Голос тигра : " + worker.getVoice(tiger));
        System.out.println();

        if (duck.isHappy())
            System.out.println("Вебер доволен");
        else System.out.println("Вебер недоволен");

        if (tiger.isHappy())
            System.out.println("Тигр доволен");
        else System.out.println("Тигр недоволен");
        System.out.println();

        tiger.tryAttack(worker);
        crocodile.tryAttack(worker);
        fish.tryAttack(worker);

        worker.CheckHP();
    }

    private static void FillPond(Swim[] pond) {
        for (int i = 0; i < pond.length; i++) {
            int rnd = (int) (Math.random() * 3 + 1);
            switch (rnd) {
                case 1:
                    pond[i] = new Duck(Integer.toString(i), 100);
                    break;
                case 2:
                    pond[i] = new Goose(Integer.toString(i), 30);
                    break;
                default:
                    pond[i] = new Fish(Integer.toString(i), 10);
                    break;
            }
        }
    }
}
