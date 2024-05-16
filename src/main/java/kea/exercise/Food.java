package kea.exercise;

public class Food extends Item {
    private int healing;
    public Food(String longName, String shortName, int healing) {
        super(longName, shortName);
        this.healing = healing;
    }

    public int getHealing() {
        return healing;
    }

    public void setHealing(int healing) {
        this.healing = healing;
    }
}
