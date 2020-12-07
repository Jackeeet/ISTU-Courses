package zooExceptions;

public class WrongFoodException extends Exception {
    public WrongFoodException(String errorMessage){
        super(errorMessage);
    }
}
