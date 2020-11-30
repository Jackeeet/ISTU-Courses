package food;

abstract public class Food {
    protected int foodPoints;
    protected int happinessBonus = 0;
    protected String name;

    public int getFoodPoints(){
        return this.foodPoints;
    }

    public int getHappinessBonus(){
        return this.happinessBonus;
    }

    public String getName(){
        return this.name;
    }

    protected Food(String name, int foodPoints, int happinessBonus){
        this.name = name;
        this.foodPoints = foodPoints;
        this.happinessBonus = happinessBonus;
    }
}
