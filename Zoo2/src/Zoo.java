import animals.*;
import enclosure.Enclosure;
import enclosure.EnclosureSize;
import food.*;
import staff.Worker;
import zooExceptions.WrongFoodException;

public class Zoo {
    public static void main(String[] args) throws WrongFoodException {

        Crocodile crocodile = new Crocodile("Гена", 35, EnclosureSize.Large);
        Duck duck = new Duck("Вебер", 100, EnclosureSize.Medium);
        Fish fish = new Fish("Рыберт", 25, EnclosureSize.Small);
        Giraffe giraffe = new Giraffe("Жираф", 40, EnclosureSize.VeryLarge);
        Goose goose = new Goose("Гусь", 35, EnclosureSize.Medium);
        Tiger tiger = new Tiger("Тигр", 10, EnclosureSize.Large);

        // вольер для хищников
        Enclosure<Carnivorous> largeCarnEnclosure = new Enclosure<>(EnclosureSize.Large);
        largeCarnEnclosure.AddAnimal(crocodile);
        largeCarnEnclosure.AddAnimal(tiger);
        largeCarnEnclosure.AddAnimal(fish);

        // удаление животного из вольера
        largeCarnEnclosure.RemoveAnimal(fish);

        // вольер для травоядных среднего размера
        Enclosure<Herbivore> mediumHerbEnclosure = new Enclosure<>(EnclosureSize.Medium);
        mediumHerbEnclosure.AddAnimal(duck);
        mediumHerbEnclosure.AddAnimal(goose);
        mediumHerbEnclosure.AddAnimal(giraffe);

        // получение ссылки по имени
        Duck weber = (Duck)mediumHerbEnclosure.GetAnimal("Вебер");
        weber.voice();

        // вольер для травоядных максимального размера
        Enclosure<Giraffe> giraffeEnclosure = new Enclosure<>(EnclosureSize.VeryLarge);
        giraffeEnclosure.AddAnimal(giraffe);
        giraffeEnclosure.AddAnimal(new Giraffe("Апельсин", 50, EnclosureSize.VeryLarge));
        giraffeEnclosure.AddAnimal(new Giraffe("Маленький жираф", 99, EnclosureSize.Small));

        ChickenPiece chickenPiece = new ChickenPiece(10);
        Flower flower = new Flower(1);
        Vegetable vegetable = new Vegetable(5);

        Worker worker = new Worker();
        worker.feed(crocodile, chickenPiece);
        worker.feed(goose, flower);
        // выбрасывается исключение WrongFoodException
        worker.feed(tiger, vegetable);
        System.out.println();
    }
}