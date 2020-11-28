import model.Kotik;

public class Application {
    public static void main(String args[]) {

        Kotik first = new Kotik(15, 10, "Моргана", "Мяу");
        Kotik second = new Kotik();
        second.setKotik(25, "Нук", 11, "Мяяяу");

        first.liveAnotherDay();
        System.out.println("\nИмя котика: " + first.getName());
        System.out.println("Вес котика: " + first.getWeight() + " кг");

        boolean meowComparisonResult = (first.getMeow() == second.getMeow());
        if (meowComparisonResult)
            System.out.println("Котики разговаривают одинаково");
        else System.out.println("Котики разговаривают по-разному");

        System.out.println("\nВсего создано котиков: " + Kotik.getCreatedCount());
    }
}
