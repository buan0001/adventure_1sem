package kea.exercise.exceptions;

public class ItemNotFoodException extends RuntimeException {

    public ItemNotFoodException(){
        super();
    }

    public ItemNotFoodException(String message){
        super(message);
    }
}
